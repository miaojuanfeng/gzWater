package gov.water.cms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import gov.water.model.DayEV;
import gov.water.model.DayPK;
import gov.water.model.User;
import gov.water.service.DayEVService;
import gov.water.service.UserService;
import gov.water.util.FuncUtil;

@Controller
@RequestMapping("cms/dev")
public class DayEVCtrl {
	
	@Autowired
	private DayEVService dayEVService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FuncUtil funcUtil;
	
	public void init(
			String method,
			Model model,
			HttpSession httpSession
	){
		model.addAttribute("classTitle", "日蒸发量");
		model.addAttribute("method", method);
		if( method.equals("show") ){
			model.addAttribute("methodTitle", "查询");
			User user = (User)httpSession.getAttribute("user");
			model.addAttribute("stnm", user.getStnm());
			model.addAttribute("type", user.getType());
		}else if( method.equals("post") ){
			model.addAttribute("methodTitle", "报送");
			User user = (User)httpSession.getAttribute("user");
			model.addAttribute("stcd", user.getStcd());
			model.addAttribute("stnm", user.getStnm());
			model.addAttribute("type", user.getType());
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			date = calendar.getTime();
			DayEV dayEV = dayEVService.selectByDate(user.getStcd(), sdf.format(date));
			if( dayEV != null ){
				model.addAttribute("dye", dayEV.getDye());
			}else{
				model.addAttribute("dye", "暂无数据");
			}
		}
	}
	
	@RequestMapping(value="show")
	public String select(HttpServletRequest request){
		return "redirect:/cms/dev/show/1"+funcUtil.requestParameters(request);
	}
	
	@RequestMapping(value="show/{page}")
	public String show(
			Model model,
			HttpSession httpSession,
			HttpServletRequest request,
			@PathVariable(value="page") Integer page
	){
		init("show", model, httpSession);
		
		User user = (User)httpSession.getAttribute("user");
		String stcd = user.getStcd();
		String type = user.getType();
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		
		if( from == null || from.equals("") ){
			from = "0000-00-00";
		}else{
			model.addAttribute("from", from);
		}
		if( to == null || to.equals("") ){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			to = sdf.format(date);
		}else{
			model.addAttribute("to", to);
		}
		
		int pageSize = 20;
		long totalRecord = 0;
		if( type.equals("s") ){
			totalRecord = dayEVService.selectCount(stcd, from, to);
		}else{
			totalRecord = dayEVService.selectCount(from, to);
		}
		int totalPage = (int)Math.ceil((double)totalRecord/pageSize);
		
		if( page < 1 || page > totalPage ){
			page = 1;
		}
		
		Integer offset = (page-1)*pageSize;
		List<DayEV> dayEVs = null;
		if( type.equals("s") ){
			dayEVs = dayEVService.selectFromTo(stcd, from, to, offset, pageSize);
		}else{
			dayEVs = dayEVService.selectFromTo(from, to, offset, pageSize);
		}
		
		Map<String, String> stations = new HashMap<String, String>();
		List<User> users = userService.selectAll();
		for(User u : users){
			stations.put(u.getStcd(), u.getStnm());
		}
		
		model.addAttribute("page", page);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("totalRecord", totalRecord);
		model.addAttribute("dayEVs", dayEVs);
		model.addAttribute("stations", stations);
		model.addAttribute("parameters", funcUtil.requestParameters(request));
		
		return "DayEVView";
	}
	
	@RequestMapping(value="post", method=RequestMethod.GET)
	public String post(
			Model model,
			HttpSession httpSession
	){
		init("post", model, httpSession);
		
		return "DayEVView";
	}
	
	@RequestMapping(value="post", method=RequestMethod.POST)
	public String post(
			@RequestParam(value="stcd") String stcd, 
			@RequestParam(value="dye") Float dye, 
			Model model,
			HttpSession httpSession
	) throws ParseException{
		init("post", model, httpSession);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		/*Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		date = calendar.getTime();*/
		String dateStr = sdf.format(date);
		
		String error = null;
		
		DayEV dayEV = dayEVService.selectByDate(stcd, dateStr);
		if( dayEV != null ){
			dayEV.setDye(dye);
			if( dayEVService.updateByPrimaryKey(dayEV) == 1 ){
				error = "蒸发量更新成功";
			}else{
				error = "蒸发量更新失败";
			}
		}else{
			dateStr += " 08:00:00.000";
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			date = sdf.parse(dateStr);
			
			dayEV = new DayEV();
			DayPK dayPK = new DayPK();
			dayPK.setStcd(stcd);
			dayPK.setTm(date);
			dayEV.setDaypk(dayPK);
			dayEV.setDye(dye);
			if( dayEVService.insertByPrimaryKey(dayEV) == 1 ){
				error = "蒸发量保存成功";
			}else{
				error = "蒸发量保存失败";
			}
		}
		
		if( error != null ){
			model.addAttribute("error", error);
		}
		
		return "DayEVView";
	}

}

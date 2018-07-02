package gov.water.cms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import gov.water.model.DayEV;
import gov.water.model.DayPK;
import gov.water.model.User;
import gov.water.service.DayEVService;

@Controller
public class PostCtrl {
	
	@Autowired
	private DayEVService dayEVService;
	
	public void init(
			Model model,
			HttpSession httpSession
	){
		User user = (User)httpSession.getAttribute("user");
		model.addAttribute("stcd", user.getStcd());
		model.addAttribute("stnm", user.getStnm());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -2);
		date = calendar.getTime();
		DayEV dayEV = dayEVService.selectByDate(user.getStcd(), sdf.format(date));
		if( dayEV != null ){
			model.addAttribute("dye", dayEV.getDye());
		}else{
			model.addAttribute("dye", "暂无数据");
		}
	}
	
	@RequestMapping(value="post", method=RequestMethod.GET)
	public String post(
			Model model,
			HttpSession httpSession
	){
		init(model, httpSession);
		
		return "PostView";
	}
	
	@RequestMapping(value="post", method=RequestMethod.POST)
	public String post(
			@RequestParam(value="stcd") String stcd, 
			@RequestParam(value="dye") Float dye, 
			Model model,
			HttpSession httpSession
	) throws ParseException{
		init(model, httpSession);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		date = calendar.getTime();
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
		
		return "PostView";
	}
}

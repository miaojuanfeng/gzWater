package gov.water.cms;

import java.text.SimpleDateFormat;
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

import gov.water.model.River;
import gov.water.model.User;
import gov.water.service.FlowService;
import gov.water.service.UserService;
import gov.water.util.FuncUtil;

@Controller
@RequestMapping("cms/flow")
public class FlowCtrl {
	
	@Autowired
	private FlowService flowService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FuncUtil funcUtil;
	
	public void init(
			Model model,
			HttpSession httpSession
	){
		User user = (User)httpSession.getAttribute("user");
		model.addAttribute("stnm", user.getStnm());
		model.addAttribute("type", user.getType());
	}
	
	@RequestMapping(value="show")
	public String select(HttpServletRequest request){
		return "redirect:/cms/flow/show/1"+funcUtil.requestParameters(request);
	}
	
	@RequestMapping(value="show/{page}")
	public String show(
			Model model,
			HttpSession httpSession,
			HttpServletRequest request,
			@PathVariable(value="page") Integer page
	){
		init(model, httpSession);
		
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
			totalRecord = flowService.selectCount(stcd, from, to);
		}else{
			totalRecord = flowService.selectCount(from, to);
		}
		int totalPage = (int)Math.ceil((double)totalRecord/pageSize);
		
		if( page < 1 || page > totalPage ){
			page = 1;
		}
		
		Integer offset = (page-1)*pageSize;
		List<River> rivers = null;
		if( type.equals("s") ){
			rivers = flowService.selectFromTo(stcd, from, to, offset, pageSize);
		}else{
			rivers = flowService.selectFromTo(from, to, offset, pageSize);
		}
		
		Map<String, String> stations = new HashMap<String, String>();
		List<User> users = userService.selectAll();
		for(User u : users){
			stations.put(u.getStcd(), u.getStnm());
		}
		
		model.addAttribute("page", page);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("totalRecord", totalRecord);
		model.addAttribute("dayEVs", rivers);
		model.addAttribute("stations", stations);
		model.addAttribute("parameters", funcUtil.requestParameters(request));
		
		return "FlowView";
	}
}

package gov.water.cms;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import gov.water.model.DayEV;
import gov.water.model.User;
import gov.water.service.DayEVService;

@Controller
@RequestMapping("cms")
public class ShowCtrl {
	
	@Autowired
	private DayEVService dayEVService;
	
	public void init(
			Model model,
			HttpSession httpSession
	){
		User user = (User)httpSession.getAttribute("user");
		model.addAttribute("stnm", user.getStnm());
	}
	
	@RequestMapping(value="/show")
	public String select(HttpServletRequest request){
		return "redirect:/cms/show/1"+this.requestParameters(request);
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
		long totalRecord = dayEVService.selectCount(stcd, from, to);
		int totalPage = (int)Math.ceil((double)totalRecord/pageSize);
		
		if( page < 1 || page > totalPage ){
			page = 1;
		}
		
		Integer offset = (page-1)*pageSize;
		List<DayEV> dayEVs = dayEVService.selectFromTo(stcd, from, to, offset, pageSize);
		
		model.addAttribute("page", page);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("totalRecord", totalRecord);
		model.addAttribute("dayEVs", dayEVs);
		model.addAttribute("parameters", this.requestParameters(request));
		
		return "ShowView";
	}
	
	private String requestParameters(HttpServletRequest request){
		String retval = "";
		
		Enumeration<String> em = request.getParameterNames();
		while (em.hasMoreElements()) {
		    String name = (String) em.nextElement();
		    String value = request.getParameter(name);
		    
		    if( retval.equals("") ){
				retval = "?" + name + "=" + value;
			}else{
				retval += "&" + name + "=" + value;
			}
		}
		
		return retval;
	}
	
	/*@RequestMapping(value="show", method=RequestMethod.POST)
	public String show(
			@RequestParam(value="user_stcd") String user_stcd, 
			@RequestParam(value="user_psd") String user_psd, 
			Model model, 
			HttpSession httpSession
	){
		init(model, httpSession);
		
		return "ShowView";
	}*/
}

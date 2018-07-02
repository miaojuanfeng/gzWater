package gov.water.cms;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import gov.water.model.User;

@Controller
public class ShowCtrl {
	
	public void init(
			Model model,
			HttpSession httpSession
	){
		User user = (User)httpSession.getAttribute("user");
		model.addAttribute("station", user.getStnm());
	}
	
	@RequestMapping(value="show", method=RequestMethod.GET)
	public String show(
			Model model,
			HttpSession httpSession
	){
		init(model, httpSession);
		
		return "ShowView";
	}
	
	@RequestMapping(value="show", method=RequestMethod.POST)
	public String show(
			@RequestParam(value="user_stcd") String user_stcd, 
			@RequestParam(value="user_psd") String user_psd, 
			Model model, 
			HttpSession httpSession
	){
		init(model, httpSession);
		
		return "ShowView";
	}
}

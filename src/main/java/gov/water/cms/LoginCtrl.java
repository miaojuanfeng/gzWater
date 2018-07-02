package gov.water.cms;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import gov.water.model.User;
import gov.water.service.UserService;

@Controller
public class LoginCtrl {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login(HttpSession httpSession) {
		if( httpSession.getAttribute("user") != null ){
			return "redirect:/post";
		}
		return "UserView";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(
			@RequestParam(value="user_stcd") String user_stcd, 
			@RequestParam(value="user_pwd") String user_pwd, 
			Model model, 
			HttpSession httpSession
	){
		if( httpSession.getAttribute("user") != null ){
			return "redirect:/post";
		}
		
		String error = null;
		
		User user = userService.selectByPrimaryKey(user_stcd);
		
		if( user != null ){
			if( user.getPwd() != null && user_pwd.equals(user.getPwd()) ){
				httpSession.setAttribute("user", user);
				
				return "redirect:/post";
			}else{
				error = "密码不正确";
			}
		}else if( user_stcd != null ){
			error = "用户不存在";
		}
		
		if( error != null ){
			model.addAttribute("error", error);
		}
		model.addAttribute("user_stcd", user_stcd);
		
		return "UserView";
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpSession httpSession){
		httpSession.setAttribute("user", null);
		
		return "redirect:/login";
	}
}

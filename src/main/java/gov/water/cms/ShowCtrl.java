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
	
	@RequestMapping(value="show", method=RequestMethod.GET)
	public String show() {
		
		return "ShowView";
	}
	
	@RequestMapping(value="show", method=RequestMethod.POST)
	public String show(
			@RequestParam(value="user_stcd") String user_stcd, 
			@RequestParam(value="user_psd") String user_psd, 
			Model model, 
			HttpSession httpSession
	){
		if( httpSession.getAttribute("user") != null ){
			return "redirect:/cms/dashboard/select";
		}
		
		String error = null;
		
		User user = userService.selectByPrimaryKey(user_stcd);
		
		if( user != null ){
			String userPsd = user.getPsd();
			if( userPsd != null && userPsd.equals(user_psd) ){
				httpSession.setAttribute("user", user);
				
				return "redirect:/cms/dashboard/select";
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
		model.addAttribute("user_psd", user_psd);
		
		return "ShowView";
	}
}

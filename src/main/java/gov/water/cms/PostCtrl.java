package gov.water.cms;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import gov.water.model.User;

@Controller
public class PostCtrl {
	
	@RequestMapping(value="post", method=RequestMethod.GET)
	public String post() {
		
		return "PostView";
	}
	
	@RequestMapping(value="post", method=RequestMethod.POST)
	public String post(
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
				error = "���벻��ȷ";
			}
		}else if( user_stcd != null ){
			error = "�û�������";
		}
		
		if( error != null ){
			model.addAttribute("error", error);
		}
		model.addAttribute("user_stcd", user_stcd);
		model.addAttribute("user_psd", user_psd);
		
		return "LoginView";
	}
}

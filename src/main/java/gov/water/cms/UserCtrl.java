package gov.water.cms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cms/user")
public class UserCtrl {
	
	@RequestMapping("login")
	public String login() {
		return "loginView";
	}
}

package gov.water.cms;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import gov.water.model.DayEV;
import gov.water.model.User;
import gov.water.service.DayEVService;

@Controller
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
	
	@RequestMapping(value="show", method=RequestMethod.GET)
	public String show(
			Model model,
			HttpSession httpSession
	){
		init(model, httpSession);
		
		List<DayEV> dayEVs = dayEVService.selectFromTo("62304720", "2018-06-01", "2018-07-05", 0, 10);
		System.out.println(dayEVs.size());
		
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

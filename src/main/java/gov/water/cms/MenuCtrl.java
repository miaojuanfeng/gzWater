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
@RequestMapping("cms")
public class MenuCtrl {
	
	@RequestMapping(value="")
	public String select(){
		return "MenuView";
	}
}

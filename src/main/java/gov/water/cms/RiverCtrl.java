package gov.water.cms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import gov.water.service.RiverService;

@Controller
public class RiverCtrl {
	
	@Autowired
	private RiverService riverService;
}

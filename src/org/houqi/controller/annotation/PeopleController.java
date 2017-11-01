package org.houqi.controller.annotation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.houqi.domain.People;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PeopleController {
	private static final Log logger=LogFactory.getLog(PeopleController.class);
	@RequestMapping(value="/people")
	public String goPeople(){
		return "people";
	}                       
	@RequestMapping(value="/peopleRegister",method=RequestMethod.POST)
	public String register(@ModelAttribute People people,Model model){
		logger.info(people);
		model.addAttribute("people",people);
		return "success";
	}
}

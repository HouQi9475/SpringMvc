package org.houqi.controller.annotation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Index {

	private static final Log logger = LogFactory.getLog(Index.class);
	
	@RequestMapping("/index")
	public String index(){
		logger.info("go to welcome..");
		return "welcome";
	}
}

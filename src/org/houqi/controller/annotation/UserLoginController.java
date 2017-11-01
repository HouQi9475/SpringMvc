package org.houqi.controller.annotation;

import org.houqi.domain.User;
import org.houqi.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserLoginController {
	//注入UserValidator对象
	@Autowired
	@Qualifier("userValidator")
	private UserValidator userValidator;
	
	@RequestMapping("/goUserLogin")
	public String goLogin(User user){
		return "userLogin";
	}
	@RequestMapping(value="/userLogin", method=RequestMethod.POST)
	public String login(@ModelAttribute User user,Model model,Errors errors){
		System.out.println(user);
		model.addAttribute("user",user);
		//调用userValidator的验证方法
		userValidator.validate(user, errors);
		if(errors.hasErrors()){
			return "userLogin";
		}
		return "success";
	}
}

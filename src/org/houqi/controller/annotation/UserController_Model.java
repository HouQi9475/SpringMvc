package org.houqi.controller.annotation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.houqi.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * SpringMvc通过Model输出模型数据
 * @author HouQi

 *
 */

@Controller
public class UserController_Model {

	private static final Log logger=LogFactory.getLog(UserController_Model.class);
	//@ModelAttribute修饰的方法会优先与Login调用，用来获取前台JSP页面传来的参数
	@ModelAttribute
	public void userModel(String username,String password,Model model){
		logger.info("userModel..");
		//创建USER对象存储JSP页面传入的参数
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		//将user对象添加到Model中
		model.addAttribute("user", user);
	}
	@RequestMapping("/login_model")
	public String Login(Model model){
		logger.info("Login...");
		//从model取出存入到Model中的user对象
		User user=(User) model.asMap().get("user");
		System.out.println(user);
		//设置user的age属性
		user.setAge(23);
		return "result_model";
	}
}

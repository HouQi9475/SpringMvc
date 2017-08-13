package org.houqi.controller.annotation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.houqi.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 通过ModelMap输出模型数据
 * 
 * @author HouQi
 */
@Controller
public class UserController_ModelMap {
	private static final Log logger = LogFactory.getLog(UserController_ModelMap.class);

	@ModelAttribute
	public void UserModelMap(String username, String password, ModelMap modelMap) {
		logger.info("UserModelMap");
		// 创建USER对象存储JSP页面传入的参数
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		// 将User对象添加到ModelMap
		modelMap.addAttribute("user", user);
	}
	@RequestMapping("/login_modelMap")
	public String Login(ModelMap modelMap){
		logger.info("Login...");
		//从modelMap取出存入到ModelMap中的user对象
		User user=(User) modelMap.get("user");
		System.out.println(user);
		//设置user的age属性
		user.setAge(23);
		return "result_modelMap";
	}
}

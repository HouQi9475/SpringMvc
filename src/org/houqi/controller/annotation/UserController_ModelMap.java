package org.houqi.controller.annotation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.houqi.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ͨ��ModelMap���ģ������
 * 
 * @author HouQi
 */
@Controller
public class UserController_ModelMap {
	private static final Log logger = LogFactory.getLog(UserController_ModelMap.class);

	@ModelAttribute
	public void UserModelMap(String username, String password, ModelMap modelMap) {
		logger.info("UserModelMap");
		// ����USER����洢JSPҳ�洫��Ĳ���
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		// ��User������ӵ�ModelMap
		modelMap.addAttribute("user", user);
	}
	@RequestMapping("/login_modelMap")
	public String Login(ModelMap modelMap){
		logger.info("Login...");
		//��modelMapȡ�����뵽ModelMap�е�user����
		User user=(User) modelMap.get("user");
		System.out.println(user);
		//����user��age����
		user.setAge(23);
		return "result_modelMap";
	}
}

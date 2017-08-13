package org.houqi.controller.annotation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.houqi.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * SpringMvcͨ��Model���ģ������
 * @author HouQi

 *
 */

@Controller
public class UserController_Model {

	private static final Log logger=LogFactory.getLog(UserController_Model.class);
	//@ModelAttribute���εķ�����������Login���ã�������ȡǰ̨JSPҳ�洫���Ĳ���
	@ModelAttribute
	public void userModel(String username,String password,Model model){
		logger.info("userModel..");
		//����USER����洢JSPҳ�洫��Ĳ���
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		//��user������ӵ�Model��
		model.addAttribute("user", user);
	}
	@RequestMapping("/login_model")
	public String Login(Model model){
		logger.info("Login...");
		//��modelȡ�����뵽Model�е�user����
		User user=(User) model.asMap().get("user");
		System.out.println(user);
		//����user��age����
		user.setAge(23);
		return "result_model";
	}
}

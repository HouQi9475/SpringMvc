package org.houqi.controller.annotation;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.houqi.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController_requestMapping {

	// ��̬��־��
	private static final Log logger = LogFactory.getLog(UserController_requestMapping.class);

	// ��̬List<User>���ϣ��˴�������ݿ���������ע����û���Ϣ
	private static List<User> userList;

	// UserController_requestMapping�Ĺ���������ʼ��List<User>����
	public UserController_requestMapping() {
		super();
		userList = new ArrayList<User>();
	}

	// �÷���ӳ�������Ϊ: http://localhost:8080/SpringMvc/user/register,�÷���֧��get
	// �������е�username��ֵ��ֵ��username������passwordͬ����
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerForm() {
		logger.info("����register_GET...");
		return "registerForm";
	}

	// �÷���ӳ�������Ϊ: http://localhost:8080/SpringMvc/user/register,�÷���֧��post
	// �������е�username��ֵ��ֵ��username������passwordͬ����
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@RequestParam("username") String username, 
			               @RequestParam("password") String password) {
		logger.info("����register_POST...");
		// ����user����
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setAge(23);
		// ģ�����ݿ�洢��Ϣ
		userList.add(user);
		// ��ת����¼ҳ��
		return "loginForm";
	}
	@RequestMapping("/login")
	public String login(
			@RequestParam("username") String username, 
            @RequestParam("password") String password,
            Model model
			){
		logger.info("��¼��:"+username+"����:"+password);
		//�������в����û��Ƿ���ڣ��˴�����ģ�����ݿ���֤
		for(User user:userList){
			if(user.getUsername().equals(username)&&user.getPassword().equals(password)){
				model.addAttribute("user", user);
				return "welcome";
			}
		}
		return "loginForm";
	}
}

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

	// 静态日志类
	private static final Log logger = LogFactory.getLog(UserController_requestMapping.class);

	// 静态List<User>集合，此处替代数据库用来保存注册的用户信息
	private static List<User> userList;

	// UserController_requestMapping的构造器，初始化List<User>集合
	public UserController_requestMapping() {
		super();
		userList = new ArrayList<User>();
	}

	// 该方法映射的请求为: http://localhost:8080/SpringMvc/user/register,该方法支持get
	// 将请求中的username的值赋值给username变量，password同样。
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerForm() {
		logger.info("调用register_GET...");
		return "registerForm";
	}

	// 该方法映射的请求为: http://localhost:8080/SpringMvc/user/register,该方法支持post
	// 将请求中的username的值赋值给username变量，password同样。
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@RequestParam("username") String username, 
			               @RequestParam("password") String password) {
		logger.info("调用register_POST...");
		// 创建user对象
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setAge(23);
		// 模拟数据库存储信息
		userList.add(user);
		// 跳转到登录页面
		return "loginForm";
	}
	@RequestMapping("/login")
	public String login(
			@RequestParam("username") String username, 
            @RequestParam("password") String password,
            Model model
			){
		logger.info("登录名:"+username+"密码:"+password);
		//到集合中查找用户是否存在，此处用来模拟数据库验证
		for(User user:userList){
			if(user.getUsername().equals(username)&&user.getPassword().equals(password)){
				model.addAttribute("user", user);
				return "welcome";
			}
		}
		return "loginForm";
	}
}

package org.houqi.controller.annotation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * HelloController是一个基于注解的控制器 可以处理多个任务请求，并且无需实现任何接口
 * org.springframework.stereotype.Controller注解用于指示该类是一个控制器
 * 
 * @author HouQi
 *
 */
@Controller
public class HelloController {

	private static Log logger = LogFactory.getLog(HelloController.class);

	/**
	 * org.springframework.web.bind.annotation.RequestMapping注解
	 * 用来映射请求的Url和请求的方法等。本例用来映射"/hello" hello只是一个普通的方法
	 */
	@RequestMapping(value = "/hello")
	public ModelAndView hello() {
		logger.info("annotation handleRequest被调用!");
		// 创建准备返回的ModelAndView对象，该对象通常包含了返回视图名，模型的名称以及对象
		ModelAndView mv = new ModelAndView();
		// 添加模型数据，可以是任意的pojo类
		mv.addObject("message", "Hello SpringMVC");
		// 设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
		mv.setViewName("/WEB-INF/content/welcome.jsp");
		// 返回ModelAndView对象
		return mv;
	}

}

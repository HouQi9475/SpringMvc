package org.houqi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
/**
 * 该类是一个实现了controller接口的控制器
 * 可以处理一个单一的动作请求
 * @author HouQi

 *
 */
public class HelloController implements Controller {
	
	private static final Log logger=LogFactory.getLog(HelloController.class);

	/**
	 * handleRequest是实现Controller接口必须实现的方法
	 * 该方法必须返回一个ModelAndView对象
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		logger.info("handleRequest被调用!");
		//创建准备返回的ModelAndView对象，该对象通常包含了返回视图名，模型的名称以及对象
		ModelAndView mv=new ModelAndView();
		//添加模型数据，可以是任意的pojo类.
		mv.addObject("message", "Hello SpringMVC");
		//设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
		mv.setViewName("/WEB-INF/content/welcome.jsp");
		//返回ModelAndView对象
		return mv;
	}

}

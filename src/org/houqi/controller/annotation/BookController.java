package org.houqi.controller.annotation;


import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.houqi.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * setJson方法中的第一个参数 @RequestBody Book book的作用是使用@RequestBody将传来的json格式的数据
 * 一一对应到book对象的属性中，第二个参数response用来输出响应数据到客户端
 * @author HouQi
 *
 */
@Controller
@RequestMapping("/json")
public class BookController {
	private static final Log logger = LogFactory.getLog(BookController.class);

	@RequestMapping(value="requestBody")
	public String testRequestBody(){
		return "jsonDemo";
	}
	// @RequestBody 根据json数据转换为对应的object对象
	@RequestMapping(value = "testRequestBody")
	public void setJson(@RequestBody Book book, HttpServletResponse response)
			throws Exception {
		//ObjectMapper类是Jackson库中的主要类，它提供一些功能将Java对象转换成对应的json格式的数据
		ObjectMapper mapper=new ObjectMapper();
		//将book对象转换为json格式输出
		logger.info(mapper.writeValueAsString(book));
		book.setAuther("侯琪");
		response.setContentType("text/html;charset=UTF-8");
		//将book对象转换成json输出到客户端
		response.getWriter().print(mapper.writeValueAsString(book));
	}
}

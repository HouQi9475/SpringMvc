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
 * setJson�����еĵ�һ������ @RequestBody Book book��������ʹ��@RequestBody��������json��ʽ������
 * һһ��Ӧ��book����������У��ڶ�������response���������Ӧ���ݵ��ͻ���
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
	// @RequestBody ����json����ת��Ϊ��Ӧ��object����
	@RequestMapping(value = "testRequestBody")
	public void setJson(@RequestBody Book book, HttpServletResponse response)
			throws Exception {
		//ObjectMapper����Jackson���е���Ҫ�࣬���ṩһЩ���ܽ�Java����ת���ɶ�Ӧ��json��ʽ������
		ObjectMapper mapper=new ObjectMapper();
		//��book����ת��Ϊjson��ʽ���
		logger.info(mapper.writeValueAsString(book));
		book.setAuther("����");
		response.setContentType("text/html;charset=UTF-8");
		//��book����ת����json������ͻ���
		response.getWriter().print(mapper.writeValueAsString(book));
	}
}

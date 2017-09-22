package org.houqi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
/**
 * ������һ��ʵ����controller�ӿڵĿ�����
 * ���Դ���һ����һ�Ķ�������
 * @author HouQi

 *
 */
public class HelloController implements Controller {
	
	private static final Log logger=LogFactory.getLog(HelloController.class);

	/**
	 * handleRequest��ʵ��Controller�ӿڱ���ʵ�ֵķ���
	 * �÷������뷵��һ��ModelAndView����
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		logger.info("handleRequest������!");
		//����׼�����ص�ModelAndView���󣬸ö���ͨ�������˷�����ͼ����ģ�͵������Լ�����
		ModelAndView mv=new ModelAndView();
		//���ģ�����ݣ������������pojo��.
		mv.addObject("message", "Hello SpringMVC");
		//�����߼���ͼ������ͼ����������ݸ����ֽ������������ͼҳ��
		mv.setViewName("/WEB-INF/content/welcome.jsp");
		//����ModelAndView����
		return mv;
	}

}

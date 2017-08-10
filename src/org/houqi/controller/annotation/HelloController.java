package org.houqi.controller.annotation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * HelloController��һ������ע��Ŀ����� ���Դ������������󣬲�������ʵ���κνӿ�
 * org.springframework.stereotype.Controllerע������ָʾ������һ��������
 * 
 * @author HouQi
 *
 */
@Controller
public class HelloController {

	private static Log logger = LogFactory.getLog(HelloController.class);

	/**
	 * org.springframework.web.bind.annotation.RequestMappingע��
	 * ����ӳ�������Url������ķ����ȡ���������ӳ��"/hello" helloֻ��һ����ͨ�ķ���
	 */
	@RequestMapping(value = "/hello")
	public ModelAndView hello() {
		logger.info("annotation handleRequest������!");
		// ����׼�����ص�ModelAndView���󣬸ö���ͨ�������˷�����ͼ����ģ�͵������Լ�����
		ModelAndView mv = new ModelAndView();
		// ���ģ�����ݣ������������pojo��
		mv.addObject("message", "Hello SpringMVC");
		// �����߼���ͼ������ͼ����������ݸ����ֽ������������ͼҳ��
		mv.setViewName("/WEB-INF/content/welcome.jsp");
		// ����ModelAndView����
		return mv;
	}

}

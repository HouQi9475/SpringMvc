package org.houqi.controller.annotation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ����      @PathVarialbe,@RequestHeader,@CookieValue
 * @author HouQi
 *
 */
@Controller
public class DataBindingController {
    //��־���
	private static final Log logger=LogFactory.getLog(DataBindingController.class);
	//���� @PathVariable
	@RequestMapping(value="/pathVariable/{userid}")
	public void testPathVariable(@PathVariable Integer userid){
		logger.info("ͨ��@PathVariable��ò���Ϊ:"+userid);
	}
	//����@RequestHeader
	@RequestMapping(value="/requestHeader")
	public void testRequestHeader(@RequestHeader("User-Agent") String agent,
								  @RequestHeader("Accept") String[] accepts){
		logger.info("ͨ��@RequestHeader��õ�����ͷΪ:"+agent);
		for(String accept:accepts){
			logger.info(accept);
		}
	}
	//����@CookieValue
	@RequestMapping(value="/cookieVlue")
	public void testCookieVlue(@CookieValue(value="JSESSIONID") String sessionid){
		logger.info("ͨ��CookieValue��õ�����Ϊ:"+sessionid);
	}
}

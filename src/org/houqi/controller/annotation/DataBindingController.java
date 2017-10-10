package org.houqi.controller.annotation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试      @PathVarialbe,@RequestHeader,@CookieValue
 * @author HouQi
 *
 */
@Controller
public class DataBindingController {
    //日志输出
	private static final Log logger=LogFactory.getLog(DataBindingController.class);
	//测试 @PathVariable
	@RequestMapping(value="/pathVariable/{userid}")
	public void testPathVariable(@PathVariable Integer userid){
		logger.info("通过@PathVariable获得参数为:"+userid);
	}
	//测试@RequestHeader
	@RequestMapping(value="/requestHeader")
	public void testRequestHeader(@RequestHeader("User-Agent") String agent,
								  @RequestHeader("Accept") String[] accepts){
		logger.info("通过@RequestHeader获得的请求头为:"+agent);
		for(String accept:accepts){
			logger.info(accept);
		}
	}
	//测试@CookieValue
	@RequestMapping(value="/cookieVlue")
	public void testCookieVlue(@CookieValue(value="JSESSIONID") String sessionid){
		logger.info("通过CookieValue获得的数据为:"+sessionid);
	}
}

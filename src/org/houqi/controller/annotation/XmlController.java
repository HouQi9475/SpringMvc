package org.houqi.controller.annotation;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.houqi.domain.Player;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.jmx.remote.internal.Unmarshal;

/**
 * 
 * @author HouQi
 *
 */
@Controller
@RequestMapping(value = "xml")
public class XmlController {
	// 日志类
	private static final Log logger = LogFactory.getLog(XmlController.class);

	// 跳转到sendXmlDemo
	@RequestMapping("testSendXml")
	public String toSendXmlDemo() {
		return "sendXmlDemo";
	}

	// 跳转到readXmlDemo
	@RequestMapping("testReadXml")
	public String toReadXmlDemo() {
		return "readXmlDemo";
	}

	// @RequestBody Player player 将传来的XML数据绑定到对应的Player对象上
	@RequestMapping(value = "sendXml", method = RequestMethod.POST)
	public void sendXml(@RequestBody Player player) {
		logger.info(player);
		logger.info("接受xml数据成功！");
	}

	// @ResponseBody 将自动把Player对象转换为xml
	@RequestMapping(value = "readXml", method = RequestMethod.POST)
	public @ResponseBody Player readXml() throws Exception {
		// 通过JAXBContext的 newInstance方法，传递一个class就可以获得一个上下文
		JAXBContext context = JAXBContext.newInstance(Player.class);
		// 创建一个Unmarshall对象
		Unmarshaller unmar = context.createUnmarshaller();
		InputStream in = this.getClass().getResourceAsStream("/player.xml");
		// Unmarshaller对象的unmarshal方法可以完成xml到java对象的转换
		Player player = (Player) unmar.unmarshal(in);
		logger.info(player);
		return player;
	}
}

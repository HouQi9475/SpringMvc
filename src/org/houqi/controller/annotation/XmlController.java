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
	// ��־��
	private static final Log logger = LogFactory.getLog(XmlController.class);

	// ��ת��sendXmlDemo
	@RequestMapping("testSendXml")
	public String toSendXmlDemo() {
		return "sendXmlDemo";
	}

	// ��ת��readXmlDemo
	@RequestMapping("testReadXml")
	public String toReadXmlDemo() {
		return "readXmlDemo";
	}

	// @RequestBody Player player ��������XML���ݰ󶨵���Ӧ��Player������
	@RequestMapping(value = "sendXml", method = RequestMethod.POST)
	public void sendXml(@RequestBody Player player) {
		logger.info(player);
		logger.info("����xml���ݳɹ���");
	}

	// @ResponseBody ���Զ���Player����ת��Ϊxml
	@RequestMapping(value = "readXml", method = RequestMethod.POST)
	public @ResponseBody Player readXml() throws Exception {
		// ͨ��JAXBContext�� newInstance����������һ��class�Ϳ��Ի��һ��������
		JAXBContext context = JAXBContext.newInstance(Player.class);
		// ����һ��Unmarshall����
		Unmarshaller unmar = context.createUnmarshaller();
		InputStream in = this.getClass().getResourceAsStream("/player.xml");
		// Unmarshaller�����unmarshal�����������xml��java�����ת��
		Player player = (Player) unmar.unmarshal(in);
		logger.info(player);
		return player;
	}
}

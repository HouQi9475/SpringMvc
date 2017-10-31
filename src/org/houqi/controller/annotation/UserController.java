package org.houqi.controller.annotation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.houqi.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author HouQi

 *
 */
@Controller
public class UserController {
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register(Model model){
		List<String> hobbies=new ArrayList<String>();
		hobbies.add("java");
		hobbies.add("python");
		List<String> allHobbies=new ArrayList<String>();
		allHobbies.add("java");
		allHobbies.add("android");
		allHobbies.add("linux");
		allHobbies.add("c++");
		Map<String,String> mapHobbies=new HashMap<String, String>();
		mapHobbies.put("c++", "c����");
		mapHobbies.put("java", "צ��");
		mapHobbies.put("linux", "��Ŧ��˹");
		mapHobbies.put("python", "��ɭ");
		List<Boolean> radio=new ArrayList<Boolean>();
		radio.add(true);
		radio.add(false);
		Map<Boolean,String> free=new HashMap<Boolean, String>();
		free.put(true, "���");
		free.put(false, "�շ�");
		Map<Boolean,String> wantGo=new HashMap<Boolean, String>();
		wantGo.put(true, "����");
		wantGo.put(false, "����");
		User user=new User("����","hou940705",24,true,hobbies);
		//model��������� commond ��ֵ�� user
		model.addAttribute("command",user);
		model.addAttribute("user",user);
		model.addAttribute("allHobbies",allHobbies);
		model.addAttribute("mapHobbies",mapHobbies);
		model.addAttribute("radio",radio);
		model.addAttribute("free",free);
		model.addAttribute("wantGo",wantGo);
		return "register";
	}
}

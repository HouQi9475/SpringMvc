package org.houqi.controller.annotation;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * �ļ��ϴ�
 * @author HouQi
 * �ϴ��ļ����Զ��󶨵�MultipartFile��.
 * MultipartFile�����г��õķ���:
 * getBytes ��ȡ�ļ�����
 * getContentType ��ȡmime���� ���� image/jpeg��
 * getInputStream ��ȡ�ļ���
 * getName ��ȡ�����ļ����������
 * getOriginalFilename ��ȡ�ϴ��ļ���ԭ��
 * isEmpty �Ƿ����ϴ��ļ�
 * transferTo(File file) ���ϴ��ļ����浽��һ���ļ���
 */
@Controller
public class UploadFileController {
	@RequestMapping("/upload")
	public String goUpload(){
		return "uploadFileForm";
	}
	@RequestMapping(value="uploadFile",method=RequestMethod.POST)
	public String upload(HttpServletRequest request
						 ,String memo
						 ,@RequestParam("file") MultipartFile file) throws Exception{
		System.out.println(memo);
		//����ļ���Ϊ�գ�д���ϴ�·��
		if(!file.isEmpty()){
			//�ϴ��ļ�·��
			String path=request.getServletContext().getRealPath("/images/");
			//D:\Program Files\apache-tomcat-7.0.35\webapps\SpringMvc\images
			System.out.println("�ļ�·��"+path);
			//�ϴ��ļ���
			String filename=file.getOriginalFilename();
			File filepath=new File(path,filename);
			//�ж�·���Ƿ���ڣ����������򴴽�һ��
			if(!filepath.getParentFile().exists()){
				System.out.println(filepath.getParentFile());
				filepath.getParentFile().mkdirs();
			}
			//���ϴ��ļ����浽һ��Ŀ���ļ���
			file.transferTo(filepath);
			return "success";
		}else{
			return "error";
		}
	}
}

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
 * 文件上传
 * @author HouQi
 * 上传文件会自动绑定到MultipartFile中.
 * MultipartFile对象中常用的方法:
 * getBytes 获取文件数据
 * getContentType 获取mime类型 ，如 image/jpeg等
 * getInputStream 获取文件流
 * getName 获取表单中文件组件的名字
 * getOriginalFilename 获取上传文件的原名
 * isEmpty 是否有上传文件
 * transferTo(File file) 将上传文件保存到另一个文件中
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
		//如果文件不为空，写入上传路径
		if(!file.isEmpty()){
			//上传文件路径
			String path=request.getServletContext().getRealPath("/images/");
			//D:\Program Files\apache-tomcat-7.0.35\webapps\SpringMvc\images
			System.out.println("文件路径"+path);
			//上传文件名
			String filename=file.getOriginalFilename();
			File filepath=new File(path,filename);
			//判断路径是否存在，若不存在则创建一个
			if(!filepath.getParentFile().exists()){
				System.out.println(filepath.getParentFile());
				filepath.getParentFile().mkdirs();
			}
			//将上传文件保存到一个目标文件中
			file.transferTo(filepath);
			return "success";
		}else{
			return "error";
		}
	}
}

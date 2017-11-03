package org.houqi.controller.annotation;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.houqi.domain.People;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 上传用户头像
 * 
 * @author HouQi 文件下载： download接受到页面传递来的参数filename后，使用FileUtils读取项目images下面的该文件，
 *         并将其构建成ResponseEntity对象返回给客户端下载
 *         使用ResponseEntity对象,可以很方便的定义返回的HttpHeaders和HttpStatus.
 *         代码中的MediaType代表的是Internet Media Type ,即互联网媒体类型，也叫做MIME类型。
 *         在http协议消息头中，使用Content-type来表示具体请求中的媒体类型消息。HttpStatus类型代表
 *         的是http协议中的状态。
 */
@Controller
public class UploadPhotoController {
	@RequestMapping("/uploadPeople")
	public String uploadInfo() {
		return "userInfo";
	}

	@RequestMapping(value = "uploadPhoto", method = RequestMethod.POST)
	public String uploadPhoto(HttpServletRequest request,
			@ModelAttribute People people, Model model) {
		System.out.println("用户的登录名:" + people.getLoginname());
		// 如果文件不为空，写入上传路径
		if (!people.getPhoto().isEmpty()) {
			// 上传文件路径
			String path = request.getServletContext().getRealPath("/upload");
			// 上传文件名
			String filename = people.getPhoto().getOriginalFilename();
			System.out.println("上传时文件名:" + filename);
			File filepath = new File(path, filename);
			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			try {
				people.getPhoto().transferTo(filepath);
				model.addAttribute("people", people);
				return "success";
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "error";
	}

	// 文件下载

	@RequestMapping(value = "/download")
	public ResponseEntity<byte[]> download(HttpServletRequest request,
			@RequestParam("filename") String filename, Model model)
			throws Exception {
		// 下载文件路径
		String path = request.getServletContext().getRealPath("/upload");
		File file = new File(path + File.separator + filename);
		HttpHeaders headers = new HttpHeaders();
		System.out.println("文件名:" + filename);
		filename = new String(filename.getBytes("iso-8859-1"), "UTF-8");
		System.out.println("文件名:" + filename);
//		filename = processFileName(request, filename);
//		System.out.println("转码后文件名：" + filename);
		// 通知浏览器以 attachment(下载方式) 方式打开图片
		headers.setContentDispositionFormData("attachment", filename);
		// application/octet-stream: 二进制流数据 (最常见的文件下载)
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		// 201 HttpStatus.CREATED
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
				headers, HttpStatus.CREATED);
	}

	/**
	 * 
	 * @Title: processFileName
	 * 
	 * @Description: ie,chrom,firfox下处理文件名显示乱码
	 */
	public  String processFileName(HttpServletRequest request,
			String fileNames) {
		String codedfilename = null;
		try {
			String agent = request.getHeader("USER-AGENT");
			if (null != agent && -1 != agent.indexOf("MSIE") || null != agent
					&& -1 != agent.indexOf("Trident")) {// ie

				String name = java.net.URLEncoder.encode(fileNames, "UTF8");

				codedfilename = name;
			} else if (null != agent && -1 != agent.indexOf("Mozilla")) {// 火狐,chrome等

				codedfilename = new String(fileNames.getBytes("UTF-8"),
						"iso-8859-1");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return codedfilename;
	}
}

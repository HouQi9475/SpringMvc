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
 * �ϴ��û�ͷ��
 * 
 * @author HouQi �ļ����أ� download���ܵ�ҳ�洫�����Ĳ���filename��ʹ��FileUtils��ȡ��Ŀimages����ĸ��ļ���
 *         �����乹����ResponseEntity���󷵻ظ��ͻ�������
 *         ʹ��ResponseEntity����,���Ժܷ���Ķ��巵�ص�HttpHeaders��HttpStatus.
 *         �����е�MediaType�������Internet Media Type ,��������ý�����ͣ�Ҳ����MIME���͡�
 *         ��httpЭ����Ϣͷ�У�ʹ��Content-type����ʾ���������е�ý��������Ϣ��HttpStatus���ʹ���
 *         ����httpЭ���е�״̬��
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
		System.out.println("�û��ĵ�¼��:" + people.getLoginname());
		// ����ļ���Ϊ�գ�д���ϴ�·��
		if (!people.getPhoto().isEmpty()) {
			// �ϴ��ļ�·��
			String path = request.getServletContext().getRealPath("/upload");
			// �ϴ��ļ���
			String filename = people.getPhoto().getOriginalFilename();
			System.out.println("�ϴ�ʱ�ļ���:" + filename);
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

	// �ļ�����

	@RequestMapping(value = "/download")
	public ResponseEntity<byte[]> download(HttpServletRequest request,
			@RequestParam("filename") String filename, Model model)
			throws Exception {
		// �����ļ�·��
		String path = request.getServletContext().getRealPath("/upload");
		File file = new File(path + File.separator + filename);
		HttpHeaders headers = new HttpHeaders();
		System.out.println("�ļ���:" + filename);
		filename = new String(filename.getBytes("iso-8859-1"), "UTF-8");
		System.out.println("�ļ���:" + filename);
//		filename = processFileName(request, filename);
//		System.out.println("ת����ļ�����" + filename);
		// ֪ͨ������� attachment(���ط�ʽ) ��ʽ��ͼƬ
		headers.setContentDispositionFormData("attachment", filename);
		// application/octet-stream: ������������ (������ļ�����)
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		// 201 HttpStatus.CREATED
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
				headers, HttpStatus.CREATED);
	}

	/**
	 * 
	 * @Title: processFileName
	 * 
	 * @Description: ie,chrom,firfox�´����ļ�����ʾ����
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
			} else if (null != agent && -1 != agent.indexOf("Mozilla")) {// ���,chrome��

				codedfilename = new String(fileNames.getBytes("UTF-8"),
						"iso-8859-1");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return codedfilename;
	}
}

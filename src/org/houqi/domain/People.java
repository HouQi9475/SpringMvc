package org.houqi.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class People implements Serializable{
	private String loginname;
	private Date birthday;
	//对应上传的file，上传文件会自动绑定到photo中
	private MultipartFile photo;
	
	public People() {
		super();
		// TODO Auto-generated constructor stub
	}


	public People(String loginname, Date birthday, MultipartFile photo) {
		super();
		this.loginname = loginname;
		this.birthday = birthday;
		this.photo = photo;
	}


	public MultipartFile getPhoto() {
		return photo;
	}


	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}


	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "People [loginname=" + loginname + ", birthday=" + birthday
				+ "]";
	}
	
}

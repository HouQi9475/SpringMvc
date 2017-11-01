package org.houqi.domain;

import java.io.Serializable;
import java.util.Date;

public class People implements Serializable{
	private String loginname;
	private Date birthday;
	
	public People() {
		super();
		// TODO Auto-generated constructor stub
	}

	public People(String loginname, Date birthday) {
		super();
		this.loginname = loginname;
		this.birthday = birthday;
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

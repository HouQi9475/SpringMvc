package org.houqi.domain;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{

	private String username;
	private String password;
	private int age;
	private boolean reader;
	private List<String> hobbies;
	
	//公共构造器
	public User(){
		super();
	}
	

	public User(String username, String password, int age, boolean reader, List<String> hobbies) {
		super();
		this.username = username;
		this.password = password;
		this.age = age;
		this.reader = reader;
		this.hobbies = hobbies;
	}


	public boolean isReader() {
		return reader;
	}


	public void setReader(boolean reader) {
		this.reader = reader;
	}


	public List<String> getHobbies() {
		return hobbies;
	}


	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}

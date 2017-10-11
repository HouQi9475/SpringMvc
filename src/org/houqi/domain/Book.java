package org.houqi.domain;

import java.io.Serializable;

public class Book implements Serializable{
	private Integer id;
	private String name;
	private String auther;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(Integer id, String name, String auther) {
		super();
		this.id = id;
		this.name = name;
		this.auther = auther;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuther() {
		return auther;
	}

	public void setAuther(String auther) {
		this.auther = auther;
	}
	
}

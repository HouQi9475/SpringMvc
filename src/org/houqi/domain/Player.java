package org.houqi.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * @xmlRootElement 表示xml文档的根元素
 * @author HouQi
 *
 */
@XmlRootElement
public class Player implements Serializable {
	private Integer id;
	private String name;
	private Integer age;
	
	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Player(Integer id, String name, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}
	//该属性作为xml的element
	@XmlElement
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}
	@XmlElement
	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
}

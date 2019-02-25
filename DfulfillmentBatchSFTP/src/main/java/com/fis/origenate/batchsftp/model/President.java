package com.fis.origenate.batchsftp.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "President")
public class President {

	private String name;
	private String email;
	private String gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	private Integer age;

	@Override
	public String toString() {
		return "President [name=" + name + ", email=" + email + ", gender=" + gender + ", age=" + age + "]";
	}

}

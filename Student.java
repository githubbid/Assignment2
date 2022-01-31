package com.curd.curddemo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student 
{
	private int id;
	private String first_name;
	private String last_name;
	private String email;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String fist_name) {
		this.first_name = fist_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString()
	{
		return "Student [id=" + id + ", First Name=" + first_name + ", Last Name=" + last_name + ", Email=" + email + "]";  
	}
 	
	
}

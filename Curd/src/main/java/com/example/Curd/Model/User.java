package com.example.Curd.Model;

import org.springframework.stereotype.Component;

@Component
public class User {

	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + ", city=" + city + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	private String name;
	private Integer id;
	private String city;
	public User(String name, Integer id, String city) {
		super();
		this.name = name;
		this.id = id;
		this.city = city;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

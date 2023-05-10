package com.example.Curd.Model;

public class ResponseFile {

	private String url;
	private String name;
	private String type;
	public ResponseFile(String url, String name, String type) {
		super();
		this.url = url;
		this.name = name;
		this.type = type;
	}
	public ResponseFile() {
		super();
		
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}

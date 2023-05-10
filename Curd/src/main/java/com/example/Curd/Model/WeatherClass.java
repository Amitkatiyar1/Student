package com.example.Curd.Model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "Weather")
public class WeatherClass {
	
	private String main;
	private String description;
	private float temp;
	private String country;
	private String name;
	private Integer humidity;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date date = new Date();

	public Integer getHumidity() {
		return humidity;
	}

	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getTemp() {
		return temp;
	}

	public void setTemp(float temp) {
		this.temp = temp;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WeatherClass(String main, String description, float temp, String country, String name, Integer humidity,
			Date date) {
		super();
		this.main = main;
		this.description = description;
		this.temp = temp;
		this.country = country;
		this.name = name;
		this.humidity = humidity;
		this.date = date;
	}

	public WeatherClass() {
		super();

	}
	@Override
	public String toString() {
		return "ModelClass [main=" + main + ", description=" + description + ", temp=" + temp + ", country=" + country
				+ ", name=" + name + ", humidity=" + humidity + ", date=" + date + "]";
	}


}

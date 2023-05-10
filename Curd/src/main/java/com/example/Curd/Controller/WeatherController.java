package com.example.Curd.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Curd.Model.WeatherClass;
import com.example.Curd.Service.WeatherService;

@RestController
@CrossOrigin
public class WeatherController {
	
	@Autowired
	private WeatherService serviceLayer;

	@GetMapping("/full")
	public void getCurrent1() {
		serviceLayer.current();

	}

	// get Current Weather
	@GetMapping("/")
	public WeatherClass getCurrent() {

		return serviceLayer.currentWeather();

	}

	// pagination
	@GetMapping("/gets")
	public ResponseEntity<?> fetchData(
			@RequestParam(value = "pageNumber", defaultValue = "1", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "9", required = false) Integer pageSize) {
		List<WeatherClass> employee = serviceLayer.getApi(pageNumber, pageSize);
		return new ResponseEntity<>(employee, employee.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	// filter by name
	@GetMapping("/g")
	public ResponseEntity<?> fetchData1(@RequestParam(defaultValue = "") String name) {

		List<WeatherClass> employee = serviceLayer.get(name);

		return new ResponseEntity<>(employee, employee.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}
}

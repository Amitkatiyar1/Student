package com.example.Curd.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.Curd.Model.WeatherClass;
import com.example.Curd.Repository.WeatherRepo;

@Component
public class WeatherService {
	@Autowired
	private WeatherRepo weatherRepo;
	@Autowired
	private RestTemplate restTemplate;

	String url = "https://api.openweathermap.org/data/2.5/weather?q=Delhi&appid=216323d1dec04eb8c04b5bf74c6c685b&units=metric";
	String url1 = "https://api.openweathermap.org/data/2.5/weather?q=Surat&appid=216323d1dec04eb8c04b5bf74c6c685b&units=metric";
	String url2 = "https://api.openweathermap.org/data/2.5/weather?q=Kannauj&appid=216323d1dec04eb8c04b5bf74c6c685b&units=metric";

	
	// @Scheduled(fixedDelay = 1000)
	public void current() {

		List<String> ids = Arrays.asList(url, url1, url2);
		List<String> responses = ids.stream().map(id -> {
			return restTemplate.getForObject(id, String.class);
		}).collect(Collectors.toList());
		for (String response : responses) {
			JSONObject root = new JSONObject(response);
			JSONObject main = root.getJSONObject("main");
			JSONObject sys = root.getJSONObject("sys");
			JSONArray wea = root.getJSONArray("weather");
			JSONObject weas = wea.getJSONObject(0);
			WeatherClass as = new WeatherClass();
			String name = root.getString("name");
			as.setName(name);
			as.getDate();
			as.setCountry(sys.getString("country"));
			as.setMain(weas.getString("main"));
			as.setDescription(weas.getString("description"));
			as.setTemp(main.getInt("temp"));
			as.setHumidity(main.getInt("humidity"));
			// System.out.println(as);
			weatherRepo.save(as);

		}
	}

	// get Current Weather
	public WeatherClass currentWeather() {

		String data = restTemplate.getForObject(url, String.class);

		JSONObject root = new JSONObject(data);
		JSONObject main = root.getJSONObject("main");
		JSONObject sys = root.getJSONObject("sys");
		JSONArray wea = root.getJSONArray("weather");
		JSONObject weas = wea.getJSONObject(0);
		WeatherClass as = new WeatherClass();
		String name = root.getString("name");
		as.setName(name);
		as.getDate();
		as.setCountry(sys.getString("country"));
		as.setMain(weas.getString("main"));
		as.setDescription(weas.getString("description"));
		as.setTemp(main.getInt("temp"));
		as.setHumidity(main.getInt("humidity"));

		return as;

	}
	// Store in db

	// @Scheduled(fixedDelay = 1000)
	public void consumeApi() throws IOException, InterruptedException {

		String data = restTemplate.getForObject(url, String.class);
		JSONObject root = new JSONObject(data);
		JSONObject main = root.getJSONObject("main");
		JSONObject sys = root.getJSONObject("sys");
		JSONArray wea = root.getJSONArray("weather");
		JSONObject weas = wea.getJSONObject(0);
		// ModelClass create object
		WeatherClass model = new WeatherClass();
		String name = root.getString("name");
		model.setName(name);
		model.getDate();
		model.setCountry(sys.getString("country"));
		model.setMain(weas.getString("main"));
		model.setDescription(weas.getString("description"));
		model.setTemp(main.getInt("temp"));
		model.setHumidity(main.getInt("humidity"));

		weatherRepo.save(model);

	}

	// pagination
	public List<WeatherClass> getApi(Integer pageNumber, Integer pageSize) {
		Pageable p = PageRequest.of(pageNumber, pageSize);
		Page<WeatherClass> pagePost = weatherRepo.findAll(p);
		List<WeatherClass> list = pagePost.getContent();

		if (list.size() > 0) {
			return list;
		}
		return new ArrayList<WeatherClass>();

	}

	// filter by name
	public List<WeatherClass> get(String name) {
		if (name.equals("")) {
			return (List<WeatherClass>) weatherRepo.findAll();
		} else {
			return (List<WeatherClass>) weatherRepo.findByNameContaining(name);

		}

	}

}

//MongoCursor<ModelClass> cursor = documents.iterator();
//while (cursor.hasNext()) {
//    System.out.println(cursor.next());
//}
//return weatherRepo.findAll(Sort.by(Direction.ASC, "name"));
//ModelClass filter = (ModelClass) Filters.eq("name", "Surat");

//FindIterable<ModelClass> documents = weatherRepo.findAll(filter);

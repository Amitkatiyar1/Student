package com.example.Curd.Repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.Curd.Model.WeatherClass;

@EnableMongoRepositories
public interface WeatherRepo extends MongoRepository<WeatherClass, Integer>{

	List<WeatherClass> findByNameContaining(String name);
	
 

}

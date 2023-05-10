package com.example.Curd.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


import com.example.Curd.Model.UserRegistration;



@EnableMongoRepositories
public interface RegistrationRepo extends MongoRepository<UserRegistration, Integer>{
	
	UserRegistration findByemail(String email);

	Optional<UserRegistration> findByEmailAndPassword(String email, String epassword);

}

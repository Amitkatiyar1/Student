package com.example.Curd.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.Curd.Model.UserRegistration;




@EnableMongoRepositories
public interface LoginRepo extends MongoRepository<UserRegistration, Integer>{

   UserRegistration findByemail(String email);
	
   UserRegistration findByemailAndPassword(String password,String email);
}

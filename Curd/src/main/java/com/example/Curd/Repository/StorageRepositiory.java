package com.example.Curd.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Curd.Model.FileModelClass;



@Repository
public interface StorageRepositiory extends MongoRepository<FileModelClass, String> {

	
	//Optional<FileData> findbyName(String filename);
}

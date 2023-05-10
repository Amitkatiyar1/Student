package com.example.Curd.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.Curd.Model.Employee;



public interface EmployeeRepository extends MongoRepository<Employee, Integer>{

	@Query
	Optional<Employee> findById(int id);
}

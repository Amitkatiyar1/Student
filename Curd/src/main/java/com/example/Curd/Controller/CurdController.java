package com.example.Curd.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Curd.Model.Login;
import com.example.Curd.Model.Employee;
import com.example.Curd.Model.UserRegistration;
import com.example.Curd.Repository.EmployeeRepository;
import com.example.Curd.Service.EmployeeService;

import jakarta.validation.ConstraintViolationException;

@RestController
@CrossOrigin("*")
public class CurdController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeRepository employeeRepo;

	@PostMapping("/add")
	public ResponseEntity<?> create(@RequestBody Employee employee) {

		try {
			employeeService.add(employee);
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} catch (ConstraintViolationException e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get")
	public ResponseEntity<?> getData(
			@RequestParam(value = "pageNumber", defaultValue = "1", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "2", required = false) Integer pageSize) {

		List<Employee> employee = employeeService.get(pageNumber, pageSize);
		return new ResponseEntity<>(employee, employee.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);

	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> getdelete(@PathVariable("id") Integer id) {

		try {
			employeeService.delete(id);
			return new ResponseEntity<>("Successfully deleted with " + id, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody Employee employee, @PathVariable("id") Integer id) {

		employeeService.update(id, employee);
		return new ResponseEntity<>("update todo with id" + id, HttpStatus.OK);

	}

	@PostMapping("/save")
	public ResponseEntity<?> saveStudent(@RequestBody UserRegistration userRegistration) {

		String id = employeeService.addEmployee(userRegistration);
		System.out.println(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<?> Login(@RequestBody Login login) {

		employeeService.loginStudent(login);

		return new ResponseEntity<>(HttpStatus.OK);

	}
}

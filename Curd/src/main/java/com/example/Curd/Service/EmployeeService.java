package com.example.Curd.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.example.Curd.Exception.EmployeeException;
import com.example.Curd.Model.Employee;
import com.example.Curd.Model.Login;
import com.example.Curd.Model.UserRegistration;
import com.example.Curd.Repository.EmployeeRepository;
import com.example.Curd.Repository.RegistrationRepo;

@Repository
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;

	@Autowired
	private RegistrationRepo registrationReo;

	public void add(Employee employee) {

		employeeRepo.save(employee);
	}

	public List<Employee> get(Integer pageNumber, Integer pageSize) {

		Pageable p = PageRequest.of(pageNumber, pageSize);
		Page<Employee> pagePost = employeeRepo.findAll(p);
		List<Employee> stud = pagePost.getContent();

		if (stud.size() > 0) {
			return stud;
		}
		return new ArrayList<Employee>();

	}

	public void delete(Integer id) throws EmployeeException {

		Optional<Employee> optionalc = employeeRepo.findById(id);
		if (!optionalc.isPresent()) {
			throw new EmployeeException(EmployeeException.NotFoundException(id));

		} else {
			employeeRepo.deleteById(id);
		}
	}

	public void update(Integer id, Employee employee) {
		Optional<Employee> optional = employeeRepo.findById(id);
		Employee employeeUpdate = optional.get();
		employeeUpdate.setAddress(employee.getAddress());
		employeeUpdate.setId(employee.getId());
		employeeUpdate.setName(employee.getName());
		employeeUpdate.setAge(employee.getAge());
		employeeUpdate.setPost(employee.getPost());
		employeeRepo.save(employeeUpdate);

	}

	public String addEmployee(UserRegistration userRegistration) {
		userRegistration.getEmail();
		userRegistration.getId();
		userRegistration.getName();
		userRegistration.getPassword();
		registrationReo.save(userRegistration);
		return userRegistration.getName();
	}

	public void loginStudent(Login login) {
		UserRegistration userRegistration = registrationReo.findByemail(login.getEmail());
		if (userRegistration != null) {
			String passWord = login.getPassword();
			String epassword = userRegistration.getPassword();
			if (passWord.equals(epassword)) {
				registrationReo.findByEmailAndPassword(login.getEmail(), epassword);
			}
		}

	}

}

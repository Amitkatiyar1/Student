package SpringTest.test.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import SpringTest.test.Model.User;
import SpringTest.test.Service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping("/add")
	public User save (@RequestBody User user) {
		
		return userService.Create(user);
	}
	@GetMapping("/get")
	public List<User> getUser(){
		return userService.getUsers();
	}
}

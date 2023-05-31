package SpringTest.test.Service;

import java.util.List;

import SpringTest.test.Model.User;

public interface UserService {

	public User Create(User user);
	public List<User> getUsers();
	
}

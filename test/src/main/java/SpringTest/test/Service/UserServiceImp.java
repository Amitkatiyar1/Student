package SpringTest.test.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringTest.test.Model.User;
import SpringTest.test.UserRepos.UserRepo;

@Service
public class UserServiceImp implements UserService {
   @Autowired
	UserRepo userRepo;
   
	@Override
	public User Create(User user) {
		return userRepo.save(user);
	}

	@Override
	public List<User> getUsers() {
		return userRepo.findAll();
	}

	

	
}

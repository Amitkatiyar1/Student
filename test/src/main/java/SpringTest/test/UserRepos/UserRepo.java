package SpringTest.test.UserRepos;

import org.springframework.data.jpa.repository.JpaRepository;

import SpringTest.test.Model.User;

public interface UserRepo extends JpaRepository<User, String>{

}

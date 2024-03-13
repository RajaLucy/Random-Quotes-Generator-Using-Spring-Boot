package in.ashokit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByUserMail(String email);
	
	public  User findByUserMailAndUserPwd(String email,String pwd);
	
}


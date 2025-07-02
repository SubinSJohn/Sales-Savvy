package sales.savvy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sales.savvy.LoginData;
import sales.savvy.entity.User;
import sales.savvy.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService{
	
	@Autowired
	UserRepository repo;

	@Override
	public String signUp(User user) {
		String name = user.getUsername();
		User u = getUserByName(name);
		
		if(u == null) {
			repo.save(user);
			return "Success";
		} else {
			return "Failed";
		}
	}
	
	@Override
	public String signIn(LoginData data) {
		String userName = data.getUserName();
		String password = data.getPassword();
		
		
		
		User u = getUserByName(userName);
		
		if (u == null) {
			return "User Name is incorrect";
		}
		
		if(!u.getPassword().equals(password)){
			return "Incorrect password";
		}
		if(u.getRole().equalsIgnoreCase("Admin")) {
			return "Admin";
		}
		return "Customer";
		
	}
	
	@Override
	public User getUserByName(String name) {
		return repo.findByusername(name);
	}
}

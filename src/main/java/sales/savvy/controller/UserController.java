package sales.savvy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sales.savvy.LoginData;
import sales.savvy.entity.User;
import sales.savvy.service.UserService;

@CrossOrigin("*")
@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	@PostMapping("/signUp")
	public String signUp(@RequestBody User user) {
		return service.signUp(user);
	}
	
	@PostMapping("/signIn")
	public String signIn(@RequestBody LoginData data) {
		return service.signIn(data);
	}

}

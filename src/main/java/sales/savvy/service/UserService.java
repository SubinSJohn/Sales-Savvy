package sales.savvy.service;

import sales.savvy.LoginData;
import sales.savvy.entity.User;

public interface UserService {

	String signUp(User user);
	User getUserByName(String name);
	String signIn(LoginData data);

}

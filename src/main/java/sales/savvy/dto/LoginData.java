package sales.savvy.dto;

public class LoginData {

	private String userName;
	private String password;
	
	public LoginData(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	public LoginData() {
		
	}
	
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginData [userName=" + userName + ", password=" + password + "]";
	}
	
	
	
}

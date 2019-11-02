package Verify_Login;

public class Device{
	
	public String host_id;
	public String User;
	
	public String getHost_id() {
		return host_id;
	}
	public void setHost_id(String host_id) {
		this.host_id = host_id;
	}
	public String getUser() {
		return User;
	}
	public void setUser(String user) {
		User = user;
	}
	public Device(String i, String user) {
		super();
		this.host_id = i;
		User = user;
	}
}
		
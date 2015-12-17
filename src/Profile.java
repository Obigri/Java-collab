import sun.security.util.Password;

public class Profile {

	private String username;
	private String mailAddress;
	private Password password;

	public Profile() {

	}

	public Profile(String username) {
		this.username = username;
	}

	public Profile(String username, String mailAddress) {
		this(username);
		this.mailAddress = mailAddress;
	}

	public Profile(String username, String mailAddress, Password password) {
		this(username, mailAddress);
		this.password = password;
	}

	public void changeSavedPassword(Password password) {
		this.password = password;
	}

	public void changeSavedUsername(String username) {
		this.username = username;
	}

}
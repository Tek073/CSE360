// ========================================================
// Class: CSE 360 Wednesday section
// Group: Wednesday 31
// Project: Restaurant menu
//
// ========================================================


public class User 
{
	
	protected String username;
	protected String password;
	
	
	public User()
	{
		this.username = null;
		this.password = null;
	}
	public User(String username, String password)
	{
		this.username = username;
		this.password = password;
	}

	public String getUsername() {return this.username; }
	protected String getPass() {return this.password; }
	
	
	
	
	
	
};
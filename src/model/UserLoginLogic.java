package model;

public class UserLoginLogic {
	private String name;
	private String pass;

	public boolean execute(User u) {
		name = u.getName();
		pass = u.getPass();

		if(name != null && name.length() != 0) {
			if(pass.equals("1234")) {
				return true;
			}
		}

		return false;
	}
}

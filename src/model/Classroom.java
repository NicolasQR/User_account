package model;

import java.util.ArrayList;
import java.util.List;

public class Classroom {

	
private List<UserAccount> users;
	
	public Classroom() {
		users = new ArrayList<UserAccount>();
	}
	
	public void addContact(String username, String gender, String career,
			String birthday, String browser, String password) {
		
		users.add(new UserAccount(username, gender, career, birthday, browser, password));
	}
	
	public List<UserAccount> getContacts(){
		return users; 
	}
}

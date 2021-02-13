package model;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;

public class Classroom {

	
private List<UserAccount> users;
	
	public Classroom() {
		users = new ArrayList<UserAccount>();
	}
	
	public void addContact(String username, String gender, String career,
			String birthday, String browser, String password, Image profilePicture) {
		
		users.add(new UserAccount(username, gender, career, birthday, browser, password, profilePicture));
	}
	
	public List<UserAccount> getUsers(){
		return users; 
	}
}

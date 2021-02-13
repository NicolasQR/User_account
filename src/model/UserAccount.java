package model;

import javafx.scene.image.Image;

public class UserAccount {

	
	private String username;
	private String gender;
	private String career;
	private String birthday;
	private String browser;
	private String password;
	private Image profilePicture;
	
	public UserAccount(String usernameN, String genderN, String careerN, String birthdayN,
			String browserN, String passwordN, Image profilePictureN) {
		
		username = usernameN;
		gender = genderN;
		career = careerN;
		birthday = birthdayN;
		browser = browserN;
		profilePicture = profilePictureN;
		password = passwordN;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Image getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(Image profilePicture) {
		this.profilePicture = profilePicture;
	}
	
	
	
}

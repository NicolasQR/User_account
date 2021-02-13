package ui;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Path;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Classroom;
import model.UserAccount;

public class ClassroomGUI{
	
	private Classroom classroom;
	private UserAccount useraccount;
	
	public ClassroomGUI(Classroom cm, UserAccount cd) {
		classroom = cm;
		useraccount = cd;
	}
	
	
	@FXML
    private CheckBox checkBoxSoftware;

    @FXML
    private CheckBox checkBoxTelematic;

    @FXML
    private CheckBox checkBoxIndustrial;
	
	@FXML
    private RadioButton rbMale;

    @FXML
    private RadioButton rbFemale;

    @FXML
    private RadioButton rbOther;
	
	@FXML
    private TextField txtUsernameAccount;

    @FXML
    private PasswordField txtPasswordAccount;
	
	@FXML
	private Pane mainPane;
	
	@FXML
    private DatePicker txtBirthday;
	
	@FXML
    private TableView<UserAccount> allList;

    @FXML
    private TableColumn<UserAccount, String> listUsername;

    @FXML
    private TableColumn<UserAccount, String> listGender;

    @FXML
    private TableColumn<UserAccount, String> listCareer;

    @FXML
    private TableColumn<UserAccount, String> listBirthday;

    @FXML
    private TableColumn<UserAccount, String> listBrowser;
	
	@FXML
    private TextField txtUsernameSignUp;

    @FXML
    private TextField txtPasswordSignUp;
    
    @FXML
    private ComboBox<String> comboBoxBrowser;
    
    @FXML
    private TextField txtProfilePhoto;

    @FXML
    void logIn(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("List.fxml"));
		
		fxmlLoader.setController(this);    	
		Parent root = fxmlLoader.load();
    	
		mainPane.getChildren().clear();
    	mainPane.getChildren().setAll(root);
    	
    	initializeTableView();
    	
 
    }

    @FXML
    void signUp(ActionEvent event) throws IOException {
    	
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Account.fxml"));
		
		fxmlLoader.setController(this);    	
		Parent root = fxmlLoader.load();
    	
		mainPane.getChildren().clear();
    	mainPane.getChildren().setAll(root);
    	
    	comboBoxBrowser.getItems().addAll("Chrome", "Firefox", "Edge", "Safari", "Opera", "Thor");
    	
    	
    	/*if(txtUsernameSignUp.getText() == useraccount.getUsername()) {
    		
   		 	
    	} else {
    		
        	Alert alert = new Alert(AlertType.ERROR);
   		 	alert.setTitle("Log in incorrect");
   		 	alert.setContentText("Ooops, The username or password is incorrect!");

   		 	alert.showAndWait();
    	}*/
 
    	 
    }
    

    @FXML
    void DirectionEscritory(ActionEvent event) {

    	try {
	    	Stage stage = new Stage();
	    	FileChooser fileChooser = new FileChooser();
	    	fileChooser.setTitle("Open Resource File");
	    	
	    	File file = fileChooser.showOpenDialog(stage);
	    	txtProfilePhoto.setText(file.getPath());
		} catch (Exception e) {
			
		} 
    }
    
    @SuppressWarnings("unlikely-arg-type")
	public Image assignPhoto() {
    	
    	Image img = null;
    	
    	if(txtProfilePhoto.equals("")) {
    		
		} else {
			
			try {
				java.nio.file.Path source = Paths.get(txtProfilePhoto.getText());
				java.nio.file.Path destination = Paths.get("src/profilePicture/PicturePhoto.png");
				
				Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
				
				img = new Image("/profilePicture/PicturePhoto.png");
			
			}catch(IOException e) {
				
			}
		}
    	
    	return img;
    }

    
    public String rbIsSelected() {
    	
    	String gr = "";
    	
    	if(rbMale.isSelected()) {
    		gr = rbMale.getText();
    		
    	}else if(rbFemale.isSelected()) {
    		gr = rbFemale.getText();
    		
    	}else if(rbOther.isSelected()) {
    		gr = rbOther.getText();
    	}
    	
    	return gr;
    }
    
    public String checkBoxIsSelected() {
    	
    	String cr = "";
    	
    	if(checkBoxSoftware.isSelected()) {
    		cr += checkBoxSoftware.getText();
    		cr += "\n";
    		
    	} if(checkBoxTelematic.isSelected()) {
    		cr += checkBoxTelematic.getText();
    		cr += "\n";
    		
    	} if(checkBoxIndustrial.isSelected()) {
    		cr += checkBoxIndustrial.getText();
    		cr += "\n";
    	}
    	
    	return cr;	
    }
    
    
    
    @FXML
    void createAccount(ActionEvent event){
    	
    	String userbrowser = String.valueOf(comboBoxBrowser.getValue());
    	String userbirthday = String.valueOf(txtBirthday.getValue());
    	String usercareer = checkBoxIsSelected();
    	String usergender = rbIsSelected();
    	String userusername = txtUsernameAccount.getText();
    	Image userimage = assignPhoto();
    	
    	if(!usercareer.equals("") && !userbirthday.equals("") && !userbrowser.equals("") &&
    			!usergender.equals("") && !userusername.equals("")  && userimage != null) {
    		
    		classroom.addContact(userusername, usergender, usercareer, userbirthday, userbrowser, "", userimage);
        	
        	txtUsernameAccount.setText("");
        	txtPasswordAccount.setText("");
        	
        	Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("User Creted");
        	alert.setHeaderText(null);
        	alert.setContentText("The user has been created successfully!");
        	alert.showAndWait();
        	
        	rbMale.setSelected(false);
        	rbFemale.setSelected(false);
        	rbOther.setSelected(false);
        	
        	checkBoxSoftware.setSelected(false);
        	checkBoxTelematic.setSelected(false);
        	checkBoxIndustrial.setSelected(false);
        	
        	
    		
    		
    	} else {
    		
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("Warning");
    		alert.setHeaderText("Unfilled fields");
    		alert.setContentText("Please, put all the necessary information!");

    		alert.showAndWait();
    	}
    	
    	
    }

    @FXML
    void goToSignin(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
		
		fxmlLoader.setController(this);    	
		Parent root = fxmlLoader.load();
    	
		mainPane.getChildren().clear();
    	mainPane.getChildren().setAll(root);
    }
    
    

    @FXML
    void selectedRbFemale(ActionEvent event) {
    	rbMale.setSelected(false);
    	rbOther.setSelected(false);
    }

    @FXML
    void selectedRbMale(ActionEvent event) {
    	rbFemale.setSelected(false);
    	rbOther.setSelected(false);
    }

    @FXML
    void selectedRbOther(ActionEvent event) {
    	rbFemale.setSelected(false);
    	rbMale.setSelected(false);
    }
    
    
    
    @FXML
    void logOut(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
		
		fxmlLoader.setController(this);    	
		Parent root = fxmlLoader.load();
    	
		mainPane.getChildren().clear();
    	mainPane.getChildren().setAll(root);
    }
    
    public void loadLogin() throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
		
		fxmlLoader.setController(this);    	
		Parent addContactPane = fxmlLoader.load();
    	
		mainPane.getChildren().clear();
    	mainPane.getChildren().setAll(addContactPane);
    }
    
    public  void initializeTableView() {
    	
    	ObservableList<UserAccount> datos;
    	datos = FXCollections.observableArrayList(classroom.getContacts());
    	
    	allList.setItems(datos);
    	this.listUsername.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("username"));
    	this.listGender.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("gender"));
    	this.listCareer.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("career"));
    	this.listBirthday.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("birthday"));
    	this.listBrowser.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("browser"));
    }
    
   
}
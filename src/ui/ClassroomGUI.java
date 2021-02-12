package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

public class ClassroomGUI{
	
	@FXML
    private TextField txtUsernameAccount;

    @FXML
    private PasswordField txtPasswordAccount;
	
	@FXML
	private Pane mainPane;
	
	@FXML
    private TableView<?> AllList;

    @FXML
    private TableColumn<?, ?> listUsername;

    @FXML
    private TableColumn<?, ?> listGender;

    @FXML
    private TableColumn<?, ?> listCareer;

    @FXML
    private TableColumn<?, ?> listBirthday;

    @FXML
    private TableColumn<?, ?> listBrowser;
	
	@FXML
    private TextField txtUsernameSignUp;

    @FXML
    private TextField txtPasswordSignUp;

    @FXML
    void logIn(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Account.fxml"));
		
		fxmlLoader.setController(this);    	
		Parent root = fxmlLoader.load();
    	
		mainPane.getChildren().clear();
    	mainPane.getChildren().setAll(root);
    }

    @FXML
    void signUp(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("List.fxml"));
		
		fxmlLoader.setController(this);    	
		Parent root = fxmlLoader.load();
    	
		mainPane.getChildren().clear();
    	mainPane.getChildren().setAll(root);
    }
    

    @FXML
    void DirectionEscritory(ActionEvent event) {

    }

    @FXML
    void checkBoxIndustrial(ActionEvent event) {

    }

    @FXML
    void checkBoxSoftware(ActionEvent event) {

    }

    @FXML
    void checkBoxTelematic(ActionEvent event) {

    }

    @FXML
    void createAccount(ActionEvent event) throws IOException {

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
    void rbFemale(ActionEvent event) {

    }

    @FXML
    void rbMale(ActionEvent event) {

    }

    @FXML
    void rbOther(ActionEvent event) {

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
    
   
}
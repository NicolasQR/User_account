package ui;

import java.io.IOException;

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
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import model.Classroom;
import model.Contact;
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
    void logIn(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Account.fxml"));
		
		fxmlLoader.setController(this);    	
		Parent root = fxmlLoader.load();
    	
		mainPane.getChildren().clear();
    	mainPane.getChildren().setAll(root);
    }

    @FXML
    void signUp(ActionEvent event) throws IOException {
    	
    	
    	if(txtUsernameSignUp.getText() == useraccount.getUsername()) {
    		
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("List.fxml"));
    		
    		fxmlLoader.setController(this);    	
    		Parent root = fxmlLoader.load();
        	
    		mainPane.getChildren().clear();
        	mainPane.getChildren().setAll(root);
   		 	
    	} else {
    		
        	Alert alert = new Alert(AlertType.ERROR);
   		 	alert.setTitle("Log in incorrect");
   		 	alert.setContentText("Ooops, The username or password is incorrect!");

   		 	alert.showAndWait();
    	}
 
    	 
    }
    

    @FXML
    void DirectionEscritory(ActionEvent event) {

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
    		cr += "";
    		
    	} else if(checkBoxTelematic.isSelected()) {
    		cr += checkBoxTelematic.getText();
    		cr += "";
    		
    	} else if(checkBoxIndustrial.isSelected()) {
    		cr += checkBoxIndustrial.isSelected();
    		cr += "";
    	}
    	
    	return cr;	
    }
    
    
    
    @FXML
    void createAccount(ActionEvent event){
    	
    	String gr = rbIsSelected();
    	String cr = checkBoxIsSelected();
    	
    	classroom.addContact(txtUsernameAccount.getText(),gr, cr, null, null, txtPasswordAccount.getText());
    	txtUsernameAccount.setText("");
    	txtPasswordAccount.setText("");
    	
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
    	
    	todaLaTabla.setItems(datos);
    	this.tablaName.setCellValueFactory(new PropertyValueFactory<Contact, String>("name"));
    	this.tablaEmail.setCellValueFactory(new PropertyValueFactory<Contact, String>("email"));
    }
    
   
}
package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Controller1Hotel implements Initializable {

	@FXML
	private TextField tfCustomerRef;
	@FXML
	 TextField tfFirstName;
	@FXML
     TextField tfLastName;
	@FXML
	private ComboBox<String> cmbGender;
	@FXML
	private TextField tfAddress;
	@FXML
	private TextField tfPostCode;
	@FXML
	private TextField tfNationality;
	@FXML
	private DatePicker dtDateOfBirth;
	@FXML
	private TextField tfMobileNo;
	@FXML
	private TextField tfEmail;
	@FXML
	private TextField tfNumberOfPeople;
	@FXML
	private TextField tfNumberOfRooms;
	@FXML
	private ComboBox<String> cmbRoomType;
	@FXML
	private TextField tfIdType;
	@FXML
	private DatePicker dtCheckInDate;
	@FXML
	private DatePicker dtCheckOutDate;
	@FXML
	private ComboBox<String> cmbPaymentMethod;
	@FXML
	private TextField tfSubTotal;
	@FXML
	private TextField tfTax;
	@FXML
	private TextField tfTotal;
	
	@FXML
	private Button btTotalCost;
	@FXML
	private Button btUpdate;
	@FXML
	private Button btReset;
	@FXML
	private Button btDelete;
	@FXML
	private Button btExit;
	@FXML
	private Button btDataPage;
	@FXML
	private Button btMainPage;
	
	
	@FXML
	private String myCash;
	@FXML
	private String myDebitCard;
	@FXML
	private String myMasterCard;
	@FXML
	private String myVisaCard;
	@FXML
	private String myMale;
	@FXML
	private String myFemale;
	@FXML
	private String mySingle;
	@FXML
	private String myDouble;
	@FXML
	private String myKing;
	@FXML
	private String myQueen;
	
	
	private double numberOfRooms;
	
	
	double inumberOfRooms, iCash, iSubTotal, iTax, iTotal;
	
	private ModelHotel modelHotel = new ModelHotel();

	Controller2Hotel controller2Hotel;
	DatabaseHandler1 database1;
	
	
	public Controller1Hotel(){
		database1 = new DatabaseHandler1();
		database1.createConnection();
	}
	

	
public void totalCost() throws IOException{
		
		String roomType = (String)cmbRoomType.getValue();
		String paymentMethod = (String)cmbPaymentMethod.getValue();
		numberOfRooms = Double.parseDouble(tfNumberOfRooms.getText());
		
		if (roomType == mySingle && paymentMethod == myCash || paymentMethod == myDebitCard || paymentMethod == myMasterCard || paymentMethod == myVisaCard) {	
	    	
		       String subTotal;
		
		       iSubTotal = modelHotel.calculateSubTotalSingle(numberOfRooms);
		      subTotal = String.format("$%.2f" , iSubTotal);
	       tfSubTotal.setText(subTotal);
	       
	       String Tax;
	    	iTax = modelHotel.calculateTaxSingle(numberOfRooms);
	    	Tax = String.format("$%.2f" , iTax);
	    	tfTax.setText(Tax);
	    	
	    	String Total;
	    	iTotal = modelHotel.calculateTotalSingle(numberOfRooms);
	    	Total = String.format("$%.2f" , iTotal);
	    	tfTotal.setText(Total);
	    	
			}
		 
		else if(roomType == myDouble && paymentMethod == myCash || paymentMethod == myDebitCard || paymentMethod == myMasterCard || paymentMethod == myVisaCard) {	
	    	
		       String subTotal;
		
		       iSubTotal = modelHotel.calculateSubTotalDouble(numberOfRooms);
		      subTotal = String.format("$%.2f" , iSubTotal);
	       tfSubTotal.setText(subTotal);
	       
	       String Tax;
	    	iTax = modelHotel.calculateTaxDouble(numberOfRooms);
	    	Tax = String.format("$%.2f" , iTax);
	    	tfTax.setText(Tax);
	    	
	    	String Total;
	    	iTotal = modelHotel.calculateTotalDouble(numberOfRooms);
	    	Total = String.format("$%.2f" , iTotal);
	    	tfTotal.setText(Total);
			}
			
		else if(roomType == myKing && paymentMethod == myCash || paymentMethod == myDebitCard || paymentMethod == myMasterCard || paymentMethod == myVisaCard) {	
	    	
		       String subTotal;
		
		       iSubTotal = modelHotel.calculateSubTotalKing(numberOfRooms);
		      subTotal = String.format("$%.2f" , iSubTotal);
	       tfSubTotal.setText(subTotal);
	       
	       String Tax;
	    	iTax = modelHotel.calculateTaxKing(numberOfRooms);
	    	Tax = String.format("$%.2f" , iTax);
	    	tfTax.setText(Tax);
	    	
	    	String Total;
	    	iTotal = modelHotel.calculateTotalKing(numberOfRooms);
	    	Total = String.format("$%.2f" , iTotal);
	    	tfTotal.setText(Total);
			}
		
		else if(roomType == myQueen && paymentMethod == myCash || paymentMethod == myDebitCard || paymentMethod == myMasterCard || paymentMethod == myVisaCard) {	
	    	
		       String subTotal;
		
		       iSubTotal = modelHotel.calculateSubTotalQueen(numberOfRooms);
		      subTotal = String.format("$%.2f" , iSubTotal);
	       tfSubTotal.setText(subTotal);
	       
	       String Tax;
	    	iTax = modelHotel.calculateTaxQueen(numberOfRooms);
	    	Tax = String.format("$%.2f" , iTax);
	    	tfTax.setText(Tax);
	    	
	    	String Total;
	    	iTotal = modelHotel.calculateTotalQueen(numberOfRooms);
	    	Total = String.format("$%.2f" , iTotal);
	    	tfTotal.setText(Total);
			}

	}
	
@FXML	
public void update(ActionEvent event) throws IOException {
	
	String customerRefx = tfCustomerRef.getText();
	String firstNamex = tfFirstName.getText();
	String lastNamex = tfLastName.getText();
	String genderx = cmbGender.getValue();
	LocalDate dateOfBirthx = dtDateOfBirth.getValue();
	String numberOfRoomsx = tfNumberOfRooms.getText();
	String addressx = tfAddress.getText();
	String postCodex = tfPostCode.getText();
	String nationalityx = tfNationality.getText();
	String mobileNox = tfMobileNo.getText();
	String emailx = tfEmail.getText();
	String numberOfPeoplex = tfNumberOfPeople.getText();
	String roomTypex = cmbRoomType.getValue();
	String idTypex = tfIdType.getText();
	String totalCostx = tfTotal.getText();

	try {
		
	if(firstNamex.isEmpty()|| dateOfBirthx == null ) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText("Enter a word!");

		alert.showAndWait();
		
		}
		
	else {	Statement stmt = database1.con.createStatement();
		
		String dbop = "INSERT INTO PEOPLE(customerRef, firstName, lastName, gender, dateOfBirth, numberOfRooms, "
				+ "address, postCode, nationality, mobileNo, email, numberOfPeople, roomType, idType, checkInDate, totalCost) "
				+ "VALUES('"+customerRefx+"','"+firstNamex+"','"+lastNamex+"','"+genderx+"','"+dateOfBirthx+"',"
				+ "'"+numberOfRoomsx+"','"+addressx+"','"+postCodex+"','"+nationalityx+"','"+mobileNox+"','"+emailx+"',"
				+ "'"+numberOfPeoplex+"','"+roomTypex+"','"+idTypex+"','"+totalCostx+"'"+")";
		
		stmt.execute(dbop);

		System.out.println("database updated");
	
        stmt.close();
	}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	tfFirstName.clear();
	tfLastName.clear();
	
	}


public void reset(){
	
}

@FXML
public void delete(ActionEvent event)throws IOException{
	
	
	
}

public void exit(){
	
}

@FXML
public void changeScreen(ActionEvent event) throws IOException {
	System.out.print("going to data page");
	FXMLLoader loader = new FXMLLoader();
	loader.setLocation(getClass().getResource("/View2Hotel.fxml"));
	Parent tableRoot = loader.load();
	Scene tableScene = new Scene(tableRoot);
	
	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	window.setScene(tableScene);
	window.show();
}



@Override
public void initialize(URL url, ResourceBundle rb) {
	// TODO Auto-generated method stub
}
}

















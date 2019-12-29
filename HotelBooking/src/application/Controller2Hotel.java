package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class Controller2Hotel implements Initializable  {
	
	
	@FXML
	private Button btDelete;
	//Configure the table
	@FXML TableView<Hotel> tableView;
	@FXML  TableColumn<Hotel, String> customerRefColumn;
	@FXML  TableColumn<Hotel, String> firstNameColumn;
	@FXML  TableColumn<Hotel, String> lastNameColumn;
	@FXML  TableColumn<Hotel, String> genderColumn;
	@FXML  TableColumn<Hotel, LocalDate> dateOfBirthColumn;
	@FXML  TableColumn<Hotel, Integer> numberOfRoomsColumn;
	@FXML TableColumn<Hotel, String> addressColumn;
	@FXML TableColumn<Hotel, String> postCodeColumn;
	@FXML TableColumn<Hotel, String> nationalityColumn;
	@FXML TableColumn<Hotel, String> mobileNoColumn;
	@FXML  TableColumn<Hotel, String> totalCostColumn;
	@FXML  TableColumn<Hotel, String> emailColumn;
	@FXML  TableColumn<Hotel, String> numberOfPeopleColumn;
	@FXML  TableColumn<Hotel, String> roomTypeColumn;
	@FXML  TableColumn<Hotel, String> idTypeColumn;

	
	public Controller1Hotel controller1Hotel;
	static DatabaseHandler1 database1; 
	
	public Controller2Hotel(){
		database1 = new DatabaseHandler1();
		controller1Hotel = new Controller1Hotel();
	}
	
	
	ObservableList<Hotel> list = FXCollections.observableArrayList();
	Connection con;
	
	//This method changes the scene to main page
	public void changeScreen(ActionEvent event) throws IOException {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/View1Hotel.fxml"));
		Parent tableRoot = loader.load();
		Scene tableScene = new Scene(tableRoot);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(tableScene);
		window.show();
	}
	
	
	//Initializes the controller class
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		initData();
		database1.createConnection();
		loadData();
		
	}
	
	public void initData() {
		customerRefColumn.setCellValueFactory(new PropertyValueFactory<>("customerRef"));
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
		dateOfBirthColumn.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
		numberOfRoomsColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfRooms"));
		addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
		postCodeColumn.setCellValueFactory(new PropertyValueFactory<>("postCode"));
		nationalityColumn.setCellValueFactory(new PropertyValueFactory<>("nationality"));
		mobileNoColumn.setCellValueFactory(new PropertyValueFactory<>("mobileNo"));
		emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
		numberOfPeopleColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfPeople"));
		roomTypeColumn.setCellValueFactory(new PropertyValueFactory<>("roomType"));
		idTypeColumn.setCellValueFactory(new PropertyValueFactory<>("idType"));
		totalCostColumn.setCellValueFactory(new PropertyValueFactory<>("totalCost"));
			    
		//make the table cells editable
		//tableView.setEditable(true);
		//firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		//lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	}

	
	public void loadData(){
		
try {
			
			Statement stmt = database1.con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM PEOPLE");
		
			
			while(rs.next()) {
				String customerRefx = rs.getString("customerRef");
				String firstNamex = rs.getString("firstName");
				String lastNamex = rs.getString("lastName");
				String genderx = rs.getString("gender");
				LocalDate dateOfBirthx =  rs.getDate("dateOfBirth").toLocalDate();
				int numberOfRoomsx = rs.getInt("numberOfRooms");
				String addressx = rs.getString("address");
				String postCodex = rs.getString("postCode");
				String nationalityx = rs.getString("nationality");
				String mobileNox = rs.getString("mobileNo");
				String emailx = rs.getString("email");
				String numberOfPeoplex = rs.getString("numberOfPeople");
				String roomTypex = rs.getString("roomType");
				String idTypex = rs.getString("idType");
				String totalCostx = rs.getString("totalCost");
				System.out.println("data is loaded into java table");
				
			list.add(new Hotel(customerRefx, firstNamex, lastNamex, genderx, dateOfBirthx, numberOfRoomsx, addressx,
					postCodex, nationalityx, mobileNox, emailx, numberOfPeoplex, roomTypex, idTypex, totalCostx));
			    
	}
		
			stmt.close();
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tableView.setItems(list);
		
	}
	
	@FXML
	public void delete(ActionEvent event)throws IOException{
	
		Hotel selectedForDeletion = tableView.getSelectionModel().getSelectedItem();
		
		
		try {	
			
			if (selectedForDeletion == null) {
				
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText(null);
				alert.setContentText("Select a row to be deleted!");

				alert.showAndWait();
			}
			
			else {	
				
			String firstNamex = selectedForDeletion.getFirstName();
			Statement stmt = database1.con.createStatement();
			
			String dbop = "DELETE FROM PEOPLE WHERE FirstName='"+firstNamex+"'";
			stmt.execute(dbop);
			
			list.remove(selectedForDeletion);

			System.out.println("database deleted");
		
			stmt.close();
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
    
}

















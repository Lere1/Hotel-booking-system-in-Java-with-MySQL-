package application;

import java.time.LocalDate;

public class Hotel {
	
	private String customerRef, firstName, lastName, gender, address, postCode, nationality, mobileNo, email,
	numberOfPeople, roomType, idType, totalCost;
	private LocalDate dateOfBirth;
	private int numberOfRooms ; 
	
	public Hotel() {
		
	}
	
	
	public  Hotel(String customerRef, String firstName, String lastName, String gender, LocalDate dateOfBirth, int numberOfRooms, 
			String address, String postCode, String nationality, String mobileNo, String email, String numberOfPeople, 
			String roomType, String idType, String totalCost) {
		
		this.customerRef = customerRef;	
	    this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.numberOfRooms = numberOfRooms;
		this.address = address;
		this.postCode = postCode;
		this.nationality = nationality;
		this.mobileNo = mobileNo;
		this.email = email;
		this.totalCost = totalCost;
		this.numberOfPeople = numberOfPeople;
		this.roomType = roomType;
		this.idType = idType;
		
		
	}
	
	public String getCustomerRef() {
		return customerRef;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getGender() {
		return gender;
	}
	
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	
	public int getNumberOfRooms() {
		return numberOfRooms;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getPostCode() {
		return postCode;
	}
	
	public String getNationality() {
		return nationality;
	}
	
	public String getMobileNo() {
		return mobileNo;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getNumberOfPeople() {
		return numberOfPeople;
	}
	
	public String getTotalCost() {
		return totalCost;
	}
	
	public String getRoomType() {
		return roomType;
	}
	
	public String getIdType() {
		return idType;
	}
	
	
}

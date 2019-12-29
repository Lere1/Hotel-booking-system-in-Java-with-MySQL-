package application;

public class ModelHotel {

	
public double calculateSubTotalSingle(double numberOfRooms) {
		
		double subTotal  = 60*numberOfRooms;
		
		return subTotal;
	}

public double calculateSubTotalDouble(double numberOfRooms) {
	
	double subTotal  = 70*numberOfRooms;
	
	return subTotal;
}

public double calculateSubTotalKing(double numberOfRooms) {
	
	double subTotal  = 80*numberOfRooms;
	
	return subTotal;
}

public double calculateSubTotalQueen(double numberOfRooms) {
	
	double subTotal  = 90*numberOfRooms;
	
	return subTotal;
}

//calculate tax
public double calculateTaxSingle(double numberOfRooms) {
		double subTotal = 60*numberOfRooms ;	
	double Tax_Rate = 2.7;
    double tax = (subTotal * Tax_Rate)/100;

    return tax;
}	

public double calculateTaxDouble(double numberOfRooms) {
	double subTotal = 70*numberOfRooms ;	
double Tax_Rate = 2.7;
double tax = (subTotal * Tax_Rate)/100;

return tax;
}	

public double calculateTaxKing(double numberOfRooms) {
	double subTotal = 80*numberOfRooms ;	
double Tax_Rate = 2.7;
double tax = (subTotal * Tax_Rate)/100;

return tax;
}

public double calculateTaxQueen(double numberOfRooms) {
	double subTotal = 90*numberOfRooms ;	
double Tax_Rate = 2.7;
double tax = (subTotal * Tax_Rate)/100;

return tax;
}

//calculate total
public double calculateTotalSingle(double numberOfRooms) {
	double subTotal = 60*numberOfRooms ;	
double Tax_Rate = 2.7;
double tax = (subTotal * Tax_Rate)/100;

double total = subTotal + tax;

return total;
}

public double calculateTotalDouble(double numberOfRooms) {
	double subTotal = 70*numberOfRooms ;	
double Tax_Rate = 2.7;
double tax = (subTotal * Tax_Rate)/100;

double total = subTotal + tax;

return total;
}	

public double calculateTotalKing(double numberOfRooms) {
	double subTotal = 80*numberOfRooms ;	
double Tax_Rate = 2.7;
double tax = (subTotal * Tax_Rate)/100;

double total = subTotal + tax;

return total;
}	

public double calculateTotalQueen(double numberOfRooms) {
	double subTotal = 90*numberOfRooms ;	
double Tax_Rate = 2.7;
double tax = (subTotal * Tax_Rate)/100;

double total = subTotal + tax;

return total;
}

}















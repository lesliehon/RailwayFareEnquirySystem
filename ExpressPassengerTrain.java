//Leslie Hon
//CREATE DATE:  7-APR-2011
//RailwayFareEnquirySystem

public class ExpressPassengerTrain extends PassengerTrain {
	//Notes: Refer to test driver program "TestLine.java" and output file "TestLineOutput.txt" for details
	//No Attributes
	
	//Method
	public ExpressPassengerTrain(String code, String startTime, Line line, Station start , Station end , int passengerCapacity){
		super(code, startTime,line,start , end , passengerCapacity);
		//A constructor of the Express Passenger , pass all the value to the super class
	}
	
	public double calculateFare(Station from , Station to, int quantity){
		//Total fare = NormalPassengerTrainFare + ReservationSurcharge
		return super.calculateFare(from, to, quantity) + super.getLine().getReservationSurcharge()*quantity;
	}
	
	public double calculateFare(Station from , Station to,int age,  int quantity){
		//Total fare = NormalPassengerTrainFare + ReservationSurcharge
		return super.calculateFare(from, to, age, quantity) + super.getLine().getReservationSurcharge()*quantity;
	}
	
	public String toString(){
		//return the information of the passenger Train followed by the word "Seat Reservation Req'd"
		StringBuffer output = new StringBuffer();
		output.append(super.getCode()+" "+super.getStartTime()+" "+super.getStart()+" -> "+super.getEnd());
		output.append(" Max. Capacity: "+super.getPassengerCapacity()+" Passenger(s) Seat Reservation Req'd");
		return output.toString();
	}
}

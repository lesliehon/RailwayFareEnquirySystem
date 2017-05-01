//Leslie Hon
//CREATE DATE:  7-APR-2011
//RailwayFareEnquirySystem

public class PassengerTrain extends Train{
	//Notes: Refer to test driver program "TestLine.java" and output file "TestLineOutput.txt" for details
	//Attributes
	private int passengerCapacity;
	
	//Method
	public PassengerTrain(String code, String startTime, Line line, Station start, Station end, int passengerCapacity){
		super(code, startTime, line, start, end);
		this.passengerCapacity = passengerCapacity;
		//A constructor
	}
	
	public double calculateDistanceFare(Station from , Station to){
		//Overrides the abstract method of the super-class which accepts two arguments
		//then return the distance fare in double type by the formula:
		//Distance fare = unit fare (fare per passenger per 1KM) * distance of the journey
		return ( super.getLine().getPassengerFarePerKm() ) * ( super.getLine().calculateDistance(from, to) );
	}
	
	public int getPassengerCapacity(){
		//Return the maximum capacity of the Passenger train in KG (in int type)
		return passengerCapacity;
	}
	
	public String toString(){
		//Returns the information of the Passenger Train in String type
		StringBuffer output = new StringBuffer();
		output.append(super.getCode()+" "+super.getStartTime()+" "+super.getStart()+" -> "+super.getEnd());
		output.append(" Max. Capacity: "+this.getPassengerCapacity()+" Passenger(s)");
		return output.toString();
	}

}

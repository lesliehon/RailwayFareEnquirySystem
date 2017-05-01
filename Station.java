//Leslie Hon
//CREATE DATE:  7-APR-2011
//RailwayFareEnquirySystem

public class Station {
	//Notes: Refer to test driver program "TestLine.java" and output file "TestLineOutput.txt" for details
	//Attributes
	private String name;
	private String country;
	
	//Method
	public Station(String name, String country){
		this.name = name;
		this.country = country;
		//A constructor of the class Station (see notes)
		
	}
	
	public String getName(){
		//Get the station name on String type
		return name;
	}
	
	public String getCountry(){
		//Get the Country of the Station in String type
		return country;
	}
	
	public String toString(){
		//Retiurn the information on Station in String type
		return getName() + "," + getCountry();
	}
}

//Leslie Hon
//CREATE DATE:  7-APR-2011
//RailwayFareEnquirySystem

public class Station {
	//Notes: Refer to test driver program "TestLine.java" and output file "TestLineOutput.txt" for details
	//Attributes
	private String name;
	private String country;
	private int childfreeAge = -1;
	private int childfareAge = -1;
	private int seniorfareAge = -1;
	
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
		//Return the information on Station in String type
		return getName() + "," + getCountry();
	}
	
	//Discount method
	
	//A method to return the max age of of child can enjoy free fare
	public int getchildfreeAge (){
		return childfreeAge;
	}
	
	public int getmaxchildfareAge(){
		return childfareAge;
	}
	
	public int getseniorfareAge (){
		return seniorfareAge;
	}
	
	public void setchildfreeAge(int Age){
		this.childfreeAge = Age;
	}
	
	public double checkAgeDiscountRate(int Age){
		//Return the discount rate of the different age of passenger
		if(Age <= childfreeAge) return 0;
		else if (Age >= childfreeAge+1 && Age <= childfareAge) return 0.5;
		else if (Age >= seniorfareAge) return 0.5;
		return 1;
	}
	
	public void setchildfareAge(int Age){
		childfareAge = Age;
	}
	
	public void setseniorfareAge(int Age){
		this.seniorfareAge= Age;
	}
	
	public boolean haveDiscount(){
		if(childfreeAge != -1 && seniorfareAge!=-1 && childfareAge!=-1)
			return true;
		else return false;
	}
}

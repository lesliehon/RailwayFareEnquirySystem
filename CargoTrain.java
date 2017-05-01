//Leslie Hon
//CREATE DATE:  7-APR-2011
//RailwayFareEnquirySystem

//A Subclass of Train Class
public class CargoTrain extends Train {
	//Attributes
	private int cargoCapacity;
	
	//Methods
	public CargoTrain( String code, String startTime , Line line, Station start , Station end, int cargoCapacity){
		super(code, startTime , line, start, end);
		this.cargoCapacity = cargoCapacity;
		//A constructor to initialize the attributes of the cargo train
	}
	
	public double calculateDistanceFare(Station from , Station to){
		//Overrides the abstract method of the super-class which accepts two arguments
		//then return the distance fare in double type by the formula:
		//Distance fare = unit fare (fare per 1KG per 1KM) * distance of the journey
		return ( super.getLine().getCargoFarePerKm() ) * ( super.getLine().calculateDistance(from, to) );
	}
	
	public int getCargoCapacity(){
		//Return the maximum capacity of the cargo train in KG (in int type)
		return cargoCapacity;
	}
	
	public String toString(){
		//Returns the information of the Cargo Train in String type
		StringBuffer output = new StringBuffer();
		output.append(super.getCode()+" "+super.getStartTime()+" "+super.getStart()+" -> "+super.getEnd());
		output.append(" Max. Capacity: "+this.getCargoCapacity()+" KG");
		return output.toString();
	}
	
	//End of cargoTrain method
}
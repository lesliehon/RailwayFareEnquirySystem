//Leslie Hon
//CREATE DATE:  7-APR-2011
//RailwayFareEnquirySystem


abstract class Train {
	//Notes: Refer to test driver program "TestLine.java" and output file "TestLineOutput.txt" for details
	//Attributes
	private String code;
	private String startTime;
	private Line line;
	private Station start;
	private Station end;
	
	//Method
	public Train(String code, String startTime, Line line , Station start, Station end){
		//Constructor of Train
		this.code = code;
		this.startTime = startTime;
		this.line = line;
		this.start = start;
		this.end = end;
	}
	
	public String getCode(){
		//Return the code of the train in String type
		return code;
	}
	
	public String getStartTime(){
		//get start time of the train in String type
		return startTime;
	}
	
	public Line getLine(){
		//get the line of the train in Line type
		return line;
	}
	
	public Station getStart(){
		//return the first station of the train in Station type
		return start;
	}
	
	public Station getEnd(){
		//return the last station of the train in Station type
		return end;
	}
	
	public Station [] getIntermediateStops(){
		//return the intermediate stations including the first and last stations (in Station[] type)
		int from = -1, to = -1;
		Station [] intermediateStops = null;
		
		for(int stop = 0 ; stop < line.getStops().length ; stop++){
			if(this.start.equals(line.getStops()[stop]))
				from = stop;
			if(this.end.equals(line.getStops()[stop]))
				to = stop;
		}
		
		if(from > to ){//If the index of from is larger than to
			intermediateStops = new Station [from - to +1];
			for(int i = 0 ; i < intermediateStops.length ; i++)
				intermediateStops[i] = line.getStops()[from-i];
		}
		else if(to > from){//If the index of to is larger than from
			intermediateStops = new Station [to - from +1];
			for(int i = 0 ; i < intermediateStops.length ; i++)
				intermediateStops[i] = line.getStops()[from+i];
		}

		
		return intermediateStops;
		
	}
	
	public int getCrossBorderCount(Station from, Station to){
		//Return the number of time(s) that the train travel across the border in the specified journey
		int totalCrossBorderCount=0;
		int fromIndex = -1 , toIndex = -1;
		for(int i= 0 ; i< getIntermediateStops().length ; i++){
			if(fromIndex != -1 && toIndex !=-1) break;
			if(getIntermediateStops()[i].equals(from)) fromIndex = i;
			else if(getIntermediateStops()[i].equals(to)) toIndex = i;
		}
		if(fromIndex != -1 && toIndex != -1)
			for(int i= fromIndex+1 ; i<= toIndex  ; i++){
				if( !getIntermediateStops()[i].getCountry().equals(getIntermediateStops()[i-1].getCountry()) )
					++totalCrossBorderCount;
			}
		
		return totalCrossBorderCount;
	}
	
	abstract double calculateDistanceFare(Station start , Station end);
	//Abstract Class accepts two arguments (Station type) , return the distance fare
	
	public Boolean isValidRoute(Station from, Station to){
		//Accept two arguments (in Station type), namely from and to. It returns true if the specified journey is valid
		Boolean isValid = true;
		int fromIndex = -1 , toIndex = -1;
		
		for(int i= 0 ; i< getIntermediateStops().length ; i++){
			if(getIntermediateStops()[i].equals(from)) fromIndex = i;
			else if(getIntermediateStops()[i].equals(to)) toIndex = i; 
			
		}
		if(fromIndex > toIndex || fromIndex == -1 || toIndex == -1)
			isValid = false;
		return isValid;
	}
	
	public double calculateFare( Station from, Station to , int quantity ){
		//Accept three data then return the total fare in double type by the formula:
		//Total Fare = Distance Fare * quantity + Cross Border charge
		return (calculateDistanceFare(from, to) + (line.getCrossBorderSurcharge()* getCrossBorderCount(from,to)) ) * quantity;
	}
	
	public String toString;
	//Abstract Method that return the information of the Train in String type
	//This method will be overridden by sub-class as different information for different type of train!!
}

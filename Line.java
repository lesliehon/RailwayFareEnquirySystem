//Leslie Hon
//CREATE DATE:  7-APR-2011
//RailwayFareEnquirySystem

public class Line {
	//Notes: Refer to test driver program "TestLine.java" and output file "TestLineOutput.txt" for details
	//Attributes
	private String name;
	private Station [] stops;
	private int[] distance;
	private double passengerFarePerKm;
	private double cargoFarePerKm;
	private int crossBorderSurcharge;
	private int reservationSurcharge;
	
	//Methods
	public Line(String lineName, String stations, String fares){
		this.name = lineName;
		String [] stationList = stations.split(" ");
		this.stops = new Station [stationList.length];
		this.distance = new int [stationList.length];
		
		//Split the stop data into array
		for(int i =0 ; i < stationList.length ; i++){
			String[] stationData = stationList[i].split(":");
			this.stops[i] = new Station(stationData[0], stationData[1]);
			distance[i] = Integer.parseInt(stationData[2]);
		}
		//Set the fare
		String [] Fare = fares.split(":");
		passengerFarePerKm = Double.parseDouble(Fare[0]);
		cargoFarePerKm = Double.parseDouble(Fare[1]);
		crossBorderSurcharge = Integer.parseInt(Fare[2]);
		reservationSurcharge = Integer.parseInt(Fare[3]);
		
	}
	
	public String getName(){
		//Return the name of Line (In String type)
		return name;
	}
	
	public Station [] getStops(){
		//return the stops of the Line (in Station[] Type)
		return stops;
	}
	
	public double getPassengerFarePerKm(){
		//Return the fare of the passenger per KM (in double type)
		return passengerFarePerKm;
	}
	
	public double getCargoFarePerKm(){
		//Return the fare of the cargo per KM per KG (in double type)
		return cargoFarePerKm;
	}
	
	public int getReservationSurcharge(){
		//Return the reservation surcharge in int form
		return reservationSurcharge;
	}
	
	public int getCrossBorderSurcharge(){
		//Return the Cross border surcharge in int type
		return crossBorderSurcharge;
	}
	
	public String toString(){
		//Return the information of the Line in String type
		StringBuffer output = new StringBuffer();
		output.append("Line"+this.getName()+"\n");
		for(int stops = 0 ; stops <this.stops.length; stops++){
			output.append(this.stops[stops].getName()+","+this.stops[stops].getCountry()+"("+distance[stops]+")");
			if(stops != this.stops.length -1) output.append(" > ");
		}
		output.append("\n");
		return output.toString();
	}
	
	public int calculateDistance(Station stationFROM , Station stationTO){
		//Accepts two stations (in Station type) and return
		//the distance (in int type) between specified stations
		int from = -1, to = -1;
		int distanceOf2Station = 0;
		for(int stop = 0 ; stop < stops.length ; stop++){
			if(stationFROM.equals(stops[stop]))
				from = stop;
			if(stationTO.equals(stops[stop]))
				to = stop;
		}
		
		if(from !=-1 && to !=-1){
			if(from > to )//If the index of from is larger than to
				for(int i = to ; i < from ; i++)
					distanceOf2Station += (distance[i+1]-distance[i]);
			else if(to > from)//If the index of to is larger than from
				for(int i = from ; i < to ; i++)
					distanceOf2Station += (distance[i+1]-distance[i]);
			else if(from == to)
				distanceOf2Station = 0;
		}
		
		return distanceOf2Station ;
	}
}

//Leslie Hon
//CREATE DATE:  7-APR-2011
//RailwayFareEnquirySystem

public class TestTrain {
	public static void main(String[] args) {
		//Line information
		Line line = new Line("Paris-Zurich-Munich", "Paris:France:0 Lyon:France:450 Geneve:Switzerland:600 Zurich:Switzerland:870 St.Gallen:Switzerland:950 Memmingen:Germany:1070 Munich:Germany:1180", "0.06:0.01:30:10");
		Station stations[] = line.getStops();
		System.out.println("All stations:");
		for(int i=0; i<stations.length; i++)
			System.out.print(stations[i] + "   ");
		System.out.println("\n");

		//Train information
		Train trains[] = new Train[3];
		trains[0] = new CargoTrain("C123", "04:12", line, stations[1], stations[3], 200);
		trains[1] = new PassengerTrain("P201", "20:00", line, stations[6], stations[0], 90);
		trains[2] = new ExpressPassengerTrain("X200", "20:30", line, stations[0], stations[6], 60);
		System.out.println("Train information:");
		for(int i=0; i<trains.length; i++)
			System.out.println(trains[i]);

		System.out.println("\nIntermediate stations for " + trains[0] + ":");
		Station inter_stations[] = trains[0].getIntermediateStops() ;
		for(int i=0; i<inter_stations.length; i++)
			System.out.print(inter_stations[i] + "   ");

		System.out.println("\nCheck valid route:");
		System.out.print(stations[1] + " to " + stations[2] + " is the valid route for train " + trains[0].getCode() + "? ");
		if (trains[0].isValidRoute(stations[1], stations[2]))
			System.out.println("Yes");
		else
			System.out.println("No");

		System.out.print(stations[2] + " to " + stations[1] + " is the valid route for train " + trains[0].getCode() + "? ");
		if (trains[0].isValidRoute(stations[2], stations[1]))
			System.out.println("Yes");
		else
			System.out.println("No");

		System.out.print(stations[0] + " to " + stations[1] + " is the valid route for train " + trains[0].getCode() + "? ");
		if (trains[0].isValidRoute(stations[0], stations[1]))
			System.out.println("Yes");
		else
			System.out.println("No");

		System.out.println("\nCalculate Border crossing:");
		System.out.println(stations[6] + " to " + stations[5] + " by train " + trains[1].getCode() + " cross border " + trains[1].getCrossBorderCount(stations[6], stations[5]) + " time(s)");
		System.out.println(stations[6] + " to " + stations[2] + " by train " + trains[1].getCode() + " cross border " + trains[1].getCrossBorderCount(stations[6], stations[2]) + " time(s)");
		System.out.println(stations[6] + " to " + stations[1] + " by train " + trains[1].getCode() + " cross border " + trains[1].getCrossBorderCount(stations[6], stations[1]) + " time(s)");

		System.out.println("\nCalculate Distance Fare");
		System.out.print("Distance Fare of " + trains[0].getCode() + " from " + stations[1] + " to " + stations[3] + " is EUR" + trains[0].calculateDistanceFare(stations[1], stations[3]));
		if(trains[0] instanceof CargoTrain)  // Example for checking the object type
			System.out.println (" Per 1KG Cargo");
		else
			System.out.println (" Per Passenger");

		System.out.println("Distance Fare of " + trains[1].getCode() + " from " + stations[6] + " to " + stations[5] + " is EUR" + trains[1].calculateDistanceFare(stations[6], stations[5]) + " Per Passenger");
		System.out.println("Distance Fare of " + trains[2].getCode() + " from " + stations[1] + " to " + stations[5] + " is EUR" + trains[2].calculateDistanceFare(stations[1], stations[5]) + " Per Passenger");

		System.out.println("\nCalculate Total Fare (including all surcharge):");
		System.out.println("Total Fare of " + trains[0].getCode() + " from " + stations[1] + " to " + stations[3] + " is EUR" + trains[0].calculateFare(stations[1], stations[3], 1) + " Per 1KG Cargo");
		System.out.println("Total Fare of " + trains[1].getCode() + " from " + stations[6] + " to " + stations[5] + " is EUR" + trains[1].calculateFare(stations[6], stations[5], 1) + " Per Passenger");
		System.out.println("Total Fare of " + trains[2].getCode() + " from " + stations[1] + " to " + stations[5] + " is EUR" + trains[2].calculateFare(stations[1], stations[5], 1) + " Per Passenger");
	}

}

//Leslie Hon
//CREATE DATE:  7-APR-2011
//RailwayFareEnquirySystem

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class FareEnquirySystem {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) {
		Train[] trains = new Train[5];
		Line line = new Line(
				"Paris-Zurich-Munich",
				"Paris:France:0 Lyon:France:450 Geneve:Switzerland:600 Zurich:Switzerland:870 St.Gallen:Switzerland:950 Memmingen:Germany:1070 Munich:Germany:1180",
				"0.06:0.01:30:10");
		Station stations[] = line.getStops();
		//Create a Array List to store the availableTrain Information
		ArrayList<Integer> availableTrainCode = new ArrayList<Integer>();
		ArrayList<Train>availableTrain = new ArrayList<Train>();
		
		// Display the title of the program in console
		System.out.println("Fare Enquiry System");
		System.out.println("===================");

		// show the line information
		System.out.println(line);

		// Display Fares Summary:
		StringBuffer faresSummary = new StringBuffer("Fares Summary:\n");
		faresSummary.append("Passenger Per KM: EUR"+ line.getPassengerFarePerKm() + "\n");
		faresSummary.append("Cargo Per KG Per KM: EUR"+ line.getCargoFarePerKm() + "\n");
		faresSummary.append("Surcharge: Cross Border: EUR"+ line.getCrossBorderSurcharge() + "\n");
		faresSummary.append("Surcharge: Seat Reservation: EUR"+ line.getReservationSurcharge());
		System.out.println(faresSummary + "\n");

		// Create the train(s) object running on this line.
		trains[0] = new CargoTrain("C123", "04:12", line, stations[1],stations[3], 200);
		trains[1] = new CargoTrain("C678", "12:00", line, stations[6],stations[3], 400);
		trains[2] = new PassengerTrain("P200", "20:00", line, stations[0],stations[6], 90);
		trains[3] = new PassengerTrain("P201", "20:00", line, stations[6],stations[0], 90);
		trains[4] = new ExpressPassengerTrain("X200", "20:00", line,stations[0], stations[6], 90);

		// display the trains running on this line
		System.out.println("All train(s) running on this line.");
		for (int i = 0; i < trains.length; i++)
			System.out.println(trains[i]);
		System.out.println();

		// List the station
		StringBuffer stationList = new StringBuffer("List of stations:\n");
		for (int i = 0; i < line.getStops().length; i++)
			stationList.append(i + ". " + stations[i] + "\n");
		System.out.println(stationList);

		// Ask user question to show the fare enquire information

		int departureStation = -1, arrivalStation = -1;
		//Input the departure and arrival station 
		System.out.print("Please enter departure station number: >");
		departureStation = sc.nextInt();
		System.out.print("Please enter arrival station number: >");
		arrivalStation = sc.nextInt();
		try {
			for (int j = 0; j < trains.length; j++) //loop the train
				for (int i = 0; i < trains[j].getIntermediateStops().length; i++) //loop the intermediate stations of the train
					if ((stations[departureStation].equals(trains[j]
							.getIntermediateStops()[i]) && i <= departureStation)) {
						//Do it when it can find the departure station in the line
						for (int t = (i + 1); t < trains[j]
								.getIntermediateStops().length; t++)
							if (stations[arrivalStation].equals(trains[j]
									.getIntermediateStops()[t])){
								// If find a train is available the departure
								// and arrival station, put it in the array List
								availableTrainCode.add(j);
								availableTrain.add(trains[j]);
							}
					}
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid station number\nBye Bye!");
			return;
		}catch (java.util.InputMismatchException e){
			System.out.println("Invalid station number\nBye Bye!");
			return;
		}
		
		// Print the available train information
		System.out.println("Select the available train:");
		for (int i = 0; i < availableTrain.toArray().length; i++)
			System.out.println(availableTrainCode.get(i)+". "+availableTrain.get(i));
		// Ask user to select the available train
		System.out.print(">");
		int trainCode = sc.nextInt();
		//Check the train code is valid or not
		if( !(availableTrain.contains(trains[trainCode])) ){
			System.out.println("Invaild train.\nBye Bye!");
			return;
		}
		
		String quantityWord;
		if (trains[trainCode] instanceof PassengerTrain) {
			System.out.print("Please enter number of passenger: >");
			quantityWord = "Passenger(s)";
		} else {
			System.out.print("Please enter cargo weight(KG): >");
			quantityWord = "KG cargo";
		}
		int quantity = sc.nextInt();
		
		//Check the quantity 
		if(trains[trainCode] instanceof PassengerTrain && 
				quantity > ((PassengerTrain) trains[trainCode]).getPassengerCapacity()){
			System.out.println("Number of passengers exceeds the capacity.\nBye Bye!");
			return;
		}
		else if(trains[trainCode] instanceof CargoTrain && 
				quantity > ((CargoTrain) trains[trainCode]).getCargoCapacity()){
			System.out.println("Cargo weight exceeds the capacity.\nBye Bye!");
			return;
		}
		
		//Calculate the train fare
		double totalfare = trains[trainCode].calculateFare(stations[departureStation], stations[arrivalStation], quantity);
		BigDecimal newtotalfare = new BigDecimal(totalfare).setScale(0,BigDecimal.ROUND_HALF_UP); // RoundUp Value
		
		//Show the result
		System.out.println("Result:\nFor " + quantity + quantityWord
				+ " travelling from " + stations[departureStation] + " to "
				+ stations[arrivalStation] + " on "
				+ trains[trainCode].getCode());
		System.out.println("Total Fare: EUR" + newtotalfare + "\nByeBye!");

	}
}
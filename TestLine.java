//Leslie Hon
//CREATE DATE:  7-APR-2011
//RailwayFareEnquirySystem

public class TestLine {

	public static void main(String[] args) {
		//Line information
		Line line = new Line("Paris-Zurich-Munich", "Paris:France:0 Lyon:France:450 Geneve:Switzerland:600 Zurich:Switzerland:870 St.Gallen:Switzerland:950 Memmingen:Germany:1070 Munich:Germany:1180", "0.06:0.01:30:10");
		
		System.out.println(line);

		Station stations[] = line.getStops();
		
		System.out.println(stations[0]);
		System.out.println(stations[1]);
		System.out.println("...");
		System.out.println(stations[stations.length-2]);
		System.out.println(stations[stations.length-1]);

		System.out.println("Distance from " + stations[1] + " to " + stations[3] + " is " + line.calculateDistance(stations[1], stations[3]));
		System.out.println("Distance from " + stations[3] + " to " + stations[1] + " is " + line.calculateDistance(stations[3], stations[1]));
	}
}

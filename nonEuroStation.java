//Leslie Hon
//CREATE DATE:  7-APR-2011
//RailwayFareEnquirySystem
//This is Bonus Part--Display local currency

public class nonEuroStation extends Station{
	private String currency;
	private Double euroRate;
	
	public nonEuroStation(String name, String country, String currency, double euroRate) {
		super(name, country);
		this.currency = currency;
		this.euroRate = euroRate;
	}
	
	public String getCurrency(){
		return currency;
	}
	
	public double geteuroRate(){
		return euroRate;
	}
}

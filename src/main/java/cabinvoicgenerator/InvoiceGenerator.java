package cabinvoicgenerator;

public class InvoiceGenerator {
	private double MINIMUM_COST_PER_KILOMETER = 10;
	private int COST_PER_TIME = 1;
	private double MINIMUM_FARE = 5;
	/**
	 * Usecase 1
	 * Function finds the fare for a ride
	 * @param distance
	 * @param time
	 * @return
	 */
	public double calculateFare(double distance, int time, String typeOfRide) {	
		if(typeOfRide.equalsIgnoreCase("Premium")) {
			MINIMUM_COST_PER_KILOMETER = 15;
			COST_PER_TIME = 2;
			MINIMUM_FARE = 20;
		}
		double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
		if(totalFare < MINIMUM_FARE) {
			return MINIMUM_FARE;
		}
		return totalFare;
	}
	/**
	 * Usecase 2
	 * Function calculates the fare for multiple ride
	 * @param rides
	 * @return
	 */
	public InvoiceSummary calculateFare(Ride[] rides, int userId) {
		double totalFare = 0;
		for(Ride ride : rides) {
			if(ride.userId == userId) {
			totalFare += this.calculateFare(ride.distance, ride.time, ride.typeOfRide);
			}
		}
		InvoiceSummary invoiceSummary = new InvoiceSummary(rides.length, totalFare);
		return invoiceSummary;
	}
}

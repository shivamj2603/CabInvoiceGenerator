package cabinvoicgenerator;

public class InvoiceGenerator {
	private static final double MINIMUM_COST_PER_KILOMETER = 10;
	private static final int COST_PER_TIME = 1;
	private static final double MINIMUM_FARE = 5;
	/**
	 * Usecase 1
	 * Function finds the fare for a ride
	 * @param distance
	 * @param time
	 * @return
	 */
	public double calculateFare(double distance, int time) {	
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
			totalFare += this.calculateFare(ride.distance, ride.time);
			}
		}
		InvoiceSummary invoiceSummary = new InvoiceSummary(rides.length, totalFare);
		return invoiceSummary;
	}
}

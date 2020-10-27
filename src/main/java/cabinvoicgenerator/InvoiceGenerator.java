package cabinvoicgenerator;

public class InvoiceGenerator {
	private double MINIMUM_COST_PER_KILOMETER = 10;
	private int COST_PER_TIME = 1;
	private double MINIMUM_FARE = 5;
	private RideRepository rideRepository;
	public InvoiceGenerator() {
		rideRepository = new RideRepository();
	}
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
	public InvoiceSummary calculateFare(Ride[] rides) {
		double totalFare = 0;
		for(Ride ride : rides) {
			totalFare += this.calculateFare(ride.distance, ride.time);
		}
		InvoiceSummary invoiceSummary = new InvoiceSummary(rides.length, totalFare);
		return invoiceSummary;
	}
	/**
	 * @param userId
	 * @param rides
	 */
	public void addRides(String userId, Ride[] rides) {
		rideRepository.addRides(userId, rides);
	}
	/**
	 * Usecase 4
	 * Get Invoice Summary for given user ID
	 * @param userId
	 * @return
	 */
	public InvoiceSummary getInvoiceSummary(String userId) {
		return this.calculateFare(rideRepository.getRides(userId));
	}
}

package cabinvoicgenerator;

public class InvoiceGenerator {
	private RideRepository rideRepository;
	public InvoiceSummary calculateFare(Ride[] rides) {
		double totalFare = 0;
		for(Ride ride : rides) {
			totalFare += ride.cabRide.calcCostOfCabRide(ride);
		}
		InvoiceSummary invoiceSummary = new InvoiceSummary(rides.length, totalFare);
		return invoiceSummary;
	}
	public InvoiceSummary getInvoiceSummary(String userId) {
		return this.calculateFare(rideRepository.getRides(userId));
	}
	public void setRideRepository(RideRepository rideRepository) {
		this.rideRepository = rideRepository;
	}
}

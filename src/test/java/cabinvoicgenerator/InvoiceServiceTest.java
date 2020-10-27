package cabinvoicgenerator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;

public class InvoiceServiceTest {
	InvoiceGenerator invoiceGenerator = null;
	@BeforeEach
	public void set() {
	invoiceGenerator = new InvoiceGenerator();
	}
	@Test
	public void givenMultipleRides_shouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(CabRide.NORMAL,3.0, 5),
				         new Ride(CabRide.NORMAL, 0.1, 2)
		               };
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		InvoiceSummary invoiceSummary = invoiceGenerator.calculateFare(rides);
		InvoiceSummary excpectedInvoiceSummary = new InvoiceSummary(2, 40.0);
		assertEquals(excpectedInvoiceSummary,invoiceSummary);	
	}
	@Test
	public void givenUserIDAndNormalRides_shouldReturn_InvoiceSummary() {
		String userId = "Shivam";
		Ride[] rides = { new Ride(CabRide.NORMAL, 3.0, 5),
		                 new Ride(CabRide.NORMAL, 0.1, 2)
                       };
		RideRepository rideRepository = new RideRepository();
		rideRepository.addRides(userId, rides);
		invoiceGenerator.setRideRepository(rideRepository);
		InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 40.0);
		assertEquals(expectedInvoiceSummary, summary);
	}
	@Test
	public void givenUserIDAndMultipleRidesWithMinimumPremiumRide_shouldReturn_InvoiceSummary() {
		String userId = "Shivam";
		Ride[] rides = { new Ride(CabRide.NORMAL, 3.0, 5),
		                 new Ride(CabRide.PREMIUM, 0.1, 2)
                       };
		RideRepository rideRepository = new RideRepository();
		rideRepository.addRides(userId, rides);
		invoiceGenerator.setRideRepository(rideRepository);
		InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 55.0);
		assertEquals(expectedInvoiceSummary, summary);
	}
	@Test
	public void givenUserIDAndMultipleRidesWithMinimumNormalRide_shouldReturn_InvoiceSummary() {
		String userId = "Shivam";
		Ride[] rides = { new Ride(CabRide.PREMIUM, 3.0, 5),
		                 new Ride(CabRide.NORMAL, 0.1, 2)
                       };
		RideRepository rideRepository = new RideRepository();
		rideRepository.addRides(userId, rides);
		invoiceGenerator.setRideRepository(rideRepository);
		InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 60.0);
		assertEquals(expectedInvoiceSummary, summary);
	}
	@Test
	public void givenUserIDAndPremiumRides_shouldReturn_InvoiceSummary() {
		String userId = "Shivam";
		Ride[] rides = { new Ride(CabRide.PREMIUM, 3.0, 5),
		                 new Ride(CabRide.PREMIUM, 0.1, 2)
                       };
		RideRepository rideRepository = new RideRepository();
		rideRepository.addRides(userId, rides);
		invoiceGenerator.setRideRepository(rideRepository);
		InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 75.0);
		assertEquals(expectedInvoiceSummary, summary);
	}	
}

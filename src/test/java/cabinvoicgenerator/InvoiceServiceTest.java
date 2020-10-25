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
	public void givenDistanceAndTime_shouldReturnTotalFare() {
		double distance = 3.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare(distance, time, "Normal");
		assertEquals(35, fare, 0.0);
	}
	@Test
	public void givenLessDistanceOrTime_shouldReturnMinFare() {
		double distance = 0.1;
		int time = 2;
		double fare = invoiceGenerator.calculateFare(distance, time, "Normal");
		assertEquals(5, fare, 0.0);
	}
	@Test
	public void givenUserId_getListOfRides_shouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(1, 3.0, 5, "Normal"),
		         new Ride(1, 0.1, 2, "Normal")
              };
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 40);
		assertEquals(expectedInvoiceSummary, invoiceGenerator.calculateFare(rides, 1));		
	}
	@Test
	public void givenPremiumRide_getListOfRides_shouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(1, 3.0, 5, "Premium"),
		         new Ride(1, 0.1, 2, "Premium")
              };
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 75);
		assertEquals(expectedInvoiceSummary, invoiceGenerator.calculateFare(rides, 1));		
	}
}

package cabinvoicgenerator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvoiceServiceTest {
	@Test
	public void givenDistanceAndTime_shouldReturnTotalFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 3.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare(distance, time);
		assertEquals(35, fare, 0.0);
	}
	@Test
	public void givenLessDistanceOrTime_shouldReturnMinFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 0.1;
		int time = 2;
		double fare = invoiceGenerator.calculateFare(distance, time);
		assertEquals(5, fare, 0.0);
	}
	@Test
	public void givenUserId_getListOfRides_shouldReturnInvoiceSummary() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		Ride[] rides = { new Ride(1, 3.0, 5),
		         new Ride(1, 0.1, 2)
              };
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 40);
		assertEquals(expectedInvoiceSummary, invoiceGenerator.calculateFare(rides, 1));
		
	}
	
}

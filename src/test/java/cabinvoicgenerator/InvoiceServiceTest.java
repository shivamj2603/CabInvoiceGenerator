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
		double fare = invoiceGenerator.calculateFare(distance, time);
		assertEquals(35, fare, 0.0);
	}
	@Test
	public void givenLessDistanceOrTime_shouldReturnMinFare() {
		double distance = 0.1;
		int time = 2;
		double fare = invoiceGenerator.calculateFare(distance, time);
		assertEquals(5, fare, 0.0);
	}
	@Test
	public void givenMultipleRides_shouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(3.0, 5),
				         new Ride(0.1, 2)
		               };
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		InvoiceSummary invoiceSummary = invoiceGenerator.calculateFare(rides);
		InvoiceSummary excpectedInvoiceSummary = new InvoiceSummary(2, 40.0);
		assertEquals(excpectedInvoiceSummary,invoiceSummary);	
	}
	@Test
	public void givenUserIDAndRides_shouldReturn_InvoiceSummary() {
		String userId = "Shivam";
		Ride[] rides = { new Ride(3.0, 5),
		                 new Ride(0.1, 2)
                       };
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		invoiceGenerator.addRides(userId, rides);
		InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 40.0);
		assertEquals(expectedInvoiceSummary, summary);
	}
}

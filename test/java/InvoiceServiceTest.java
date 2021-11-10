
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class InvoiceServiceTest {
    InvoiceGenerator invoiceGenerator = null;
    @Before
    public void setUp() throws  Exception{
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
    }
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare(){
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance,time);
        Assertions.assertEquals(25, fare,0.0);
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnMinimumFare(){
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance,time);
        Assertions.assertEquals(5, fare,0.0);
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnInvoiceSummary() {
          InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
          Ride [] rides = {new Ride(2.0, 5),
                            new Ride(0.1, 1)
                            };
          InvoiceSummary summary = InvoiceGenerator.calculateFare(rides);
          InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,30.0);
        // double fare = invoiceGenerator.CalculateFare(rides);
        Assertions.assertEquals(expectedInvoiceSummary,summary);
    }
}

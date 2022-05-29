package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CabInvoiceServiceTest {

	@Test
	public void GivenDistanceAndTime_ShouldReturnTotalFare()
	{
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 2.0;
		int time = 5;
		double fare = invoiceGenerator.CalculateFare(distance, time);
		Assertions.assertEquals(25, fare,0.0);
	}

	@Test
	public void givenLessDistanceAndTime_shouldReturnMinFare()
	{
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.CalculateFare(distance, time);
		Assertions.assertEquals(5, fare,0.0);

	}

	@Test
	public void givenMultipleRides_shouldReturnTotalFare(){
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		Rides[] rides ={ new Rides(2.0, 5),
							new Rides(0.1,1)
		};
		double fare = invoiceGenerator.CalculateFare(rides);
		Assertions.assertEquals(30,fare,0.0);
	}



}

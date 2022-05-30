package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CabInvoiceServiceTest {

	@Test
	public void GivenDistanceAndTime_ShouldReturnTotalFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 2.0;
		int time = 5;
		double fare = invoiceGenerator.CalculateFare(distance, time);
		Assertions.assertEquals(25, fare, 0.0);
	}

	@Test
	public void givenLessDistanceAndTime_shouldReturnMinFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.CalculateFare(distance, time);
		Assertions.assertEquals(5, fare, 0.0);

	}

	@Test
	public void givenMultipleRide_ShouldReturnInvoiceSummary() {
		InvoiceGenerator invoiceGerator = new InvoiceGenerator();
		Rides[] rides = {new Rides(2.0, 5),
				new Rides(0.11, 1)
		};
		InvoiceSummary summary = invoiceGerator.CalculateFare(rides);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
		Assertions.assertEquals(expectedInvoiceSummary, summary);
	}



	@Test
	public void GivenDistanceAndTimeForUserId_ShouldReturnTotalFare() {
		InvoiceGenerator invoiceGerator = new InvoiceGenerator();
		String userId = "John";
		Rides[] rides = {new Rides(2.0, 5),
				new Rides(0.11, 1)
		};
		UserID.AddRide(userId, List.of(rides));
		InvoiceSummary summary = invoiceGerator.CalculateFare(rides);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
		Assertions.assertEquals(expectedInvoiceSummary, summary);
	}

		@Test
	public void GivenDistanceAndTimeForPremium_ShouldReturnTotalFare()
	{
		double distance = 2.0;
		int time = 5;
		double fare = RideType.CalculateFarePER(distance, time);
		Assertions.assertEquals(40, fare,0.0);
	}

	@Test
	public void GivenDistanceAndTimeNormal_ShouldReturnTotalFare() {

		double distance = 2.0;
		int time = 5;
		double fare = RideType.CalculateFareNormal(distance, time);
		Assertions.assertEquals(25, fare, 0.0);
	}

}

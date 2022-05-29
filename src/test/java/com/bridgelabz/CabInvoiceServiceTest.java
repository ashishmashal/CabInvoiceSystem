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
		double expected = 25;
		Assertions.assertEquals(expected, fare);
	}

	@Test
	public void GivenLessDistanceAndTime_ShouldReturnMinFare()
	{
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.CalculateFare(distance, time);
		double expected = 5;
		Assertions.assertEquals(expected, fare);
	}
}

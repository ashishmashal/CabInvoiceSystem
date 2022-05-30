package com.bridgelabz;

public class InvoiceGenerator {
	private static final double MINIMUN_COST_PER_KM = 10.0;
	private static final int COST_PER_TIME = 1;
	private static final double MINIMUN_FARE = 5;


	public InvoiceSummary CalculateFare(Rides[] rides) {
		double totalFare = 0.0;
		for (Rides ride : rides) {
			totalFare += this.CalculateFare(ride.distance , ride.time);
		}
		return new InvoiceSummary(rides.length,totalFare);
	}

	public double CalculateFare(double distance, int time) {
		double totalFare = distance * MINIMUN_COST_PER_KM + time * COST_PER_TIME;
		return Math.max(totalFare, MINIMUN_FARE);
	}
}

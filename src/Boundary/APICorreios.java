package Boundary;

import Entity.BookTrade;

public class APICorreios {
	
	public static String sendBooks(BookTrade bt) {
		String trackingCodes = "";
		
		trackingCodes += bt.getBook2().getName() + " TRACKING CODE: " + "0193712\n";
		trackingCodes += bt.getBook1().getName() + " TRACKING CODE: " + "1284343\n";
		
		return trackingCodes;
	}
}

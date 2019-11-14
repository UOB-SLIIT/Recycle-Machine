package com.perisic.peripherals;
import com.perisic.beds.recycling.*;
/**
 * Tests the recycling machine.
 * @author Marc Conrad
 *
 */
public class SimpleTester {
/**
 * Start the tester here.  
 */
	public static void main(String [] args) { 

		PrinterInterface myPrinter = new ReceiptPrinter(); 

		CustomerPanel myPanel = new CustomerPanel(myPrinter); 
		myPanel.itemReceived(1);
		myPanel.itemReceived(1);
		myPanel.itemReceived(3);
		myPanel.itemReceived(2);
		myPanel.itemReceived(3);
		myPanel.itemReceived(1); 
		myPanel.itemReceived(1);
		
		myPanel.printReceipt();
	}
}

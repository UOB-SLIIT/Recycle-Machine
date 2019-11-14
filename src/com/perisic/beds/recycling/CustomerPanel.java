package com.perisic.beds.recycling;

/**
 * This is the interface of the system. It represents the interaction from 
 * the customer with the system. 
 * The customer panel knows the recycling machine (i.e. the Deposit Item Receiver class)
 * @author Marc Conrad
 *
 */
public class CustomerPanel {
	DepositItemReceiver receiver = null; 

	public CustomerPanel(PrinterInterface myPrinter) {
		super(); 
		receiver = new DepositItemReceiver(myPrinter); 
	}

	/**
	 * Use Case I - an item has been entered into the system.
	 * @param slot
	 */
	public void itemReceived(int slot) { 
		receiver.classifyItem(slot); 
	}
	/**
	 * Use Case II - a receipt has been requested. 
	 */
	public void printReceipt() { 
		receiver.printReceipt();
	}

	public void setPrinter(PrinterInterface myPrinter) { 
		// Add something like for Task 2, b: receiver.setPrinter(myPrinter); 
	}

}

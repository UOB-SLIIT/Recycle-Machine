package com.perisic.beds.recycling;

/** 
 * This class represents the overall system. 
 * @author Marc Conrad
 *
 */
public class DepositItemReceiver {
	ReceiptBasis theReceiptBasis = null; 	
	/**
	 * The deposit item receiver is constructed with the output device (i.e. the printer)
	 * @param printer
	 */
	public DepositItemReceiver(PrinterInterface printer) {
		super();
		this.printer = printer;
	}

	PrinterInterface printer = null; 

	/**
	 * Initiates the 'database' of the system. Items are stored in the receipt basis.
	 */
	public void createReceiptBasis() { 
		theReceiptBasis = new ReceiptBasis(); 
	}
	/**
	 * This method receives the slot and then adds items into the machine according to the slot indicated.
	 * @param slot
	 */
	public void classifyItem(int slot) { 
		DepositItem item = null; 
		if( slot == 1 ) { 
			item = new Can(); 
		} else if( slot == 2 ) { 
			item = new Bottle(); 
		} else if ( slot == 3 ) { 
			item = new Crate(); 
		} else if (slot == 4) {
			item = new Bag();
		} 
		if( theReceiptBasis == null ) { 
			createReceiptBasis(); 
		}
		theReceiptBasis.addItem(item); 
	}

	/**
	 * Prints the receipt. 
	 */
	public void printReceipt() { 
		String str = theReceiptBasis.computeSum(); 
		printer.print(str); 
		theReceiptBasis = null; 
	}
}

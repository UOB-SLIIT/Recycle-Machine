package com.perisic.peripherals;
import com.perisic.beds.recycling.PrinterInterface;

/**
 * Simulates a very simple printer that prints out stuff.
 * @author Marc Conrad
 *
 */
public class ReceiptPrinter implements PrinterInterface {
	/**
	 * @param str
	 */
	public void print(String str) { 
		// add code here to work with a real printer... 
		System.out.println(str);
	}
}

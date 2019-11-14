package com.perisic.peripherals;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.perisic.beds.recycling.CustomerPanel;
import com.perisic.beds.recycling.PrinterInterface;
/**
 * A Simple Graphical User Interface for the Recycling Machine.
 * This class combines three different aspects: 
 * 1) Starting the software
 * 2) Implementing the GUI
 * 3) Handling events
 *  
 * @author Marc Conrad
 *
 */
public class RecyclingGUI extends JFrame implements ActionListener  {

	private static final long serialVersionUID = -1077856539035586635L;
	int count1;
	
	/**
	 * Method that is called when an item has been entered into the machine or a receipt has been requested.
	 */
	
	
	
	public void actionPerformed(ActionEvent e) {
		if( e.getSource().equals(slot1)) { 
			myPanel.itemReceived(1);
			count();
		} else if( e.getSource().equals(slot2)) { 
			myPanel.itemReceived(2);
			count();
		} else if(e.getSource().equals(slot3)) { 
			myPanel.itemReceived(3);
			count();
		} else if(e.getSource().equals(slot4)) { 
			myPanel.itemReceived(4);
			count();
		} else if(e.getSource().equals(receipt)) { 
			myPanel.printReceipt();
			count1 = 0;
			count.setText("0");
		}
	}

	JButton slot1 = new JButton("Can"); 
	JButton slot2 = new JButton("Bottle"); 
	JButton slot3 = new JButton("Crate");
	JButton slot4 = new JButton("Bag");
	JButton receipt = new JButton("Receipt"); 
	
	JLabel no = new JLabel("No of Items : ");
	JLabel count = new JLabel("0");
	//static JTextArea Text1 = new JTextArea(400,200);//test
	



	CustomerPanel myPanel = null;

	public RecyclingGUI() {
		super();
		setSize(400, 200);// Increasing GUI size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setResizable(false); // setting resize ability false
		JPanel panel = new JPanel();
		panel.setBackground(new Color(210, 187, 187)); // adding background color to the panel
		
		 
		slot1.setBounds(10, 20, 130, 34);
		slot1.setBackground(new Color(1,149,135)); // adding background color to the Button
		slot1.setForeground(new Color(255,255,255)); // adding foreground color to the Button
		panel.add(slot1);
		
		
		slot2.setBounds(10, 20, 130, 34);
		slot2.setBackground(new Color(1,149,135));// adding background color to the Button
		slot2.setForeground(new Color(255,255,255));// adding foreground color to the Button
		panel.add(slot2);
		
		
		
		slot3.setBounds(10, 20, 130, 34);
		slot3.setBackground(new Color(1,149,135));// adding background color to the Button
		slot3.setForeground(new Color(255,255,255));// adding foreground color to the Button
		panel.add(slot3);
		
		
		slot4.setBounds(10, 20, 130, 34);
		slot4.setBackground(new Color(1,149,135));// adding background color to the Button
		slot4.setForeground(new Color(255,255,255));// adding foreground color to the Button
		panel.add(slot4);
		

		slot1.addActionListener(this); 
		slot2.addActionListener(this); 
		slot3.addActionListener(this); 
		slot4.addActionListener(this); 

		 
		
		
		
		receipt.setBounds(10, 20, 130, 34);
		receipt.setBackground(new Color(102,169,34));// adding background color to the Button
		receipt.setForeground(new Color(255,255,255));// adding foreground color to the Button
		panel.add(receipt); 
		
		receipt.addActionListener(this);
		
		panel.add(no);
		
		
		panel.add(count);


		getContentPane().add(panel);
		panel.repaint();

		PrinterInterface myPrinter = new Display(); 
		myPanel = new CustomerPanel(myPrinter); 
		
	}
	
	/**
	 * Method that is called when an item has been entered into the machine .
	 * This method will keep track of the count of items entered to the machine.
	 */
	
	public void count() {
		
		count1++;
		String counter = Integer.toString(count1);
		count.setText(counter);
		System.out.println(counter); // for Testing

	}
	
	
	
	
	
	/**
	 * Main entry point into the recycling machine.
	 * @param args not used.
	 */
	public static void main(String [] args ) { 
		RecyclingGUI myGUI = new RecyclingGUI(); 
		myGUI.setVisible(true); 

	}
	
	

}
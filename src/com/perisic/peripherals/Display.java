package com.perisic.peripherals;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.perisic.beds.recycling.PrinterInterface; 
/** 
 * Displays text in a frame.
 */
public class Display extends JFrame implements PrinterInterface {
	/**
	 * A serialVersionUID is required by the JFrame class. 
	 */
	private static final long serialVersionUID = -8505887234618184162L;
	private JTextArea outputWindow; 

	/**
	 * when constructed the display will be directly visible. 
	 */	
	public Display() {
		super();
		setSize(400, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		setResizable(false); // setting Resizable ability fails
		outputWindow = new JTextArea();
		outputWindow.setForeground(Color.RED);
		getContentPane().add(outputWindow);
		setVisible(true); 
		
	}
	/** 
	 * Prints the text str to the screen. Any previous text will be overwritten. 
	 * @see com.perisic.beds.PrinterInterface#print(java.lang.String)
	 */
	public void print(String str) { 
		
		Document document = new Document();
		
		int input = JOptionPane.showConfirmDialog(null, "Do you want to save the Receipt as PFD?");
			if(input == 0) {
				
				try {
					PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Receipt.pdf"));
					document.open();
					document.add(new Paragraph(str));
					document.close();
					writer.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (DocumentException e) {
					e.printStackTrace();
				}
				
				//Confirmation Message
				JOptionPane.showMessageDialog(null, "Receipt Saved successfully in project folder");
				
			}if(input == 1) {
				outputWindow.setText(str); 
				outputWindow.repaint();
			}
		
		
		
		
		
		//Create pdf
		
		
		
		
			
			
		
		
		
	}

}
package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class HandleFile {
 
	//Declare Variable
	JFileChooser fileChooser = new JFileChooser();
	StringBuilder sb = new StringBuilder();
 
	public void PickFile() throws Exception{
  
		if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			
			//get the file
			java.io.File file = fileChooser.getSelectedFile();
	   
			//create a scanner for the file
			Scanner input = new Scanner(file);
	   
			//read text from file
			while(input.hasNext()) {
		    sb.append(input.nextLine());
		    	sb.append("\n");;
		   	}
		   		input.close();
		} else {
		  sb.append("No file was selected");
	  	}
	}
	
	public BufferedReader PutFile(JFrame frame) throws Exception {
		
		int returnVal = fileChooser.showOpenDialog(frame);
		BufferedReader input = null;
		
	    if (returnVal == JFileChooser.APPROVE_OPTION) {
	    	File file = fileChooser.getSelectedFile();
	    	
	    	try {
	    		input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

	      	} catch (Exception e) {
	      		e.printStackTrace();
	      	}
	    } else {
	    	 System.out.println("Operation is CANCELLED :(");
	    }
	    
	    return input;
	}
}


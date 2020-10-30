package main;

import java.io.File;

import java.util.Scanner;
import javax.swing.JFileChooser;

public class HandleFile {
 
	JFileChooser fileChooser = new JFileChooser();
	StringBuilder sb = new StringBuilder();
	
	// Pick the txt file and return the content in string format
	public String PickFile() throws Exception{
  
		if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			
			// Get the file
			File file = fileChooser.getSelectedFile();
	   
			// Create a scanner for the file
			Scanner input = new Scanner(file);
	   
			// Read text from file and put on sb
			while(input.hasNext()) {
				sb.append(input.nextLine());
		    	sb.append("\n");
		   	}
		   	input.close();
		} else {
			sb.append("No file was selected");
	  	}
	   	return sb.toString();
	}
}


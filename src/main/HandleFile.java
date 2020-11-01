package main;

import java.io.File;

import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/**
 * Receive Txt archive and return in string
 * @author Roque Matheus Gomes Costa
 *
 */
public class HandleFile {

	JFileChooser fileChooser = new JFileChooser();
	StringBuilder receiveTextOfTheTxt = new StringBuilder();

	/**
	 * Pick the txt file and return the content in string format
	 * @author Roque Matheus Gomes Costa
	 * @return returnTextOfTheTxt
	 * @throws Exception 
	 */
	public String PickFile() throws Exception {

		receiveTextOfTheTxt.setLength(0);

		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

			// Get the file
			File file = fileChooser.getSelectedFile();

			// Create a scanner for the file
			Scanner input = new Scanner(file);

			// Read text from file and put on sb
			while (input.hasNext()) {

				receiveTextOfTheTxt.append(input.nextLine());
				receiveTextOfTheTxt.append("\n");

			}

			input.close();

		} else {

			JOptionPane.showMessageDialog(null, "No file was selected");

		}

		return receiveTextOfTheTxt.toString();
		
	}
}

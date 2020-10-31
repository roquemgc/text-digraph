package main;

import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;


public class CreateCsvFile {
	
	public void createCsv(List<String> txtContent){
	
		try {
			FileWriter csvWriter = new FileWriter("convertedFile.csv");
			
			for (String s : txtContent) {
			    csvWriter.append(String.join(", ", s));
			}

			csvWriter.flush();
			csvWriter.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}

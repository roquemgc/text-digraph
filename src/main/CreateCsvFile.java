package main;

import java.io.FileWriter;

public class CreateCsvFile {

	public void CreateCsv(String txtContent) {

		try {

			FileWriter csvWriter = new FileWriter("convertedFile.csv");
			csvWriter.write(txtContent);
			csvWriter.flush();
			csvWriter.close();

		} catch (Exception e) {

			System.out.println(e);
		}
	}
}

package view;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import main.ConvertString;
import main.CreateCsvFile;
import main.HandleFile;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Component;
import javax.swing.JLabel;

public class MainScreen extends JFrame {

	private JPanel contentPane;
	private HandleFile handleFile = new HandleFile();
	private String fileContent;

	public MainScreen() {
		setTitle("Txt Converter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txaTxt = new JTextArea();
		txaTxt.setLineWrap(true);
		txaTxt.setEditable(false);
		
		
		JScrollPane spTxt = new JScrollPane(txaTxt);
		spTxt.setBounds(24, 100, 317, 345);
		contentPane.add(spTxt);
		
		JTextArea txaCsv = new JTextArea();
		txaCsv.setLineWrap(true);
		txaCsv.setEditable(false);
		
		JScrollPane spScv = new JScrollPane(txaCsv);
		spScv.setBounds(382, 100, 195, 345);
		contentPane.add(spScv);

		JButton btnOpenFile = new JButton("Pick file");
		btnOpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        txaTxt.setText(" ");
				try {
					// Receive the string of picked file
					fileContent = handleFile.PickFile();	
					
					// Put the txt content on textArea

			      	txaTxt.setText(fileContent);
					
					// Print the content of the file
					System.out.println(fileContent);
					
				} catch (Exception e) {
					System.out.println(e);
				}

			}
		});

		btnOpenFile.setBounds(24, 12, 177, 25);
		contentPane.add(btnOpenFile);
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					if(fileContent == null) {
						
						JOptionPane.showMessageDialog(null,"Please select a file first.");
					
					}else{	
						
						ConvertString call = new ConvertString(fileContent);
						CreateCsvFile createFile = new CreateCsvFile();

						call.removePunctuationString();
						call.saveNewTextOftheTxtInTheList();
						call.orderArraysWithWordsOfTheTextTxt();
						createFile.createCsv(call.generateFinalText());
						
						txaCsv.setText(call.convertToString());
						
					}
				
				} catch (Exception e) {
					
					System.out.println(e);
				}
			}
		
		});
		btnConvert.setBounds(213, 12, 177, 25);
		contentPane.add(btnConvert);
		
		JLabel lblNewLabel = new JLabel("Txt file content");
		lblNewLabel.setBounds(24, 75, 138, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblTxtConvertedTo = new JLabel("Txt converted to Csv");
		lblTxtConvertedTo.setBounds(382, 75, 195, 15);
		contentPane.add(lblTxtConvertedTo);
		
	}
}

package view;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import main.ConvertString;
import main.HandleFile;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.JTextPane;

public class MainScreen extends JFrame {

	private JPanel contentPane;
	private HandleFile handleFile = new HandleFile();
	private String fileContent;
	private List<String> textOutput = new ArrayList<String>();

	public MainScreen() {
		setTitle("Txt Converter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txpContent = new JTextPane();
		txpContent.setEditable(false);
		txpContent.setBounds(15, 34, 481, 192);
		contentPane.add(txpContent);
		
		JButton btnOpenFile = new JButton("Pick file");
		btnOpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					// Receive the string of picked file
					fileContent = handleFile.PickFile();	
					
					// Put the txt content on JTextPane
					txpContent.setText(fileContent);
					
					// Print the content of the file
					System.out.println(fileContent);
					
				} catch (Exception e) {
					System.out.println(e);
				}

			}
		});
		btnOpenFile.setBounds(59, 278, 177, 25);
		contentPane.add(btnOpenFile);
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
					try {
					
					if(fileContent == null) {
						
						JOptionPane.showMessageDialog(null,"Please select a file first.");
						
					}else{
						
						ConvertString call = new ConvertString(fileContent);
						
						call.RemovePunctuationString();
						
						call.SaveNewTextOftheTxtInTheList();
						
						call.OrderArraysWithWordsOfTheTextTxt();
						
						textOutput = call.GeneratorFinalText();
						
						String finalTextOutputInString = "";
						
						for (String  FinaltextOutput : textOutput) {
							
							finalTextOutputInString  += FinaltextOutput;
							
						}
						
						txpContent.setText(finalTextOutputInString);
					
					}
					
					} catch (Exception e) {
						
						System.out.println(e);
						
					}
					
			}
		
		});
		btnConvert.setBounds(271, 278, 177, 25);
		contentPane.add(btnConvert);

	}
}

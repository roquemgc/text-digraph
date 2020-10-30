package view;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import main.ConvertString;
import main.HandleFile;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextPane;

public class MainScreen extends JFrame {

	private JPanel contentPane;
	private HandleFile handleFile = new HandleFile();
	public String fileContent;

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
					fileContent = handleFile.pickFile();	
					
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
						
						call.RemovePontuationsString();
						
						call.saveNewTextOftheTxtInTheList();
						
						call.OrderArraysWithWordsOfTheTextTxt();
						
						call.GeneratorFinalText();
					
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

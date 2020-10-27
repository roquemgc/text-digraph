package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import main.HandleFile;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.StringReader;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;

public class MainScreen extends JFrame {

	private JPanel contentPane;
	private HandleFile handleFile = new HandleFile();

	public MainScreen() {
		setTitle("Txt Converter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txaFileContent = new JTextArea();
		txaFileContent.setEditable(false);
		txaFileContent.setBounds(33, 30, 449, 223);
		contentPane.add(txaFileContent);
		
		JButton btnOpenFile = new JButton("Escolher arquivo");
		btnOpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					// Receive the string of picked file
					String fileContent = handleFile.pickFile();
					
					// Convert the txt file content to reader format
					BufferedReader reader = new BufferedReader(new StringReader(fileContent));
					
					// Put the reader on TextArea
					txaFileContent.read(reader, "Reading File");
					
					// Print the content of the file
					System.out.println(fileContent);
				} catch (Exception e) {
					System.out.println(e);
				}

			}
		});
		btnOpenFile.setBounds(59, 278, 177, 25);
		contentPane.add(btnOpenFile);
		
		JButton btnConvert = new JButton("Converter");
		btnConvert.setBounds(282, 278, 177, 25);
		contentPane.add(btnConvert);

	}
}

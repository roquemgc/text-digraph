package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import main.HandleFile;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class MainScreen extends JFrame {

	private JPanel contentPane;
	private HandleFile handleFile = new HandleFile();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainScreen() {
		setTitle("Txt Converter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
		
		JTextArea txaFileContent = new JTextArea();
		txaFileContent.setEditable(false);
		txaFileContent.setBounds(33, 30, 449, 223);
		contentPane.add(txaFileContent);
		
		JButton btnOpenFile = new JButton("Escolher arquivo");
		btnOpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					handleFile.PickFile();
					txaFileContent.read(handleFile.PutFile(frame), "Reading File");
				} catch (Exception e) {
					
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

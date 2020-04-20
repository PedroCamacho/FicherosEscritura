import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.*;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;

public class VentanaEscritura extends JFrame {

	private JPanel contentPane;
	private JLabel lblResultado;
	private JTextArea txtaTexto;
	private JButton btnEscribe2;
	private JButton btnEscribe3;
	private JLabel lblInfo;

	public VentanaEscritura() {
		setTitle("Escritura de Ficheros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 39, 299, 191);
		contentPane.add(scrollPane);

		txtaTexto = new JTextArea();
		scrollPane.setViewportView(txtaTexto);

		JButton btnEscribe1 = new JButton("Escribe 1");
		btnEscribe1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				metodo1();
			}
		});
		btnEscribe1.setBounds(329, 41, 89, 23);
		contentPane.add(btnEscribe1);

		lblResultado = new JLabel("");
		lblResultado.setForeground(Color.RED);
		lblResultado.setBounds(20, 241, 299, 14);
		contentPane.add(lblResultado);
		
		btnEscribe2 = new JButton("Escribe 2");
		btnEscribe2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				metodo2();
			}
		});
		btnEscribe2.setBounds(329, 75, 89, 23);
		contentPane.add(btnEscribe2);
		
		btnEscribe3 = new JButton("Escribe 3");
		btnEscribe3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				metodo3();
			}
		});
		btnEscribe3.setBounds(329, 109, 89, 23);
		contentPane.add(btnEscribe3);
		
		lblInfo = new JLabel("Escribe el texto y luego pulsa un bot\u00F3n:");
		lblInfo.setBounds(20, 11, 288, 14);
		contentPane.add(lblInfo);
	}

	private void metodo1() {
		File rutaProyecto = new File(System.getProperty("user.dir"));
		JFileChooser fc = new JFileChooser(rutaProyecto);
		int seleccion = fc.showSaveDialog(contentPane);
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			File fichero = fc.getSelectedFile();
			try {
				FileOutputStream fos = new FileOutputStream(fichero);
				fos.write(txtaTexto.getText().getBytes());
				fos.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	private void metodo2() {
		File rutaProyecto = new File(System.getProperty("user.dir"));
		JFileChooser fc = new JFileChooser(rutaProyecto);
		int seleccion = fc.showSaveDialog(contentPane);
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			File fichero = fc.getSelectedFile();
			try {
				FileWriter fw = new FileWriter(fichero);
				BufferedWriter bw = new BufferedWriter (fw);
				bw.write(txtaTexto.getText());
				bw.close();
				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	private void metodo3() {
		File rutaProyecto = new File(System.getProperty("user.dir"));
		JFileChooser fc = new JFileChooser(rutaProyecto);
		int seleccion = fc.showSaveDialog(contentPane);
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			File fichero = fc.getSelectedFile();
			try {
				PrintWriter pw = new PrintWriter(fichero);
				pw.println(txtaTexto.getText());
				pw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
}

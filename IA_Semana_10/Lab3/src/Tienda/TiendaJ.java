package Tienda;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class TiendaJ extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblMarca;
	private JComboBox cboMarca;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JButton btnProcesar;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TiendaJ frame = new TiendaJ();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TiendaJ() {
		setTitle("Tienda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(10, 11, 91, 14);
		contentPane.add(lblMarca);
		
		cboMarca = new JComboBox();
		cboMarca.setModel(new DefaultComboBoxModel(new String[] {"Tabernero", "Navarro Correas", "Trapiche", "Tacama"}));
		cboMarca.setBounds(89, 7, 127, 22);
		contentPane.add(cboMarca);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 414, 200);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrollPane.setViewportView(txtS);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 36, 69, 14);
		contentPane.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(89, 36, 127, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 7, 89, 23);
		contentPane.add(btnProcesar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(335, 33, 89, 23);
		contentPane.add(btnCerrar);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnNewButton(e);
		}
	}
	
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		//Declaración de variables locales
		int posMarca, cantidad, caramelos, lapiceros;
		double tarifa, aPagar;
		
		//Entrada de datos
		posMarca = leerPosMarca();
		cantidad = leerCantidad();

		//Proceso de datos
		tarifa = obtenerTarifa(posMarca);
		aPagar = calcularImportePagar(cantidad, tarifa);
		caramelos = calcularCaramelos(cantidad);
		lapiceros = calcularLapiceros(posMarca, cantidad);
		
		//Salida de resultados
		mostrarResultados(tarifa, aPagar, caramelos, lapiceros);
	}
	
	
	
	
	int leerPosMarca() {
		return cboMarca.getSelectedIndex();
	}
	
	int leerCantidad () {
		return Integer.parseInt(txtCantidad.getText());
	}
	
	double obtenerTarifa (int pos) {
		double tar;
		
		switch (pos) {
			case 0: tar = 14.9;   break;
			case 1: tar = 24.9;   break;	
			case 2: tar = 29.9;   break;
			default: tar = 20.9; 
		}
		
		return tar;
	}
	double calcularImportePagar (int can, double pre) {
		return can * pre;
	}
	 
	int calcularCaramelos (int can) {
		
		int obsq1;
		
		if (can <=5) 
			obsq1 = 2;
		else
			if (can <= 10)
				obsq1 = 3;
			else
				if (can <= 15)
					obsq1 = 1 * can;
				else 
					obsq1 = 2 * can;
		
		return obsq1;
	}
	int calcularLapiceros (int pos, int can) {
		int obsq2;
		
		if (pos == 0) 
			obsq2 = 4 * can;
		else
			if (pos == 1)
				obsq2 = 3 * can;
			else
				if (pos == 2)
					obsq2 = 2 * can;
				else
					obsq2 = 1 * can;
		return obsq2;
	}
	void mostrarResultados(double tar, double aPag, int obsq1, int obsq2) {
		txtS.setText("BOLETA DE VENTA" + "\n\n");
		imprimir("Precio por unidad :  S/. " + tar);
		imprimir("Importe a Pagar   :  S/. " + aPag);
		imprimir("Caramelos         :  " + obsq1 + " caramelos");
		imprimir("Lapiceros         :  " + obsq2 + " lapiceros");
	}	
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
}

package semana_10;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Hotel extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblMarca;
	private JLabel lblCantidad;
	private JComboBox <String> cboMarca;
	private JTextField txtCantidad;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JScrollPane scrollPane;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hotel frame = new Hotel();
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
	public Hotel() {
		setTitle("Tienda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(10, 7, 120, 23);
		contentPane.add(lblMarca);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 32, 120, 23);
		contentPane.add(lblCantidad);
		
		cboMarca = new JComboBox <String> ();
		cboMarca.setModel(new DefaultComboBoxModel(new String[] {"Tabernero", "Navarro Correas", "Trapiche", "Tacama"}));
		cboMarca.setBounds(120, 7, 100, 23);
		contentPane.add(cboMarca);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(120, 32, 101, 23);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 7, 89, 23);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(335, 32, 89, 23);
		contentPane.add(btnBorrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 414, 189);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrollPane.setViewportView(txtS);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
	}
	
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
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
		
		
		
		
		
		
		
		/**
		//Declaración de variables locales
		int posHabitacion, cantidad, obsequio;
		double tarifa, descuento, subTotal, aPagar;
		
		//Entrada de datos
		posHabitacion = leerPosHabitacion();
		cantidad = leerCantidad();
		
		//Proceso de cálculos
		tarifa = calcularTarifa(posHabitacion);
		subTotal = calcularSubTotal(cantidad, tarifa);
		descuento = calcularDescuento(cantidad, subTotal);
		aPagar = calcularPago(subTotal, descuento);
		obsequio = calcularObsequio(aPagar, cantidad);
		
		//Salidad de resultados
		mostrarResultados(tarifa, subTotal, descuento, aPagar, obsequio);
	}
	
//********************************************************		
		//Método de retorno sin parámetros
		int leerPosHabitacion() {
			return cboTipoHabitacion.getSelectedIndex();
		}
//########################################################		
		int leerCantidad() {
			return Integer.parseInt(txtCantidadDias.getText());
		}
//********************************************************		
		//Método de retorno con parámetros
		double calcularTarifa(int pos) {
			double tar;
			switch(pos) {
				case 0: tar = 80.00; break;
				case 1: tar = 130.00; break;
				case 2: tar = 140.00; break;
				default: tar = 180.00;
			}
			return tar;	
		 }
//########################################################		
		double calcularSubTotal(int can, double tar) {
			return can * tar;
		}
//########################################################		
		double calcularDescuento(int can, double sT) {
			
			double des;
			
			if (can >= 12)
				des = 0.075 * sT;
			else
				if (can >=6)
					des = 0.05 * sT;
				else
					if (can >=3)
						des = 0.025 * sT;
					else 
						des = 0.0;
			
			return des;
		}
//########################################################			
		double calcularPago(double sT, double des) {
			return sT - des;
		}
//########################################################			
		int calcularObsequio(double pago, int can) {
			int lap;
			
			if (pago < 100.0)
				lap = 2*can;
			else
				if (pago < 150.0)
					lap = 3*can;
				else
					lap = 4*can;
			
			return lap;
		}
//********************************************************		
		void imprimir(String s) {
			txtS.append(s + "\n");
		}
//########################################################		
		//Método sin valor de retorno con parámetros
		void mostrarResultados(double tar, double sT, double des, double pago, int ob) {
			txtS.setText("BOLETA DE PAGO" + "\n\n");
			imprimir("Tarifa diaria :  S/. " + tar);
			imprimir("SubTotal      :  S/. " + sT);
			imprimir("Descuento     :  S/. " + des);
			imprimir("A pagar       :  S/. " + pago);
			imprimir("Obsequio      :  " + ob + " lapiceros");
		}

		
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		cboTipoHabitacion.setSelectedIndex(0);
		txtCantidad.setText("");
		txtS.setText("");
		txtCantidad.requestFocus();
	}*/


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

public class Mochila extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblModelo;
	private JLabel lblCantidad;
	private JComboBox <String> cboModelo;
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
					Mochila frame = new Mochila();
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
	public Mochila() {
		setTitle("Mochila");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 7, 70, 23);
		contentPane.add(lblModelo);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 32, 70, 23);
		contentPane.add(lblCantidad);
		
		cboModelo = new JComboBox <String> ();
		cboModelo.setModel(new DefaultComboBoxModel <String>
		                  (new String[] {"Sherman", "Faguo", "Aldo", "Suburban"}));
		cboModelo.setBounds(70, 7, 85, 23);
		contentPane.add(cboModelo);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(70, 32, 86, 23);
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
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(e);
		}
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		
		//Declaración de variables locales
		int posModelo, cantidad, obsequio;
		double tarifa, descuento, subTotal, aPagar;
		
		//Entrada de datos
		posModelo = obtenerModelo();
		cantidad = leerCantidad();

		//Proceso de cálculos
		tarifa = calcularTarifa(posModelo);
		subTotal = calcularSubTotal(cantidad, tarifa);
		descuento = calcularDescuento(cantidad, subTotal);
		aPagar = calcularPago(subTotal, descuento);
		obsequio = calcularObsequio(aPagar, cantidad);
		
		
		//Salidad de resultados
		mostrarResultados(subTotal, descuento, aPagar, obsequio);
		
	}
	
	//Métodos de retorno sin parámetros
	
	int obtenerModelo() {
		return cboModelo.getSelectedIndex();
	}
	
	int leerCantidad() {
		return Integer.parseInt(txtCantidad.getText());
	}
	
	//Métodos de retorno con parámetros
	
	double calcularTarifa (int pos) {
		
		double tar;
		
		switch (pos) {
			case 0: tar = 149.9; break;
			case 1: tar = 89.0; break;
			case 2: tar = 119.9; break;
			default: tar = 174.9;
		}
		return tar;
	}
	
	double calcularSubTotal (int can, double tar) {
		return can * tar;
	}
	
	double calcularDescuento (int can, double sT) {
		
		double des;
		
		if (can < 5)
			des = 0;
		else
			if (can < 10)
				des = 0.05 * sT;
			else
				if (can < 20)
					des = 0.07 * sT;
				else
					des = 0.09 * sT;
		
		return des;
	}
	
	double calcularPago (double sT, double des) {
		return sT - des;
	}
	
	int calcularObsequio (double pago, int can) {
		
		int choco;
		
		if (pago < 200)
			choco = 0;
		else
			if (pago < 500) 
				choco = 1 * can;
			else
				if (pago < 700)
					choco = 2 * can;
				else 
					choco = 3 * can;
		
		return choco;
		
	}
	
	//Métodos sin valor de retorno con Parámetros
	
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
	
	void tituloBoleta(String s) {
		txtS.setText(s + "\n\n");
	}
		
	void mostrarResultados (double sT, double des, double pago, int obs) {
		tituloBoleta("BOLETA DE VENTA");
		imprimir("Importa de compra : S/. " + sT);
		imprimir("Descuento         : S/. " + des);
		imprimir("A pagar           : S/. " + pago);
		imprimir("Chocolates        : S/. " + obs);
	}
	
	protected void actionPerformedBtnBorrar(ActionEvent e) {
		cboModelo.setSelectedIndex(0);
		txtCantidad.setText("");
		txtS.setText("");
		txtCantidad.requestFocus();
	}
}

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

public class Libreria extends JFrame implements ActionListener {

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
					Libreria frame = new Libreria();
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
	public Libreria() {
		setTitle("Librer\u00EDa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(10, 7, 70, 23);
		contentPane.add(lblMarca);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 32, 70, 23);
		contentPane.add(lblCantidad);
		
		cboMarca = new JComboBox <String> ();
		cboMarca.setModel(new DefaultComboBoxModel <String>
		                 (new String[] {"Standford", "Alpha", "Justus", "Loro"}));
		cboMarca.setBounds(70, 7, 85, 23);
		contentPane.add(cboMarca);
		
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
	
	int posMarca, cantidad;
	double tarifa, descuento, subTotal, aPagar;
	
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		//Declaración de variables locales

		
		//Entrada de datos
		posMarca = leerPosMarca();
		cantidad = leerCantidad();

		
		//Proceso de cálculos
		tarifa = obtenerPrecio(posMarca);
		subTotal = calcularSubTotal(cantidad, tarifa);
		descuento = calcularDescuento(cantidad, subTotal);
		aPagar = calcularPago(subTotal, descuento);
		
		//Salidad de resultados
		mostrarResultados(subTotal, descuento, aPagar);
		

	}
	
	//Métodos de retorno sin parámetros
	int leerPosMarca() {
		return cboMarca.getSelectedIndex();
	}
	
	int leerCantidad() {
		return Integer.parseInt(txtCantidad.getText());
	}
	
	//Métodos de retorno con parámetros
	double obtenerPrecio(int pos) {
		
		double tar;
		
		switch (pos) {
			case 0:	tar = 4.85;	break;
			case 1: tar = 4.35; break;
			case 2: tar = 3.50; break;
			default: tar = 4.55;
		}
		return tar;
	}
	
	double calcularSubTotal(int can, double tar) {
		return can * tar;
	}
	
	double calcularDescuento(int can, double sT) {
		
		double des;
		
		if (can >= 36)
			des = 0.135 * sT;
		else
			if (can >= 24)
				des = 0.115 * sT;
			else 
				if (can >= 12)
					des = 0.095 * sT;
				else 
					des = 0.075 * sT;
		
		return des;
	}
	
	double calcularPago(double sT, double des) {
		return sT - des;
	}
	

	//Métodos sin valor de retorno con Parámetros
	
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
	
	void tituloBoleta(String s) {
		txtS.setText(s + "\n\n");
	}
		
	void mostrarResultados (double sT, double des, double pago) {
		tituloBoleta("BOLETA DE VENTA");
		imprimir("Importa de compra : S/. " + sT);
		imprimir("Descuento         : S/. " + des);
		imprimir("A pagar           : S/. " + pago);
	}
	
	protected void actionPerformedBtnBorrar(ActionEvent e) {
		cboMarca.setSelectedIndex(0);
		txtCantidad.setText("");
		txtS.setText("");
		txtCantidad.requestFocus();
	}
}

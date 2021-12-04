package semana_09;

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
	private JLabel lblTipoHabitacion;
	private JLabel lblCantidadDias;
	private JComboBox <String> cboTipoHabitacion;
	private JTextField txtCantidadDias;
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
		setTitle("Hotel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTipoHabitacion = new JLabel("Tipo de habitaci\u00F3n");
		lblTipoHabitacion.setBounds(10, 7, 120, 23);
		contentPane.add(lblTipoHabitacion);
		
		lblCantidadDias = new JLabel("Cantidad de d\u00EDas");
		lblCantidadDias.setBounds(10, 32, 120, 23);
		contentPane.add(lblCantidadDias);
		
		cboTipoHabitacion = new JComboBox <String> ();
		cboTipoHabitacion.setModel(new DefaultComboBoxModel <String>
		                          (new String[] {"Simple", "Matrimonial", "Doble", "Triple"}));
		cboTipoHabitacion.setBounds(120, 7, 100, 23);
		contentPane.add(cboTipoHabitacion);
		
		txtCantidadDias = new JTextField();
		txtCantidadDias.setBounds(120, 32, 101, 23);
		contentPane.add(txtCantidadDias);
		txtCantidadDias.setColumns(10);
		
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
		if (arg0.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(arg0);
		}
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
	}
	
	//Declaración de variables globales
	int posHabitacion, cantidad, lapiceros;
	double tarifa, subTotal, descuento, aPagar;
	
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		entradaDeDatos();
		procesoDeCalculo();
		salidaDeResultados();
	}
	//Método sin valor de retornor (con parámetros)
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
	
	void titulo(String x) {
		txtS.setText(x + "\n\n");
	}
	
	//Métodos sin valor de retorno (sin parámetros)
	
	void procesoDeCalculo() {
		switch (posHabitacion) {
			case 0: tarifa = 80.0; break;
			case 1: tarifa = 130.0; break;
			case 2: tarifa = 140.0; break;
			default: tarifa = 180.0; 
		}
		
		subTotal = cantidad * tarifa;
		
		if (cantidad >= 12)
			descuento = 0.075 * subTotal;
		else 
			if (cantidad >=6)
				descuento = 0.05 * subTotal;
			else 
				if (cantidad >=3)
					descuento = 0.025 * subTotal;
					else 
						descuento = 0.0;
		
		aPagar = subTotal - descuento;
		
		if (aPagar <100)
			lapiceros = 2 * cantidad;
		else
			if (aPagar <150)
				lapiceros = 3 * cantidad;
				else 
					lapiceros = 4 * cantidad;
			
	}
	
	void entradaDeDatos() {
		posHabitacion = cboTipoHabitacion.getSelectedIndex();
		cantidad = Integer.parseInt(txtCantidadDias.getText());
	}
	
	void salidaDeResultados() {
		titulo("BOLETA DE PAGO");
		imprimir("Tarifa por día    : S/." + tarifa);
		imprimir("Subtotal          : S/." + subTotal);
		imprimir("Descuento         : S/." + descuento);
		imprimir("A pagar           : S/." + aPagar);
		imprimir("Obsequio          : " + lapiceros + " lapiceros");
	}
	
	
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		eliminarImpresion();
	}
	
	void eliminarImpresion () {
		txtS.setText("");
		txtS.append("");
		cboTipoHabitacion.setSelectedIndex(0);
		txtCantidadDias.setText("");
		txtCantidadDias.requestFocus();
	}
}

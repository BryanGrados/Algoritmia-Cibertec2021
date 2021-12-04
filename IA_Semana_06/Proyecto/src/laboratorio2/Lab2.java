package laboratorio2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;

public class Lab2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JComboBox cboPlan;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JLabel lblTipo;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JScrollPane scrollPane;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lab2 frame = new Lab2();
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
	public Lab2() {
		setTitle("ABC SEGUROS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cboPlan = new JComboBox();
		cboPlan.setBounds(143, 11, 84, 22);
		cboPlan.setModel(new DefaultComboBoxModel(new String[] {"Plan A", "Plan B", "Plan C", "Plan D"}));
		contentPane.add(cboPlan);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.setBounds(335, 11, 89, 23);
		btnProcesar.addActionListener(this);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(335, 34, 89, 23);
		btnBorrar.addActionListener(this);
		contentPane.add(btnBorrar);
		
		lblTipo = new JLabel("Tipo de Plan");
		lblTipo.setBounds(42, 15, 91, 14);
		contentPane.add(lblTipo);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(42, 38, 68, 14);
		contentPane.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(143, 35, 84, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 65, 414, 185);
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
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
	//Declaración de variables
		int tipoPlan, cantidad, agendas;
		double descuento, costo, subTotal, aPagar;
		
	//Entada de datos
		tipoPlan = cboPlan.getSelectedIndex();
		cantidad = Integer.parseInt(txtCantidad.getText());
		
	//Proceso de cálculo
		switch (tipoPlan) {
			case 0: costo = 625.8; break;
			case 1: costo = 709.1; break;
			case 2: costo = 834.2; break;
			default: costo = 980.5;
		}
		
		subTotal = cantidad * costo;
		
		if (cantidad <3)
			descuento = 0.025 * costo;
			else if (cantidad <6)
					descuento = 0.035 * costo;
					else if (cantidad <9)
							descuento = 0.045 * costo;
							else 
								descuento = 0.055 * costo;
		
		aPagar = subTotal - descuento;
		
		switch (tipoPlan) {
			case 0: agendas = 4 * cantidad; break;
			case 1: agendas = 3 * cantidad; break;
			case 2: agendas = 5; break;
			default: agendas = 2; break;
		}
		
	//Salida de resultados
		txtS.setText("BOLETA DE VENTA" + "\n\n");
		txtS.append("Importe de Venta     :  S/. " + subTotal + "\n");
		txtS.append("Importe de Descuento :  S/. " + descuento + "\n");
		txtS.append("Importe de Pago      :  S/. " + aPagar + "\n");
		txtS.append("Obsequio(s)          :  " + agendas +  " agendas");
	}
	
	
	protected void actionPerformedBtnBorrar(ActionEvent e) {
		txtS.setText("");
		txtS.append("");
		txtCantidad.setText("");
		txtCantidad.requestFocus();
		cboPlan.setSelectedIndex(0);
	}
}

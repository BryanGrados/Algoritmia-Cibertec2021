package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JScrollPane;

public class DialogoVender extends JDialog implements ActionListener {
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JButton btnCerrar;
	private JTextArea txtS;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogoVender dialog = new DialogoVender();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DialogoVender() {
		setTitle("Mantenimiento | Vender");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 11, 57, 14);
		getContentPane().add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(63, 8, 86, 20);
		getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(159, 7, 89, 23);
		getContentPane().add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(247, 7, 89, 23);
		getContentPane().add(btnBorrar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(335, 7, 89, 23);
		getContentPane().add(btnCerrar);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtS.setBounds(10, 36, 414, 214);
		getContentPane().add(txtS);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 414, 214);
		getContentPane().add(scrollPane);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(e);
		}
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		// Declaraci?n de variables
		int cantidad;
		double importeCompra, importeDescuento, importePagar;
		
		// Entrada de datos
		cantidad = Integer.parseInt(txtCantidad.getText());
		
		// Proceso de c?lculo
		importeCompra = Proyecto.precio * cantidad;
		importeDescuento = Proyecto.descuento * importeCompra / 100;
		importePagar = importeCompra - importeDescuento;
		
		// Salida de resultados
		txtS.setText("Importe de la compra : S/ " + importeCompra + "\n");
		txtS.append ("Importe del descuento : S/ " + importeDescuento + "\n");
		txtS.append ("Importe a pagar : S/ " + importePagar);
	}
	protected void actionPerformedBtnBorrar(ActionEvent e) {
		txtS.setText("");
		txtCantidad.setText("");
		txtCantidad.requestFocus();
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}

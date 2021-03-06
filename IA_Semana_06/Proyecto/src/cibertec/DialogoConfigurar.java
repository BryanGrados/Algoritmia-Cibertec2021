package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoConfigurar extends JDialog implements ActionListener {
	private JTextField txtPrecio;
	private JTextField txtDescuento;
	private JLabel lblPrecio;
	private JLabel lblDescuento;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogoConfigurar dialog = new DialogoConfigurar();
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
	public DialogoConfigurar() {
		setTitle("Mantenimiento | Configurar");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		txtPrecio = new JTextField("" + Proyecto.precio);
		txtPrecio.setBounds(131, 11, 86, 20);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
	
		
		txtDescuento = new JTextField("" + Proyecto.descuento);
		txtDescuento.setBounds(131, 42, 86, 20);
		getContentPane().add(txtDescuento);
		txtDescuento.setColumns(10);
		
		lblPrecio = new JLabel("Precio (S/.)");
		lblPrecio.setBounds(20, 14, 101, 14);
		getContentPane().add(lblPrecio);
		
		lblDescuento = new JLabel("Descuento (%)");
		lblDescuento.setBounds(20, 45, 101, 14);
		getContentPane().add(lblDescuento);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(335, 10, 89, 23);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(335, 41, 89, 23);
		getContentPane().add(btnCancelar);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		Proyecto.precio = Double.parseDouble(txtPrecio.getText());
		Proyecto.descuento = Double.parseDouble(txtDescuento.getText());
		dispose();
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
}

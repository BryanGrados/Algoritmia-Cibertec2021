package guisConfiguracion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import guis.Proyecto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DialogoConfigurarCantidadOptima extends JDialog implements ActionListener {
	private JTextField txtCantidadOptima;
	private JButton btnCancelar;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoConfigurarCantidadOptima dialog = new DialogoConfigurarCantidadOptima();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoConfigurarCantidadOptima() {
		setTitle("Configurar | Cantidad \u00D3ptima");
		setBounds(100, 100, 450, 116);
		getContentPane().setLayout(null);
		{
			JLabel lblCantidadOptima = new JLabel("Cantidad \u00D3ptima de unidades vendidas");
			lblCantidadOptima.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblCantidadOptima.setBounds(10, 11, 219, 14);
			getContentPane().add(lblCantidadOptima);
		}
		{
			txtCantidadOptima = new JTextField(Proyecto.cantidadOptima + "");
			txtCantidadOptima.setBounds(215, 8, 86, 20);
			getContentPane().add(txtCantidadOptima);
			txtCantidadOptima.setColumns(10);
		}
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(this);
			btnAceptar.setBounds(335, 7, 89, 23);
			getContentPane().add(btnAceptar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(335, 32, 89, 23);
			getContentPane().add(btnCancelar);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
	}
	
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		grabarDatos();
	}	
	
	
	
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}

	
	
	
void grabarDatos() {
	
	try {
			int cdOptima = leerNum(txtCantidadOptima);
			
			Proyecto.cantidadOptima = cdOptima;
			dispose();
	}
	catch (Exception x) {
		validacion("valor", txtCantidadOptima);
	}

	
	
	

}


void validacion(String s, JTextField txt) {
	mensaje("Ingrese un " + s + " correcto", "Error", 0);
	txt.setText("");
	txt.requestFocus();
}	

void mensaje(String s1, String s2, int i) {
	JOptionPane.showMessageDialog(this, s1, s2, i);
}


	
int leerNum(JTextField txt) {
	return Integer.parseInt(txt.getText());
}	
	

}

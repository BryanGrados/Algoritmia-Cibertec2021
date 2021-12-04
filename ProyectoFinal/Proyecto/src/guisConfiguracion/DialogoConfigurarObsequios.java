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

public class DialogoConfigurarObsequios extends JDialog implements ActionListener {
	private JTextField txtTipoObsequio;
	private JLabel lblObsequioCantidad1;
	private JLabel lblObsequioCantidad2;
	private JLabel lblObsequioCantidad3;
	private JTextField txtObsequioCantidad1;
	private JTextField txtObsequioCantidad2;
	private JTextField txtObsequioCantidad3;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoConfigurarObsequios dialog = new DialogoConfigurarObsequios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoConfigurarObsequios() {
		setTitle("Configurar | Obsequios");
		setBounds(100, 100, 450, 151);
		getContentPane().setLayout(null);
		{
			JLabel lblTipoObsequio = new JLabel("Tipo de Obsequio");
			lblTipoObsequio.setBounds(10, 11, 109, 14);
			getContentPane().add(lblTipoObsequio);
		}
		
		txtTipoObsequio = new JTextField(Proyecto.tipoObsequio);
		txtTipoObsequio.setBounds(166, 8, 86, 20);
		getContentPane().add(txtTipoObsequio);
		txtTipoObsequio.setColumns(10);
		
		lblObsequioCantidad1 = new JLabel("1 a 5 unidades");
		lblObsequioCantidad1.setBounds(10, 36, 109, 14);
		getContentPane().add(lblObsequioCantidad1);
		
		lblObsequioCantidad2 = new JLabel("6 a 10 unidades");
		lblObsequioCantidad2.setBounds(10, 61, 109, 14);
		getContentPane().add(lblObsequioCantidad2);
		
		lblObsequioCantidad3 = new JLabel("11 a m\u00E1s unidades");
		lblObsequioCantidad3.setBounds(10, 86, 109, 14);
		getContentPane().add(lblObsequioCantidad3);
		
		txtObsequioCantidad1 = new JTextField(Proyecto.obsequioCantidad1 + "");
		txtObsequioCantidad1.setColumns(10);
		txtObsequioCantidad1.setBounds(166, 33, 86, 20);
		getContentPane().add(txtObsequioCantidad1);
		
		txtObsequioCantidad2 = new JTextField(Proyecto.obsequioCantidad2 + "");
		txtObsequioCantidad2.setColumns(10);
		txtObsequioCantidad2.setBounds(166, 58, 86, 20);
		getContentPane().add(txtObsequioCantidad2);
		
		txtObsequioCantidad3 = new JTextField(Proyecto.obsequioCantidad3 + "");
		txtObsequioCantidad3.setColumns(10);
		txtObsequioCantidad3.setBounds(166, 83, 86, 20);
		getContentPane().add(txtObsequioCantidad3);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(335, 7, 89, 23);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(335, 36, 89, 23);
		getContentPane().add(btnCancelar);
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
	
	String tipObs = leerDat(txtTipoObsequio);
	
	if (tipObs.length() > 0) 
		try {
			int de1_5 = leerNum(txtObsequioCantidad1);
			try {
				int de6_10 = leerNum(txtObsequioCantidad2);
				try {
					int de11_ = leerNum(txtObsequioCantidad3);
					
						Proyecto.tipoObsequio = tipObs;
	
						Proyecto.obsequioCantidad1 = de1_5;
						Proyecto.obsequioCantidad2 = de6_10;
						Proyecto.obsequioCantidad3 = de11_;
						
						dispose();	
				
				}
				catch (Exception x) {
					validacion("valor" , txtObsequioCantidad3);
				}
			}
			catch (Exception x) {
				validacion("valor" , txtObsequioCantidad2);
			}
		}
		catch (Exception x) {
			validacion("valor" , txtObsequioCantidad1);
		}
	else
		validacion("nombre" , txtTipoObsequio);
	
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
	
String leerDat(JTextField txt) {
	return String.format(txt.getText());
}


}

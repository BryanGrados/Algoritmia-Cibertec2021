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

public class DialogoConfigurarDescuentos extends JDialog implements ActionListener {
	private JTextField txtPorcentaje1;
	private JTextField txtPorcentaje2;
	private JTextField txtPorcentaje3;
	private JTextField txtPorcentaje4;
	private JButton btnCancelar;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoConfigurarDescuentos dialog = new DialogoConfigurarDescuentos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoConfigurarDescuentos() {
		setTitle("Configurar | Descuentos");
		setBounds(100, 100, 389, 160);
		getContentPane().setLayout(null);
		{
			JLabel lblPorcentaje1 = new JLabel("1 a 5 unidades");
			lblPorcentaje1.setBounds(10, 11, 100, 14);
			getContentPane().add(lblPorcentaje1);
		}
		{
			JLabel lblPorcentaje2 = new JLabel("6 a 10 unidades");
			lblPorcentaje2.setBounds(10, 36, 100, 14);
			getContentPane().add(lblPorcentaje2);
		}
		{
			JLabel lblPorcentaje3 = new JLabel("11 a 15 unidades");
			lblPorcentaje3.setBounds(10, 61, 100, 14);
			getContentPane().add(lblPorcentaje3);
		}
		{
			JLabel lblPorcentaje4 = new JLabel("M\u00E1s de 15 unidades");
			lblPorcentaje4.setBounds(10, 86, 122, 14);
			getContentPane().add(lblPorcentaje4);
		}
		{
			txtPorcentaje1 = new JTextField(Proyecto.porcentaje1 + "");
			txtPorcentaje1.setBounds(140, 8, 63, 20);
			getContentPane().add(txtPorcentaje1);
			txtPorcentaje1.setColumns(10);
		}
		{
			txtPorcentaje2 = new JTextField(Proyecto.porcentaje2 + "");
			txtPorcentaje2.setColumns(10);
			txtPorcentaje2.setBounds(140, 33, 63, 20);
			getContentPane().add(txtPorcentaje2);
		}
		{
			txtPorcentaje3 = new JTextField(Proyecto.porcentaje3 + "");
			txtPorcentaje3.setColumns(10);
			txtPorcentaje3.setBounds(140, 58, 63, 20);
			getContentPane().add(txtPorcentaje3);
		}
		{
			txtPorcentaje4 = new JTextField(Proyecto.porcentaje4 + "");
			txtPorcentaje4.setColumns(10);
			txtPorcentaje4.setBounds(140, 83, 63, 20);
			getContentPane().add(txtPorcentaje4);
		}
		{
			JLabel lblPorc4 = new JLabel("%");
			lblPorc4.setBounds(213, 82, 46, 23);
			getContentPane().add(lblPorc4);
		}
		{
			JLabel lblPorc3 = new JLabel("%");
			lblPorc3.setBounds(213, 57, 46, 23);
			getContentPane().add(lblPorc3);
		}
		{
			JLabel lblPorc2 = new JLabel("%");
			lblPorc2.setBounds(213, 32, 46, 23);
			getContentPane().add(lblPorc2);
		}
		{
			JLabel lblPorc1 = new JLabel("%");
			lblPorc1.setBounds(213, 7, 46, 23);
			getContentPane().add(lblPorc1);
		}
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(this);
			btnAceptar.setBounds(278, 7, 89, 23);
			getContentPane().add(btnAceptar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(278, 32, 89, 23);
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
		double porcen1 = leerNum(txtPorcentaje1);
		try {
			double porcen2 = leerNum(txtPorcentaje2);
			try {
				double porcen3 = leerNum(txtPorcentaje3);
				try {
					double porcen4 = leerNum(txtPorcentaje4);
					
					Proyecto.porcentaje1 = porcen1;
					Proyecto.porcentaje2 = porcen2;
					Proyecto.porcentaje3 = porcen3;
					Proyecto.porcentaje4 = porcen4;
					
					dispose();

					
				}
				catch (Exception x) {
					validacion("Nro° 4" , txtPorcentaje4);
				}
			}
			catch (Exception x) {
				validacion("Nro° 3" , txtPorcentaje3);
			}
		}
		catch (Exception x) {
			validacion("Nro° 2" , txtPorcentaje2);
		}
	}
	catch (Exception x) {
		validacion("Nro° 1" , txtPorcentaje1);		
}
	
	
	
	
	

}
	
void validacion(String s, JTextField txt) {
	mensaje("Valor " + s + " incorrecto", "Error", 0);
	txt.setText("");
	txt.requestFocus();
}	

void mensaje(String s1, String s2, int i) {
	JOptionPane.showMessageDialog(this, s1, s2, i);
}


double leerNum(JTextField txt) {
	return Double.parseDouble(txt.getText());
}	
	
	
}

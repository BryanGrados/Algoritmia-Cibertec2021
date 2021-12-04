package guisMantenimiento;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import guis.Proyecto;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoModificarDisco extends JDialog implements ActionListener {
	private JTextField txtPrecio;
	private JTextField txtAncho;
	private JTextField txtAlto;
	private JTextField txtFondo;
	private JTextField txtCapacidad;
	private JComboBox cboModelo;
	private JButton btnGrabar;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoModificarDisco dialog = new DialogoModificarDisco();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoModificarDisco() {
		setTitle("Mantenimiento | Modificar Disco Duro");
		setBounds(100, 100, 500, 200);
		getContentPane().setLayout(null);
		{
			JLabel lblModelo = new JLabel("Modelo");
			lblModelo.setBounds(10, 11, 89, 14);
			getContentPane().add(lblModelo);
		}
		{
			JLabel lblPrecio = new JLabel("Precio (S/.)");
			lblPrecio.setBounds(10, 36, 89, 14);
			getContentPane().add(lblPrecio);
		}
		{
			JLabel lblAncho = new JLabel("Ancho (cm)");
			lblAncho.setBounds(10, 61, 89, 14);
			getContentPane().add(lblAncho);
		}
		{
			JLabel lblAlto = new JLabel("Alto (cm)");
			lblAlto.setBounds(10, 86, 89, 14);
			getContentPane().add(lblAlto);
		}
		{
			JLabel lblFondo = new JLabel("Fondo (cm)");
			lblFondo.setBounds(10, 111, 89, 14);
			getContentPane().add(lblFondo);
		}
		{
			JLabel lblCapacidad = new JLabel("Capacidad (TB)");
			lblCapacidad.setBounds(10, 136, 89, 14);
			getContentPane().add(lblCapacidad);
		}
		{
			cboModelo = new JComboBox();
			cboModelo.addActionListener(this);
			cboModelo.setModel(new DefaultComboBoxModel(new String[] {"Western Digital My Cloud Home 6TB", "Western Digital Elements 4TB", "Toshiba Canvio Basics 4TB", "Seagate Expansion 4TB", "Seagate Backup Plus Hub 10TB"}));
			cboModelo.setBounds(142, 7, 218, 22);
			getContentPane().add(cboModelo);
		}
		{
			txtPrecio = new JTextField(Proyecto.precio0 + "");
			txtPrecio.setBounds(142, 33, 218, 20);
			getContentPane().add(txtPrecio);
			txtPrecio.setColumns(10);
		}
		{
			txtAncho = new JTextField(Proyecto.ancho0 + "");
			txtAncho.setColumns(10);
			txtAncho.setBounds(142, 58, 218, 20);
			getContentPane().add(txtAncho);
		}
		{
			txtAlto = new JTextField(Proyecto.alto0 + "");
			txtAlto.setColumns(10);
			txtAlto.setBounds(142, 83, 218, 20);
			getContentPane().add(txtAlto);
		}
		{
			txtFondo = new JTextField(Proyecto.fondo0 + "");
			txtFondo.setColumns(10);
			txtFondo.setBounds(142, 108, 218, 20);
			getContentPane().add(txtFondo);
		}
		{
			txtCapacidad = new JTextField(Proyecto.capacidad0 + "");
			txtCapacidad.setColumns(10);
			txtCapacidad.setBounds(142, 133, 218, 20);
			getContentPane().add(txtCapacidad);
		}
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(385, 32, 89, 23);
			getContentPane().add(btnCerrar);
		}
		{
			btnGrabar = new JButton("Grabar");
			btnGrabar.addActionListener(this);
			btnGrabar.setBounds(385, 7, 89, 23);
			getContentPane().add(btnGrabar);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(e);
		}
		if (e.getSource() == cboModelo) {
			actionPerformedComboBox(e);
		}
	}
	
	
	
	protected void actionPerformedComboBox(ActionEvent e) {
		listaTexto();
	}
	
	
	protected void actionPerformedBtnGrabar(ActionEvent e) {
		grabarTexto();
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
	void listaTexto() {
		switch (cboModelo.getSelectedIndex()) {
		case 0:
			txtPrecio.setText(Proyecto.precio0 + "");
			txtAncho.setText(Proyecto.ancho0 + "");
			txtAlto.setText(Proyecto.alto0 + "");
			txtFondo.setText(Proyecto.fondo0 + "");
			txtCapacidad.setText(Proyecto.capacidad0 + "");
			break;
		case 1:
			txtPrecio.setText(Proyecto.precio1 + "");
			txtAncho.setText(Proyecto.ancho1 + "");
			txtAlto.setText(Proyecto.alto1 + "");
			txtFondo.setText(Proyecto.fondo1 + "");
			txtCapacidad.setText(Proyecto.capacidad1 + "");
			break;
		case 2:
			txtPrecio.setText(Proyecto.precio2 + "");
			txtAncho.setText(Proyecto.ancho2 + "");
			txtAlto.setText(Proyecto.alto2 + "");
			txtFondo.setText(Proyecto.fondo2 + "");
			txtCapacidad.setText(Proyecto.capacidad2 + "");
			break;
		case 3:
			txtPrecio.setText(Proyecto.precio3 + "");
			txtAncho.setText(Proyecto.ancho3 + "");
			txtAlto.setText(Proyecto.alto3 + "");
			txtFondo.setText(Proyecto.fondo3 + "");
			txtCapacidad.setText(Proyecto.capacidad3 + "");
			break;
		default:
			txtPrecio.setText(Proyecto.precio4 + "");
			txtAncho.setText(Proyecto.ancho4 + "");
			txtAlto.setText(Proyecto.alto4 + "");
			txtFondo.setText(Proyecto.fondo4 + "");
			txtCapacidad.setText(Proyecto.capacidad4 + "");
			}
	}
	
void grabarTexto() {
	
	try {
		double precio = leerNum(txtPrecio);
		try {
			double ancho = leerNum(txtAncho);
			try {
				double alto = leerNum(txtAlto);	
				try {
					double fondo = leerNum(txtFondo);
					try {
						double capacidad = leerNum(txtCapacidad);
					
						switch (cboModelo.getSelectedIndex()) {
						case 0:
							Proyecto.precio0 = precio;
							Proyecto.ancho0 = ancho;
							Proyecto.alto0 = alto;
							Proyecto.fondo0 = fondo;
							Proyecto.capacidad0 = capacidad;
							break;
						case 1:
							Proyecto.precio1 = precio;
							Proyecto.ancho1 = ancho;
							Proyecto.alto1 = alto;
							Proyecto.fondo1 = fondo;
							Proyecto.capacidad1 = capacidad;
							break;
						case 2:
							Proyecto.precio2 = precio;
							Proyecto.ancho2 = ancho;
							Proyecto.alto2 = alto;
							Proyecto.fondo2 = fondo;
							Proyecto.capacidad2 = capacidad;
							break;
						case 3:
							Proyecto.precio3 = precio;
							Proyecto.ancho3 = ancho;
							Proyecto.alto3 = alto;
							Proyecto.fondo3 = fondo;
							Proyecto.capacidad3 = capacidad;
							break;
						default:
							Proyecto.precio4 = precio;
							Proyecto.ancho4 = ancho;
							Proyecto.alto4 = alto;
							Proyecto.fondo4 = fondo;
							Proyecto.capacidad4 = capacidad;
						}
						
						dispose();
					}
					catch (Exception x) {
						validacion("Capacidad", txtCapacidad);
					}
				 }	
				 catch (Exception x) {
						validacion("Fondo", txtFondo);
				}
		     }
			 catch (Exception x) {
					validacion("Alto", txtAlto); 
			 }
		  }
		   catch (Exception x) {
				validacion("Ancho", txtAncho);
		   }
		}
		catch (Exception x) {
			validacion("Precio", txtPrecio);
	   }
}
	
void validacion(String s, JTextField txt) {
	mensaje("Ingrese " + s + " correcto", "Error", 0);
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

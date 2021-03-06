package guisMantenimiento;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

import guis.Proyecto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoConsultarDisco extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox cboModelo;
	private JTextField txtPrecio;
	private JTextField txtAncho;
	private JTextField txtAlto;
	private JTextField txtFondo;
	private JTextField txtCapacidad;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoConsultarDisco dialog = new DialogoConsultarDisco();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoConsultarDisco() {
		setTitle("Mantenimiento | Consultar Disco Duro");
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
		
		cboModelo = new JComboBox();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"Western Digital My Cloud Home 6TB", "Western Digital Elements 4TB", "Toshiba Canvio Basics 4TB", "Seagate Expansion 4TB", "Seagate Backup Plus Hub 10TB"}));
		cboModelo.setBounds(123, 7, 230, 22);
		getContentPane().add(cboModelo);
		
		txtPrecio = new JTextField(Proyecto.precio0 + "");
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(123, 33, 230, 20);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtAncho = new JTextField(Proyecto.ancho0 + "");
		txtAncho.setEditable(false);
		txtAncho.setBounds(123, 58, 230, 20);
		getContentPane().add(txtAncho);
		txtAncho.setColumns(10);
		
		txtAlto = new JTextField(Proyecto.alto0 + "");
		txtAlto.setEditable(false);
		txtAlto.setBounds(123, 83, 230, 20);
		getContentPane().add(txtAlto);
		txtAlto.setColumns(10);
		
		txtFondo = new JTextField(Proyecto.fondo0 + "");
		txtFondo.setEditable(false);
		txtFondo.setBounds(123, 108, 230, 20);
		getContentPane().add(txtFondo);
		txtFondo.setColumns(10);
		
		txtCapacidad = new JTextField(Proyecto.capacidad0 + "");
		txtCapacidad.setEditable(false);
		txtCapacidad.setBounds(123, 133, 230, 20);
		getContentPane().add(txtCapacidad);
		txtCapacidad.setColumns(10);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(385, 7, 89, 23);
		getContentPane().add(btnCerrar);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboModelo) {
			actionPerformedCboModelo(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	
	protected void actionPerformedCboModelo(ActionEvent e) {
		int posModelo = cboModelo.getSelectedIndex();
		switch (posModelo) {
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
	
	
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}

package guisMantenimiento;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import guis.Proyecto;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DialogoListarDisco extends JDialog implements ActionListener {
	private JButton btnCerrar;
	private JButton btnListar;
	private JScrollPane scrollPane;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoListarDisco dialog = new DialogoListarDisco();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoListarDisco() {
		setTitle("Mantenimiento | Listado de Discos Duros ");
		setBounds(100, 100, 550, 523);
		getContentPane().setLayout(null);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(171, 437, 89, 23);
		getContentPane().add(btnCerrar);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setBounds(270, 437, 89, 23);
		getContentPane().add(btnListar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 514, 415);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrollPane.setViewportView(txtS);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}

	protected void actionPerformedBtnListar(ActionEvent e) {
		listado();
	}	
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}

	
	void listado() {
		imprimir("LISTADO DE DISCOS DUROS");
		imprimir("");
		imprimir("Modelo      : " + Proyecto.modelo0);
		imprimir("Precio      : " + "S/ " + Proyecto.precio0);
		imprimir("Ancho       : " + Proyecto.ancho0 + "cm" );
		imprimir("Alto        : " + Proyecto.alto0 + "cm");
		imprimir("Profundidad : " + Proyecto.fondo0 + "cm");
		imprimir("Capacidad   : " + Proyecto.capacidad0 + "kg");
		imprimir("");
		imprimir("Modelo      : " + Proyecto.modelo1);
		imprimir("Precio      : " + "S/ " + Proyecto.precio1);
		imprimir("Ancho       : " + Proyecto.ancho1 + "cm" );
		imprimir("Alto        : " + Proyecto.alto1 + "cm");
		imprimir("Profundidad : " + Proyecto.fondo1 + "cm");
		imprimir("Capacidad   : " + Proyecto.capacidad1 + "kg");
		imprimir("");
		imprimir("Modelo      : " + Proyecto.modelo2);
		imprimir("Precio      : " + "S/ " + Proyecto.precio2);
		imprimir("Ancho       : " + Proyecto.ancho2 + "cm" );
		imprimir("Alto        : " + Proyecto.alto2 + "cm");
		imprimir("Profundidad : " + Proyecto.fondo2 + "cm");
		imprimir("Capacidad   : " + Proyecto.capacidad2 + "kg");
		imprimir("");
		imprimir("Modelo      : " + Proyecto.modelo3);
		imprimir("Precio      : " + "S/ " + Proyecto.precio3);
		imprimir("Ancho       : " + Proyecto.ancho3 + "cm" );
		imprimir("Alto        : " + Proyecto.alto3 + "cm");
		imprimir("Profundidad : " + Proyecto.fondo3 + "cm");
		imprimir("Capacidad   : " + Proyecto.capacidad3 + "kg");
		imprimir("");
		imprimir("Modelo      : " + Proyecto.modelo4);
		imprimir("Precio      : " + "S/ " + Proyecto.precio4);
		imprimir("Ancho       : " + Proyecto.ancho4 + "cm" );
		imprimir("Alto        : " + Proyecto.alto4 + "cm");
		imprimir("Profundidad : " + Proyecto.fondo4 + "cm");
		imprimir("Capacidad   : " + Proyecto.capacidad4 + "kg");
		imprimir("");
	}
	
	
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
	
}

package cibertec;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Proyecto extends JFrame implements ActionListener {
	
	//Declaración de Variables globales
	
	public static double precio = 25.7, descuento = 15;
	
	private JPanel contentPane;
	private JMenuBar menuProyecto;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
	private JMenu mnMantenimiento;
	private JMenuItem mntmConfigurar;
	private JMenuItem mntmVender;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Proyecto frame = new Proyecto();
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
	public Proyecto() {
		setTitle("Proyecto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuProyecto = new JMenuBar();
		menuProyecto.setBounds(0, 0, 784, 22);
		contentPane.add(menuProyecto);
		
		mnArchivo = new JMenu("Archivo");
		menuProyecto.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuProyecto.add(mnMantenimiento);
		
		mntmConfigurar = new JMenuItem("Configurar");
		mntmConfigurar.addActionListener(this);
		mnMantenimiento.add(mntmConfigurar);
		
		mntmVender = new JMenuItem("Vender");
		mntmVender.addActionListener(this);
		mnMantenimiento.add(mntmVender);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmVender) {
			actionPerformedMntmVender(e);
		}
		if (e.getSource() == mntmConfigurar) {
			actionPerformedMntmConfigurar(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
	}
	protected void actionPerformedMntmSalir(ActionEvent e) {
		System.exit(0);
	}
	protected void actionPerformedMntmConfigurar(ActionEvent e) {
		DialogoConfigurar dc = new DialogoConfigurar();
		dc.setLocationRelativeTo(this);
		dc.setVisible(true);
		
		
	}
	protected void actionPerformedMntmVender(ActionEvent e) {
		DialogoVender dv = new DialogoVender();
		dv.setLocationRelativeTo(this);
		dv.setVisible(true);
	}
}

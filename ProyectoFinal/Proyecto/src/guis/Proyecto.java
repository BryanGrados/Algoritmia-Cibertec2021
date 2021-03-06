package guis;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import guisAyuda.DialogoAcercaTienda;
import guisConfiguracion.DialogoConfigurarCantidadOptima;
import guisConfiguracion.DialogoConfigurarCuotaDiaria;
import guisConfiguracion.DialogoConfigurarDescuentos;
import guisConfiguracion.DialogoConfigurarObsequios;
import guisMantenimiento.DialogoConsultarDisco;
import guisMantenimiento.DialogoListarDisco;
import guisMantenimiento.DialogoModificarDisco;
import guisVentas.DialogoGenerarReportes;
import guisVentas.DialogoVender;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Proyecto extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JMenuBar menuTienda;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenu mnVentas;
	private JMenu mnConfiguracion;
	private JMenu mnAyuda;
	private JMenuItem mntmSalir;
	private JMenuItem mntmConsultarDisco;
	private JMenuItem mntmModificarDisco;
	private JMenuItem mntmListarDisco;
	private JMenuItem mntmVender;
	private JMenuItem mntmGenerarReportes;
	private JMenuItem mntmConfigurarDescuentos;
	private JMenuItem mntmConfigurarObsequio;
	private JMenuItem mntmCantidadOptima;
	private JMenuItem mntmCuotaDiaria;
	private JMenuItem mntmAcercaDeLaTienda;

	
	// Datos m?nimos del primer disco duro
	public static String modelo0 = "Western Digital My Cloud Home 6TB";
	public static double precio0 = 1499.0;
	public static double fondo0 = 14.0;
	public static double ancho0 = 5.3;
	public static double alto0 = 17.5;
	public static double capacidad0 = 6;
	// Datos m?nimos del segundo disco duro
	public static String modelo1 = "Western Digital Elements 4TB";
	public static double precio1 = 555.0;
	public static double ancho1 = 11.5;
	public static double alto1 = 8.2;
	public static double fondo1 = 2.1;
	public static double capacidad1 = 4;
	// Datos m?nimos del tercer disco duro
	public static String modelo2 = "Toshiba Canvio Basics 4TB";
	public static double precio2 = 499.0;
	public static double ancho2 = 14.1;
	public static double alto2 = 11.1;
	public static double fondo2 = 3.8;
	public static double capacidad2 = 4;
	// Datos m?nimos del cuarto disco duro
	public static String modelo3 = "Seagate Expansion 4TB";
	public static double precio3 = 619.0;
	public static double ancho3 = 11.7;
	public static double alto3 = 8.0;
	public static double fondo3 = 2.1;
	public static double capacidad3 = 4;
	// Datos m?nimos del quinto disco duro
	public static String modelo4 = "Seagate Backup Plus Hub 10TB";
	public static double precio4 = 1099.0;
	public static double ancho4 = 19.8;
	public static double alto4 = 11.8;
	public static double fondo4 = 4.1;
	public static double capacidad4 = 10;
	// Porcentajes de descuento
	public static double porcentaje1 = 7.5;
	public static double porcentaje2 = 10.0;
	public static double porcentaje3 = 12.5;
	public static double porcentaje4 = 15.0;
	// Obsequios
	public static String tipoObsequio = "Lapicero";
	public static int obsequioCantidad1 = 2;
	public static int obsequioCantidad2 = 3;
	public static int obsequioCantidad3 = 4;
	// Cantidad ?ptima de unidades vendidas por d?a
	public static int cantidadOptima = 10;
	// Cuota diaria
	public static double cuotaDiaria = 30000;	
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Proyecto frame = new Proyecto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Proyecto() {
		setTitle("Tienda 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		
		menuTienda = new JMenuBar();
		setJMenuBar(menuTienda);
		
		mnArchivo = new JMenu("Archivo");
		menuTienda.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuTienda.add(mnMantenimiento);
		
		mntmConsultarDisco = new JMenuItem("Consultar Disco Duro");
		mntmConsultarDisco.addActionListener(this);
		mnMantenimiento.add(mntmConsultarDisco);
		
		mntmModificarDisco = new JMenuItem("Modificar Disco Duro");
		mntmModificarDisco.addActionListener(this);
		mnMantenimiento.add(mntmModificarDisco);
		
		mntmListarDisco = new JMenuItem("Listar Disco Duro");
		mntmListarDisco.addActionListener(this);
		mnMantenimiento.add(mntmListarDisco);
		
		mnVentas = new JMenu("Ventas");
		menuTienda.add(mnVentas);
		
		mntmVender = new JMenuItem("Vender");
		mntmVender.addActionListener(this);
		mnVentas.add(mntmVender);
		
		mntmGenerarReportes = new JMenuItem("Generar Reportes");
		mntmGenerarReportes.addActionListener(this);
		mnVentas.add(mntmGenerarReportes);
		
		mnConfiguracion = new JMenu("Configuraci\u00F3n");
		menuTienda.add(mnConfiguracion);
		
		mntmConfigurarDescuentos = new JMenuItem("Configurar Descuentos");
		mntmConfigurarDescuentos.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarDescuentos);
		
		mntmConfigurarObsequio = new JMenuItem("Configurar Obsequio");
		mntmConfigurarObsequio.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarObsequio);
		
		mntmCantidadOptima = new JMenuItem("Cantidad \u00D3ptima");
		mntmCantidadOptima.addActionListener(this);
		mnConfiguracion.add(mntmCantidadOptima);
		
		mntmCuotaDiaria = new JMenuItem("Cuota Diaria");
		mntmCuotaDiaria.addActionListener(this);
		mnConfiguracion.add(mntmCuotaDiaria);
		
		mnAyuda = new JMenu("Ayuda");
		menuTienda.add(mnAyuda);
		
		mntmAcercaDeLaTienda = new JMenuItem("Acerca de Tienda");
		mntmAcercaDeLaTienda.addActionListener(this);
		mnAyuda.add(mntmAcercaDeLaTienda);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmCuotaDiaria) {
			actionPerformedMntmCuotaDiaria(e);
		}
		if (e.getSource() == mntmCantidadOptima) {
			actionPerformedMntmCantidadOptima(e);
		}
		if (e.getSource() == mntmConfigurarObsequio) {
			actionPerformedMntmConfigurarObsequio(e);
		}
		if (e.getSource() == mntmConfigurarDescuentos) {
			actionPerformedMntmConfigurarDescuentos(e);
		}
		if (e.getSource() == mntmGenerarReportes) {
			actionPerformedMntmGenerarReportes(e);
		}
		if (e.getSource() == mntmVender) {
			actionPerformedMntmVender(e);
		}
		if (e.getSource() == mntmListarDisco) {
			actionPerformedMntmListarDisco(e);
		}
		if (e.getSource() == mntmModificarDisco) {
			actionPerformedMntmModificarDisco(e);
		}
		if (e.getSource() == mntmConsultarDisco) {
			actionPerformedMntmConsultarDisco(e);
		}
		if (e.getSource() == mntmAcercaDeLaTienda) {
			actionPerformedMntmAcercaDeLaTienda(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
	}
	
	// Men? Archivo > Salir
	protected void actionPerformedMntmSalir(ActionEvent e) {
		dispose();
	}	

	// Men? Mantenimiento > Consultar Disco Duro
	protected void actionPerformedMntmConsultarDisco(ActionEvent e) {
		DialogoConsultarDisco cdd = new DialogoConsultarDisco();
		cdd.setLocationRelativeTo(this);
		cdd.setVisible(true);
	}
	
	// Men? Mantenimiento > Listar Disco Duro
	protected void actionPerformedMntmListarDisco(ActionEvent e) {
		DialogoListarDisco ldd = new DialogoListarDisco();
		ldd.setLocationRelativeTo(this);
		ldd.setVisible(true);
	}	
	
	// Men? Mantenimiento > Modificar Disco Duro
	protected void actionPerformedMntmModificarDisco(ActionEvent e) {
		DialogoModificarDisco mdd = new DialogoModificarDisco();
		mdd.setLocationRelativeTo(this);
		mdd.setVisible(true);
	}	
	
	// Men? Ventas > Vender
	protected void actionPerformedMntmVender(ActionEvent e) {
		DialogoVender ven = new DialogoVender();
		ven.setLocationRelativeTo(this);
		ven.setVisible(true);
	}	
	
		
	// Men? Ventas > Generar Reportes
	protected void actionPerformedMntmGenerarReportes(ActionEvent e) {
		DialogoGenerarReportes grv = new DialogoGenerarReportes();
		grv.setLocationRelativeTo(this);
		grv.setVisible(true);
	}	
	
	// Men? Configuraraci?n > Configurar Descuentos
	protected void actionPerformedMntmConfigurarDescuentos(ActionEvent e) {
		DialogoConfigurarDescuentos cdt = new DialogoConfigurarDescuentos();
		cdt.setLocationRelativeTo(this);
		cdt.setVisible(true);
	}	
	
	// Men? Configuraci?n > Configurar Obsequios
	protected void actionPerformedMntmConfigurarObsequio(ActionEvent e) {
		DialogoConfigurarObsequios cob = new DialogoConfigurarObsequios();
		cob.setLocationRelativeTo(this);
		cob.setVisible(true);
	}	
	
	// Men? Configuraci?n > Configurar Cantidad ?ptima
	protected void actionPerformedMntmCantidadOptima(ActionEvent e) {
		DialogoConfigurarCantidadOptima cco = new DialogoConfigurarCantidadOptima();
		cco.setLocationRelativeTo(this);
		cco.setVisible(true);
	}	
	
	// Men? Configuraci?n > Configurar Cuota Diaria
	protected void actionPerformedMntmCuotaDiaria(ActionEvent e) {
		DialogoConfigurarCuotaDiaria ccd = new DialogoConfigurarCuotaDiaria();
		ccd.setLocationRelativeTo(this);
		ccd.setVisible(true);
	}	
	
	// Men? Ayuda > Acerca de la Tienda
	protected void actionPerformedMntmAcercaDeLaTienda(ActionEvent e) {
		DialogoAcercaTienda dat = new DialogoAcercaTienda();
		dat.setLocationRelativeTo(this);
		dat.setVisible(true);
	}








}

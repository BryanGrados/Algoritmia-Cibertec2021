package guisVentas;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import guis.Proyecto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DialogoVender extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblModelo;
	private JComboBox cboModelo;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JButton btnVender;
	private JButton btnCerrar;
	private JScrollPane scrollPane;
	private JTextArea txtS;

	
	private double aPagar;
	
	
	public static int
	          
	        cantidadVentasModelo0 = 0,
            cantidadVentasModelo1 = 0,
            cantidadVentasModelo2 = 0,
            cantidadVentasModelo3 = 0,
            cantidadVentasModelo4 = 0,
    
            discosVendidosModelo0 = 0,
    		discosVendidosModelo1 = 0,
			discosVendidosModelo2 = 0,
			discosVendidosModelo3 = 0,
			discosVendidosModelo4 = 0;
	
	
	public static double         		
			impAcumuladoModelo0 = 0.0,
			impAcumuladoModelo1 = 0.0,
			impAcumuladoModelo2 = 0.0,
			impAcumuladoModelo3 = 0.0,
			impAcumuladoModelo4 = 0.0;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoVender dialog = new DialogoVender();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoVender() {
		setTitle("Vender");
		setBounds(100, 100, 500, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 11, 65, 14);
		contentPanel.add(lblModelo);
		
		cboModelo = new JComboBox();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"Western Digital My Cloud Home 6TB", "Western Digital Elements 4TB", "Toshiba Canvio Basics 4TB", "Seagate Expansion 4TB", "Seagate Backup Plus Hub 10TB"}));
		cboModelo.setBounds(85, 7, 241, 22);
		contentPanel.add(cboModelo);
		
		lblPrecio = new JLabel("Precio (S/.)");
		lblPrecio.setBounds(10, 43, 65, 14);
		contentPanel.add(lblPrecio);
		
		txtPrecio = new JTextField(Proyecto.precio0 + "");
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(85, 40, 241, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 68, 65, 14);
		contentPanel.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(85, 71, 241, 20);
		contentPanel.add(txtCantidad);
		
		btnVender = new JButton("Vender");
		btnVender.addActionListener(this);
		btnVender.setBounds(385, 7, 89, 23);
		contentPanel.add(btnVender);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(385, 39, 89, 23);
		contentPanel.add(btnCerrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 109, 464, 241);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrollPane.setViewportView(txtS);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboModelo) {
			actionPerformedCboModelo(e);
		}
		if (e.getSource() == btnVender) {
			actionPerformedBtnVender(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}

private int contador = 1;
private int acumuladorVentas = 1;
private double porcentaje = 0;
    
	protected void actionPerformedBtnVender(ActionEvent e) {
	    //Variables
		int obsequio, cantidad;
	    double precio, importeCompra, descuento;
	    String modelo;
	    
	    cantidad = leerCantidad();
	    
	    //Selección
	    switch (cboModelo.getSelectedIndex()) {
	    case 0:
	        modelo = Proyecto.modelo0;
	        precio = Proyecto.precio0;
	        importeCompra = precio * cantidad;
	        break;
	    case 1:
	        modelo = Proyecto.modelo1;
	        precio = Proyecto.precio1;
	        importeCompra = precio * cantidad;
	        break;
	    case 2:
	        modelo = Proyecto.modelo2;
	        precio = Proyecto.precio2;
	        importeCompra = precio * cantidad;
	        break;
	    case 3:
	        modelo = Proyecto.modelo3;
	        precio = Proyecto.precio3;
	        importeCompra = precio * cantidad;
	        break;
	    default:
	        modelo = Proyecto.modelo4;
	        precio = Proyecto.precio4;
	        importeCompra = precio * cantidad;
	    }
	
	    //Procesos
		descuento = calcularDescuento(cantidad, importeCompra);
	    aPagar = calcularImpCompra(importeCompra, descuento);
	    obsequio = calcularObsequios(cantidad);
	    calcularImpTotalGeneral(cantidad);
	    
	    //Resultados
	    imprimirResultados(modelo, precio, cantidad, importeCompra, descuento, obsequio);
	    	
	}
	
	
	
  double calcularDescuento(int can, double impCompra) {
	   
	double des;
	
	//Descuento
    if (can <= 5)
        des = Proyecto.porcentaje1/100 * impCompra;
    else
        if (can <= 10)
            des = Proyecto.porcentaje2/100 * impCompra;
        else
            if (can <= 15)
                des = Proyecto.porcentaje3/100 * impCompra;
            else
                des = Proyecto.porcentaje4/100 * impCompra;
    	
    return des;

 }	   
	
	
  double calcularImpCompra(double impCompra, double des) { 
	    
		double aPag;
		
		//A pagar
    return aPag = impCompra - des;
  }
	
  int calcularObsequios(int can) {
   
	int obs;
	
	//Obsequios
    if (can <= 5)
        obs = Proyecto.obsequioCantidad1 * can;
    else
        if (can <= 10)
            obs = Proyecto.obsequioCantidad2 * can;
            else
                obs = Proyecto.obsequioCantidad3 * can;	
    
    return obs;
  }
	
  void calcularImpTotalGeneral(int can) {
	  
    //Alerta > ImporteTotalGeneral Acumulado
	switch (cboModelo.getSelectedIndex()) {
	case 0:
		cantidadVentasModelo0 ++;
		discosVendidosModelo0 += can;
		impAcumuladoModelo0 += aPagar;
		break;
	case 1:
		cantidadVentasModelo1 ++;
		discosVendidosModelo1 += can;
		impAcumuladoModelo1 += aPagar;
		break;
	case 2:
		cantidadVentasModelo2 ++;
		discosVendidosModelo2 += can;
		impAcumuladoModelo2 += aPagar;
		break;
	case 3:
		cantidadVentasModelo3 ++;
		discosVendidosModelo3 += can;
		impAcumuladoModelo3 += aPagar;
		break;
	default:
		cantidadVentasModelo4 ++;
		discosVendidosModelo4 += can;
		impAcumuladoModelo4 += aPagar;
}        
    
	double importeAcumuladoGeneral = 
			impAcumuladoModelo0 +
            impAcumuladoModelo1 +
            impAcumuladoModelo2 +
            impAcumuladoModelo3 +
            impAcumuladoModelo4;

    //Alerta > Porcentaje
    porcentaje = ((importeAcumuladoGeneral*100)/Proyecto.cuotaDiaria);
	
	
	//Alerta > Contador
    
    if (contador != 5 ) {
        	contador ++;
    		acumuladorVentas ++;
    }
    else  {
        mensaje("Venta Nro. " + acumuladorVentas + "\n" + "Importe total general acumulado: "  + Math.round(importeAcumuladoGeneral*100.0)/100.0 + "\n" + "Porcentaje de la cuota diara: " + Math.round(porcentaje*100.0)/100.0 + "%");
        contador = 0;
    }
 }
	
  void imprimirResultados(String mod, double pre, int can, double impCompra, double des, int obs) {
		//Imprimir
	    txtS.setText("");
	    imprimir("BOLETA DE VENTA" + "\n");
	    imprimir("Modelo               : " + mod);
	    imprimir("Precio               : S/. " + pre);
	    imprimir("Cantidad Adquirida   : " + can);
	    imprimir("Importe Compra       : S/. " + impCompra);
	    imprimir("Importe Descuento    : S/. " + des);
	    imprimir("Importe Pagar        : S/. " + aPagar);
	    imprimir("Tipo Obsequio        : " + Proyecto.tipoObsequio);
	    imprimir("Unidades obsequiadas : " + obs);

  }
  
  
  protected void actionPerformedBtnCerrar(ActionEvent e) {
    dispose();
  }
	
  protected void actionPerformedCboModelo(ActionEvent e) {
    int posModelo = cboModelo.getSelectedIndex();
    switch (posModelo) {
    case 0:
        txtPrecio.setText(Proyecto.precio0 + "");
        break;
    case 1:
        txtPrecio.setText(Proyecto.precio1 + "");
        break;
    case 2:
        txtPrecio.setText(Proyecto.precio2 + "");
        break;
    case 3:
        txtPrecio.setText(Proyecto.precio3 + "");
        break;
    default:
        txtPrecio.setText(Proyecto.precio4 + "");
    }
  }    
	    
  void imprimir(String s) {
    txtS.append(s + "\n");
  }
	
  int leerCantidad() {
    return Integer.parseInt(txtCantidad.getText());
  }
	
  void mensaje(String s) {
    JOptionPane.showMessageDialog(this, s, "Tienda", 1);
  }
	
}

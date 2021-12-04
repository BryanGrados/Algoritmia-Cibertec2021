package guisVentas;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import guis.Proyecto;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.awt.event.ActionEvent;

public class DialogoGenerarReportes extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnCerrar;
	private JComboBox cboReportes;
	private JScrollPane scrollPane;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoGenerarReportes dialog = new DialogoGenerarReportes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoGenerarReportes() {
		setTitle("Generar Reportes");
		setBounds(100, 100, 600, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lbltipoReporte = new JLabel("Tipo de Reporte");
			lbltipoReporte.setBounds(10, 15, 102, 14);
			contentPanel.add(lbltipoReporte);
		}
		{
			cboReportes = new JComboBox();
			cboReportes.addActionListener(this);
			cboReportes.setModel(new DefaultComboBoxModel(new String[] {"Ventas por modelo", "Raz\u00F3n de precios en relaci\u00F3n al precio mayor", "Estad\u00EDstica sobre la cantidad \u00F3ptima", "Estad\u00EDstica sobre el precio"}));
			cboReportes.setBounds(108, 11, 261, 22);
			contentPanel.add(cboReportes);
		}
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(485, 11, 89, 23);
			contentPanel.add(btnCerrar);
		}
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 564, 193);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrollPane.setViewportView(txtS);
		
		
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboReportes) {
			actionPerformedCboReportes(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	
	
	protected void actionPerformedCboReportes(ActionEvent e) {
		txtS.setText("");
		switch (cboReportes.getSelectedIndex()) {
			case 0:
				ventaPorModelo(); break;
			case 1:
				razonesPrecios(); break;
			case 2:
				cantidadOptima(); break;
			default:
				promedios();
		}
	}
	
void ventaPorModelo() {
//Variables	

double aporteModelo0 = ((DialogoVender.impAcumuladoModelo0*100)/Proyecto.cuotaDiaria);
double aporteModelo1 = ((DialogoVender.impAcumuladoModelo1*100)/Proyecto.cuotaDiaria);
double aporteModelo2 = ((DialogoVender.impAcumuladoModelo2*100)/Proyecto.cuotaDiaria);
double aporteModelo3 = ((DialogoVender.impAcumuladoModelo3*100)/Proyecto.cuotaDiaria);
double aporteModelo4 = ((DialogoVender.impAcumuladoModelo4*100)/Proyecto.cuotaDiaria);

//Impresión
		imprimir("VENTAS POR MODELO");
		imprimir("");
		imprimir("Modelo                        : " + Proyecto.modelo0);
		imprimir("Cantidad de ventas            : " + DialogoVender.cantidadVentasModelo0);
		imprimir("Cantidad de unidades vendidas : " + DialogoVender.discosVendidosModelo0);
		imprimir("Importe total vendido         : S/." + DialogoVender.impAcumuladoModelo0);
		imprimir("Aporte a la cuota diaria      : " + Math.round(aporteModelo0*100.0)/100.0 + "%");
		imprimir("");
		imprimir("Modelo                        : " + Proyecto.modelo1);
		imprimir("Cantidad de ventas            : " + DialogoVender.cantidadVentasModelo1);
		imprimir("Cantidad de unidades vendidas : " + DialogoVender.discosVendidosModelo1);
		imprimir("Importe total vendido         : S/." + DialogoVender.impAcumuladoModelo1);		
		imprimir("Aporte a la cuota diaria      : " + Math.round(aporteModelo1*100.0)/100.0 + "%");
		imprimir("");
		imprimir("Modelo                        : " + Proyecto.modelo2);
		imprimir("Cantidad de ventas            : " + DialogoVender.cantidadVentasModelo2);
		imprimir("Cantidad de unidades vendidas : " + DialogoVender.discosVendidosModelo2);
		imprimir("Importe total vendido         : S/." + DialogoVender.impAcumuladoModelo2);
		imprimir("Aporte a la cuota diaria      : " + Math.round(aporteModelo2*100.0)/100.0 + "%");
		imprimir("");
		imprimir("Modelo                        : " + Proyecto.modelo3);
		imprimir("Cantidad de ventas            : " + DialogoVender.cantidadVentasModelo3);
		imprimir("Cantidad de unidades vendidas : " + DialogoVender.discosVendidosModelo3);
		imprimir("Importe total vendido         : S/." + DialogoVender.impAcumuladoModelo3);
		imprimir("Aporte a la cuota diaria      : " + Math.round(aporteModelo3*100.0)/100.0 + "%");
		imprimir("");
		imprimir("Modelo                        : " + Proyecto.modelo4);
		imprimir("Cantidad de ventas            : " + DialogoVender.cantidadVentasModelo4);
		imprimir("Cantidad de unidades vendidas : " + DialogoVender.discosVendidosModelo4);
		imprimir("Importe total vendido         : S/." + Math.round(DialogoVender.impAcumuladoModelo4*100.0)/100.0);
		imprimir("Aporte a la cuota diaria      : " + Math.round(aporteModelo4*100.0)/100.0 + "%");
		imprimir("");
	}
//---
void razonesPrecios() {
	
	double precioMayor;
	
	precioMayor = calcularMaximo(Proyecto.precio0, Proyecto.precio1, Proyecto.precio2, Proyecto.precio3, Proyecto.precio4);
	
	
	double razonModelo0 = ((Proyecto.precio0/precioMayor) * 1);
	double razonModelo1 = ((Proyecto.precio1/precioMayor) * 1);
	double razonModelo2 = ((Proyecto.precio2/precioMayor) * 1);			
	double razonModelo3 = ((Proyecto.precio3/precioMayor) * 1);
	double razonModelo4 = ((Proyecto.precio4/precioMayor) * 1);	
	
	BigDecimal bd0 = new BigDecimal(razonModelo0).setScale(2, RoundingMode.DOWN);
	double razonMod0 = bd0.doubleValue();
	BigDecimal bd1 = new BigDecimal(razonModelo1).setScale(2, RoundingMode.DOWN);
	double razonMod1 = bd1.doubleValue();
	BigDecimal bd2 = new BigDecimal(razonModelo2).setScale(2, RoundingMode.DOWN);
	double razonMod2 = bd2.doubleValue();
	BigDecimal bd3 = new BigDecimal(razonModelo3).setScale(2, RoundingMode.DOWN);
	double razonMod3 = bd3.doubleValue();
	BigDecimal bd4 = new BigDecimal(razonModelo4).setScale(2, RoundingMode.DOWN);
	double razonMod4 = bd4.doubleValue();
	
	imprimir("RAZÓN DE PRECIOS EN RELACIÓN AL PRECIO MAYOR");
	imprimir("");
	imprimir("Modelo : " + Proyecto.modelo0);
	imprimir("Precio : " + Proyecto.precio0);
	imprimir("Razón  : " + razonMod0);
	imprimir("");
	imprimir("Modelo : " + Proyecto.modelo1);
	imprimir("Precio : " + Proyecto.precio1);
	imprimir("Razón  : " + razonMod1);
	imprimir("");
	imprimir("Modelo : " + Proyecto.modelo2);
	imprimir("Precio : " + Proyecto.precio2);
	imprimir("Razón  : " + razonMod2);
	imprimir("");
	imprimir("Modelo : " + Proyecto.modelo3);
	imprimir("Precio : " + Proyecto.precio3);
	imprimir("Razón  : " + razonMod3);
	imprimir("");
	imprimir("Modelo : " + Proyecto.modelo4);
	imprimir("Precio : " + Proyecto.precio4);
	imprimir("Razón  : " + razonMod4);
}

//---
private int superoCantidad = 0;
private int igualoCantidad = 0;
private int menorCantidad = 0;

void validarVentas (int unidadesVendidas) {
	
	if(unidadesVendidas == Proyecto.cantidadOptima) 
		igualoCantidad ++;
	else 
		if(unidadesVendidas >= Proyecto.cantidadOptima) 
			superoCantidad ++;
		else 
			menorCantidad++;
}

void ReinicioContador() {
	superoCantidad = 0;
	igualoCantidad = 0;
	menorCantidad = 0;
}

void cantidadOptima () {
	ReinicioContador();
	validarVentas(DialogoVender.discosVendidosModelo0);
	validarVentas(DialogoVender.discosVendidosModelo1);
	validarVentas(DialogoVender.discosVendidosModelo2);
	validarVentas(DialogoVender.discosVendidosModelo3);
	validarVentas(DialogoVender.discosVendidosModelo4);

	
	imprimir("ESTADÍSTICA SOBRE LA CANTIDAD ÓPTIMA");
	imprimir("");
	imprimir("Cantidad de modelos que superaron la cantidad óptima    : " + superoCantidad);
	imprimir("Cantidad de modelos que no superaron la cantidad óptima : " + menorCantidad);
	imprimir("Cantidad de modelos que igualaron la cantidad óptima    : " + igualoCantidad);
	
	}

//-----
void promedios () {
	double precioPromedio, precioMinimo, precioMaximo;
	
	precioPromedio = calcularPromedio(Proyecto.precio0, Proyecto.precio1, Proyecto.precio2, Proyecto.precio3, Proyecto.precio4);
	precioMaximo = calcularMaximo(Proyecto.precio0, Proyecto.precio1, Proyecto.precio2, Proyecto.precio3, Proyecto.precio4);
	precioMinimo = calcularMinimo(Proyecto.precio0, Proyecto.precio1, Proyecto.precio2, Proyecto.precio3, Proyecto.precio4);
	
	imprimir("ESTADÍSTICA SOBRE EL PRECIO");
	imprimir("");
	imprimir("Precio promedio : S/. " + precioPromedio);
	imprimir("Precio mayor    : S/. " + precioMaximo);
	imprimir("Precio menor    : S/. " + precioMinimo);
	
}

double calcularPromedio(double a, double b, double c, double d, double e) {
	return (a + b + c + d + e) / 5;
}

double calcularMinimo (double a, double b, double c, double d, double e) {
	double minimo = a;
	
	if (minimo > b)
		minimo = b;
	if (minimo > c)
		minimo = c;
	if (minimo > d)
		minimo = d;
	if (minimo > e)
		minimo = e;
	
	return minimo;
}

double calcularMaximo (double a, double b, double c, double d, double e) {
	double maximo = a;
	
	if (maximo < b)
		maximo = b;
	if (maximo < c)
		maximo = c;
	if (maximo < d)
		maximo = d;
	if (maximo < e)
		maximo = e;
	
	return maximo;
}
//---
	void imprimir(String s) {
		txtS.append(s + "\n");
	}	
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}

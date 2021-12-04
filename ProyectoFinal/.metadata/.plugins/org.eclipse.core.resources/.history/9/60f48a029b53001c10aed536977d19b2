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

public class DialogoConfigurarCuotaDiaria extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCuotaDiaria;
	private JButton btnCancelar;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoConfigurarCuotaDiaria dialog = new DialogoConfigurarCuotaDiaria();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoConfigurarCuotaDiaria() {
		setTitle("Configurar | Cuota Diaria");
		setBounds(100, 100, 450, 105);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblCuotaDiaria = new JLabel("Cuota diaria esperada (S/.)");
			lblCuotaDiaria.setBounds(10, 11, 160, 14);
			contentPanel.add(lblCuotaDiaria);
		}
		{
			txtCuotaDiaria = new JTextField(Proyecto.cuotaDiaria + "");
			txtCuotaDiaria.setBounds(180, 8, 86, 20);
			contentPanel.add(txtCuotaDiaria);
			txtCuotaDiaria.setColumns(10);
		}
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(this);
			btnAceptar.setBounds(335, 7, 89, 23);
			contentPanel.add(btnAceptar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(335, 35, 89, 23);
			contentPanel.add(btnCancelar);
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
		double ctDiaria = leerNum(txtCuotaDiaria);
		
		
		Proyecto.cuotaDiaria = ctDiaria;	
		
		dispose();
		
		
		
	}
	catch (Exception x) {
		validacion("valor" , txtCuotaDiaria);
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

	
double leerNum(JTextField txt) {
	return Double.parseDouble(txt.getText());
}	
	
	
}

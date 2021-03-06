package guisAyuda;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class DialogoAcercaTienda extends JDialog implements ActionListener {
	

	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoAcercaTienda dialog = new DialogoAcercaTienda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoAcercaTienda() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		{
			JLabel lblTienda = new JLabel("Tienda 1.0");
			lblTienda.setFont(new Font("Tahoma", Font.BOLD, 23));
			lblTienda.setBounds(161, 11, 129, 36);
			getContentPane().add(lblTienda);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 58, 414, 2);
			getContentPane().add(separator);
		}
		{
			JLabel lblAutores = new JLabel("Autores");
			lblAutores.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblAutores.setBounds(194, 71, 53, 14);
			getContentPane().add(lblAutores);
		}
		{
			JLabel lblBryanGrados = new JLabel("Bryan Grados");
			lblBryanGrados.setHorizontalAlignment(SwingConstants.CENTER);
			lblBryanGrados.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblBryanGrados.setBounds(182, 112, 81, 14);
			getContentPane().add(lblBryanGrados);
		}
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(174, 227, 89, 23);
			getContentPane().add(btnCerrar);
		}
		
		JLabel lblJhanTeran = new JLabel("Jhan Teran ");
		lblJhanTeran.setHorizontalAlignment(SwingConstants.CENTER);
		lblJhanTeran.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblJhanTeran.setBounds(182, 137, 81, 14);
		getContentPane().add(lblJhanTeran);
		
		JLabel lblSebastinEspinoza = new JLabel("Sebasti\u00E1n Espinoza");
		lblSebastinEspinoza.setHorizontalAlignment(SwingConstants.CENTER);
		lblSebastinEspinoza.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSebastinEspinoza.setBounds(161, 162, 129, 14);
		getContentPane().add(lblSebastinEspinoza);
		
		JLabel lblGustavoRomero = new JLabel("Gustavo Romero");
		lblGustavoRomero.setHorizontalAlignment(SwingConstants.CENTER);
		lblGustavoRomero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGustavoRomero.setBounds(161, 187, 129, 14);
		getContentPane().add(lblGustavoRomero);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		dispose();
	}
}

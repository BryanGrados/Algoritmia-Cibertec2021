package semana_15;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Font;

public class DoWhile extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JButton btnA;
	private JButton btnB;
	private JButton btnC;
	private JButton btnD;
	private JButton btnE;
	private JButton btnF;
	private JScrollPane scpScroll;
	private JTextArea txtS;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoWhile frame = new DoWhile();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DoWhile() {
		setTitle("Estructura de repeti?n: do while");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 400);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnA = new JButton("A");
		btnA.addActionListener(this);
		btnA.setBounds(10, 10, 89, 23);
		contentPane.add(btnA);

		btnB = new JButton("B");
		btnB.addActionListener(this);
		btnB.setBounds(100, 10, 89, 23);
		contentPane.add(btnB);

		btnC = new JButton("C");
		btnC.addActionListener(this);
		btnC.setBounds(190, 10, 89, 23);
		contentPane.add(btnC);

		btnD = new JButton("D");
		btnD.addActionListener(this);
		btnD.setBounds(280, 10, 89, 23);
		contentPane.add(btnD);
	
		btnE = new JButton("E");
		btnE.addActionListener(this);
		btnE.setBounds(370, 10, 89, 23);
		contentPane.add(btnE);

		btnF = new JButton("F");
		btnF.addActionListener(this);
		btnF.setBounds(460, 10, 89, 23);
		contentPane.add(btnF);
		
		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 40, 539, 310);
		contentPane.add(scpScroll);

		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 12));
		scpScroll.setViewportView(txtS);
	}

	public void actionPerformed(ActionEvent arg0) {
		txtS.setText("");
		if (arg0.getSource() == btnF) {
			actionPerformedBtnF(arg0);
		}
		if (arg0.getSource() == btnE) {
			actionPerformedBtnE(arg0);
		}
		if (arg0.getSource() == btnD) {
			actionPerformedBtnD(arg0);
		}
		if (arg0.getSource() == btnC) {
			actionPerformedBtnC(arg0);
		}
		if (arg0.getSource() == btnB) {
			actionPerformedBtnB(arg0);
		}
		if (arg0.getSource() == btnA) {
			actionPerformedBtnA(arg0);
		}
	}
	
	//  Procesa la pulsaci?n del bot?n A
	protected void actionPerformedBtnA(ActionEvent arg0) {
		/**
			Simule el lanzamiento de un dado una y otra vez
			hasta obtener el puntaje m?ximo.
		 */
		int dado;
		
		do {
			dado = aleatorio(1, 6);
			imprimir("dado = " + dado);
		} while (dado < 6);
	}
	//  Procesa la pulsaci?n del bot?n B
	protected void actionPerformedBtnB(ActionEvent arg0) {
		/**
		    Genere una y otra vez n?meros naturales de dos
		    d?gitos hasta obtener un n?mero menor a 20.
		    Muestre la suma de los n?meros.
	     */
		int numero, suma = 0;
		
		do {
			numero = aleatorio(10, 99);
			imprimir("n?mero = " + numero);
			suma += numero;
		} while (numero >= 20);
		imprimir("La suma de los dos n?meros es : " + suma);
	}
	//  Procesa la pulsaci?n del bot?n C
	protected void actionPerformedBtnC(ActionEvent arg0) {
		/**
			Simule el lanzamiento de dos dados una y otra vez
			hasta obtener el puntaje m?ximo en ambos dados.
			Mostrar adem?s la cantidad de intentos
		 */
		int dadoA, dadoB, intentos = 0;
		
		do {
			dadoA = aleatorio(1, 6);
			dadoB = aleatorio(1, 6);
			imprimir("dadoA = " + dadoA + "\t" + "dadoB = " + dadoB);
			intentos ++;
		} /*while (dadoA < 6 || dadoB < 6)*/ while (dadoA + dadoB < 12);
		imprimir("");
		imprimir("Logr? obtener el puntaje m?ximo en " + intentos + " intentos");
	}
	//  Procesa la pulsaci?n del bot?n D
	protected void actionPerformedBtnD(ActionEvent arg0) {
		/**
		   Simule el lanzamiento de dos dados una y otra vez
		   hasta obtener 1 en el primer dado y 6 en el segundo.
	     */

		int dadoA, dadoB;
		
		do {
			dadoA = aleatorio(1, 6);
			dadoB = aleatorio(1, 6);
			imprimir("dadoA = " + dadoA + "\t" + "dadoB = " + dadoB);
		} while (!(dadoA == 1 && dadoB == 6));
	}
	//  Procesa la pulsaci?n del bot?n E
	protected void actionPerformedBtnE(ActionEvent arg0) {
		/**
			Genere una y otra vez n?meros naturales de tres
		    d?gitos hasta obtener un n?mero par mayor a 300
		    pero menor o igual a 400.
		 */
		int numero;
		
		do {
			numero = aleatorio(1, 999);
			imprimir("n?mero = " + numero);
		} while (!(numero % 2 == 0 && numero > 300 && numero <= 400));
	}
	//  Procesa la pulsaci?n del bot?n F
	protected void actionPerformedBtnF(ActionEvent arg0) {
		/**
		    Genere una y otra vez n?meros naturales de dos
		    d?gitos hasta obtener un n?mero m?ltiplo de 3
		    mayor o igual a 20 pero menor a 40.
	     */
		int numero;
		
		do {
			numero = aleatorio(10, 99);
			imprimir("n?mero = " + numero);
		} while (!(numero % 3 == 0 && numero >= 20 && numero < 40));
	}
	//  M?todos tipo void (con par?metros)
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
	//  M?todos que retornan valor (con par?metros)
	int aleatorio(int min, int max) {
		return (int)((max - min + 1)*Math.random()) + min;
	}
	
}
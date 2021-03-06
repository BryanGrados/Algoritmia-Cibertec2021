package semana_14;

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

public class For extends JFrame implements ActionListener {

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
					For frame = new For();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public For() {
		setTitle("Estructura de repeti?n: for");
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
			Genere 15 n?meros naturales al azar de dos d?gitos.
		    Muestre la suma de los n?meros.
		 */
		int numero, suma = 0;
		for (int i=1; i<=15; i++) {
			numero = aleatorio(10, 99);
			imprimir(i + ")" + "\t" + "numero = " + numero);
			suma += numero;
		}
		imprimir("");
		imprimir("La suma de los n?meros es : " + suma);
		
	}
	//  Procesa la pulsaci?n del bot?n B
	protected void actionPerformedBtnB(ActionEvent arg0) {
		/**
		    Simule 20 veces el lanzamiento de dos dados.
		    Muestre el puntaje acumulado por cada uno.
	     */
		int dadoA, dadoB, sumaA = 0, sumaB = 0;
		for (int i=1; i<=20; i++) {
			dadoA = aleatorio(1, 6);
			dadoB = aleatorio(1, 6);
			imprimir(i + ")" + "\t" + "dadoA = " + dadoA + "\t" + "dadoB = " + dadoB);
			sumaA += dadoA;
			sumaB += dadoB;
		}
		imprimir("");
		imprimir("Puntaje de los dados: " + "\n\n" + "dadoA = " + sumaA + "\n" + "dadoB = " + sumaB);
	}
	//  Procesa la pulsaci?n del bot?n C
	protected void actionPerformedBtnC(ActionEvent arg0) {
		/**
			Muestre y sume los 30 primeros t?rminos de la serie:
			5  10  15  20  25  . . .
		 */
		int serie = 5, suma = 0;
		for (int i=1; i<=30; i++) {
			imprimir(i + ")" + "\t" + "serie = " + serie);
			suma += serie;
			serie += 5;
		}
		imprimir("");
		imprimir("La suma de los n?meros es : " + suma);
	}
	//  Procesa la pulsaci?n del bot?n D
	protected void actionPerformedBtnD(ActionEvent arg0) {
		/**
		   Muestre y sume los 25 primeros t?rminos de la serie:
			2/3  5/7  8/11  11/15  14/19  . . .
	     */
		int num = 2, den = 3;
		double serie, suma = 0;
		for (int i=1; i<=25; i++) {
			imprimir(i +")" + "\t" + num + "/" + den);
			serie = num*1.0/den;
			suma += serie;
			num += 3;
			den += 4;
		}
		imprimir("");
		imprimir("La suma de los 25 primeros t?rminos es : " + suma);
	}
	//  Procesa la pulsaci?n del bot?n E
	protected void actionPerformedBtnE(ActionEvent arg0) {
		/**
			Muestre y sume los 30 primeros t?rminos de la serie:
			1/2  3/7  5/12  7/17  9/22  . . .
		 */
		int num = 1, den = 2;
		double serie, suma = 0;
		for (int i=1; i<=30; i++) {
			imprimir(i +")" + "\t" + num + "/" + den);
			serie = num*1.0/den;
			suma += serie;
			num += 2;
			den += 5;
		}
		imprimir("");
		imprimir("La suma de los 30 primeros t?rminos es : " + suma);
	}
	//  Procesa la pulsaci?n del bot?n F
	protected void actionPerformedBtnF(ActionEvent arg0) {
		/**
			Muestre y sume los 30 primeros t?rminos de la serie:
			2/5  -5/7  8/9  -11/11  14/13  . . .
	     */
		
	}
	//  M?todos que retornan valor (con par?metros)
	int aleatorio(int min, int max) {
		return (int)((max - min + 1)*Math.random()) + min;
	}
	//  M?todos tipo void (con par?metros)
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
	
}
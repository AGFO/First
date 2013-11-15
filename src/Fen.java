import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class Fen extends JFrame implements ActionListener {

	private JPanel panel;
	private JMenuBar menu;
	private JMenu menuPdt;
	private JMenuItem consulter;
	private JMenuItem modif;
	private JMenu menuPg;
	private JMenuItem quitter;
	private JPanel panelI;
	
	private JTextField jtfNom;
	private JTextField jtfPrenom;
	private JButton Btn1 ;

	public Fen() {

		this.setTitle("Application");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 300);

		panel = new JPanel();
		
		menu = new JMenuBar();
		menuPdt = new JMenu("Option");
		consulter = new JMenuItem("Consulter");
		modif = new JMenuItem("Inserer");
		quitter = new JMenuItem("Quitter");
		Btn1 = new JButton("Valider");
		
		
		
		
		panelI = new JPanel();
		
		jtfNom = new JTextField(10);
		jtfPrenom = new JTextField(10);

		panelI.add(jtfNom);
		panelI.add(jtfPrenom);
		
		panelI.add(Btn1);

	

		modif.addActionListener(this);
		quitter.addActionListener(this);
		consulter.addActionListener(this);
		Btn1.addActionListener(this);
		menuPdt.add(consulter);
		menu.add(menuPdt);
		menuPdt.add(modif);
		menuPdt.add(quitter);



		this.setJMenuBar(menu);


		this.getContentPane().add(panel);
		
		this.setVisible(true);
		
	}


public void actionPerformed(ActionEvent e) {
	
	if (e.getSource() == Btn1) {

	int test =	m_connect.nvContact(jtfNom.getText(),jtfPrenom.getText(),"");
	if (test == 1) {
		System.out.println(" ook ");
	}
	else 
		System.out.println("  pas ook ");
		
			}
	
	
	if (e.getSource() == modif) {
		this.setContentPane(panelI);
		
		this.setVisible(true);


			}
	else if  ( e.getSource() == quitter){
				System.exit(0);

			}
	if ( e.getSource() == consulter) {
		String [] title = {"nom","prenom"};
		Object [][] donnees = {	{"toto","titi"},{"test","test2"}};
		JTable tableau = new JTable(donnees, title);
		JScrollPane js = new JScrollPane(tableau);
		panelI.add(js);
		this.setContentPane(panelI);
		
		this.setVisible(true);
		
	}

}

}

		
/*	class Exit implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	class Consultation implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
		}
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}*/
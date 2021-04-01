package PT2020.demo.Polinoame1;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import java.awt.Color;


public class View {
	
	private Polynomial model1;
	private Monimial model2;
	private JFrame frame;
	private JPanel panel1;
	private JPanel panel2;
	private JTextField pol1;
	private JTextField pol2;
	private JTextField rez;
	private JComboBox operatie;
	private JLabel l1;
	private JLabel l2;
	private JLabel l3;
	private JLabel l4;
	private JLabel l5;
	private JLabel l6;
	private JButton egal;

	
	public View(Polynomial p, Monimial m) {
		this.setModel1(p);
		this.setModel2(m);
		frame = new JFrame("POLYNOMIALS CALCULATOR");
		frame.setPreferredSize(new Dimension(850, 500));
		frame.setLocation(650, 150);

		panel1 = new JPanel();
		panel2 = new JPanel();

		Color color2 = new Color(247, 202, 201);
		Color color3 = new Color(159, 146, 237);

		panel1.setBackground(color2);
		panel2.setBackground(color2);
		

		SpringLayout slPanel = new SpringLayout();
		panel1.setLayout(slPanel);
		panel2.setLayout(slPanel);
		

		egal = new JButton("=");
		egal.setPreferredSize(new Dimension(80, 30));
		egal.setForeground(color3);
		egal.setFont(new Font("Arial", 1, 20));
		slPanel.putConstraint(SpringLayout.NORTH, egal, 10, SpringLayout.NORTH, panel2);
		slPanel.putConstraint(SpringLayout.WEST, egal, 50, SpringLayout.WEST, panel2);
		panel2.add(egal);

		
		l1 = new JLabel("Primul polinom:");
		l1.setFont(new Font("Arial", 1, 20));
		l1.setSize(new Dimension(0, 50));
		l1.setForeground(color3);
		slPanel.putConstraint(SpringLayout.NORTH, l1, 10, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, l1, 0, SpringLayout.WEST, panel1);
		panel1.add(l1);
		
		l2 = new JLabel("Al doilea polinom:");
		l2.setFont(new Font("Arial", 1, 20));
		l2.setSize(new Dimension(0, 50));
		l2.setForeground(color3);
		slPanel.putConstraint(SpringLayout.NORTH, l2, 150, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, l2, 0, SpringLayout.WEST, panel1);
		panel1.add(l2);
		
		l3 = new JLabel("Rezultat:");
		l3.setFont(new Font("Arial", 1, 20));
		l3.setSize(new Dimension(0, 50));
		l3.setForeground(color3);
		slPanel.putConstraint(SpringLayout.NORTH, l3, 60, SpringLayout.NORTH, panel2);
		slPanel.putConstraint(SpringLayout.WEST, l3, 0, SpringLayout.WEST, panel2);
		panel2.add(l3);
		
		l4 = new JLabel("Polinoamele introduse vor fi de forma: 6x^2+5x^1+3x^0");
		l4.setFont(new Font("Arial", 1, 16));
		l4.setSize(new Dimension(0, 50));
		l4.setForeground(color3);
		slPanel.putConstraint(SpringLayout.NORTH, l4, 180, SpringLayout.NORTH, panel2);
		slPanel.putConstraint(SpringLayout.WEST, l4, 0, SpringLayout.WEST, panel2);
		panel2.add(l4);
		
		l5 = new JLabel("În cazul operațiilor de derivare și integrare, rezultatul afișat va fi pentru primul polinom");
		l5.setFont(new Font("Arial", 1, 16));
		l5.setSize(new Dimension(0, 50));
		l5.setForeground(color3);
		slPanel.putConstraint(SpringLayout.NORTH, l5, 200, SpringLayout.NORTH, panel2);
		slPanel.putConstraint(SpringLayout.WEST, l5, 0, SpringLayout.WEST, panel2);
		panel2.add(l5);
		
		l6 = new JLabel("");
		l6.setFont(new Font("Arial", 1, 27));
		l6.setSize(new Dimension(0, 50));
		l6.setForeground(color3);
		slPanel.putConstraint(SpringLayout.NORTH, l6, 125, SpringLayout.NORTH, panel2);
		slPanel.putConstraint(SpringLayout.WEST, l6, 0, SpringLayout.WEST, panel2);
		panel2.add(l6);

		operatie = new JComboBox(model1.getStringOp());
		operatie.setSize(new Dimension(170,100));
		operatie.setFont(new Font("Arial",1,20));
		operatie.setSelectedIndex(2);
		operatie.setForeground(color3);
		slPanel.putConstraint(SpringLayout.NORTH, operatie, 90, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, operatie, 50, SpringLayout.WEST, panel1);
		panel1.add(operatie);
		
		pol1 = new JTextField(30); 
		pol1.setFont(new Font("Arial",1,20));
		slPanel.putConstraint(SpringLayout.NORTH, pol1, 40, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, pol1, 50, SpringLayout.WEST, panel1);
		panel1.add(pol1);
		
		pol2 = new JTextField(30); 
		pol2.setFont(new Font("Arial",1,20));
		slPanel.putConstraint(SpringLayout.NORTH, pol2, 180, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, pol2, 50, SpringLayout.WEST, panel1);
		panel1.add(pol2);
		
		rez = new JTextField(30); 
		rez.setFont(new Font("Arial",1,20));
		slPanel.putConstraint(SpringLayout.NORTH, rez, 90, SpringLayout.NORTH, panel2);
		slPanel.putConstraint(SpringLayout.WEST, rez, 50, SpringLayout.WEST, panel2);
		panel2.add(rez);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(0, 1));
		mainPanel.add(panel1);
		mainPanel.add(panel2);

		frame.setContentPane(mainPanel);
		frame.setVisible(true);
		frame.pack();
	}
	
	public void egalListener(ActionListener action) {
    	this.egal.addActionListener(action);
    }
	
	public String continutFrom() {
		return (String) this.operatie.getSelectedItem();
	}
	
	public String getPol1() { 
		 return pol1.getText();
	} 
	
	public String getPol2() { 
		 return pol2.getText();
	} 
	
	public void putRez(String s) {
		rez.removeAll();
		rez.setText(s);
		rez.add(rez);
		rez.repaint();
	}
	
	public void putErr(String s) {
		l6.setText(s);
	}

	public JTextField getRez() {
		return rez;
	}


	public String getL6() {
		return l6.getText();
	}

	public void setL6(JLabel l6) {
		this.l6 = l6;
	}

	public Polynomial getModel1() {
		return model1;
	}

	public void setModel1(Polynomial model1) {
		this.model1 = model1;
	}

	public Monimial getModel2() {
		return model2;
	}

	public void setModel2(Monimial model2) {
		this.model2 = model2;
	}

}
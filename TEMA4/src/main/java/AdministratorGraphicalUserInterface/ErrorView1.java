package AdministratorGraphicalUserInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class ErrorView1 {
	private JFrame frame;
	private JPanel panel1;
	private JLabel jlabel;
	
	public ErrorView1() {

		frame = new JFrame("ERROR");
		frame.setPreferredSize(new Dimension(810, 300));
		frame.setLocation(650, 150);
		
		panel1 = new JPanel();
		SpringLayout slPanel = new SpringLayout();
		panel1.setLayout(slPanel);
		
		Color color2 = new Color(0, 176, 178);
		Color color3 = new Color(0, 66, 54);


		panel1.setBackground(color2);

		jlabel = new JLabel("This item already exists!");
		jlabel.setFont(new Font("Arial", 1, 25));
		jlabel.setSize(new Dimension(300, 100));
		slPanel.putConstraint(SpringLayout.NORTH, jlabel, 100, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, jlabel, 230, SpringLayout.WEST, panel1);
		jlabel.setForeground(color3);
		panel1.add(jlabel);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(0, 1));
		mainPanel.add(panel1);

		frame.setContentPane(mainPanel);
		frame.setVisible(true);
		frame.pack();
	}
}

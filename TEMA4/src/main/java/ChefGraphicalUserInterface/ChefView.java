package ChefGraphicalUserInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;


public class ChefView implements Observer {
	private JFrame frame;
	private JPanel panel1;
	private JLabel jlabel;
	private JLabel note;
	
	public ChefView(String s) {

		frame = new JFrame("CHEF");
		frame.setPreferredSize(new Dimension(270, 250));
		frame.setLocation(930, 250);

		panel1 = new JPanel();
		Color color2 = new Color(0, 176, 178);
		Color color3 = new Color(0, 66, 54);

		SpringLayout slPanel = new SpringLayout();
		panel1.setLayout(slPanel);
		panel1.setBackground(color2);

		jlabel = new JLabel("Chef's menu");
		jlabel.setFont(new Font("Arial", 1, 20));
		jlabel.setSize(new Dimension(400, 200));
		slPanel.putConstraint(SpringLayout.NORTH, jlabel, 10, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, jlabel, 65, SpringLayout.WEST, panel1);
		jlabel.setForeground(color3);
		panel1.add(jlabel);
		
		note = new JLabel(s);
		note.setFont(new Font("Arial", 1, 20));
		note.setSize(new Dimension(300, 100));
		slPanel.putConstraint(SpringLayout.NORTH, note, 50, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, note, 50, SpringLayout.WEST, panel1);
		note.setForeground(color3);
		panel1.add(note);	

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(0, 1));
		mainPanel.add(panel1);

		frame.setContentPane(mainPanel);
		frame.setVisible(true);
		frame.pack();
	}

	public void update(Observable o, Object arg) {
		this.setNote((String) arg);
	}
	
	public void setNote(String s) {
		this.note.setText(s);
	}
}


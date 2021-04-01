package PresentationLayer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;


public class MainMenuFrame extends Frame {
	private JButton btnSave;
	private JButton btnWaiter;
	private JButton btnAdministrator;
	public MainMenuFrame(String title) {
		super(title);
		Color color3 = new Color(0, 176, 178);
		Color color2 = new Color(0, 66, 54);

		contentPanel.setLayout(new GridLayout(0, 3, 0, 0));

		JPanel pan = new JPanel();
		contentPanel.add(pan);
		SpringLayout slPanel = new SpringLayout();
		pan.setLayout(slPanel);

		btnSave = new JButton("SAVE");
		btnSave.setBackground(color3);
		btnSave.setForeground(color2);
		btnSave.setPreferredSize(new Dimension(150, 100));
		btnSave.setFont(new Font("Arial", Font.BOLD, 40));
		slPanel.putConstraint(SpringLayout.NORTH, btnSave, 50, SpringLayout.NORTH, pan);
		slPanel.putConstraint(SpringLayout.WEST, btnSave, 93, SpringLayout.WEST, pan);
		pan.add(btnSave);

		btnWaiter = new JButton("WAITER");
		btnWaiter.setBackground(color3);
		btnWaiter.setForeground(color2);
		btnWaiter.setPreferredSize(new Dimension(200, 100));
		btnWaiter.setFont(new Font("Arial", Font.BOLD, 40));
		slPanel.putConstraint(SpringLayout.NORTH, btnWaiter, 650, SpringLayout.NORTH, pan);
		slPanel.putConstraint(SpringLayout.WEST, btnWaiter, 93, SpringLayout.WEST, pan);
		pan.add(btnWaiter);

		btnAdministrator = new JButton("ADMIN");
		btnAdministrator.setBackground(color3);
		btnAdministrator.setForeground(color2);
		btnAdministrator.setPreferredSize(new Dimension(180, 100));
		btnAdministrator.setFont(new Font("Arial", Font.BOLD, 40));
		slPanel.putConstraint(SpringLayout.NORTH, btnAdministrator, 350, SpringLayout.NORTH, pan);
		slPanel.putConstraint(SpringLayout.WEST, btnAdministrator, 93, SpringLayout.WEST, pan);
		pan.add(btnAdministrator);

		JPanel panel_2 = new JPanel();
		contentPanel.add(panel_2);
		setVisible(true);
	}

	public void setSaveButtonActionListener(ActionListener a) {
		btnSave.addActionListener(a);
	}
	
	public void setWaiterButtonActionListener(ActionListener a) {
		btnWaiter.addActionListener(a);
	}

	public void setAdministratorButtonActionListener(ActionListener a) {
		btnAdministrator.addActionListener(a);
	}
}

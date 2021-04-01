package PresentationLayer;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public abstract class Frame extends JFrame {

	protected JPanel contentPanel;
	public Frame(String title) {
		Color color3 = new Color(0, 176, 178);
		setBackground(color3);
		setTitle(title);
		setSize(1000, 1000);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(45, 45, 45, 45));
		contentPanel.setBackground(color3);
		add(contentPanel, BorderLayout.CENTER);
	}
}

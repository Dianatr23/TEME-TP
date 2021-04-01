package WaiterGraphicalUserInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import Start.Start;

public class WaiterView {
	private JFrame frame;
	private JPanel panel1;
	private JLabel jlabel;
	private JTextField menuItems;
	private JLabel menu;
	private JLabel date;
	private JLabel data;
	private JTextField nrTable;
	private JLabel nr;
	private JButton comanda;
	private JLabel price;
	private JTextField pr;
	private JButton pret;
	private JLabel t;
	private JTextField t1;
	private JTable table;
	private Object[][] dataa = {};
	private DefaultTableModel model;

	public WaiterView() {

		frame = new JFrame("WAITER");
		frame.setPreferredSize(new Dimension(1700, 1700));
		frame.setLocation(200, 100);

		panel1 = new JPanel();
		SpringLayout slPanel = new SpringLayout();
		panel1.setLayout(slPanel);
		
		Color color2 = new Color(0, 176, 178);
		Color color3 = new Color(0, 66, 54);


		panel1.setBackground(color2);

		jlabel = new JLabel("Waiter's menu");
		jlabel.setFont(new Font("Arial", 1, 20));
		jlabel.setSize(new Dimension(300, 100));
		jlabel.setForeground(color3);
		slPanel.putConstraint(SpringLayout.NORTH, jlabel, 1, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, jlabel, 300, SpringLayout.WEST, panel1);
		panel1.add(jlabel);
		
		data = new JLabel("Date:");
		data.setFont(new Font("Arial", 1, 20));
		data.setSize(new Dimension(300, 100));
		data.setForeground(color3);
		slPanel.putConstraint(SpringLayout.NORTH, data, 40, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, data, 50, SpringLayout.WEST, panel1);
		panel1.add(data);
		
		menuItems = new JTextField(30);
		menuItems.setFont(new Font("Arial",1,20));
		slPanel.putConstraint(SpringLayout.NORTH, menuItems, 90, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, menuItems, 200, SpringLayout.WEST, panel1);
		panel1.add(menuItems);
		
		
		menu = new JLabel("Menu Items:");
		menu.setFont(new Font("Arial", 1, 20));
		menu.setSize(new Dimension(300, 100));
		menu.setForeground(color3);
		slPanel.putConstraint(SpringLayout.NORTH, menu, 90, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, menu, 50, SpringLayout.WEST, panel1);
		panel1.add(menu);
		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date d = new Date();
		//System.out.println(dateFormat.format(d)); 
		date = new JLabel(dateFormat.format(d)); 
		date.setFont(new Font("Arial",1,20));
		slPanel.putConstraint(SpringLayout.NORTH, date, 40, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, date, 120, SpringLayout.WEST, panel1);
		panel1.add(date);
		
		nr = new JLabel("Table number:");
		nr.setFont(new Font("Arial", 1, 20));
		nr.setSize(new Dimension(300, 100));
		nr.setForeground(color3);
		slPanel.putConstraint(SpringLayout.NORTH, nr, 140, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, nr, 50, SpringLayout.WEST, panel1);
		panel1.add(nr);
		
		nrTable = new JTextField(30);
		nrTable.setFont(new Font("Arial",1,20));
		nrTable.setPreferredSize(new Dimension(0,25));
		slPanel.putConstraint(SpringLayout.NORTH, nrTable, 140, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, nrTable, 200, SpringLayout.WEST, panel1);
		panel1.add(nrTable);
		
		comanda = new JButton("Make order!");
		comanda.setBackground(color3);
		comanda.setForeground(color2);
		comanda.setPreferredSize(new Dimension(150, 50));
		comanda.setFont(new Font("Arial", Font.BOLD, 20));
		slPanel.putConstraint(SpringLayout.NORTH, comanda, 190, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, comanda, 50, SpringLayout.WEST, panel1);
		panel1.add(comanda);
		
		pr = new JTextField(30);
		pr.setFont(new Font("Arial",1,20));
		pr.setPreferredSize(new Dimension(0,25));
		slPanel.putConstraint(SpringLayout.NORTH, pr, 270, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, pr, 200, SpringLayout.WEST, panel1);
		panel1.add(pr);
		
		price = new JLabel("OrderID:");
		price.setFont(new Font("Arial", 1, 20));
		price.setSize(new Dimension(300, 100));
		price.setForeground(color3);
		slPanel.putConstraint(SpringLayout.NORTH, price, 270, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, price, 50, SpringLayout.WEST, panel1);
		panel1.add(price);
		
		t = new JLabel("TableNo:");
		t.setFont(new Font("Arial", 1, 20));
		t.setSize(new Dimension(300, 100));
		t.setForeground(color3);
		slPanel.putConstraint(SpringLayout.NORTH, t, 320, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, t, 50, SpringLayout.WEST, panel1);
		panel1.add(t);
		
		t1 = new JTextField(30);
		t1.setFont(new Font("Arial",1,20));
		t1.setPreferredSize(new Dimension(0,25));
		slPanel.putConstraint(SpringLayout.NORTH, t1, 320, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, t1, 200, SpringLayout.WEST, panel1);
		panel1.add(t1);
		
		
		pret = new JButton("Compute price and generate bill!");
		pret.setBackground(color3);
		pret.setForeground(color2);
	    pret.setPreferredSize(new Dimension(360, 50));
		pret.setFont(new Font("Arial", Font.BOLD, 20));
		slPanel.putConstraint(SpringLayout.NORTH, pret, 370, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, pret, 50, SpringLayout.WEST, panel1);
		panel1.add(pret);
		
		 model = new DefaultTableModel();
	     model.addColumn("OrderID");
	     model.addColumn("TableNo");
	     JTable table = new JTable(model);
	     for(int i=0; i<Start.r.getOrders().size(); i++) {
	    	 Object[] obj = Start.r.orderTable(i);
			 model.addRow(obj);
	     }
	     table.setPreferredSize(new Dimension(500, 500));
	     JScrollPane pane = new JScrollPane(table);
	     pane.setPreferredSize(new Dimension(500, 500));
		 slPanel.putConstraint(SpringLayout.NORTH, pane, 50, SpringLayout.NORTH, panel1);
		 slPanel.putConstraint(SpringLayout.WEST, pane, 1000, SpringLayout.WEST, panel1);
		 panel1.add(pane);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(0, 1));
		mainPanel.add(panel1);

		frame.setContentPane(mainPanel);
		frame.setVisible(true);
		frame.pack();
	}
	
	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}
	
	public String getPr() {
		return pr.getText();
	}
	
	public String getT1() {
		return t1.getText();
	}
	public String getMenuItems() {
		return menuItems.getText();
	}

	public String getNrTable() {
		return nrTable.getText();
	}
	
	public void setPr(String s) {
		this.pr.setText(s);
	}
	
	public void setComandaButtonActionListener(ActionListener a) {
		comanda.addActionListener(a);
	}
	
	public void setPretButtonActionListener(ActionListener a) {
		pret.addActionListener(a);
	}
}

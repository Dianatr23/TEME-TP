package AdministratorGraphicalUserInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import Start.Start;


public class AdministratorView {
	private JFrame frame;
	private JPanel panel1;
	private JLabel jlabel;
	private JButton add;
	private JLabel denumire;
	private JTextField den;
	private JLabel gramaj;
	private JTextField gr;
	private JButton edit;
	private JButton delete;
	private JLabel denumire1;
	private JTextField den1;
	private JLabel denumire2;
	private JTextField den2;
	private JLabel editare;
	private JComboBox editare1;
	private String[] editTypes = {"Name", "Grams"};
	private JTextField new1;
	private JLabel newl;
	private JTable table;
	private Object[][] data = {};
	private DefaultTableModel model;
	private JTextField items;
	private JLabel itemsl;
	private JComboBox type;
	private JLabel typel;
	private String[] types = {"CompositeProduct", "BaseProduct"};
	private JLabel pricel;
	private JTextField price;
	
	public AdministratorView() {

		frame = new JFrame("ADMINISTRATOR");
		frame.setPreferredSize(new Dimension(1700, 1700));
		frame.setLocation(200, 100);

		panel1 = new JPanel();
		SpringLayout slPanel = new SpringLayout();
		panel1.setLayout(slPanel);

		Color color2 = new Color(0, 176, 178);
		Color color3 = new Color(0, 66, 54);


		panel1.setBackground(color2);

		jlabel = new JLabel("Administrator's menu");
		jlabel.setFont(new Font("Arial", 1, 20));
		jlabel.setSize(new Dimension(300, 100));
		slPanel.putConstraint(SpringLayout.NORTH, jlabel, 1, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, jlabel, 300, SpringLayout.WEST, panel1);
		jlabel.setForeground(color3);
		panel1.add(jlabel);
		
		den = new JTextField(30);
		den.setFont(new Font("Arial",1,20));
		slPanel.putConstraint(SpringLayout.NORTH, den, 50, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, den, 200, SpringLayout.WEST, panel1);
		panel1.add(den);
		 
		denumire = new JLabel("Name:"); 
		denumire.setFont(new Font("Arial", 1, 20));
		denumire.setSize(new Dimension(300, 100));
		denumire.setForeground(color3);
		slPanel.putConstraint(SpringLayout.NORTH, denumire, 50, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, denumire, 50, SpringLayout.WEST, panel1);
		panel1.add(denumire);
		
		gramaj = new JLabel("Grams:");
		gramaj.setFont(new Font("Arial", 1, 20));
		gramaj.setSize(new Dimension(300, 100));
		gramaj.setForeground(color3);
		slPanel.putConstraint(SpringLayout.NORTH, gramaj, 100, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, gramaj, 50, SpringLayout.WEST, panel1);
		panel1.add(gramaj);
		
		gr = new JTextField(30);
		gr.setFont(new Font("Arial",1,20));
		gr.setPreferredSize(new Dimension(0,25));
		slPanel.putConstraint(SpringLayout.NORTH, gr, 100, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, gr, 200, SpringLayout.WEST, panel1);
		panel1.add(gr);
		
		itemsl = new JLabel("Items:");
		itemsl.setFont(new Font("Arial", 1, 20));
		itemsl.setSize(new Dimension(300, 100));
		itemsl.setForeground(color3);
		slPanel.putConstraint(SpringLayout.NORTH, itemsl, 150, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, itemsl, 50, SpringLayout.WEST, panel1);
		panel1.add(itemsl);
		
		items = new JTextField(30);
		items.setFont(new Font("Arial",1,20));
		items.setPreferredSize(new Dimension(0,25));
		slPanel.putConstraint(SpringLayout.NORTH, items, 150, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, items, 200, SpringLayout.WEST, panel1);
		panel1.add(items);
		
		typel = new JLabel("Type:");
		typel.setFont(new Font("Arial", 1, 20));
		typel.setSize(new Dimension(300, 100));
		typel.setForeground(color3);
		slPanel.putConstraint(SpringLayout.NORTH, typel, 200, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, typel, 50, SpringLayout.WEST, panel1);
		panel1.add(typel);
		
		type = new JComboBox(types);
		type.setFont(new Font("Arial",1,20));
		type.setPreferredSize(new Dimension(220,35));
		type.setSelectedIndex(1);
		slPanel.putConstraint(SpringLayout.NORTH, type, 200, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, type, 200, SpringLayout.WEST, panel1);
		panel1.add(type);
		
		pricel = new JLabel("Price:");
		pricel.setFont(new Font("Arial", 1, 20));
		pricel.setSize(new Dimension(300, 100));
		pricel.setForeground(color3);
		slPanel.putConstraint(SpringLayout.NORTH, pricel, 250, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, pricel, 50, SpringLayout.WEST, panel1);
		panel1.add(pricel);
		
		price = new JTextField(30);
		price.setFont(new Font("Arial",1,20));
		price.setText("0.0");
		price.setPreferredSize(new Dimension(0,25));
		slPanel.putConstraint(SpringLayout.NORTH, price, 250, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, price, 200, SpringLayout.WEST, panel1);
		panel1.add(price);
		
		add = new JButton("Add item!");
		add.setBackground(color3);
		add.setForeground(color2);
		add.setPreferredSize(new Dimension(150, 50));
		add.setFont(new Font("Arial", Font.BOLD, 20));
		slPanel.putConstraint(SpringLayout.NORTH, add, 300, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, add, 50, SpringLayout.WEST, panel1);
		panel1.add(add);
		
		den1 = new JTextField(30);
		den1.setFont(new Font("Arial",1,20));
		den1.setPreferredSize(new Dimension(0,25));
		slPanel.putConstraint(SpringLayout.NORTH, den1, 400, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, den1, 200, SpringLayout.WEST, panel1);
		panel1.add(den1);
		
		editare1 = new JComboBox(editTypes);
		editare1.setFont(new Font("Arial",1,20));
		editare1.setPreferredSize(new Dimension(220, 35));
		editare1.setSelectedIndex(1);
		slPanel.putConstraint(SpringLayout.NORTH, editare1, 445, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, editare1, 200, SpringLayout.WEST, panel1);
		panel1.add(editare1);
		
		denumire1 = new JLabel("Name:");
		denumire1.setFont(new Font("Arial", 1, 20));
		denumire1.setSize(new Dimension(280, 100));
		denumire1.setForeground(color3);
		slPanel.putConstraint(SpringLayout.NORTH, denumire1, 400, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, denumire1, 50, SpringLayout.WEST, panel1);
		panel1.add(denumire1);
		
		editare = new JLabel("Edit:");
		editare.setFont(new Font("Arial", 1, 20));
		editare.setSize(new Dimension(300, 100));
		editare.setForeground(color3);
		slPanel.putConstraint(SpringLayout.NORTH, editare, 450, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, editare, 50, SpringLayout.WEST, panel1);
		panel1.add(editare);
		
		newl = new JLabel("New value:");
		newl.setFont(new Font("Arial", 1, 20));
		newl.setSize(new Dimension(300, 100));
		newl.setForeground(color3);
		slPanel.putConstraint(SpringLayout.NORTH, newl, 500, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, newl, 50, SpringLayout.WEST, panel1);
		panel1.add(newl);
		
		new1 = new JTextField(30);
		new1.setFont(new Font("Arial",1,20));
		new1.setPreferredSize(new Dimension(0,25));
		slPanel.putConstraint(SpringLayout.NORTH, new1, 500, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, new1, 200, SpringLayout.WEST, panel1);
		panel1.add(new1);
		
		edit = new JButton("Edit item!");
		edit.setBackground(color3);
		edit.setForeground(color2);
	    edit.setPreferredSize(new Dimension(150, 50));
		edit.setFont(new Font("Arial", Font.BOLD, 20));
		slPanel.putConstraint(SpringLayout.NORTH, edit, 570, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, edit, 50, SpringLayout.WEST, panel1);
		panel1.add(edit);
		
		den2 = new JTextField(30);
		den2.setFont(new Font("Arial",1,20));
		slPanel.putConstraint(SpringLayout.NORTH, den2, 680, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, den2, 200, SpringLayout.WEST, panel1);
		panel1.add(den2);
		 
		denumire2 = new JLabel("Name:"); 
		denumire2.setFont(new Font("Arial", 1, 20));
		denumire2.setSize(new Dimension(300, 100));
		denumire2.setForeground(color3);
		slPanel.putConstraint(SpringLayout.NORTH, denumire2, 680, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, denumire2, 50, SpringLayout.WEST, panel1);
		panel1.add(denumire2);
		
		delete = new JButton("Delete item!");
		delete.setBackground(color3);
		delete.setForeground(color2);
	    delete.setPreferredSize(new Dimension(150, 50));
		delete.setFont(new Font("Arial", Font.BOLD, 20));
		slPanel.putConstraint(SpringLayout.NORTH, delete, 740, SpringLayout.NORTH, panel1);
		slPanel.putConstraint(SpringLayout.WEST, delete, 50, SpringLayout.WEST, panel1);
		panel1.add(delete);
		
		 model = new DefaultTableModel();
	     model.addColumn("Name");
	     model.addColumn("Grams");
	     model.addColumn("Price");
	     JTable table = new JTable(model);
	     for(int i=0; i<Start.r.menu.size(); i++) {
	    	 Object[] obj = Start.r.itemTable(i);
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
	
	public String getDen() {
		return den.getText();
	}
	public String getDen1() {
		return den1.getText();
	}
	public String getDelete() {
		return den2.getText();
	}
	public String getEdit() {
		return (String) this.editare1.getSelectedItem();
	}
	public String getGr() {
		return gr.getText();
	}
	public String getNew() {
		return new1.getText();
	}
	public String getItems() {
		return items.getText();
	}
	public JTable getTable() {
		return table;
	}
	public void setAddButtonActionListener(ActionListener a) {
		add.addActionListener(a);
	}
	public void setEditButtonActionListener(ActionListener a) {
		edit.addActionListener(a);
	}

	public void setDeleteButtonActionListener(ActionListener a) {
		delete.addActionListener(a);
	}

	public Object[][] getData() {
		return data;
	}

	public void setData(Object[][] data) {
		this.data = data;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}
	
	public String getPrice() {
		return price.getText();
	}
	
	public String continutFrom() {
		return (String) this.type.getSelectedItem();
	}
}


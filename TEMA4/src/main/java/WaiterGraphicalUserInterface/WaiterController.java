package WaiterGraphicalUserInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import BusinessLayer.Order;
import BusinessLayer.Restaurant;
import ChefGraphicalUserInterface.ChefView;
import Start.Start;

public class WaiterController {
	
	//private ChefView chefview;
	private WaiterView frame;

	public WaiterController(WaiterView frame) {
		this.frame = frame;
		//this.chefview = new ChefView("Chef is not cooking");
		frame.setPretButtonActionListener(new PretButtonActionListener());
		frame.setComandaButtonActionListener(new ComandaButtonActionListener());
	}
	
	private class PretButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frame.getModel().setNumRows(0);
			int id = Integer.parseInt(frame.getPr());
			int table = Integer.parseInt(frame.getT1());
			double price = Start.r.computePrice(id, table);
			int ok =Start.r.generateBill(id, table);
			if(ok == 1) {
				for(int i=0; i<Start.r.getOrders().size(); i++) {
			    	 Object[] obj = Start.r.orderTable(i);
					 frame.getModel().addRow(obj);
			     }
			}else {
				ErrorWView2 view = new ErrorWView2();
			}
		}
	}

	private class ComandaButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String items = frame.getMenuItems();
			int table = Integer.parseInt(frame.getNrTable());
			if(Start.r.getOrders().size() == 0)
				Restaurant.id = 1;
			else {
				for(int i=0; i<Start.r.getOrders().size(); i++) {
					Order o = (Order) Start.r.getOrders().get(i);
					Restaurant.id = o.getId();
				}
				Restaurant.id++;
			}
			int ok = Start.r.createOrder(Restaurant.id, table, items);
			if(ok == 0) {				
				Restaurant.id++;
				frame.getModel().setNumRows(0);
				for(int i=0; i<Start.r.getOrders().size(); i++) {
			    	 Object[] obj = Start.r.orderTable(i);
					 frame.getModel().addRow(obj);
			    }
				String[] item = items.split(", ");
				for(String a : item) { 
					for(int j=0; j<Start.r.menu.size(); j++) {
						if(a.contentEquals(Start.r.menu.get(j).getDenumire())) {
							if(Start.r.menu.get(j).getClass().getName().equals("assignment4.assignment4.CompositeProduct")) {
								Start.r.addObserver(new ChefView(""));
								Start.r.setChef("Chef is cooking");
						 } 
				     } 
				  }
			    }	
			}else if(ok == 1){
				ErrorWView1 view = new ErrorWView1();
			}else {
				ErrorWView3 view = new ErrorWView3();
			}
		}
	}
}
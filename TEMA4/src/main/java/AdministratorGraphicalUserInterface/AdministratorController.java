package AdministratorGraphicalUserInterface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Start.Start;

public class AdministratorController {
	
	private AdministratorView frame;

	public AdministratorController(AdministratorView frame) {
		this.frame = frame;
		frame.setAddButtonActionListener(new AddButtonActionListener());
		frame.setEditButtonActionListener(new EditButtonActionListener());
		frame.setDeleteButtonActionListener(new DeleteButtonActionListener());
	}
	
	
	private class AddButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int ok = 0;
			String denumire = frame.getDen();
			int grams = Integer.parseInt(frame.getGr());
			double price;
			String type = frame.continutFrom();
			if(type.equals("CompositeProduct"))
				price = 0.0;
			else 
				price = Double.parseDouble(frame.getPrice());
			String items = frame.getItems();
			ok = Start.r.addItem(denumire, grams, type, items, price);
			//daca produsul nu exista  se modifica tabelul
			if(ok == 1) {
				frame.getModel().setNumRows(0);
				for(int i=0; i<Start.r.menu.size(); i++) {
			    	 Object[] obj = Start.r.itemTable(i);
					 frame.getModel().addRow(obj);
			    }
			}else {
				ErrorView1 view = new ErrorView1();
			}
		}
	}

	private class EditButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int gr = 0;
			int found = 0;
			String denumire = frame.getDen1();
			String edit = frame.getEdit();
			if(edit.equals("Grams")) {
				//System.out.println("grams");
				int gramaj = Integer.parseInt(frame.getNew());
				gr = Start.r.editItemByGrams(denumire, gramaj);
				frame.getModel().setNumRows(0);
				for(int i=0; i<Start.r.menu.size(); i++) {
			    	 Object[] obj = Start.r.itemTable(i);
					 frame.getModel().addRow(obj);
			     }
				if(gr == 0) {
					ErrorView2 view = new ErrorView2();
				}
			}
			else{
				frame.getModel().setNumRows(0);
				String den = frame.getNew();
				found = Start.r.editItemByName(denumire, den);
				for(int i=0; i<Start.r.menu.size(); i++) {
			    	 Object[] obj = Start.r.itemTable(i);
					 frame.getModel().addRow(obj);
			     }
				if(found == 0) {
					ErrorView2 view = new ErrorView2();
				}
			}
		}
	}
	

	private class DeleteButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int ok = 0;
			//sterg tot tabelul
			frame.getModel().setNumRows(0);
			//sterg produsul
			String denumire = frame.getDelete();
			ok = Start.r.deleteItem(denumire);
			//repun in tabel produsele ramase
			for(int i=0; i<Start.r.menu.size(); i++) {
				Object[] obj = Start.r.itemTable(i);
				frame.getModel().addRow(obj);
			}
			if(ok == 0){
				ErrorView2 view = new ErrorView2();
			}
		}
	}
}

package PresentationLayer;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;

import AdministratorGraphicalUserInterface.AdministratorController;
import AdministratorGraphicalUserInterface.AdministratorView;
import DataLayer.RestaurantSerializator;
import Start.Start;
import WaiterGraphicalUserInterface.WaiterController;
import WaiterGraphicalUserInterface.WaiterView;

public class MainMenuController {
	
	private JFrame frame;

	public MainMenuController(MainMenuFrame frame) {
		this.frame = frame;
		frame.setSaveButtonActionListener(new SaveButtonActionListener());
		frame.setWaiterButtonActionListener(new WaiterButtonActionListener());
		frame.setAdministratorButtonActionListener(new AdministratorButtonActionListener());
	}

	private class SaveButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			RestaurantSerializator res = new RestaurantSerializator();
			res.serialization();
			//Serializare
//			try {
//				FileOutputStream fileOut = new FileOutputStream("restaurant.ser");
//				ObjectOutputStream out = new ObjectOutputStream(fileOut);
//				out.writeObject(Start.r);
//				out.close();
//				fileOut.close();
//			}catch(IOException i) {
//				i.printStackTrace();
//			}
		}
	}

	private class WaiterButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			WaiterView view = new WaiterView();
			WaiterController controller= new WaiterController(view);
		}
	}
	
	private class AdministratorButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			AdministratorView view = new AdministratorView();
			AdministratorController controller = new AdministratorController(view);
		}
	}
}

package DataLayer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import Start.Start;

public class RestaurantSerializator {
	public void serialization() {
		try {
			FileOutputStream fileOut = new FileOutputStream("restaurant.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(Start.r);
			out.close();
			fileOut.close();
		}catch(IOException i) {
			i.printStackTrace();
		}
	}
}

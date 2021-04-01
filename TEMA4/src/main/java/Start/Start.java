package Start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import BusinessLayer.Restaurant;
import PresentationLayer.MainMenuController;
import PresentationLayer.MainMenuFrame;

public class Start{
	public static Restaurant r = new Restaurant();

	public static void main(String[] args) {
    //Deserializare
	try
    {    
       FileInputStream file = new FileInputStream("restaurant.ser"); 
       ObjectInputStream in = new ObjectInputStream(file); 
       r = (Restaurant)in.readObject(); 
       in.close(); 
       file.close();  
    } catch(IOException ex) { 
        System.out.println("IOException is caught"); 
    } catch(ClassNotFoundException ex) { 
        System.out.println("ClassNotFoundException is caught"); 
    }
	new MainMenuController(new MainMenuFrame("RESTAURANT"));
	}
}

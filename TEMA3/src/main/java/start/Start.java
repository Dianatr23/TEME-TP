package start;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.*;
import model.*;
import presentation.*;

/**
 * In this class is the main method
 * @author Diana Trifu
 *
 */
public class Start {

	/**
	 * this method receive as input a txt file from where it will read the commands and execute them 
	 * this where the interaction between the code and the database happens
	 * @param args arguments from command line
	 */
	public static void main(String[] args) {
		List list =new ArrayList();
		List list1 =new ArrayList();
		List produse = new ArrayList();
		ProdusDao p = new ProdusDao();
		Produs p1 = new Produs();
		ClientDao c = new ClientDao();
		FacturaDao f = new FacturaDao();
		Client cl = new Client();
		ComandaDao o = new ComandaDao();
		Scanner myReader =null;
		int pdfClient = 0, pdfProdus = 0, pdfComanda = 0, pdfFactura = 0, stoc = 0;
		try {
		     myReader = new Scanner(new File(args[0]));
		} catch (FileNotFoundException e) {
		      e.printStackTrace();
		}
		while (myReader.hasNextLine()) {
            Scanner r = new Scanner(myReader.nextLine());
        while (r.hasNext()) {
            String s = r.next();
            list.add(s);
        }
    }	
		for(int i=0; i<list.size();i++) {
			list1.add(((String) list.get(i)).replaceAll(",", ""));
		}
		int match = 0, poz = 0;
		for(int i = 0; i<list1.size(); i++) {
			if(list1.get(i).equals("Insert")) {
				if(list1.get(i+1).equals("client:"))
					ClientDao.insert(list1.get(i+2) + " " + list1.get(i+3), (String)list1.get(i+4));
				if(list1.get(i+1).equals("product:")) {
					boolean b;
					match = 0;
					for(int j = 0; j<produse.size(); j=j+2){
						b = produse.get(j).equals(list1.get(i+2));
						if(b == true) {
							match=match+1;
							poz = j;
							
						}
					}
					if(match == 1) {
						int update = (Integer)produse.get(poz+1) + Integer.parseInt((String) list1.get(i+3));
						p.updateCantByName(update, (String)list1.get(i+2));
					    produse.remove(poz+1);
					    produse.add(poz+1, update);
					}
					else {
						ProdusDao.insert((String)list1.get(i+2), Integer.parseInt((String)list1.get(i+3)), Float.parseFloat((String)list1.get(i+4)));
						produse.add(list1.get(i+2));
						produse.add(Integer.parseInt((String)list1.get(i+3)));
					}
				}
			}
			if(list1.get(i).equals("Delete")) {
				if(list1.get(i+1).equals("client:")) {
					cl = c.findByName(list1.get(i+2)+ " " + list1.get(i+3));
				    o.deleteByIdC(cl.getId());
				    f.deleteByIdC(cl.getId());
					c.deleteByName(list1.get(i+2)+ " " + list1.get(i+3));
				}
				if(list1.get(i+1).equals("product:")) {
					p1 = p.findByName((String)list1.get(i+2));
					o.deleteByIdP(p1.getId());
					f.deleteByIdP(p1.getId());
					p.deleteByName((String)list1.get(i+2));
					for(int ind=0; ind<produse.size(); ind=ind+2) {
						boolean b = produse.get(ind).equals(list1.get(i+2));
						if(b == true) {
							produse.remove(ind);
							produse.remove(ind);
						}
					}
				}
			}
			if(list1.get(i).equals("Report")) {
				if(list1.get(i+1).equals("client")) {
					ClientPDF.query(pdfClient);
					pdfClient++;
				}
				if(list1.get(i+1).equals("product")) {
					ProdusPDF.query(pdfProdus);
					pdfProdus++;
				}
				if(list1.get(i+1).equals("order")) {
					ComandaPDF.query(pdfComanda);
					pdfComanda++;
				}	
			}
			if(list1.get(i).equals("Order:")) {
				match = 0;
				for(int j=0; j<produse.size(); j++) {
					boolean b  = produse.get(j).equals(list1.get(i+3));
					if(b == true) {
						match = 1;
						poz = j;
					}
				}
				if(match == 1) {
					int c1 = (Integer) produse.get(poz+1);
					int c2 = Integer.parseInt((String)list1.get(i+4));
					if(c1 >= c2) {
						//update cantitate sir produse
						int update = c1 - c2;
						produse.remove(poz+1);
					    produse.add(poz+1, update);
					    //generare facura + inserare factura in baza de date
					    p1 = p.findByName((String)list1.get(i+3));
						float pret = Float.parseFloat((String)list1.get(i+4)) * p1.getPret();
					    FacturaPDF.facturare(pdfFactura, list1.get(i+1) + " " + list1.get(i+2), (String)list1.get(i+3), (String)list1.get(i+4), pret);
					    pdfFactura++;
						//update cantitate baza de date
					    p.updateCantByName(update, (String)list1.get(i+3));
					    //inserare comanda in baza de date
					    cl = c.findByName(list1.get(i+1) + " " + list1.get(i+2));
					    p1 = p.findByName((String)list1.get(i+3));
						ComandaDao.insert(list1.get(i+1) + " " + list1.get(i+2), (String)list1.get(i+3), Integer.parseInt((String)list1.get(i+4)), cl.getId(), p1.getId());
						//inserare factura in baza de date
						 FacturaDao.insert(list1.get(i+1) + " " + list1.get(i+2), (String)list1.get(i+3), Integer.parseInt((String)list1.get(i+4)), pret, cl.getId(), p1.getId());
					}else{
							//generare pdf pentru semnalarea stocului insuficient
							FacturaPDF.stocInsuficient(stoc, list1.get(i+1) + " " + list1.get(i+2), (String)list1.get(i+3));
							stoc++;	
				    }
				}
			}			
		}
	}
	
}

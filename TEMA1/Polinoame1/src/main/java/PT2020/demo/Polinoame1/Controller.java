package PT2020.demo.Polinoame1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Controller {

	private Polynomial model;
	private Monimial m;
    private View view;
	
	public Controller(Monimial model, Polynomial p, View view){
		this.model=p;
		this.m = model;
		this.view=view;
		view.egalListener(new egalitateListener());
	}
	
	private class egalitateListener implements ActionListener{
	   	 public void actionPerformed(ActionEvent e) {
	   		 if(view.getPol2().equals("") && view.continutFrom()!="derivare" && view.continutFrom()!="integrare") {
	   			 view.putErr("Trebuie introdus si un al doilea polinom!!!");
	   			 view.putRez(" ");
	   		 }
	   		 else
	   			 view.putErr(" ");
	   		 String p1 = view.getPol1();
	   		 String p2 = view.getPol2();
	   		String[] n1 = new String[20];
	   		String[] n2 = new String[20];
	   		
		     n1 = p1.replace("^", "").split("((?=\\+)|(?=\\-)|x)");
		     n2 = p2.replace("^", "").split("((?=\\+)|(?=\\-)|x)");

		        List<Integer> ce1 = new ArrayList<Integer>();
		        List<Integer> ce2 = new ArrayList<Integer>();

		        try {
		        for (int i = 0; i < n1.length - 1; i += 2) {
		            ce1.add(Integer.parseInt(n1[i]));
		            ce1.add(Integer.parseInt(n1[i + 1]));
		        }
		        
		        for (int i = 0; i < n2.length - 1; i += 2) {
		            ce2.add(Integer.parseInt(n2[i]));
		            ce2.add(Integer.parseInt(n2[i + 1]));
		        }
		        }catch(Exception NumberFormatException) {
		        	System.out.println("FGHJKL");
		   			 view.putErr("Forma unuia dintre polinoame nu se potriveste->vezi mai jos");
		   			 view.putRez("");
		        }
		        Polynomial po1 = new Polynomial();
		        Polynomial po2 = new Polynomial();
		        Polynomial rez = new Polynomial();
		        Polynomial rez1 = new Polynomial();
		        for(int i = 0; i < ce1.size(); i += 2) {
		        	int j = i+1;
		        	po1.getPolinom().add(new Monimial(ce1.get(i), ce1.get(j)));
		        }
		        for(int i = 0; i < ce2.size(); i += 2) {
		        	int j = i + 1;
		        	po2.getPolinom().add(new Monimial(ce2.get(i), ce2.get(j)));
		        }
		        
		  if(view.continutFrom() == model.getOp(0)) {
			  String sss = "=";
			  po1.addPol(po2, rez);
			  for(String s : rez.printPol()) {
				  sss = sss + s; 
			  }
			  view.putRez(sss);
			  
			  
		  }
		  else if(view.continutFrom()==model.getOp(1)) {
			  String sss = "=";
			  po1.subPol(po2, rez);
			  for(String s : rez.printPol()) {
				  sss = sss + s; 
			  }
			  view.putRez(sss);
		   }
		  else if(view.continutFrom()=="înmulțire") {
			  String sss = "=";
			  po1.mulPol(po2, rez1, rez);
			  for(String s : rez.printPol()) {
				  sss = sss + s; 
			  }
			  view.putRez(sss);
		  }
	   	  else if(view.continutFrom()=="împărțire") {
	   		String sss = "=";
			  po1.divPol(po2, rez);
			  for(String s : rez.printPol()) {
				  sss = sss + s; 
			  }
			  view.putRez(sss);
	   	  }
	   	  else if(view.continutFrom()=="derivare" ) {
	   		String sss = "=";
			  po1.derPol(rez);
			  for(String s : rez.printPol()) {
				  sss = sss + s; 
			  }
			  view.putRez(sss);
	   	  }
	   	  else if(view.continutFrom()=="integrare" ) {
	   		String sss = "=";
			  po1.intPol(rez);
			  for(String s : rez.printInt()) {
				  sss = sss + s; 
			  }
			  view.putRez(sss);
	   	  }
	   	 }
	    }
}

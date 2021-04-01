package PT2020.demo.Polinoame1;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		Polynomial a = new Polynomial();
		Polynomial b = new Polynomial();
		Polynomial rez = new Polynomial();
		Polynomial rez1 = new Polynomial();
		Monimial s = new Monimial(1, 2);
		Monimial s1 = new Monimial(5, 1);
		Monimial s2 = new Monimial(7, 0);
		Monimial s3 = new Monimial(1, 1);
		Monimial s4 = new Monimial(-1, 0);
		a.getPolinom().add(s);
		a.getPolinom().add(s1);
		a.getPolinom().add(s2);
		b.getPolinom().add(s3);
		b.getPolinom().add(s4);
		Monimial m = new Monimial(0, 0);
		Polynomial m1 = new Polynomial();
		View v = new View(m1, m);
		new Controller(m, m1, v);

		a.addPol(b, rez);
		//a.subPol(b, rez);
	    //a.mulPol(b, rez, rez1);
     	//rez.printInt();
		List<String> str = rez.printPol();	
		for(String strg : str)
			System.out.print(strg);    
	}

}

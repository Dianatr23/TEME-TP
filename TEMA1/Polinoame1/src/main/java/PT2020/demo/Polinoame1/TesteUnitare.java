package PT2020.demo.Polinoame1;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TesteUnitare extends TestCase {
	
	Polynomial a = new Polynomial();
	Polynomial b = new Polynomial();
	Polynomial rez = new Polynomial();
	Polynomial rezz = new Polynomial();
	Monimial s = new Monimial(1, 2);
	Monimial s1 = new Monimial(5, 1);
	Monimial s2 = new Monimial(7, 0);
	Monimial s3 = new Monimial(1, 1);
	Monimial s4 = new Monimial(-1, 0);
	
	public void testAdunare() {
		a.getPolinom().add(s);
		a.getPolinom().add(s1);
		a.getPolinom().add(s2);
		b.getPolinom().add(s3);
		b.getPolinom().add(s4);
		
		a.addPol(b, rez);
		List<String> rez1 = new ArrayList<String>();
 		rez1.add("1");
		rez1.add("*x^");
		rez1.add("2");
		rez1.add(" + ");
		rez1.add("6");
		rez1.add("*x^");
		rez1.add("1");
		rez1.add(" + ");
		rez1.add("6");
		assertEquals(rez.printPol(), rez1);
	}
	
	public void testScadere() {
		a.getPolinom().add(s);
		a.getPolinom().add(s1);
		a.getPolinom().add(s2);
		b.getPolinom().add(s3);
		b.getPolinom().add(s4);
		
		a.subPol(b, rez);
		List<String> rez1 = new ArrayList<String>();
 		rez1.add("1");
		rez1.add("*x^");
		rez1.add("2");
		rez1.add(" + ");
		rez1.add("4");
		rez1.add("*x^");
		rez1.add("1");
		rez1.add(" + ");
		rez1.add("8");
		assertEquals(rez.printPol(), rez1);
	}
	
	public void testInmultire() {
		a.getPolinom().add(s);
		a.getPolinom().add(s1);
		a.getPolinom().add(s2);
		b.getPolinom().add(s3);
		b.getPolinom().add(s4);
		
		a.mulPol(b, rezz, rez);
		List<String> rez1 = new ArrayList<String>();
 		rez1.add("1");
		rez1.add("*x^");
		rez1.add("3");
		rez1.add(" + ");
		rez1.add("4");
		rez1.add("*x^");
		rez1.add("2");
		rez1.add(" + ");
		rez1.add("2");
		rez1.add("*x^");
		rez1.add("1");
		rez1.add(" + ");
		rez1.add("-7");
		assertEquals(rez.printPol(), rez1);
	}
	
	public void testImpartire() {
		a.getPolinom().add(s);
		a.getPolinom().add(s1);
		a.getPolinom().add(s2);
		b.getPolinom().add(s3);
		b.getPolinom().add(s4);
		
		a.divPol(b, rez);
		List<String> rez1 = new ArrayList<String>();
 		rez1.add("1");
		rez1.add("*x^");
		rez1.add("1");
		rez1.add(" + ");
		rez1.add("6");
		assertEquals(rez.printPol(), rez1);
	}
	
	public void testDerivare() {
		a.getPolinom().add(s);
		a.getPolinom().add(s1);
		a.getPolinom().add(s2);
		
		a.derPol(rez);
		List<String> rez1 = new ArrayList<String>();
 		rez1.add("2");
		rez1.add("*x^");
		rez1.add("1");
		rez1.add(" + ");
		rez1.add("5");
		rez1.add(" + ");
		rez1.add("0");
		assertEquals(rez.printPol(), rez1);
	}
	
	public void testIntegrare() {
		a.getPolinom().add(s);
		a.getPolinom().add(s1);
		a.getPolinom().add(s2);
		
		a.intPol(rez);
		List<String> rez1 = new ArrayList<String>();
 		rez1.add("1");
		rez1.add("/");
		rez1.add("3");
		rez1.add("*x^");
		rez1.add("3");
		rez1.add(" + ");
		rez1.add("5");
		rez1.add("/");
		rez1.add("2");
		rez1.add("*x^");
		rez1.add("2");
		rez1.add(" + ");
		rez1.add("7");
		rez1.add("*x^");
		rez1.add("1");
		assertEquals(rez.printInt(), rez1);
	}
	
	public void testPreluarePolinom() {
		String pol = new String("2x^2+3x^0");
	    String[] n1 = pol.replace("^", "").split("((?=\\+)|(?=\\-)|x)");
	    List<Integer> l = new ArrayList<Integer>();
	    List<Integer> l1 = new ArrayList<Integer>();
	    
	    l1.add(2);
	    l1.add(2);
	    l1.add(3);
	    l1.add(0);

        for (int i = 0; i < n1.length; i += 2) {
        	int j = i + 1;
            l.add(Integer.parseInt(n1[i]));
            l.add(Integer.parseInt(n1[j]));
        }
        assertEquals(l, l1);
	}
}

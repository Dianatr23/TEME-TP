package PT2020.demo.Polinoame1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Polynomial {
	private List<Monimial> polinom;
	private String[] operatii = { "adunare", "scădere", "înmulțire", "împărțire", "derivare", "integrare"};
	
	
	public Polynomial() {
		this.polinom = new ArrayList<Monimial>();
	}
	
	//adunarea polinoamelor
	public void addPol(Polynomial b, Polynomial r) {
		int ok = 0;
		int x = 0;
			for(Monimial i : this.getPolinom()) {
				ok = 0;
				for(Monimial j : b.getPolinom()) {
					if(i.getGrad() == j.getGrad()) {
						r.getPolinom().add(new Monimial (i.getCoeficient() + j.getCoeficient(), i.getGrad()));
						ok = ok + 1;
						//b.getPolinom().remove(j);
					}
	            }
				if(ok == 0)
					r.getPolinom().add(new Monimial(i.getCoeficient(), i.getGrad()));
			}
			for(Monimial s : b.getPolinom()) {
				for(Monimial h : r.getPolinom()) {
					if(s.getGrad() == h.getGrad())
						x = x +1;
				}
				if(x == 0)
					r.getPolinom().add(new Monimial(s.getCoeficient(), s.getGrad()));	
	        }				
	}
	
	//scaderea polinoamelor
	public void subPol(Polynomial b, Polynomial r) {
		int ok = 0;
		int x = 0;
			for(Monimial i : this.getPolinom()) {
				ok = 0;
				for(Monimial j : b.getPolinom()) {
					if(i.getGrad() == j.getGrad()) {
						r.getPolinom().add(new Monimial (i.getCoeficient() - j.getCoeficient(), i.getGrad()));
						ok = ok + 1;
					}
	            }
				if(ok == 0)
					r.getPolinom().add(new Monimial(i.getCoeficient(), i.getGrad()));
			}
			for(Monimial s : b.getPolinom()) {
				for(Monimial h : r.getPolinom()) {
					if(s.getGrad() == h.getGrad())
						x = x +1;
				}
				if(x == 0)
					r.getPolinom().add(new Monimial(-1*s.getCoeficient(), s.getGrad()));	
	        }				
	}
	
	//inmultirea polinoamelor
		public void  mulPol(Polynomial b, Polynomial r, Polynomial y) {
				for(Monimial i : this.getPolinom()) {
					for(Monimial j : b.getPolinom()) {
							r.getPolinom().add(new Monimial (i.getCoeficient() * j.getCoeficient(), i.getGrad() + j.getGrad()));
		            }
				}
				//adunarea monoamelor cu acelasi grad dupa inmultire
				Collections.sort(r.getPolinom());
				int nr = r.size();
				int j = 0;
				for(int i = 0; i<nr; i++) {
						j = i + 1;
						if(j<nr) {
							if((r.getPolinom().get(i).getGrad() == r.getPolinom().get(j).getGrad())) {
								y.getPolinom().add(new Monimial(r.getPolinom().get(i).getCoeficient()+r.getPolinom().get(j).getCoeficient(),r.getPolinom().get(i).getGrad()));
								r.getPolinom().remove(i);
								r.getPolinom().remove(i);
								nr = nr - 2;
								i = i - 1;
							}
						}
				}
				for(Monimial a : r.getPolinom()) {
					y.getPolinom().add(a);
				}
		}

	
	//impartirea polinoamelor
	public void divPol(Polynomial b, Polynomial rez) {
			Polynomial a = this;
		     while(a.getPolinom().get(0).getGrad() != 0 ) {
		    	 //elementul catului
		    	 Monimial c = new Monimial((a.getPolinom().get(0).getCoeficient() / b.getPolinom().get(0).getCoeficient()), (a.getPolinom().get(0).getGrad() - b.getPolinom().get(0).getGrad()));
		    	 rez.getPolinom().add(c);
		    	 
		    	 Polynomial g = new Polynomial();
		    	 //b.mulPol(s, g1, g);
		    	 for(Monimial m : b.getPolinom()) {
		    		 g.getPolinom().add(new Monimial(c.getCoeficient() * m.getCoeficient(), c.getGrad() + m.getGrad()));
		    	 }
		    	 
		    	 Polynomial a1 = new Polynomial();
		    	 a.subPol(g, a1);
		    	 a1.getPolinom().remove(0);
		    	 a = a1;
		     }
	}
	
	//derivarea unui polinom
	public void derPol(Polynomial r) {
		for(Monimial a : this.getPolinom()) {
				r.getPolinom().add(new Monimial(a.getCoeficient() * a.getGrad(), a.getGrad()-1));
		}
	}
	
	//integrarea unui polinom
	public void intPol(Polynomial r) {
		for(Monimial a : this.getPolinom()) {
			r.getPolinom().add(new Monimial(a.getCoeficient(), a.getGrad() + 1));
		}
	}
	
	//printare integrarea unui polinom
	public List<String> printInt() {
		int nr = this.size();
		List <String> rezultat = new ArrayList<String>();
		for(Monimial a : this.getPolinom()) {
			nr = nr - 1;
			if(nr == 0) {
				if(a.getGrad() == 1) {
					rezultat.add(Integer.toString(a.getCoeficient()));
					rezultat.add("*x^");
					rezultat.add(Integer.toString(a.getGrad()));
				}
				else {
				rezultat.add(Integer.toString(a.getCoeficient()));
				rezultat.add("/");
				rezultat.add(Integer.toString(a.getGrad()));
				rezultat.add("*x^");
				rezultat.add(Integer.toString(a.getGrad()));
				}
			}
			else {
				rezultat.add(Integer.toString(a.getCoeficient()));
				rezultat.add("/");
				rezultat.add(Integer.toString(a.getGrad()));
				rezultat.add("*x^");
				rezultat.add(Integer.toString(a.getGrad()));
				rezultat.add(" + ");
			}
		}
		return rezultat;
	}
	
	//lungimea listei/polinomului
	public int size() {
		int s = 0;
		for(Monimial a : this.getPolinom())
			s = s + 1;
		return s;
	}
	
	//functie pentru printarea listei
	public List<String> printPol() {
		Collections.sort(this.getPolinom()); 
		List <String> rezultat = new ArrayList<String>();
		int nr = this.size();
		int nrr = 0;
		for(Monimial a : this.getPolinom()) {
			if(a.getCoeficient() == 0)
				nrr++;
		}
		if(nrr == nr)
			rezultat.add("0");
		else {
		for(Monimial a : this.getPolinom()) {
			nr = nr - 1;
			if(a.getGrad() <= 0) { 
				if(nr == 0)
					rezultat.add(Integer.toString(a.getCoeficient()));
				    //System.out.print(a.getCoeficient());
				else {
					rezultat.add(Integer.toString(a.getCoeficient()));
					rezultat.add(" + ");
				}
			}
			else {		
				if(a.getCoeficient() > 0) {
					if(nr == 0) {
						rezultat.add(Integer.toString(a.getCoeficient()));
						rezultat.add("*x^");
						rezultat.add(Integer.toString(a.getGrad()));
					}
						//System.out.print(a.getCoeficient() + "*x^" + a.getGrad());
					else {
						rezultat.add(Integer.toString(a.getCoeficient()));
						rezultat.add("*x^");
						rezultat.add(Integer.toString(a.getGrad()));
						rezultat.add(" + ");
						
					}
						//System.out.print(a.getCoeficient() + "*x^" + a.getGrad() + " + ");
				}
				else {
					if(nr != 0)
					{
						rezultat.add("(");
						rezultat.add(Integer.toString(a.getCoeficient()));
						rezultat.add("*x^");
						rezultat.add(Integer.toString(a.getGrad()));
						rezultat.add(")");
						rezultat.add(" + ");
					}
						//System.out.print("(" + a.getCoeficient() + "*x^" + a.getGrad() + ") + ");
					else
					{
						rezultat.add("(");
						rezultat.add(Integer.toString(a.getCoeficient()));
						rezultat.add("*x^");
						rezultat.add(Integer.toString(a.getGrad()));
						rezultat.add(")");
					}
						//System.out.print("(" + a.getCoeficient() + "*x^" + a.getGrad() + ")");
		    	}
		    }
		}
		}
		return rezultat;
	}

	public List<Monimial> getPolinom() {
		return polinom;
	}

	public void setPolinom(List<Monimial> pol1) {
		this.polinom = pol1;
	}
	
	public String[] getStringOp() {
		return this.operatii;
	}
	
	public String getOp(int i) {
		return this.operatii[i];
	}
}

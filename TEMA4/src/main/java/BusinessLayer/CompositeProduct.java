package BusinessLayer;

import java.util.ArrayList;
import java.util.List;

public class CompositeProduct extends MenuItem{
	private List<MenuItem> base;
	
	public CompositeProduct(String den, int gr, List l) {
		super(den, gr);
		this.base = l;
		this.setPret(computePrice(gr));
	}
	public double computePrice(int gramaj) {
		double price = 0.0;
		for(int i = 0; i<base.size(); i++)
			price = price + base.get(i).getPret();
		if(gramaj < 350)
			price = price + 5.0;
		else if(gramaj == 350)
			price = price + 10.0;
		else 
			price = price + 15.0;
		return price;
	}
	public List<MenuItem> getBase() {
		return base;
	}
	public void setBase(List<MenuItem> base) {
		this.base = base;
	}
}

package BusinessLayer;

public class BaseProduct extends MenuItem{
	public BaseProduct(String den, int gr, double price) {
		super(den, gr);
		this.setPret(price);
	}
	public double computePrice(int gramaj) {
		double price = 0.0;
		return price;
	}
}

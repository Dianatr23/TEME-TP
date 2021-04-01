package BusinessLayer;

public abstract class MenuItem implements java.io.Serializable{
	private String denumire;
	private int gramaj;
	private double pret;
	public MenuItem(String denumire, int gr) {
		this.setDenumire(denumire);
		this.setGramaj(gr);
	}
	public double computePrice() {
		return 0.0;
	}
	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	public int getGramaj() {
		return gramaj;
	}
	public void setGramaj(int gramaj) {
		this.gramaj = gramaj;
	}
	public double getPret() {
		return pret;
	}
	public void setPret(double pret) {
		this.pret = pret;
	}
	
}

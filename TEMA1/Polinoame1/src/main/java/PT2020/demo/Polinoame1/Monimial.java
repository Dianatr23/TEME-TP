package PT2020.demo.Polinoame1;

public class Monimial implements Comparable<Monimial>{
	private int coeficient;
	private int grad;
	
	public Monimial(int coef, int gr) {
		this.setCoeficient(coef);
		this.setGrad(gr);
	}

	public int getCoeficient() {
		return coeficient;
	}

	public void setCoeficient(int coeficient) {
		this.coeficient = coeficient;
	}

	public int getGrad() {
		return grad;
	}

	public void setGrad(int grad) {
		this.grad = grad;
	}

	public int compareTo(Monimial a) {
		if(this.getGrad() > a.getGrad())
			return -1;
		else if(this.getGrad() < a.getGrad())
			return 1;
		else
			return 0;
	}
	
	
}

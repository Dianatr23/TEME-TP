package PT2020.queues.Queues;

public class Client implements Comparable<Client>{
	private int ID;
	private int tArrival;
	private int tService;
	
	public Client(int id1, int ta, int ts) {
		this.ID = id1;
		this.tArrival = ta;
		this.tService = ts;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int gettArrival() {
		return tArrival;
	}
	public void settArrival(int tArrival) {
		this.tArrival = tArrival;
	}
	public int gettService() {
		return tService;
	}
	public void settService(int tService) {
		this.tService = tService;
	}

	public int compareTo(Client c) {
		if(this.gettArrival() > c.gettArrival())
			return 1;
		else if(this.gettArrival() < c.gettArrival())
			return -1;
		else
			return 0;
	}
}

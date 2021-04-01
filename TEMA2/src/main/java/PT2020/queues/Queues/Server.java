package PT2020.queues.Queues;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server extends Thread implements Runnable{
	private int nrClient;
	private BlockingQueue<Client> clienti;
	private int indice;
	private AtomicInteger waitingTime;
	private int time;
	public int waitTime = 0;
	
	public Server(int i, int t) {
		this.setIndice(i);
		this.waitingTime = new AtomicInteger(0);
		this.clienti = new LinkedBlockingQueue();
		this.nrClient = 0;
		this.time = t;
	}
	
	public void addClient(Client c) {
		this.getClienti().add(c);
		this.getWaitingTime().addAndGet(c.gettService());
		waitTime = waitTime + this.getWaitingTime().intValue();
		nrClient = nrClient + 1;
	}
	
	public void run() {
		int k = 0;
		while(k<=time) {
			if(clienti.isEmpty()) {
				System.out.println("TIME " + k + ": Server-ul " + this.getIndice() + " este inchis");
			}
			if(clienti.peek() != null) {
				System.out.println("TIME " + k + ": Server-ul "+this.getIndice() + ": "+"("+clienti.peek().getID()+", "+clienti.peek().gettArrival()+", "+clienti.peek().gettService()+")");
				if(clienti.peek().gettService() == 1) 
					clienti.remove(clienti.peek());	
				else
					clienti.peek().settService(clienti.peek().gettService()-1);
			}
			try {
				Thread.sleep(1000);
	        }catch (InterruptedException e) {
	        	e.printStackTrace();
			}
			if(this.getWaitingTime().intValue() > 0)
				this.getWaitingTime().decrementAndGet();
			k++;
			}
		}
	
	public int getNrClient() {
		return nrClient;
	}
	public void setNrClient(int nrClient) {
		this.nrClient = nrClient;
	}
	public BlockingQueue<Client> getClienti() {
		return clienti;
	}
	public void setClienti(BlockingQueue<Client> clienti) {
		this.clienti = clienti;
	}

	public AtomicInteger getWaitingTime() {
		return waitingTime;
	}

	public void setWaitingTime(AtomicInteger waitingTime) {
		this.waitingTime = waitingTime;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}
}

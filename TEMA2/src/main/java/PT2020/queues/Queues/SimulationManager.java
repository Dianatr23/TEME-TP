package PT2020.queues.Queues;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SimulationManager implements Runnable{
	public int timeLimit;
	public int maxServiceTime;
	public int minServiceTime;
	public int maxArrivalTime;
	public int minArrivalTime;
 	public int numberOfServers;
	public int numberOfClients;
	public SelectionPolicy selectionPolicy = SelectionPolicy.SHORTEST_TIME;
	private Scheduler scheduler;
	private List<Client> clienti;
	public int serviceTime = 0;
	
	public SimulationManager(int a, int b, int c, int d, int e, int f, int g){
		this.clienti = new ArrayList<Client>();
		this.numberOfClients = a;
		this.numberOfServers = b;
		this.timeLimit = c;
		this.minArrivalTime = d;
		this.maxArrivalTime = e;
		this.minServiceTime = f;
		this.maxServiceTime = g;
		this.scheduler = new Scheduler(numberOfServers, c);
		for(int i=0; i<numberOfServers;i++) {
			this.scheduler.getServers().add(new Server(i, c));
			this.scheduler.getServers().get(i).start();
		}
		this.scheduler.changeStrategy(selectionPolicy);
		this.generateClients();
	}
	
	private void generateClients() {
		int arrival, service;
		Random r = new Random();
		for (int i = 0; i < numberOfClients; i++) {
			arrival = this.minArrivalTime + r.nextInt(this.maxArrivalTime - this.minArrivalTime);
			service = this.minServiceTime + r.nextInt(this.maxServiceTime - this.minServiceTime);
			this.getClienti().add(new Client(i,arrival,service));
		}
		Collections.sort(this.getClienti()); 
	}

	public void run() {
		int currentTime = 0;
		while(currentTime <= timeLimit) {
			//System.out.println("TIME: " + currentTime); 
			for(int i = 0; i<clienti.size();i++) {
				if(clienti.get(i).gettArrival() <= currentTime) {
					this.scheduler.dispatchClient(clienti.get(i));
					serviceTime = serviceTime + clienti.get(i).gettService();
					clienti.remove(i);
					i--;
				}
			}
			currentTime = currentTime + 1;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		int averageWaitingTime = 0;
		int pers = 0;
		for(int i = 0; i< numberOfServers; i++) {
			averageWaitingTime = averageWaitingTime + this.getScheduler().getServers().get(i).waitTime;
			pers = pers + this.getScheduler().getServers().get(i).getNrClient();
		}
		double avWaitTime = (double) averageWaitingTime / pers;
		//System.out.println("In this case the average waiting time is: " + pers);
		System.out.println("In this case the average waiting time is: " + avWaitTime);
		
	}
	
	public Scheduler getScheduler() {
		return scheduler;
	}

	public void setScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;
	}
	
	public List<Client> getClienti() {
		return clienti;
	}

	public void setClienti(List<Client> clienti) {
		this.clienti = clienti;
	}
	
	public static void main(String[] args) {
		 PrintStream o;
			try {
				o = new PrintStream(new File(args[1]));
				PrintStream console = System.out; 
				System.setOut(o);  
		       		} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
		List<Integer> list = new ArrayList<Integer>();
		List<String> list1 = new ArrayList<String>();
		try {
		      File myObj = new File(args[0]);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        list1.add(data);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("Erorr");
		      e.printStackTrace();
		    }
			for(int i=0; i<list1.size();i++) {
				if(i==3 || i==4) {
					String[] data = list1.get(i).split(",");
					list.add(Integer.parseInt(data[0]));
					list.add(Integer.parseInt(data[1]));
				}
				else 
					list.add(Integer.parseInt(list1.get(i)));
			}
			
		SimulationManager gen = new SimulationManager(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5), list.get(6));
		Thread t = new Thread(gen);
		t.start();
		
	}
}

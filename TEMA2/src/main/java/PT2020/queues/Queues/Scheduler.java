package PT2020.queues.Queues;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
	private List<Server> servers;
	private int nrServer;
	private Strategy strategy;
	
	public Scheduler(int nr, int t) {
		this.servers = new ArrayList<Server>();
		for(int i=0; i<nr; i++)
			servers.add(new Server(i, t));
		this.nrServer = nr;
	}
	
	public void changeStrategy(SelectionPolicy policy) {
		if(policy == SelectionPolicy.SHORTEST_QUEUE)
			strategy = new ConcreteSTrategyQueue();
		if(policy == SelectionPolicy.SHORTEST_TIME)
			strategy = new ConcreteSTrategyTime();
	}
	
	public void dispatchClient(Client c) {
		this.strategy.addClient(this.getServers(), c);
	}
	
	public List<Server> getServers() {
		return servers;
	}
	public void setServers(List<Server> servers) {
		this.servers = servers;
	}
	public int getNrServer() {
		return nrServer;
	}
	public void setNrServer(int nrServer) {
		this.nrServer = nrServer;
	}

	public Strategy getStrategy() {
		return strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
}

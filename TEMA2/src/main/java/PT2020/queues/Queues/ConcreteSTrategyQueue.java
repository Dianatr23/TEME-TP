package PT2020.queues.Queues;

import java.util.List;

public class ConcreteSTrategyQueue implements Strategy {

	public void addClient(List<Server> servers, Client c) {
		int index = 0;
		for(Server s : servers) {
			if(s.getNrClient() < servers.get(index).getNrClient()) {
				index = s.getIndice();
			}
		}	
		for(Server s : servers) {
			if(s.getIndice() == index)
				s.addClient(c);
		}
}
}

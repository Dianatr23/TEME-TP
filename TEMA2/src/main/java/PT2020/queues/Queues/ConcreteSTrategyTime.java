package PT2020.queues.Queues;

import java.util.List;

public class ConcreteSTrategyTime implements Strategy {

	public void addClient(List<Server> servers, Client c) {
			int index = 0;
			for(Server s : servers) {
				if(s.getWaitingTime().intValue() < servers.get(index).getWaitingTime().intValue()) {
					index = s.getIndice();
				}
			}	
			for(Server s : servers) {
				if(s.getIndice() == index) {
					s.addClient(c);
				}
			}
	}
}

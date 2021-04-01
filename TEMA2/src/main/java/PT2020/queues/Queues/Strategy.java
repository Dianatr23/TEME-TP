package PT2020.queues.Queues;

import java.util.List;

public interface Strategy {
	public void addClient(List<Server> servers, Client c);
}

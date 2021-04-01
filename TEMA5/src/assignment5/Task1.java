package assignment5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Task1 {
	private List<MonitoredData> data;
	
	public Task1() {
		data = new ArrayList<MonitoredData>();
	}
	
	public List<MonitoredData> read() {
		String fileName = "Activity.txt";
		File file = new File(fileName);
		try (Stream<String> lines = Files.lines(file.toPath()))
		{
			lines.map(l -> l.split("  ")).forEach(a -> data.add(new MonitoredData(a[0], a[1], a[2])));
			data.forEach(d -> {
				if(d.getActivity().substring(0, Math.min(d.getActivity().length(), 7)).equals("Leaving"))
	    			 d.setActivity("Leaving");
	    	     if(d.getActivity().substring(0, Math.min(d.getActivity().length(), 9)).equals("Toileting"))
	    	    	 d.setActivity("Toileting");
	    	     if(d.getActivity().substring(0, Math.min(d.getActivity().length(), 9)).equals("Showering"))
	    	    	 d.setActivity("Showering");
	    	     if(d.getActivity().substring(0, Math.min(d.getActivity().length(), 8)).equals("Sleeping"))
	    	    	 d.setActivity("Sleeping");
	    	     if(d.getActivity().substring(0, Math.min(d.getActivity().length(), 9)).equals("Breakfast"))
	    	    	 d.setActivity("Breakfast");
	    	     if(d.getActivity().substring(0, Math.min(d.getActivity().length(), 5)).equals("Lunch"))
	    	    	 d.setActivity("Lunch");
	    	     if(d.getActivity().substring(0, Math.min(d.getActivity().length(), 6)).equals("Dinner"))
	    	    	 d.setActivity("Dinner");
	    	     if(d.getActivity().substring(0, Math.min(d.getActivity().length(), 5)).equals("Snack"))
	    	    	 d.setActivity("Snack");
	    	     if(d.getActivity().substring(0, Math.min(d.getActivity().length(), 13)).equals("Spare_Time/TV"))
	    	    	 d.setActivity("Spare_Time/TV");
	    	     if(d.getActivity().substring(0, Math.min(d.getActivity().length(), 8)).equals("Grooming"))
	    	    	 d.setActivity("Grooming");
			});
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return data;
	}
	public List<MonitoredData> getData() {
		return data;
	}
	public void setData(List<MonitoredData> data) {
		this.data = data;
	}
}

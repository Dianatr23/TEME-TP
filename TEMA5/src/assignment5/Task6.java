package assignment5;

import static java.time.temporal.ChronoUnit.SECONDS;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Task6 {
	
	private int count;
	
	public List<String> getActivities() {
		List<String> l = new ArrayList<String>();
		l.add("Leaving");
		l.add("Sleeping");
		l.add("Breakfast");
		l.add("Lunch");
		l.add("Dinner");
		l.add("Grooming");
		l.add("Spare_Time/TV");
		l.add("Toileting");
		l.add("Showering");
		l.add("Snack");
		return l;
	}
	
	public List<MonitoredData> getActivity(List<MonitoredData> list, String activity) {
		List<MonitoredData> l = new ArrayList<MonitoredData>();
		list.forEach(a ->{
			if(a.getActivity().equals(activity)) {
				l.add(a);
			}
		} );
		return l;
	}
	
	public boolean lessThanFive(List<MonitoredData> l) {
		double procent =l.size() * 0.9;
		count = 0;
		l.forEach(l1 -> {
			long time = 0;
			String start = l1.getStartTime().substring(11, Math.min(l1.getStartTime().length(), 19));
	    	String end = l1.getEndTime().substring(11, Math.min(l1.getEndTime().length(), 19));
	    	LocalTime lt1 = LocalTime.parse(start);
	        LocalTime lt2 = LocalTime.parse(end);
	        LocalTime lt3 = LocalTime.parse("23:59:59");
	        int comp = lt1.compareTo(lt2);
	        if(comp > 0){
	        	time = lt1.until(lt3, SECONDS) + 24*3600 - lt2.until(lt3, SECONDS);
	        }else {
	        	time = lt1.until(lt2, SECONDS);
	        }
	        if(time <= 300)
	        	count++;
		});
		if(count >= procent)
			return true;
		else 
			return false;
	}
	
	public List<String> findActivities(List<MonitoredData> li){
		PrintStream o;
		try {
			o = new PrintStream(new File("task_6.txt"));
			System.setOut(o);  
	       		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		System.out.println("Activities that have more than 90% of the monitoring record with duration less than 5 minutes: ");
		List<String> list = new ArrayList<String>();
		List<String> l = getActivities();
		l.forEach(l1 ->{
			List<MonitoredData> l2 = getActivity(li, l1);
			if(lessThanFive(l2)) {
				list.add(l1);
				System.out.println(l1);
			}
		});
		return list;
	}
	
	
}

package assignment5;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static java.time.temporal.ChronoUnit.SECONDS;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;


public class Task5 {
	private long time;
	
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
	
	public HashMap<String, Long> time(List<MonitoredData> list) {
		//tipul Long pentru numarul de secunde cat dureaza o activitate
		HashMap<String, Long> map = new HashMap<String, Long>();
		PrintStream o;
		try {
			o = new PrintStream(new File("task_5.txt"));
			System.setOut(o);  
	       		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		System.out.println("The entire duration for each activity over the monitoring period: ");
		List<String> l1 = getActivities();
		int n = 0;
		while(n < 10) {
		    time = 0;
			List<MonitoredData> l = getActivity(list, l1.get(n));
			l.forEach(a -> {
				String start = a.getStartTime().substring(11, Math.min(a.getStartTime().length(), 19));
		    	String end = a.getEndTime().substring(11, Math.min(a.getEndTime().length(), 19));
		    	LocalTime lt1 = LocalTime.parse(start);
		        LocalTime lt2 = LocalTime.parse(end);
		        LocalTime lt3 = LocalTime.parse("23:59:59");
		        int comp = lt1.compareTo(lt2);
		        if(comp > 0){
		        	time = time + lt1.until(lt3, SECONDS) + 24*3600 - lt2.until(lt3, SECONDS);
		        }else {
		        	time = time + lt1.until(lt2, SECONDS);
		        }
			});
		    long h = time / 3600;
		    long m = (time - h * 3600) / 60;
			long s = time - h*3600 - m * 60;
			System.out.println(l1.get(n) + ": " + h + "h" + " " + m + "min" + " " +s + "sec");
			map.put(l1.get(n), time);
			n++;
		}
		return map;
	}
}

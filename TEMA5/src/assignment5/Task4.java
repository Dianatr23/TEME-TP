package assignment5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Task4 {
	private int le;
	private int t;
	private int sh;
	private int sl;
	private int b;
	private int lu;
	private int d;
	private int sn;
	private int sp;
	private int g;
	private int ok;
	
	public List<String> getDays(List<MonitoredData> list) {
		List<String> l = new ArrayList<String>();
		list.forEach(a ->{String str = a.getStartTime();
    		String s = str.substring(0, Math.min(str.length(), 10));
    		ok = 0;
    		l.forEach(l1 -> {
    			if(l1.equals(s)) {
    				ok = 1;
    			}
		    });
    		if(ok == 0) {
    			l.add(s);
    		}
    	});
		return l;
	}
	
	public List<MonitoredData> getTheDay(List <MonitoredData> list, String day) {
		List<MonitoredData> l = new ArrayList<MonitoredData>();
		list.forEach(a -> {if(a.getStartTime().substring(0, Math.min(a.getStartTime().length(), 10)).equals(day)) {l.add(a);}});
		return l;
	}
	
	public HashMap<String, Integer> count(List<MonitoredData> l, String start, String end, String md, int n, List<String> l1) {
		le = t = sh = sl = b = lu = d = sn = sp = g = 0;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
    	 l.forEach(a -> {
    		 String str = a.getActivity();
    	     if(str.equals("Leaving"))
    			 le++;
    	     if(str.equals("Toileting"))
    			 t++;
    	     if(str.equals("Showering"))
    			 sh++;
    	     if(str.equals("Sleeping"))
    			 sl++;
    	     if(str.equals("Breakfast"))
    			 b++;
    	     if(str.equals("Lunch"))
    			 lu++;
    	     if(str.equals("Dinner"))
    			 d++;
    	     if(str.equals("Snack"))
    			 sn++;
    	     if(str.equals("Spare_Time/TV"))
    			 sp++;
    	     if(str.equals("Grooming"))
    			 g++;
    	 }); 
    	 map.put("Leaving", le);
    	 map.put("Toileting", t);
    	 map.put("Showering", sh);
    	 map.put("Sleeping", sl);
    	 map.put("Breakfast", b);
    	 map.put("Lunch", lu);
    	 map.put("Dinner", d);
    	 map.put("Snack", sn);
    	 map.put("Spare_Time/TV", sp);
    	 map.put("Grooming", g);
    	 if((!start.equals(end)) && (n != 0)) {
	    		Integer integer = (Integer) map.get(md);
	    		map.remove(md);
	    		map.put(md, integer + 1);
	    }
    	 System.out.println("Day " + l1.get(n));
    	 System.out.println();
		 System.out.println("Leaving " + map.get("Leaving"));
		 System.out.println("Toileting " + map.get("Toileting"));
		 System.out.println("Showering " +map.get("Showering")); 
		 System.out.println("Sleeping " + map.get("Sleeping"));
		 System.out.println("Breakfast " + map.get("Breakfast")); 
		 System.out.println("Lunch " + map.get("Lunch"));
		 System.out.println("Dinner " + map.get("Dinner")); 
		 System.out.println("Snack " +map.get("Snack")); 
		 System.out.println("Spare_Time/Tv " + map.get("Spare_Time/TV"));
		 System.out.println("Grooming " + map.get("Grooming"));
		 System.out.println();
    	 return map;
	}
	
	public HashMap<Integer, HashMap<String, Integer>> count(List<MonitoredData> list, int days) {
		PrintStream o;
		try {
			o = new PrintStream(new File("task_4.txt")); 
			System.setOut(o);  
	       		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		System.out.println("How many times each activity has appeared for each day over the monitoring period :");
		String md = " ";
		String start = " ";
		String end = " ";
		HashMap<Integer, HashMap<String, Integer>> map = new HashMap<Integer, HashMap<String, Integer>>(); 
		List<String> l = this.getDays(list);
    	int n = 0;
    	while(n < days) {
	    	List<MonitoredData> l1 = this.getTheDay(list, l.get(n));
	    	HashMap<String, Integer> m = new HashMap<String, Integer>();
	    	m = count(l1, start, end, md, n, l);
	    	start = l1.get(l1.size()-1).getStartTime().substring(0, Math.min(l1.get(l1.size()-1).getStartTime().length(), 10));
	    	end = l1.get(l1.size()-1).getEndTime().substring(0, Math.min(l1.get(l1.size()-1).getEndTime().length(), 10));
	    	md = l1.get(l1.size()-1).getActivity();
	    	map.put(n, m);
	    	n++;
    	}
		return map;
	}
}

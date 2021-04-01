package assignment5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;

public class Task3 {
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
	
	
	public HashMap<String, Integer> count(List<MonitoredData> l) {
		PrintStream o;
		try {
			o = new PrintStream(new File("task_3.txt"));
			System.setOut(o);  
	       		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		System.out.println("How manu times each activity appeared over the entire monitoring period: ");
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
		
		 System.out.println("Leaving " + le);
		 System.out.println("Toileting " + t);
		 System.out.println("Showering " + sh); 
		 System.out.println("Sleeping " + sl);
		 System.out.println("Breakfast " + b); 
		 System.out.println("Lunch " + lu);
		 System.out.println("Dinner " + d); 
		 System.out.println("Snack " +sn); 
		 System.out.println("Spare_Time/Tv " + sp);
		 System.out.println("Grooming " + g);
		 System.out.println();
		     	 
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
    	 
    	 return map;
	}
}

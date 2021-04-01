package assignment5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
     private int distinctDays;
     private int ok;
     
     public void count(List<MonitoredData> list) {
    	 PrintStream o;
			try {
				o = new PrintStream(new File("task_2.txt")); 
				System.setOut(o);  
		       		} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
		 System.out.println("The distinct days that appear in the monitoring data: ");
    	 List<String> l = new ArrayList<String>();
    	 list.forEach(b -> { 
    		 	String str = b.getStartTime();
    		 	String s = str.substring(0, Math.min(str.length(), 10));
    		 	ok = 0;  
    		 	l.forEach(a -> {if(a.equals(s)) { ok++;}});
    		 	if(ok == 0) {
        			this.distinctDays++;
        			l.add(s);
        		}
         });
    	 System.out.println("Distinct days: " + this.distinctDays);
    	 System.out.println();
     }
     
     public int getDistinctDays() {
    	 return this.distinctDays;
     }
}

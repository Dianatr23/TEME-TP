package assignment5;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Start {
	private static Task1 r;
	private static Task2 t2;
	private static Task3 t3;
	private static Task4 t4;
	private static Task5 t5;
	private static Task6 t6;

	public static void main(String[] args) {
		
		HashMap<String, Integer> map3 = new HashMap<String, Integer>();
		HashMap<Integer, HashMap<String, Integer>> map4 = new HashMap<Integer, HashMap<String, Integer>>();
		HashMap<String, Long> map5 = new HashMap<String, Long>();
		List<String> list1 = new ArrayList<String>();
	
		//TASK1: citire din fisier + formarea obiecteleor de tip MonitoredData + dispunerea acestora intr-o lista
		r = new Task1();
		r.read();
		List<MonitoredData> list = r.getData();
		//TASK2: numararea zilelor disticte 
		t2 = new Task2();
		t2.count(list);
	
		//TASK3: numarul de aparitii pentru fiecare activitate
		t3 = new Task3();
		map3 = t3.count(list);
	
		//TASK4: numarul de activititi/zile
		t4 = new Task4();
		map4 = t4.count(list, t2.getDistinctDays());
		
		//TASK5: durata fiecarei activitati pe parcursul zilelor monotorizate
		t5 = new Task5();
		map5 = t5.time(list);
		
		//TASK6: activitatile cu durata de sub 5 min in peste 90% din inregistrari
		t6 = new Task6();
		list1 = t6.findActivities(list);
	}

}

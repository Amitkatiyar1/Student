package comparatorAndComparable;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class HashmapComprator {

	public static void main(String[] args) {
		Map<Integer ,String> map =  new HashMap<>();
		map.put(101, "Amit");
		map.put(102, "katiyar");
		map.put(103, "boy");
		map.put(104, "doctor");
		System.out.println(map);
		
		Set<Entry<Integer, String>> entrySet = map.entrySet();
		
		LinkedList<Map.Entry<Integer, String>> link = new LinkedList<>(entrySet);
		Collections.sort(link, new Comparator<Entry<Integer,String>>() {

			@Override
			public int compare(Entry<Integer, String> o1, Entry<Integer, String> o2) {
				// TODO Auto-generated method stub
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		for(Map.Entry<Integer, String> hj:link) {
			System.out.println(hj.getKey()+" " +hj.getValue());
		}
		

	}

}

package comparatorAndComparable;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.Comparator;

public class SortExample {

	public static void main(String[] args) {
		ArrayList<Emp> emps = new ArrayList<>();
		emps.add(new Emp(  "Amit", "674", 12));
		emps.add(new Emp(  "sidhant", "6734", 4));
		emps.add(new Emp( "pradeep", "67457", 6));
		System.out.println(emps);
		Collections.sort(emps,new Idcomparator());
		//comparable
		System.out.println(emps);
		ArrayList<Emp> emps1 = new ArrayList<>(emps);
		Collections.sort(emps1,new NameComparator());
		System.out.println(emps1);
	}

}

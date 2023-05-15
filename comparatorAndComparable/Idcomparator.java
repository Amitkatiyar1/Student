package comparatorAndComparable;

import java.util.Comparator;

public class Idcomparator implements Comparator<Emp>{

	public static void main(String[] args) {
		

	}

	@Override
	public int compare(Emp o1, Emp o2) {
		
		return o1.getempid()-o2.getempid();
	}

}

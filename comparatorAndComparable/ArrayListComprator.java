package comparatorAndComparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



	class Student{
		int id;
		String name;
		String value;


			public Student(int id, String name, String value) {
				this.id=id;
				this.name=name;
				this.value=value;
				
				
			
		}

			@Override
			public String toString() {
				return "Student [id=" + id + ", name=" + name + ", value=" + value + "]";
			}	
			
		}	

		/// sort by value
		class Sortbyvalue implements Comparator<Student>{
		@Override
		public int compare(Student o1, Student o2) {
			
			return o1.value.compareTo(o2.value);
		}
		}
		//sort by name
		class Sortbyname implements Comparator<Student>{
			@Override
			public int compare(Student o1, Student o2) {
				
				return o1.name.compareTo(o2.name);
			}
		}
		

		public class ArrayListComprator {

			public static void main(String[] args) {
				ArrayList<Student> list = new ArrayList<>();
				list.add(new Student(11,"Amit","katiyar"));
				list.add(new Student(11,"pradeep","nishad"));
				list.add(new Student(11,"boy","yu"));
				list.add(new Student(11,"dear","Amit"));
				
				Collections.sort(list,new Sortbyvalue());
				for(int i=0;i<list.size();i++) {
					System.out.println(list.get(i));
				}
				//sort by name
				Collections.sort(list,new Sortbyname());
				for(int i=0;i<list.size();i++) {
					System.out.print("sort by name"+list.get(i));
				}
			}
}

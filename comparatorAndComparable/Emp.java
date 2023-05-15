package comparatorAndComparable;

public class Emp{

	private String name;
	private String phone;
	private int empid;
	
	
	
	public Emp(String name,String phone,int empid) {
		this.name=name;
		this.phone=phone;
		this.empid = empid; 
	}
	
	public String getname() {
		return name;
	}
	
	public String getphone() {
		return phone;
	}
	public int getempid() {
		return empid;
	}

	@Override
	public String toString() {
		return "Emp [name=" + name + ", phone=" + phone + ", empid=" + empid + "]";
	}

	
	
	
	
	
	
	
	
}

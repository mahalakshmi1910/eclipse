package springdb;

public class Employee {
	private int id;  
	private String name;  
	private float salary;  
	Employee(){}
	Employee(int id,String name,float sal)
	{
		this.id=id;
		this.name=name;
		this.salary=sal;
	}
	public void setId(int id)
	{
		this.id=id;
	}
	public void setName(String name)
	{
		this.name=name;
		
	}
	public void setSalary(float salary)
	{
		this.salary=salary;
	}
	public int getId()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	public float getSalary()
	{
		return salary;
	}

}

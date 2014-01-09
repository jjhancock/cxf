package domain;

public class Foo
{
	private String name;
	private String age;

	public Foo()
	{
		super();
	}
	
	public static Foo newInstance(String name, String age)
	{
		Foo result = new Foo();
		result.setName(name);
		result.setAge(age);
		return result;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAge()
	{
		return age;
	}

	public void setAge(String age)
	{
		this.age = age;
	}

}

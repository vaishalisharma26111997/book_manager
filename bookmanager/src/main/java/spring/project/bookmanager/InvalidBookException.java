package spring.project.bookmanager;

public class InvalidBookException extends RuntimeException 
{
	public  InvalidBookException(String name)
	{
		super(name);
	}


}

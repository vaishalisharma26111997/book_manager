package spring.project.bookmanager;

public class InvalidIdException extends RuntimeException {
	public  InvalidIdException(Integer id)
	{
		super("book not present with given"+id);
	}

	
}

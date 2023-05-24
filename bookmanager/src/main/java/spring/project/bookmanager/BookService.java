package spring.project.bookmanager;

import java.util.List;
import java.util.Optional;

public class BookService {
 
	BookRepository bookRepository=new  BookRepository();
	
	public String  addBook(BOOK book)
	{
	   bookRepository.add(book);
		
		return "book added successfully";
	}

	public BOOK getBook(Integer id) {
		Optional<BOOK> bookOptional=bookRepository.getBookbyId(id);
		if(bookOptional.isPresent())
		 return bookOptional.get();
		else if(bookOptional.isEmpty())
		  throw new InvalidIdException(id);
		return 	bookOptional.get();
	}

	public List<BOOK> getAllBooks() {
		
		return bookRepository.getAll();
	}

	public String deleteBook(Integer id) {
		bookRepository.deletebook(id);
		return "book deleted";
	}

	public BOOK getbookbyName(String name) throws InvalidBookException{

	 List<BOOK>books=bookRepository.getAll();
	 for(BOOK book:books)
	 {
		 if(book.getTitle().equals(name))
			 return book;
	 }
	 throw new InvalidBookException("book name invalid");
	
	}

	public BOOK updateBookbyPage(Integer id, Integer pages) throws InvalidIdException{
		BOOK book=getBook(id);
		book.setPages(pages);
		addBook(book);
		return book;
	}
}

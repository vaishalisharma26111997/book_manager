package spring.project.bookmanager;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
   
     BookService bookService=new BookService();
	
    @PostMapping("/add-book")
	public ResponseEntity <String> addBook(@RequestBody BOOK book)
	{ try {
		//bookData.put(book.getId(),book);
    	String msg=bookService.addBook(book);
	  return new  ResponseEntity<>(msg,HttpStatus.CREATED);
	}
	catch(Exception ex){
		return new  ResponseEntity<>("book can not be added",HttpStatus.BAD_REQUEST);
	    }
	}
    
    @GetMapping("/get-book")
    public ResponseEntity <BOOK> getBook(@RequestParam Integer id)
    {try {
    	BOOK book=new BOOK();
    	book=bookService.getBook(id);
    	return new  ResponseEntity<>(book,HttpStatus.OK);
    }
    catch(InvalidIdException ex)
    {
    	System.out.println("book not found");
    	return new  ResponseEntity<>(null,HttpStatus.NOT_FOUND);
     }
    }
    
    @GetMapping("/get-all-books")
    public ResponseEntity<List<BOOK>> getAllBook()
    {try {
    	return new  ResponseEntity<>(bookService.getAllBooks(),HttpStatus.OK);
    }
    catch(InvalidBookException ex )
    {
    	return new  ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }
    }
    
    @GetMapping("/get-bookby-name/{name}")
    public ResponseEntity<BOOK> getBookByName(@PathVariable String name)
    { try {
    	return new ResponseEntity<>(bookService.getbookbyName(name),HttpStatus.OK);
    }
    	catch(InvalidBookException ex )
        {
        	return new  ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
    
    @PutMapping("/update-bookby-pages")
    public ResponseEntity<BOOK> updateBookbyPages(@RequestParam Integer id,@RequestParam Integer pages)
    {try {
    	return new ResponseEntity<>(bookService.updateBookbyPage(id,pages),HttpStatus.OK);
    }
    catch(InvalidBookException ex )
    {
    	return new  ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }
    
    }

    @DeleteMapping("/delete-bookby-Id/{id}")
    public  ResponseEntity<String> deleteBookbyId(@PathVariable Integer id)
    {try {
    	
    
    	String msg=bookService.deleteBook(id);
    	return new ResponseEntity<>(msg,HttpStatus.OK);
    }
    catch(InvalidBookException ex )
    {
    	return new  ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }
}
}
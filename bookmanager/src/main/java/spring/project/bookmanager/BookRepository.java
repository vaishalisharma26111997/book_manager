package spring.project.bookmanager;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class BookRepository {

	 private Map<Integer,BOOK> bookData=new HashMap<>();

	public void add(BOOK book) {
		bookData.put(book.getId(), book);
	}

	public Optional<BOOK> getBookbyId(Integer id) {
	
		if(bookData.containsKey(id))
			return Optional.of(bookData.get(id));
		else
			return Optional.empty();
	}

	public List<BOOK> getAll() {
	return new ArrayList<>(bookData.values());	
	}

	public void deletebook(Integer id) {
		if(bookData.containsKey(id))
		  bookData.remove(id);
		
	}

	
	
}

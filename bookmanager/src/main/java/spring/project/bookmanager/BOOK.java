package spring.project.bookmanager;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BOOK {
	private Integer id;
	private String author;
	private String title;
	private Integer pages;


public BOOK() {
		super();
	}
public BOOK(Integer id, String author, String title, Integer pages) {
		super();
		this.id = id;
		this.author = author;
		this.title = title;
		this.pages = pages;
	}
	
}

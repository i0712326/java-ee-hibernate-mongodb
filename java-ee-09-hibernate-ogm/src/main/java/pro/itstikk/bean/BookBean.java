package pro.itstikk.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import pro.itstikk.dao.BookDao;
import pro.itstikk.entity.Book;

@Named("bookBean")
@RequestScoped
public class BookBean {
	private Book book;
	private List<Book> books;
	
	@EJB
	private BookDao bookDao;
	
	@PostConstruct
	public void init() {
		book= new Book();
	}
	
	/**
	 * action method
	 * @return
	 */
	public String save() {
		bookDao.save(book);
		return "result.xhtml";
		
	}
	public String find() {
		books = bookDao.getAllBooks();
		return "resultList.xhtml";
	}

	/**
	 * setter and getter for objects
	 * @return
	 */
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
}

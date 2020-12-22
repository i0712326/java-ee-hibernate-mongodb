package pro.itstikk.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pro.itstikk.entity.Book;

@Stateless
public class BookDao {
	@PersistenceContext
	private EntityManager em;
	
	public void save(Book book) {
		em.persist(book);
	}
	
	public List<Book> getAllBooks(){
		TypedQuery<Book> query = em.createQuery("FROM Book b",Book.class);
        List<Book> list = query.getResultList();
        return list;
	}
	
	
}

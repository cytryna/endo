package com.diligentia.dao;

import com.diligentia.entity.Book;
import com.diligentia.entity.MemberEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class BookDao {

    private static int i = 0;
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
    //    @PersistenceContext
    private EntityManager em;

    public BookDao() {
        em = entityManagerFactory.createEntityManager();
    }

    public List<MemberEntity> getAllMembers() {
        Query query = em.createQuery("SELECT e FROM MemberEntity e");
        return (List<MemberEntity>) query.getResultList();
    }

    public void persistBook(Book book) {
        em.getTransaction().begin();
        em.merge(book);//żeby działało rownież w edycji, normalnie należy użyć persist
        em.getTransaction().commit();
    }

    public void deleteBook(Book book) {
        em.getTransaction().begin();
//        em.setProperty(":id", book.getId());
//        em.createQuery("DELETE FROM Book WHERE id = :id").executeUpdate();
//        em.remove(book);
        em.remove(em.contains(book) ? book : em.merge(book));
        em.getTransaction().commit();
    }
    public void updateBook(Book book) {
        em.merge(book);
    }

    public Book getBookDetails(Long bookId) {
        //w przypadku pobierania powi�zanych obiekt�w wymaganych dla widoku szczeg��w
        //nalezy uzyc opcji 'left outer join fetch' w zapytaniu
        TypedQuery<Book> q = em.createQuery("from Book where id = :id", Book.class);
        q.setParameter("id", bookId);
        Book res = q.getSingleResult();
        return res;
    }

}

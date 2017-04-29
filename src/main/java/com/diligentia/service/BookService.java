package com.diligentia.service;

import com.diligentia.dao.BookDao;
import com.diligentia.entity.Book;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class BookService implements Serializable {

//    @Inject
    private BookDao bookDaoDAO;

    public BookService() {
        bookDaoDAO = new BookDao();
    }

    //    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Book> getAllBooks() {
        return bookDaoDAO.getAllBooks();
    }


//    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void persistBook(Book book) {
        bookDaoDAO.persistBook(book);
    }

    public void deleteBook(Book book) {
        bookDaoDAO.deleteBook(book);
    }
//
//    @TransactionAttribute(TransactionAttributeType.REQUIRED)
//    public void updateBook(Book book) {
//        bookDaoDAO.updateBook(book);
//    }
//

//    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Book getBookDetails(Long bookId) {
        return bookDaoDAO.getBookDetails(bookId);
    }

}

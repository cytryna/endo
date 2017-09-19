package com.diligentia.service;

import com.diligentia.Member;
import com.diligentia.dao.BookDao;
import com.diligentia.entity.Book;
import com.diligentia.entity.MemberEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class EndoService implements Serializable {

    @Autowired
    private BookDao bookDaoDAO;

    public EndoService() {
        bookDaoDAO = new BookDao();
    }

//    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Member> getAllMembers() {
        List<Member> members = new ArrayList<>();
        for (int i = 0; i <bookDaoDAO.getAllMembers().size(); i++) {
            members.add(toMember(bookDaoDAO.getAllMembers().get(i)));
        }
        return members;
    }

    private Member toMember(MemberEntity memberEntity) {
        return new Member(memberEntity.getName(), memberEntity.getScore());
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

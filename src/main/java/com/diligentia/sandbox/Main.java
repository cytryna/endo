package com.diligentia.sandbox;

import com.diligentia.entity.Autor;
import com.diligentia.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();
    private final static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//    private List<Author> authors;

    public static void main(String[] args) {
        new Main().start();
    }

    private void start() {
        try {
            Autor authorTemorary1;
//            Book bookTemporary;

            entityManager.getTransaction().begin();

            authorTemorary1 = new Autor("Ryszard Mickiewicz");//stworzenie autora w pamieci
            entityManager.persist(authorTemorary1);//zapis do bazy
//            saveBook("Pan Tadeusz", authorTemorary1);
//            saveBook("Sonety krymskie", authorTemorary1);
//
//            authorTemorary1 = new Autor("Henryk Sienkiewicz");//stworzenie autora w pamieci
//            entityManager.persist(authorTemorary1);//zapis do bazy
//            saveBook("Krzyżacy", authorTemorary1);
//            saveBook("Potop", authorTemorary1);
//            saveBook("Pan Wołodyjowski", authorTemorary1);
//            saveBook("Ogniem i mieczem", authorTemorary1);
//
//
//            authorTemorary1 = new Autor("Bolesław Prus");//stworzenie autora w pamieci
//            entityManager.persist(authorTemorary1);//zapis do bazy
//            saveBook("Lalka", authorTemorary1);
//            saveBook("Kamizelka", authorTemorary1);
//            saveBook("Faraon", authorTemorary1);
//            saveBook("Anielka", authorTemorary1);
//
//            authorTemorary1 = new Autor("Władysław Raymont");//stworzenie autora w pamieci
//            entityManager.persist(authorTemorary1);//zapis do bazy
//            saveBook("Chłopi", authorTemorary1);
//            saveBook("Bunt", authorTemorary1);
//            saveBook("Ziemia obiecana", authorTemorary1);
//
//            authorTemorary1 = new Autor("Eliza Orzeszkowa");//stworzenie autora w pamieci
//            entityManager.persist(authorTemorary1);//zapis do bazy
//            saveBook("Obrazek z lat głodowych", authorTemorary1);
//            saveBook("Ostatnia miłość", authorTemorary1);
//            saveBook("Na dnie sumienia", authorTemorary1);
//
//            authorTemorary1 = new Autor("Aleksander Fredro");//stworzenie autora w pamieci
//            entityManager.persist(authorTemorary1);//zapis do bazy
//            saveBook("Zemsta", authorTemorary1);
//            saveBook("Mąż i żona", authorTemorary1);
//            saveBook("Wychowanka", authorTemorary1);
//
//            authorTemorary1 = new Autor("William Szekspir");//stworzenie autora w pamieci
//            entityManager.persist(authorTemorary1);//zapis do bazy
//            saveBook("Romeo i Julia", authorTemorary1);
//            saveBook("Hamlet", authorTemorary1);
//            saveBook("Król Lear", authorTemorary1);
//            saveBook("Sen nocy letniej", authorTemorary1);
//            saveBook("Burza", authorTemorary1);
//
//            authorTemorary1 = new Autor("Molier");//stworzenie autora w pamieci
//            entityManager.persist(authorTemorary1);//zapis do bazy
//            saveBook("Skąpiec", authorTemorary1);
//            saveBook("Natrętny", authorTemorary1);
//
//            authorTemorary1 = new Autor("Aleksander Kamiński");//stworzenie autora w pamieci
//            entityManager.persist(authorTemorary1);//zapis do bazy
//            saveBook("Kamienie na szaniec", authorTemorary1);
//            saveBook("Antek Cwaniak", authorTemorary1);
//            saveBook("Narodziny dzielności", authorTemorary1);
//
//            authorTemorary1 = new Autor("Antoine de Saint Exupéry");//stworzenie autora w pamieci
//            entityManager.persist(authorTemorary1);//zapis do bazy
//            saveBook("Mały książe", authorTemorary1);
//
//            authorTemorary1 = new Autor("Juliusz Słowacki");//stworzenie autora w pamieci
//            entityManager.persist(authorTemorary1);//zapis do bazy
//            saveBook("Balladyna", authorTemorary1);
//
//            authorTemorary1 = new Autor("Stanisław Wyspiański");//stworzenie autora w pamieci
//            entityManager.persist(authorTemorary1);//zapis do bazy
//            saveBook("Wesele", authorTemorary1);
//
//            authorTemorary1 = new Autor("Stefan Żeromski");//stworzenie autora w pamieci
//            entityManager.persist(authorTemorary1);//zapis do bazy
//            saveBook("Ludzie bezdomni", authorTemorary1);
//            saveBook("Przedwiośnie", authorTemorary1);

//            List<User> users = new ArrayList<>();
//            users.add(new User("radek@gmail.com", "radek", "radek"));
//            users.stream().forEach(user -> entityManager.persist(user));


//            Transaction transaction = new Transaction();
//            transaction.setBook(books.get(2));
//            transaction.setUser(users.get(0));
//            transaction.setDateFrom(new Date());
//            transaction.setTransactionType(TransactionType.RESERVATION);

//            authors.stream().forEach(author -> entityManager.persist(author));
//            books.stream().forEach(bookItem -> {
//                entityManager.persist(bookItem);
//            });
//            entityManager.persist(transaction);

            entityManager.getTransaction().commit();

            entityManager.close();
            entityManagerFactory.close();

            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    private void saveBook(String title, Autor authorTemorary1) {
//        Book bookTemporary;
//        bookTemporary = new Book(title);//stworzenei książki w pamięci
//        bookTemporary.setAutor(authorTemorary1);
//        entityManager.persist(bookTemporary);//zapias do bazy
//    }

//    private Book createBook(String title) {
//        Book book = new Book(title);
//        book.getAuthors().add(getRandomAutor());
//        return book;
//    }
//
//    private static Date stringToDate(String testDate) throws ParseException {
//        return formatter.parse(testDate);
//    }

//    public Author getRandomAutor() {
//        Random r = new Random();
//        int high = authors.size();
//        return authors.get(r.nextInt(high));
//    }

}
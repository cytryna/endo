package com.diligentia.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


//@Entity
public class Book {

//    @Id
//    @GeneratedValue
    private long id;
    private String title;
    private Autor autor;
    private int numberPages;
    private Date dateRelease;

    public Book(String title) {
        this.title = title;
    }


    //    @OneToOne
//    @JoinColumn(name = "adressId")
//    private Autor autor;
//    private Date dateInserted;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(Date dateRelease) {
        this.dateRelease = dateRelease;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }
}

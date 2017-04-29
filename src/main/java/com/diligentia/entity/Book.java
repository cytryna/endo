package com.diligentia.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class Book {

    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String autorFirstName;
    private String autorLastName;
    private int numberPages;
    private Date dateRelease;


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

    public String getAutorFirstName() {
        return autorFirstName;
    }

    public void setAutorFirstName(String autorFirstName) {
        this.autorFirstName = autorFirstName;
    }

    public String getAutorLastName() {
        return autorLastName;
    }

    public void setAutorLastName(String autorLastName) {
        this.autorLastName = autorLastName;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }
}

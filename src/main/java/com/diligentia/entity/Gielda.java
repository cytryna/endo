package com.diligentia.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Gielda
{
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private Date data;
    private int kursOtwarcia;
    private int kursZamkniecia;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getKursOtwarcia() {
        return kursOtwarcia;
    }

    public void setKursOtwarcia(int kursOtwarcia) {
        this.kursOtwarcia = kursOtwarcia;
    }

    public int getKursZamkniecia() {
        return kursZamkniecia;
    }

    public void setKursZamkniecia(int kursZamkniecia) {
        this.kursZamkniecia = kursZamkniecia;
    }
}

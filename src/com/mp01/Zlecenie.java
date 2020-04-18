package com.mp01;

import java.io.*;
import java.util.Date;

public class Zlecenie extends ObjectPlus implements Serializable{

    Long id;
    String status="w trakcie realizacji";
    Date dataUtworzeniaZlecenia;
    Date dataZrealizowania=null;
    Przesylka przesylka;

    public Zlecenie(Przesylka przesylka){
        this.przesylka=przesylka;
        this.dataUtworzeniaZlecenia=new Date();
        addToExtent(this.getClass(),this);
    }

    public static void showThisExtent() {
        showExtent(Zlecenie.class);
    }

    public void zmianaStatusuZlecenia(String status){
        this.status = status;
    }

    public void zmianaStatusuZlecenia(String status, Date date){
        this.status = status;
        setDataZrealizowania(date);
    }

    public void setDataZrealizowania(Date dataZrealizowania) {
        this.dataZrealizowania = dataZrealizowania;
    }

    @Override
    public String toString() {
        return "Zlecenie{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", dataWykonania=" + dataZrealizowania +
                ", przesylka=" + przesylka +
                '}';
    }
}

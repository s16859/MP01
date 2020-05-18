package com.mp01;

import java.io.*;
import java.util.Date;

public class Zlecenie extends ObjectPlusPlus implements Serializable{

    private Long id;
    private String status="w trakcie realizacji";
    private Date dataUtworzeniaZlecenia;
    private Date dataZrealizowania=null;
    private Przesylka przesylka;
    private Kurier kurier;

    public Zlecenie(Przesylka przesylka){

        this.przesylka=przesylka;
        this.dataUtworzeniaZlecenia=new Date();
        addToExtent(this.getClass(),this);
    }

    public void setKurier(Kurier kurier){
        if(this.kurier == null){
            this.kurier=kurier;
            kurier.dodajZlecenie(this);
        }
        else if(this.kurier!=kurier){
            this.kurier.usunZlecenie(this);
            this.kurier=kurier;
            kurier.dodajZlecenie(this);
        }
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
                ", dataUtworzeniaZlecenia=" + dataUtworzeniaZlecenia +
                ", dataZrealizowania=" + dataZrealizowania +
                ", kurier=" + kurier.getId() +
                '}';
    }
}

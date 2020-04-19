package com.mp01;

public class Adres extends ObjectPlus{

    Long id;
    //Long klientId;
    String kraj,
    region,
    miasto,
    ulica,
    numer,
    kodPocztowy;

    public Adres(Long id,String miasto, String ulica, String numer,String kodPocztowy){
        this.id=id;
        this.miasto=miasto;
        this.ulica=ulica;
        this.numer=numer;
        this.kodPocztowy=kodPocztowy;
        addToExtent(this.getClass(),this);
    }

    public static void showThisExtent() {
        showExtent(Adres.class);
    }
}

package com.mp01;

public class Adres extends ObjectPlus{

    Long id;
    Long klientId;
    String kraj,
    region,
    miasto,
    ulica,
    numer,
    kodPocztowy;

    public Adres(){
        addToExtent(this.getClass(),this);
    }

    public static void showThisExtent() {
        showExtent(Adres.class);
    }
}

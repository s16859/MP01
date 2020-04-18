package com.mp01;

import java.util.ArrayList;
import java.util.List;

public class Samochod extends ObjectPlus{

    Long id;
    String typ;
    String marka;
    int ladownosc;
    int pojemnosc;
    String nrRejestracyjny;
    List<Long> przesylkiWsamochodzie = new ArrayList<>();

    public Samochod(){
        addToExtent(this.getClass(),this);
    }

    public static void showThisExtent() {
        showExtent(Samochod.class);
    }

    public void dodajPrzesylke(Long id){
        przesylkiWsamochodzie.add(id);
    }

    public void usunPrzesylke(Long id){
        przesylkiWsamochodzie.remove(id);
    }



}

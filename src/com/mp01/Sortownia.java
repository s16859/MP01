package com.mp01;

import java.util.ArrayList;
import java.util.List;

public class Sortownia extends ObjectPlus{

    Long id;
    List<Long> przesylkiWsortwni = new ArrayList<>();

    public Sortownia(){
        addToExtent(this.getClass(),this);
    }

    public static void showThisExtent() {
        showExtent(Sortownia.class);
    }

    public void dodajPrzesylke(Long id){
        przesylkiWsortwni.add(id);
    }

    public void usunPrzesylke(Long id){
        przesylkiWsortwni.remove(id);
    }
}

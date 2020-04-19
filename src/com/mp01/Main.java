package com.mp01;

import java.util.Date;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {

        ObjectPlus.loadExtent();

        Adres a1 = new Adres(1L,"Warszawa","Spokojna","34","08-200");
        Adres a2 = new Adres(2L,"Kraków","Centralna","99","11-520");

        new KlientFirma(1L,"606231456","Krzak","5343",a1);
        new KlientOsobaFizyczna(2L,"606943293","Tomasz Kowalski",a2);
        Klient.showThisExtent();

        Kurier k1 = new Kurier(1L,"Adam Nowak","606123123");
        Kurier.getByIndex(Kurier.class).get(0).dodajZlecenie(1L);
        Kurier.showThisExtent();


       Przesylka.nadaniePrzesylki(1L,1L,2L,"pobraniowa",19,23,43,22);
       Przesylka.nadaniePrzesylki(2L,2L,1L,"zwykła",6,10,5,4);
       //Przesylka.showThisExtent();

       //Zlecenie.showThisExtent();



       Przesylka.getByIndex(Przesylka.class).get(0).anulowaniePrzesylki();
       Przesylka.usuniecieAnulowanychPrzesylek();
       Przesylka.showThisExtent();

       Zlecenie.getByIndex(Zlecenie.class).get(0).zmianaStatusuZlecenia("dostarczona",new Date());
       Zlecenie.showThisExtent();

    }
}

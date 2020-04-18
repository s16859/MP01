package com.mp01;

import java.util.Date;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {



        ObjectPlus.loadExtent();

        new KlientFirma(1L,"606231456","Krzak","5343");
        new KlientOsobaFizyczna(2L,"606943293","Tomasz Kowalski");
        Klient.showThisExtent();

        Kurier k1 = new Kurier(1L,"Adam Nowak","606123123");
        Kurier.showThisExtent();


       Przesylka.nadaniePrzesylki(1L,1L,2L,"pobraniowa",19,23,43,22);
       Przesylka.showThisExtent();


       Zlecenie.showThisExtent();

    }
}

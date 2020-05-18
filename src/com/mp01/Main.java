package com.mp01;

import java.util.Date;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {

        ObjectPlus.loadExtent();

        //Adres a1 = new Adres(1L,"Warszawa","Spokojna","34","08-200");
        //Adres a2 = new Adres(2L,"Kraków","Centralna","99","11-520");

        Przesylka.nadaniePrzesylki(1L,"pobraniowa",19,23,43,22);
        Przesylka.nadaniePrzesylki(2L,"zwykła",6,10,5,4);

        Sortownia sor1=new Sortownia(1L);
        Sortownia sor2=new Sortownia(2L);
        sor1.addMovieQualif(Przesylka.getByIndex(Przesylka.class).get(0));
        sor1.addMovieQualif(Przesylka.getByIndex(Przesylka.class).get(1));

        System.out.println(Przesylka.getByIndex(Przesylka.class).get(0).toString());

        Klient kl1 = new KlientFirma(1L,"606231456","Krzak","5343");
        Klient kl2 = new KlientOsobaFizyczna(2L,"606943293","Tomasz Kowalski");
        try {
            Adres.createAdres(kl1,1L,"Warszawa","Spokojna","34","08-200");
            Adres.createAdres(kl1,2L,"Kraków","Centralna","99","11-520");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(kl1.toString());



        Kurier k1 = new Kurier(1L,"Adam Nowak","606123123");
        //Kurier.getByIndex(Kurier.class).get(0).dodajZlecenie(1L);




 /*
        Przesylka.getByIndex(Przesylka.class).get(0).setNadawca(kl1);
        Przesylka.getByIndex(Przesylka.class).get(0).setAdresat(kl2);

        Przesylka.getByIndex(Przesylka.class).get(1).setNadawca(kl2);
        Przesylka.getByIndex(Przesylka.class).get(1).setAdresat(kl1);

        //System.out.println(Przesylka.getByIndex(Przesylka.class).get(0).toString());
        System.out.println(kl2.toString());




       Przesylka.getByIndex(Przesylka.class).get(0).anulowaniePrzesylki();
       Przesylka.usuniecieAnulowanychPrzesylek();
       Przesylka.showThisExtent();



       Zlecenie.getByIndex(Zlecenie.class).get(0).zmianaStatusuZlecenia("dostarczona",new Date());
       Zlecenie.showThisExtent();
       */
    }
}

package com.mp01;

import java.util.Date;

public abstract class Klient extends ObjectPlus{

    Long id;
    String daneKontaktowe;
    Adres adres;

    Klient(Long id,String daneKontaktowe, Adres adres){
        this.id=id;
        this.daneKontaktowe=daneKontaktowe;
        this.adres=adres;
    }

    public static void showThisExtent() {
        showExtent(Klient.class);
    }

    @Override
    public String toString() {
        return "Klient{" +
                "id=" + id +
                ", daneKontaktowe='" + daneKontaktowe + '\'' +
                '}';
    }
}

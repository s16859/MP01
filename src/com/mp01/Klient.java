package com.mp01;

import java.util.Date;

public abstract class Klient extends ObjectPlus{

    Long id;
    String daneKontaktowe;

    Klient(Long id,String daneKontaktowe){
        this.id=id;
        this.daneKontaktowe=daneKontaktowe;
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

package com.mp01;

public class KlientFirma extends Klient {

    String nazwa,
           regon;


    public KlientFirma(Long id,String daneKontaktowe,String nazwa,String regon, Adres adres){
        super(id,daneKontaktowe,adres);
        this.nazwa=nazwa;
        this.regon=regon;
        addToExtent(Klient.class,this);
    }

    @Override
    public String toString() {
        return "KlientFirma{" +
                "nazwa='" + nazwa + '\'' +
                ", regon='" + regon + '\'' +
                ", daneKontaktowe='" + daneKontaktowe + '\'' +
                ", id=" + id +
                '}';
    }
}

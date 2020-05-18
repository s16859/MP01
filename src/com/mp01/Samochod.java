package com.mp01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Samochod extends ObjectPlusPlus{

    private Long id;
    private String typ;
    private String marka;
    private int ladownosc;
    private int pojemnosc;
    private String nrRejestracyjny;
    private List<KurierSamochod> kurierSamochod = new ArrayList<>();

    public Samochod(Long id){
        addToExtent(this.getClass(),this);
    }

    public void dodajKurierSamochod(KurierSamochod ks){
        if(!kurierSamochod.contains(ks)){
            kurierSamochod.add(ks);
            ks.setSamochod(this);
        }
    }

    public void usunKurierSamochod(KurierSamochod ks){
        kurierSamochod.remove(ks);
    }


    public static void showThisExtent() {
        showExtent(Samochod.class);
    }

    @Override
    public String toString() {
        return "Samochod{" +
                "id=" + id +
                '}';
    }
}

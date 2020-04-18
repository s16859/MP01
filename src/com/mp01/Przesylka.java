package com.mp01;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Przesylka extends ObjectPlus implements Serializable {

    private Long id;
    Long nadawca;
    Long adresat;
    private Date dataNadania = new Date();
    private Date dataDostarczenia = null;
    private static int kosztZaObjetosc = 1;
    private static int dodatkowaZaPobranie=8;
    private String typ;
    private int koszt;
    private String status="u_nadawcy";
    private int waga;
    private int szerokosc;
    private int dlugosc;
    private int wysokosc;
    private int pobranie=0;

    public Przesylka(Long id,Long nadawca, Long adresat, String typ, int waga, int szerokosc, int dlugosc, int wysokosc){
        this.id=id;
        this.nadawca=nadawca;
        this.adresat=adresat;
        this.typ=typ;
        this.waga=waga;
        this.koszt=obliczKosztPrzesylki(szerokosc,dlugosc,wysokosc);
        this.szerokosc=szerokosc;
        this.dlugosc=dlugosc;
        this.wysokosc=wysokosc;
        this.status=new String("u_nadawcy");
        addToExtent(this.getClass(),this);
    }

    public static void showThisExtent() {
        showExtent(Przesylka.class);
    }

    public static void nadaniePrzesylki(Long id, Long nadawca, Long adresat, String typ, int waga, int szerokosc, int dlugosc, int wysokosc){
        new Zlecenie(new Przesylka(id,nadawca,adresat,typ, waga, szerokosc, dlugosc, wysokosc));
    }

    public void anulowaniePrzesylki(){
        zmianaStatusuPrzesylki("Anulowana");
    }

    public void zmianaStatusuPrzesylki(String status){
        setStatus(status);
    }

    public String sprawdzStatusPrzesylki(){
        return getStatus();
    }


    public static void usuniecieAnulowanychPrzesylek(){

        Iterator<Przesylka> extent=  getExtent(Przesylka.class).iterator();
        List<ObjectPlus> newExtent = new ArrayList<>();

        while (extent.hasNext()){
            Przesylka p = extent.next();
            if(!p.getStatus().equals("Anulowana")){
                newExtent.add(p);
            }
        }
        addToExtent(Przesylka.class,newExtent);
    }

    public static int obliczKosztPrzesylki(int szerokosc, int dlugosc, int wysokosc){
        return szerokosc*dlugosc*wysokosc*kosztZaObjetosc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Przesylka{" +
                "id=" + id +
                ", typ='" + typ + '\'' +
                ", koszt=" + koszt +
                ", status='" + status + '\'' +
                ", waga=" + waga +
                ", szerokosc=" + szerokosc +
                ", dlugosc=" + dlugosc +
                ", wysokosc=" + wysokosc +
                ", pobranie=" + pobranie +
                '}';
    }
}

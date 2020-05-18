package com.mp01;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Przesylka extends ObjectPlus implements Serializable {

    private Long id;
    private Klient nadawca;
    private Klient adresat;
    private List<Sortownia> sortownie = new ArrayList<>();
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

    public Przesylka(Long id, String typ, int waga, int szerokosc, int dlugosc, int wysokosc, int koszt){
        this.id=id;
        this.typ=typ;
        this.waga=waga;
        this.koszt=koszt;
        this.szerokosc=szerokosc;
        this.dlugosc=dlugosc;
        this.wysokosc=wysokosc;
        this.status=new String("u_nadawcy");
        addToExtent(this.getClass(),this);
    }

    public void dodajSortownie(Sortownia sortownia){
           sortownie.add(sortownia);
    }


    /*
    public void setNadawca(Klient klient){
        if(nadawca == null){
            this.nadawca=klient;
            klient.dodajNadanaPrzesylke(this);
        }
        else if(nadawca!=klient){
            nadawca.usunNadana(this);
            klient.dodajNadanaPrzesylke(this);
            this.nadawca=klient;
        }
    }

    public void setAdresat(Klient klient){
        if(adresat == null){
            this.adresat=klient;
            klient.dodajAdresowanaPrzesylke(this);
        }
        else if(adresat!=klient){
            adresat.usunAdresowana(this);
            klient.dodajAdresowanaPrzesylke(this);
            this.adresat=klient;
        }
    }*/


    public static void showThisExtent() {
        showExtent(Przesylka.class);
    }

    public static void nadaniePrzesylki(Long id, String typ, int waga, int szerokosc, int dlugosc, int wysokosc){
        int koszt=obliczKosztPrzesylki(szerokosc,dlugosc,wysokosc);
        new Zlecenie(new Przesylka(id,typ, waga, szerokosc, dlugosc, wysokosc,koszt));
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
            else{
                System.out.println("Usunięto: "+p.toString());
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String toString() {
        String res = "Przesylka: id=" + id + '\n';
        res+="Sortownie w ktorcyh byla przesylka:";
        for(Sortownia s : sortownie){
            res+="\n";
            res+=s.toString();
        }
        return res;
    }
    /*
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
    }*/
}

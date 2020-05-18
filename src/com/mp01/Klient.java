package com.mp01;

import java.util.*;

public abstract class Klient extends ObjectPlus{

    Long id;
    String daneKontaktowe;

    List<Adres> adresy = new ArrayList<>();
    static Set<Adres> wszystkieAdresy = new HashSet<>();

    Klient(Long id,String daneKontaktowe){
        this.id=id;
        this.daneKontaktowe=daneKontaktowe;
    }

    public void addAdres(Adres adres) throws Exception {
        if(!adresy.contains(adres)){
            if(wszystkieAdresy.contains(adres)) {
                throw new Exception("The part is already connected with a whole!");
            }
            adresy.add(adres);
            wszystkieAdresy.add(adres);
        }
    }



    //List<Przesylka> nadane= new ArrayList<>();
    //List<Przesylka> adresowane= new ArrayList<>();

    /*
    public void dodajNadanaPrzesylke(Przesylka przesylka){
        if(!nadane.contains(przesylka)){
            nadane.add(przesylka);
            przesylka.setNadawca(this);
        }
    }

    public void dodajAdresowanaPrzesylke(Przesylka przesylka){
        if(!adresowane.contains(przesylka)){
            adresowane.add(przesylka);
            przesylka.setAdresat(this);
        }
    }

    public void usunAdresowana(Przesylka przesylka){
        adresowane.remove(przesylka);
    }

    public void usunNadana(Przesylka przesylka){
        nadane.remove(przesylka);
    }*/

    public static void showThisExtent() {
        showExtent(Klient.class);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*
    @Override
    public String toString() {
        return "Klient{" +
                "id=" + id +
                ", daneKontaktowe='" + daneKontaktowe + '\'' +
                '}';
    }*/

    @Override
    public String toString() {
        String res = "Klient: id=" + id + '\n';
        /*
        for(Przesylka p : nadane){
            res+="\n";
            res+="id="+p.getId();
        }
        res+="\n";
        res+="Przesylki adresowane:";
        for(Przesylka p : adresowane){
            res+="\n";
            res+="id="+p.getId();
        }
        res+="\n";*/
        res+="Adresy:";
        for(Adres p : adresy){
            res+="\n";
            res+=p.toString();
        }
        return res;
    }

}

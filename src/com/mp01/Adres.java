package com.mp01;

public class Adres extends ObjectPlusPlus{

    Long id;
    Klient klient;
    String miasto,
    ulica,
    numer,
    kodPocztowy;

    private Adres(Klient klient, Long id,String miasto, String ulica, String numer,String kodPocztowy){
        this.klient=klient;
        this.id=id;
        this.miasto=miasto;
        this.ulica=ulica;
        this.numer=numer;
        this.kodPocztowy=kodPocztowy;
        addToExtent(this.getClass(),this);
    }

    public static void createAdres(Klient klient, Long id,String miasto, String ulica, String numer,String kodPocztowy) throws Exception {
        if(klient == null) {
            throw new Exception("The given whole does not exist!");
        }
        Adres adres = new Adres(klient,id,miasto,ulica,numer,kodPocztowy);
        klient.addAdres(adres);
    }


        public static void showThisExtent() {
        showExtent(Adres.class);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Adres{" +
                "id=" + id +
                ", miasto='" + miasto + '\'' +
                ", ulica='" + ulica + '\'' +
                ", numer='" + numer + '\'' +
                ", kodPocztowy='" + kodPocztowy + '\'' +
                '}';
    }
}

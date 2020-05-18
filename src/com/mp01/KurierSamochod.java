package com.mp01;

import java.util.Date;

public class KurierSamochod {

    private Long id;
    private Date dataPrzydzialu;
    private Kurier kurier;
    private Samochod samochod;

    public KurierSamochod(Long id){
        this.id=id;
        this.dataPrzydzialu=new Date();
    }

    public KurierSamochod(Long id,Kurier kurier,Samochod samochod){
        this.id=id;
        this.dataPrzydzialu=new Date();
        this.kurier=kurier;
        this.samochod=samochod;
        kurier.dodajKurierSamochod(this);
        samochod.dodajKurierSamochod(this);
    }

    public void setKurier(Kurier kurier){
        if(this.kurier == null){
            this.kurier=kurier;
            kurier.dodajKurierSamochod(this);
        }
        else if(this.kurier!=kurier){
            this.kurier.usunKurierSamochod(this);
            this.kurier=kurier;
            kurier.dodajKurierSamochod(this);
        }
    }

    public void setSamochod(Samochod samochod){
        if(this.samochod == null){
            this.samochod=samochod;
            samochod.dodajKurierSamochod(this);
        }
        else if(this.samochod!=samochod){
            samochod.usunKurierSamochod(this);
            this.samochod=samochod;
            samochod.dodajKurierSamochod(this);
        }
    }

    @Override
    public String toString() {
        return "KurierSamochod{" +
                "id=" + id +
                ", dataPrzydzialu=" + dataPrzydzialu +
                '}';
    }
}

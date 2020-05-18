package com.mp01;

import java.util.ArrayList;
import java.util.List;

public class Kurier extends ObjectPlus{

    private Long id;
    private String daneOsobowe;
    private String daneKontaktowe;
    private List<Zlecenie> zleceniaKuriera=new ArrayList<>();
    private List<KurierSamochod> kurierSamochod = new ArrayList<>();

    public Kurier(Long id, String daneOsobowe, String daneKontaktowe){
        this.id=id;
        this.daneOsobowe=daneOsobowe;
        this.daneKontaktowe=daneKontaktowe;
        addToExtent(this.getClass(),this);
    }
    //=================================================
    public void dodajKurierSamochod(KurierSamochod ks){
        if(!kurierSamochod.contains(ks)){
            kurierSamochod.add(ks);
            ks.setKurier(this);
        }
    }

    public void usunKurierSamochod(KurierSamochod ks){
        kurierSamochod.remove(ks);
    }

    //==============================================
    public void dodajZlecenie(Zlecenie zlecenie){
        if(!zleceniaKuriera.contains(zlecenie)){
            zleceniaKuriera.add(zlecenie);
            zlecenie.setKurier(this);
        }
    }

    public void usunZlecenie(Zlecenie zlecenie){
        zleceniaKuriera.remove(zlecenie);
    }
    //=============================================
    public static void showThisExtent() {
        showExtent(Kurier.class);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Kurier{" +
                "id=" + id +
                ", daneOsobowe='" + daneOsobowe + '\'' +
                ", daneKontaktowe='" + daneKontaktowe + '\'' +
                ", zleceniaKuriera=" + zleceniaKuriera +
                '}';
    }
}

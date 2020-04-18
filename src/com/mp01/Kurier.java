package com.mp01;

import java.util.ArrayList;
import java.util.List;

public class Kurier extends ObjectPlus{

    Long id;
    String daneOsobowe;
    String daneKontaktowe;
    List<Long> zleceniaKuriera=new ArrayList<>();

    public Kurier(Long id, String daneOsobowe, String daneKontaktowe){
        this.id=id;
        this.daneOsobowe=daneOsobowe;
        this.daneKontaktowe=daneKontaktowe;
        addToExtent(this.getClass(),this);
    }

    public static void showThisExtent() {
        showExtent(Kurier.class);
    }

    public void dodajZlecenie(Long id){
        zleceniaKuriera.add(id);
    }

    public void usunZlecenie(Long id){
        zleceniaKuriera.remove(id);
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

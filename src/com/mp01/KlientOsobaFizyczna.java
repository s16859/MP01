package com.mp01;

public class KlientOsobaFizyczna extends Klient {

    String daneOsobowe;

    public KlientOsobaFizyczna(Long id,String daneKontaktowe,String daneOsobowe){
        super(id,daneKontaktowe);
        this.daneOsobowe=daneOsobowe;
        addToExtent(Klient.class,this);
    }

    /*
    @Override
    public String toString() {
        return "KlientOsobaFizyczna{" +
                "daneOsobowe='" + daneOsobowe + '\'' +
                ", id=" + id +
                ", daneKontaktowe='" + daneKontaktowe + '\'' +
                '}';
    }*/

}

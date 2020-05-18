package com.mp01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Sortownia extends ObjectPlusPlus{

    private Long id;
    private Map<Long, Przesylka> przesylkiQualif = new TreeMap<>();

    public Sortownia(Long id){
        this.id=id;
        addToExtent(this.getClass(),this);
    }


    public void addMovieQualif(Przesylka przesylka) {
         if(!przesylkiQualif.containsKey(przesylka.getId())) {
             przesylkiQualif.put(przesylka.getId(), przesylka);
             przesylka.dodajSortownie(this);
         }
    }
    public Przesylka findMovieQualif(Long id) throws Exception {
        if(!przesylkiQualif.containsKey(id)) {
            throw new Exception("Unable to find a movie: " + id);
        }
        return przesylkiQualif.get(id);
    }


    public static void showThisExtent() {
        showExtent(Sortownia.class);
    }


    @Override
    public String toString() {
        return "Sortownia{" +
                "id=" + id +
                '}';
    }
}

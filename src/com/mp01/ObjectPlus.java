package com.mp01;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectPlus implements Serializable {

    private static Map<Class, List<ObjectPlus>> allExtents = new HashMap<>();

    public static  <T> Iterable<T> getExtent(Class<T> type) {
        if (allExtents.containsKey(type)) {
            return (Iterable<T>) allExtents.get(type);
        }
        return null;
    }

    public <T> void addToExtent(Class<T> type, ObjectPlus object) {
        List<ObjectPlus> extent;
       if(allExtents.containsKey(type)){
           extent = allExtents.get(type);
           extent.add(object);
           allExtents.put(type,extent);
       }else {
           extent = new ArrayList<>();
           extent.add(object);
           allExtents.put(type,extent);
       }
       saveExtent();
    }

    public static <T> void addToExtent(Class<T> type, List<ObjectPlus> extent) {
        allExtents.put(type,extent);
        saveExtent();
    }


    public static  <T> List<T> getByIndex(Class<T> type) {
        if (allExtents.containsKey(type)) {
            return (List<T>) allExtents.get(type);
        }
        return null;
    }


    public static  <T> void showExtent(Class<T> type) {

        System.out.println("Ekstensja: " + type.getName());

        for (T z : getExtent(type)) {
            System.out.println(z);
        }
    }

    public static void saveExtent() {
        try {
            FileOutputStream fos = new FileOutputStream("allExtents.extent");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(allExtents);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadExtent() {
        try {
            FileInputStream fis = new FileInputStream("allExtents.extent");
            ObjectInputStream ois = new ObjectInputStream(fis);
            allExtents = (Map<Class, List<ObjectPlus>>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException i) {
            //i.printStackTrace();
            return;
        } catch (ClassNotFoundException e) {
            System.out.println("Extent class not found");
            //e.printStackTrace();
            return;
        }
    }
}



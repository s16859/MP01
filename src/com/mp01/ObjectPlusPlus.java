package com.mp01;

import java.io.PrintStream;
import java.util.*;

public class ObjectPlusPlus extends ObjectPlus {

    protected Map<String, Map<Object, ObjectPlusPlus>> links = new Hashtable<>();

    protected static Set<ObjectPlusPlus> allParts = new HashSet<>();

    public ObjectPlusPlus() {
        super();
    }

    private void addLink(String roleName, String reverseRoleName, ObjectPlusPlus targetObject, Object qualifier, int counter) {
        Map<Object, ObjectPlusPlus> objectLink;

        if(counter < 1) {
            return;
        }

        if(links.containsKey(roleName)) {
            objectLink = links.get(roleName);
        }
        else {
            objectLink = new HashMap<>();
            links.put(roleName, objectLink);
        }

        if(!objectLink.containsKey(qualifier)) {
            objectLink.put(qualifier, targetObject);
            targetObject.addLink(reverseRoleName, roleName, this, this, counter - 1);
        }
    }


    public void addLink(String roleName, String reverseRoleName, ObjectPlusPlus targetObject, Object qualifier) {
        addLink(roleName, reverseRoleName, targetObject, qualifier, 2);
    }

    public void addLink(String roleName, String reverseRoleName, ObjectPlusPlus targetObject) {
        addLink(roleName, reverseRoleName, targetObject, targetObject);
    }


    public void addPart(String roleName, String reverseRoleName, ObjectPlusPlus partObject) throws Exception {
        // Sprawdz czy ta czesc juz gdzies nie wystepuje
        if(allParts.contains(partObject)) {
            throw new Exception("Ta czesc jest ju� powiazana z jakas caloscia!");
        }

        addLink(roleName, reverseRoleName, partObject);

        // Zapamietaj dodanie obiektu jako czesci
        allParts.add(partObject);
    }

    /**
     * Zwraca tablice zawierajaca docelowe obiekty dla podanej nazwy roli.
     * @param roleName
     * @return
     * @throws Exception
     */
    public ObjectPlusPlus[] getLinks(String roleName) throws Exception {
        Map<Object, ObjectPlusPlus> objectLinks;

        if(!links.containsKey(roleName)) {
            // Brak powiazan dla tej roli
            throw new Exception("Brak powiazan dla roli: " + roleName);
        }

        objectLinks = links.get(roleName);

        return (ObjectPlusPlus[]) objectLinks.values().toArray(new ObjectPlusPlus[0]);
    }

    /**
     * Informuje czy istnieja powiazania dla podanej nazwy roli.
     * @param roleName
     * @return false gdy brak nazwy roli lub gdy liczba powiazan dla tej roli jest 0.
     */
    public boolean areLinks(String roleName) {
        if(!links.containsKey(roleName)) {
            return false;
        }

        Map<Object, ObjectPlusPlus> objectLinks = links.get(roleName);
        return objectLinks.size() > 0;
    }

    /**
     * Wyswietla powiazania (dla podanej nazwy roli) na podanym strumieniu.
     * @param roleName
     * @param stream
     * @throws Exception
     */
    public void showLinks(String roleName, PrintStream stream) throws Exception {
        Map<Object, ObjectPlusPlus> objectLink;

        if(!links.containsKey(roleName)) {
            // Brak powiazan dla tej roli
            throw new Exception("No links for the role: " + roleName);
        }

        objectLink = links.get(roleName);

        Collection col = objectLink.values();

        stream.println(this.toString() + " (" + this.getClass().getSimpleName() + ") links for the '" + roleName + "' role:");

        for(Object obj : col) {
            stream.println("   " + obj);
        }
    }

    /**
     * Wyswietla wszystkie powiazania danego obiektu na podanym strumieniu.
     * @param stream
     * @throws Exception
     */
    public void showLinks(PrintStream stream) throws Exception {
        // Dla kazdego klucza
        for(String klucz : links.keySet()) {
            showLinks(klucz, stream);
        }
    }


    /**
     * Zwraca obiekt odnaleziony na podstawie kwalifikatora (dla podanej nazwy roli).
     * Dziala w oparciu o asocjacje kwalifikowana.
     * @param roleName
     * @param qualifier
     * @return
     * @throws Exception
     */
    public ObjectPlusPlus getLinkedObject(String roleName, Object qualifier) throws Exception {
        Map<Object, ObjectPlusPlus> objectLinks;

        if(!links.containsKey(roleName)) {
            // Brak powiazan dla tej roli
            throw new Exception("Brak powiazan dla roli: " + roleName);
        }

        objectLinks = links.get(roleName);
        if(!objectLinks.containsKey(qualifier)) {
            // Brak powiazan dla tej roli
            throw new Exception("Brak powiazania dla kwalifikatora: " + qualifier);
        }

        return objectLinks.get(qualifier);
    }

    /**
     * Indicates if there is a link to a given object for a given role.
     * returns false also if there is no info about the role.
     * @param roleName
     * @param targetObject
     * @return
     */
    public boolean isLink(String roleName, ObjectPlusPlus targetObject) {
        Map<Object, ObjectPlusPlus> objectLink;

        if(!links.containsKey(roleName)) {
            // No links for the role
            return false;
        }

        objectLink = links.get(roleName);
        if(objectLink.containsValue(targetObject)) {
            // There is a target object
            return true;
        }

        // No target object
        return false;
    }
}

package com.company;

/*
 * Benutzer Klasse enthält alle Informationen des Systems über den Benutzer.
 * Besteht aus den Attributen userId und passWort.
 */
public class Benutzer {
    /*
    * Speichert die ID des Benutzers
     */
    String userId;
    /*
    * Speichert dass Passwort des Benutzers
     */
    char[] passWort;

    /*
    * Initialisiert einen leeren Benutzer
     */
    Benutzer()
    {
        userId = "";
        passWort = new char[1];
    }

    /*
    * Initialisiert den Benutzer
    * @param id: Die ID des Benutzers
    * @param pw: Das Passwort des Benutzers
     */
    Benutzer(String id, char[] pw)
    {
        userId = id;
        passWort = pw;
    }

    /*
    * Kopiert einen Benutzer und initialisiert einen neuen mit den gleichen Werten
    * @param b: Der zu kopierende Benutzer
     */
    Benutzer(Benutzer b)
    {
        this(b.userId, b.passWort.clone());
    }

    /*
    * Vergleicht den aktuellen Benutzer mit dem angegeben
    * @param b: Der zu vergleichende Benutzer
    * @return: True wenn id & pw gleich
     */
    public boolean equals(Benutzer b)
    {
        return userId.equals(b.userId) && java.util.Arrays.equals(passWort, b.passWort);
    }

    /*
    * Gibt den Benutzer als String zurück
    * @return den Benutzer als String
     */
    public String toString()
    {
        return "(Benutzer, ID: " + userId + ", PW: " + java.util.Arrays.toString(passWort) + ")";
    }

}

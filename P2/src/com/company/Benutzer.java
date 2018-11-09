package com.company;

/*
 * Benutzer Klasse enthält alle Informationen des Systems über den Benutzer
 */
public class Benutzer {
    String userId;
    char[] passWort;

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
    * Vergleicht den aktuellen Benutzer mit dem angegeben
    * @param b: Der zu vergleichende Benutzer
    * @return: True wenn id & pw gleich
     */
    public boolean equals(Benutzer b)
    {
        return userId.equals(b.userId) && java.util.Arrays.equals(passWort, b.passWort);
    }

    /*
    * @return den Benutzer als String
     */
    public String toString()
    {
        return "(Benuter, ID: " + userId + ", PW: " + java.util.Arrays.toString(passWort) + ")";
    }

}

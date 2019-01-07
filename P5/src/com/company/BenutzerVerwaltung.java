package com.company;

/*
* Verwaltet die Benutzer
 */
public interface BenutzerVerwaltung {
    /*
    * Trägt einen Benutzer in die Datenhaltung ein
    * @param benutzer: Der einzutragende Benutzer
    * @throws BenutzerAlreadyExistsExcepiton
     */
    public void benutzerEintragen(Benutzer benutzer) throws BenutzerAlreadyExistsException;

    /*
    * Überprüft ob der Benutzer ok ist
    * @param benutzer: Der zu überprüfende Benutzer
    * @return: Liefert true, falls das Parameterobjekt in der Datenhaltung vorhanden ist, sonst false.
     */
    public boolean benutzerOk(Benutzer benutzer);
}

package com.company;
import java.util.*;

public class BenutzerVerwaltungAdmin implements BenutzerVerwaltung
{
    private List<Benutzer> datenhaltung = new ArrayList<Benutzer>();

    public void benutzerEintragen(Benutzer benutzer) throws BenutzerAlreadyExistsException
    {
        if (datenhaltung.contains(benutzer))
            throw new BenutzerAlreadyExistsException("Benutzer existiert schon in der Datenhaltung!");

        datenhaltung.add(benutzer);
    }

    public boolean benutzerOk(Benutzer benutzer)
    {
        if (!datenhaltung.contains(benutzer))
            return false;

        return true;
    }

    /*
    * Der Benutzer wird aus der Datenhaltung entfernt.
    * @param benutzer: Der zu entfernende Benutzer
    * @throws BenutzerNotFoundException
     */
    void benutzerLöschen(Benutzer benutzer) throws BenutzerNotFoundException
    {
        if (!datenhaltung.contains(benutzer))
        {
            throw new BenutzerNotFoundException("Benutzer nicht gefunden!");
        }

        datenhaltung.remove(benutzer);
    }
}

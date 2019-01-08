package prak4gemklassen;

import java.util.*;
import java.io.*;

public class BenutzerVerwaltungAdmin implements BenutzerVerwaltung
{
    private List<Benutzer> datenhaltung;
    private final String fileName = "datenhaltung.s";

    public void benutzerEintragen(Benutzer benutzer) throws BenutzerAlreadyExistsException
    {
        dbRead();
        if (datenhaltung.contains(benutzer))
            throw new BenutzerAlreadyExistsException("Benutzer existiert schon in der Datenhaltung!");

        datenhaltung.add(benutzer);
        dbWrite();
    }

    public boolean benutzerOk(Benutzer benutzer)
    {
        dbRead();
        return datenhaltung.contains(benutzer);
    }

    /*
    * Der Benutzer wird aus der Datenhaltung entfernt.
    * @param benutzer: Der zu entfernende Benutzer
    * @throws BenutzerNotFoundException
     */
    public void benutzerLöschen(Benutzer benutzer) throws BenutzerNotFoundException
    {
        dbRead();

        if (!datenhaltung.contains(benutzer))
        {
            throw new BenutzerNotFoundException("Benutzer nicht gefunden!");
        }

        datenhaltung.remove(benutzer);

        dbWrite();
    }

    public void dbInitialisieren()
    {
        datenhaltung = new ArrayList<Benutzer>();

        dbWrite();
    }

    private void dbRead()
    {
        try {
            FileInputStream fs = new FileInputStream(fileName);
            ObjectInputStream is = new ObjectInputStream(fs);
            datenhaltung = (List<Benutzer>) is.readObject();
            is.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void dbWrite()
    {
        try {
            FileOutputStream fs = new FileOutputStream(fileName);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(datenhaltung);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

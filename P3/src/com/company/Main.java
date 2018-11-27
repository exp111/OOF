package com.company;

public class Main {

    public static void main(String[] args) {

        BenutzerVerwaltungAdmin a = new BenutzerVerwaltungAdmin();

        Benutzer user = new Benutzer();

        try {
            a.benutzerEintragen(user);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}

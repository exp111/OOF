package com.company;

public class Main {

    public static void main(String[] args) {
        // Benutzer erstellen
        Benutzer user1 = new Benutzer("gzufall", "1235".toCharArray());
        Benutzer user2 = new Benutzer("rzufall", "passwort3".toCharArray());
        Benutzer user3 = new Benutzer(user1);

        // Teste Benutzer
        System.out.println("User1: " + user1.toString());
        System.out.println("User2: " + user2.toString());
        System.out.println("User1 == User2: " + user1.equals(user2));
        System.out.println("User3: " + user3.toString());
        System.out.println("User1 == User3: " + user1.equals(user3));

        // Erstelle Datenhaltung
        BenutzerVerwaltungAdmin verwaltung = new BenutzerVerwaltungAdmin();

        // Trage Benutzer ein
        System.out.println("User1 ok: " + verwaltung.benutzerOk(user1));
        try
        {
            verwaltung.benutzerEintragen(user1);
        }
        catch (BenutzerAlreadyExistsException e)
        {
            System.out.println("Exception beim Eintragen von User1: " + e);
        }
        System.out.println("User1 eingetragen: " + verwaltung.benutzerOk(user1));
        try
        {
            verwaltung.benutzerEintragen(user1);
        }
        catch (BenutzerAlreadyExistsException e)
        {
            System.out.println("Exception beim Eintragen von User1: " + e);
        }

        // Löschen des Benutzers
        try
        {
            verwaltung.benutzerLöschen(user1);
        }
        catch (BenutzerNotFoundException e)
        {
            System.out.println("Exception beim Löschen von User1: " + e);
        }
        System.out.println("User1 gelöscht: " + verwaltung.benutzerOk(user1));
        try
        {
            verwaltung.benutzerLöschen(user1);
        }
        catch (BenutzerNotFoundException e)
        {
            System.out.println("Exception beim Löschen von User1: " + e);
        }

    }
}

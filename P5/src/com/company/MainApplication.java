package com.company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class MainApplication extends Application
{
    Stage primaryStage;
    BenutzerVerwaltungAdmin admin;

    private void setScene(String scene)
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(scene + ".fxml"));

        Parent root;
        try{
            root = fxmlLoader.load();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return;
        }

        switch (scene)
        {
            case "login":
                ((LoginController)fxmlLoader.getController()).setMainApplication(this);
                primaryStage.setTitle("Login");
                break;
            case "anmeldung":
                ((AnmeldungsController)fxmlLoader.getController()).setMainApplication(this);
                primaryStage.setTitle("Anmeldung");
                break;
            case "anwendung":
                primaryStage.setTitle("Anwendung");
                break;
        }

        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        this.primaryStage = primaryStage;
        admin = new BenutzerVerwaltungAdmin();

        System.out.println("Initialisieren?");
        BufferedReader din = new BufferedReader(
                new InputStreamReader(System.in));
        int dbInitialisieren = Integer.parseInt(din.readLine());

        if (dbInitialisieren > 0) {
            admin.dbInitialisieren();
        }
        setScene("login");
    }

    /*
    Die Scene wird durch eine AnmeldungsScene ersetzt und deren
    Controller wird die eigene Referenz übergeben.
     */
    public void neuAnmeldung()
    {
        this.setScene("anmeldung");
    }

    /*
    Es wird versucht den neuen Benutzer durch Aufruf der Methode
    benutzerEintragen(benutzer)in die BenutzerVerwaltungAdmin
    einzutragen.
    Ist dies erfolgreich, so soll dem Anwender angezeigt werden, dass er
    jetzt den Login-Vorgang durchführen kann (indem eine LoginScene
    erzeugt und deren Controller die eigene Referenz übergeben wird).
    Beim Auftreten der Exception soll eine aussagekräftige Fehlermeldung
    angezeigt werden (z.B. in dem obersten Textfeld der
    AnmeldungsScene).
     */
    public void neuerBenutzer(Benutzer benutzer)
    {
        try {
            admin.benutzerEintragen(benutzer);
        }
        catch (Exception e)
        {
            // Aussagekräftige Fehlermeldung
            System.err.print("Fehler beim Eintragen eines Benutzers aufgetreten: " + e.getMessage());
            return;
        }

        this.setScene("login");
    }

    /*
    Es wird durch Aufruf der Methode benutzerOk(benutzer) überprüft,
    ob der Benutzer bereits in BenutzerVerwaltungAdmin eingetragen ist.
    Ist dies der Fall, soll dem Anwender angezeigt werden, dass er nun
    das System benutzen kann, indem eine AnwendungsScene erzeugt
    wird (er kann jedoch lediglich nur den Button drücken).
    Im anderen Fall soll eine aussagekräftige Fehlermeldung angezeigt
    werden (z.B. in dem obersten Textfeld der LoginScene).
     */
    void benutzerLogin(Benutzer benutzer)
    {
        boolean ok = admin.benutzerOk(benutzer);

        if (ok)
        {
            setScene("anwendung");
        }
        else
        {
            // Aussagekräftige Fehlermeldung
            System.err.print("Der Benutzer existiert nicht!");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

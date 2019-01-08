package prak4client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import prak4gemklassen.Benutzer;
import prak4gemklassen.BenutzerVerwaltungAdmin;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static javafx.application.Application.launch;

public class Client extends Application {
    private boolean lokal = true;
    private String address = "127.0.0.1";
    private ClientOrb clientOrb; //TODO: generalize admin into the interface and delete this
    private Stage primaryStage;

    private BenutzerVerwaltungAdmin admin; //TODO: make this a BenutzerVerwaltung
    private boolean initialized = false;

    public Client()
    {
        clientOrb = new ClientOrb(address);
    }

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
                LoginController controller = fxmlLoader.getController();
                controller.setClient(this);
                controller.setLokal(lokal);
                primaryStage.setTitle("Login");
                break;
            case "anmeldung":
                ((AnmeldungsController)fxmlLoader.getController()).setClient(this);
                primaryStage.setTitle("Anmeldung");
                break;
            case "anwendung":
                primaryStage.setTitle("Anwendung");
                break;
        }

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        this.primaryStage = primaryStage;
        admin = new BenutzerVerwaltungAdmin();

        setScene("login");
    }

    public void setLokal(boolean lokal)
    {
        this.lokal = lokal;


        if (!initialized) {
            int dbInitialisieren = 0;
            try {
                System.out.println("Initialisieren?");
                BufferedReader din = new BufferedReader(new InputStreamReader(System.in));
                dbInitialisieren = Integer.parseInt(din.readLine());
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (dbInitialisieren > 0) {
                if (lokal) {
                    admin.dbInitialisieren();
                } else {
                    clientOrb.dbInitialisieren();
                }
            }

            initialized = true;
        }
    }

    /*
    Die Scene wird durch eine AnmeldungsScene ersetzt und deren
    Controller wird die eigene Referenz übergeben.
     */
    public void neuAnmeldungLokal()
    {
        setLokal(true);
        setScene("anmeldung");
    }

    public void neuAnmeldungRemote()
    {
        setLokal(false);
        setScene("anmeldung");
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
            if (lokal) {
                admin.benutzerEintragen(benutzer);
            }
            else
            {
                clientOrb.benutzerEintragen(benutzer);
            }
        }
        catch (Exception e)
        {
            // Aussagekräftige Fehlermeldung
            System.err.println("Fehler beim Eintragen eines Benutzers aufgetreten: " + e.getMessage());
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
    void benutzerLoginLokal(Benutzer benutzer)
    {
        setLokal(true);
        boolean ok = admin.benutzerOk(benutzer);

        if (ok)
        {
            setScene("anwendung");
        }
        else
        {
            // Aussagekräftige Fehlermeldung
            System.err.println("Der Benutzer existiert nicht!");
        }
    }

    void benutzerLoginRemote(Benutzer benutzer)
    {
        setLokal(false);
        boolean ok = clientOrb.benutzerOk(benutzer);

        if (ok)
        {
            setScene("anwendung");
        }
        else
        {
            // Aussagekräftige Fehlermeldung
            System.err.println("Der Benutzer existiert nicht!");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

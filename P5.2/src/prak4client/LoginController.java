package prak4client;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import prak4gemklassen.*;

/*
* Handled Ereignisse in der Login Scene
 */
public class LoginController
{
    // Items in Scene
    @FXML private TextField userField;
    @FXML private PasswordField pwField;
    @FXML private Button execButton;
    @FXML private CheckBox remoteCheckbox;

    private boolean neuAnmeldung = false;
    private boolean lokal = true;
    void setLokal(boolean lokal)
    {
        this.lokal = lokal;
        remoteCheckbox.setSelected(!lokal);
    }

    private Client client;
    void setClient(Client client)
    {
        this.client = client;
    }

    /*
    * Toggled die Neu Anmeldung und gibt den Wert in die Konsole aus.
     */
    @FXML
    private void handleNeuAnmeldungCheckboxEvent()
    {
        neuAnmeldung = !neuAnmeldung;
    }

    @FXML
    private void handleRemoteCheckboxEvent()
    {
        lokal = !lokal;
    }

    /*
    *  Wird aktiviert, wenn der "Ausführen" Knopf gedrückt wird. Erstellt einen neuen Benutzer,
     * Gibt diesen in der Konsole aus und schließt das Fenster.
     */
    @FXML
    private void handleButtonEvent()
    {
        Benutzer newUser = new Benutzer(userField.getText(), pwField.getText().toCharArray());

        if (neuAnmeldung)
        {
            if (lokal) {
                client.neuAnmeldungLokal();
            }
            else
            {
                client.neuAnmeldungRemote();
            }
        }
        else
        {
            if (lokal) {
                client.benutzerLoginLokal(newUser);
            }
            else
            {
                client.benutzerLoginRemote(newUser);
            }
        }
    }
}

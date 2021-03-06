package prak4client;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import prak4gemklassen.*;

/*
* Handled Ereignisse in der AnmeldungsScene
 */
public class AnmeldungsController
{
    // Items in scene
    @FXML private TextField userField;
    @FXML private PasswordField pwField;
    @FXML private PasswordField pwRepeatField;
    @FXML private Button execButton;

    private Client client;
    void setClient(Client client)
    {
        this.client = client;
    }

    /*
    * Wird aktiviert, wenn der "Ausführen" Knopf gedrückt wird. Überprüft das Passwort & Wiederholungsfeld, erstellt einen neuen Benutzer,
    * Gibt diesen in der Konsole aus und schließt das Fenster.
     */
    @FXML
    private void handleButtonEvent()
    {
    String pw = pwField.getText();
    String pwRepeat = pwRepeatField.getText();
    if (!pw.equals(pwRepeat))
    {
        userField.setText("Passwort != Wiederholung");
        return;
    }

    Benutzer newUser = new Benutzer(userField.getText(), pw.toCharArray());

    client.neuerBenutzer(newUser);
}
}

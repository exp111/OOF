package com.company;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/*
* Handled Ereignisse in der Login Scene
 */
public class LoginController
{
    // Items in Scene
    @FXML private TextField userField;
    @FXML private PasswordField pwField;
    @FXML private Button execButton;

    private boolean neuAnmeldung = false;

    private MainApplication mainApplication;
    void setMainApplication(MainApplication main)
    {
        this.mainApplication = main;
    }

    /*
    * Toggled die Neu Anmeldung und gibt den Wert in die Konsole aus.
     */
    @FXML
    private void handleCheckboxEvent()
    {
        neuAnmeldung = !neuAnmeldung;
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
            mainApplication.neuAnmeldung();
        }
        else
        {
            mainApplication.benutzerLogin(newUser);
        }
    }
}

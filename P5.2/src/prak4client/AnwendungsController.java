package prak4client;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import prak4gemklassen.*;

/*
* Handled Ereignisse in der Anwendungs Scene
 */
public class AnwendungsController
{
    // Items in Scene
    @FXML private Button cancelButton;

    /*
    * Gibt eine Nachricht in die Konsole aus und schließt das Fenster.
     */
    @FXML
    private void handleButtonAction()
    {
        System.out.println("Knopf gedrückt. Bricht ab.");
        // Schließt das Fenster
        Stage stage = (Stage)cancelButton.getScene().getWindow();
        stage.close();
    }
}

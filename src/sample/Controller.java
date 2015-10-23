package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

import javax.xml.soap.Text;

public class Controller {
    public TextArea text;
    public MenuItem miOFTimes;
    public MenuItem miOFArial;
    public MenuItem miOT12;
    public MenuItem miOT10;
    public MenuItem miFSortir;
    public MenuItem miECopiar;
    public MenuItem miETallar;
    public MenuItem miEPaste;
    public MenuItem miEUndo;
    public Button btCopy;
    public MenuItem miAAbout;
    public AnchorPane mainPane;

    private double fontSize;

    /**
     * S'executa al iniciar l'aplicació.
     */
    public void initialize(){
        fontSize = text.getFont().getSize();
        btCopy.setGraphic(new ImageView("copy.png"));
    }

    /**
     * Menú Opcions -> Font. Canvi de la font del text.
     * @param actionEvent Event onAction de tots els MenuItem
     */
    public void setFont(ActionEvent actionEvent) {
        text.setFont(new Font(((MenuItem) actionEvent.getSource()).getText(), fontSize));
    }

    /**
     * Menú Opcions -> Tamany. Canvi del tamany de la font del text.
     * @param actionEvent Event onAction de tots els MenuItem
     */
    public void setFontSize(ActionEvent actionEvent) {
        fontSize = Double.parseDouble(((MenuItem)actionEvent.getSource()).getText());
        text.setFont(new Font(fontSize));
    }

    /**
     * Menú Fitxer -> Sortir. Surt de l'aplicació
     * @param actionEvent Event onAction de tots els MenuItem
     */
    public void sortir(ActionEvent actionEvent) {
        Platform.exit();
    }

    /**
     * Menú Editar -> Copiar. Còpia el text seleccionat.
     * @param actionEvent Event onAction de tots els MenuItem
     */
    public void eCopiar(ActionEvent actionEvent) {
        text.copy();
    }

    /**
     * Menú Editar -> Tallar. Talla el text seleccionat.
     * @param actionEvent Event onAction de tots els MenuItem
     */
    public void eTallar(ActionEvent actionEvent) {
        text.cut();
    }

    /**
     * Menú Editar -> Enganxar. Enganxa el text del clipboard.
     * @param actionEvent Event onAction de tots els MenuItem
     */
    public void ePaste(ActionEvent actionEvent) {
        text.paste();
    }

    /**
     * Menú Editar -> Desfer. Desfà la última acció.
     * @param actionEvent Event onAction de tots els MenuItem
     */
    public void eUndo(ActionEvent actionEvent) {
        text.undo();
    }

    public void eAbout(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Look, an Information Dialog");
        alert.setContentText("I have a great message for you!");

        alert.showAndWait();
    }
}
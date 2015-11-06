package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class Controller {


    public MenuItem mIMono;
    public MenuItem mISerif;
    public MenuItem mIT14;
    public MenuItem mIT12;
    public MenuItem mISalir;
    public MenuItem mICopiar;
    public MenuItem mICortar;
    public MenuItem mIPegar;
    public MenuItem mIDeshacer;
    public MenuItem mIAbrir;
    public MenuItem mIGuardar;
    public MenuItem mIInfo;
    public Button bTCopiar;
    public Button btPegar;
    public Button btCortar;
    public TextArea texto;

    private double fontSize;


    public void initialize(){
        fontSize = texto.getFont().getSize();
        bTCopiar.setGraphic(new ImageView("copy.png"));
        btPegar.setGraphic(new ImageView("paste.png"));
        btCortar.setGraphic(new ImageView("cut.png"));
    }

    public void setFuente(ActionEvent actionEvent) {
        texto.setFont(new Font(((MenuItem) actionEvent.getSource()).getText(), fontSize));
    }

    public void setTamaño(ActionEvent actionEvent) {
        fontSize = Double.parseDouble(((MenuItem)actionEvent.getSource()).getText());
        texto.setFont(new Font(fontSize));
    }

    public void onSalir(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void onCopiar(ActionEvent actionEvent) {
        texto.copy();
    }

    public void onCortar(ActionEvent actionEvent) {
        texto.cut();
    }

    public void onPegar(ActionEvent actionEvent) {
        texto.paste();
    }

    public void onDeshacer(ActionEvent actionEvent) {
        texto.undo();
    }

    public void onInfo(ActionEvent actionEvent) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información sobre el programa");
        alert.setHeaderText("Aquí tiene la información sobre el programa");
        alert.setContentText("Editor de texto simple.");
        alert.showAndWait();
    }

    public void onAbrir(ActionEvent actionEvent) {

        FileChooser fchooser = new FileChooser();
        fchooser.setTitle("Abrir archivo");
        fchooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Archivos de texto", "*.txt"),
                new FileChooser.ExtensionFilter("Todos los archivos", "*")
        );
        Stage stage = new Stage();
        File fileChoosed = fchooser.showSaveDialog(stage);
        fchooser.setTitle(fileChoosed.getName());

        try
        {
            BufferedReader br = new BufferedReader(new FileReader(fileChoosed));
            while (br.ready())
            {
                texto.setText(texto.getText()+br.readLine()+"\n");
            }
            br.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onGuardar(ActionEvent actionEvent) {

        FileChooser fchooser = new FileChooser();
        fchooser.setTitle("Abrir archivo");
        fchooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Archivos de texto", "*.txt"),
                new FileChooser.ExtensionFilter("Todos los archivos", "*")
        );
        Stage stage = new Stage();
        File fileChoosed = fchooser.showSaveDialog(stage);
        fchooser.setTitle(fileChoosed.getName());

        try
        {
            fileChoosed.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileChoosed));
            bw.write(texto.getText());
            bw.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
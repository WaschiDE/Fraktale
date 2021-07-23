package Ressources;

import Fractal.SierpinskiDreieck;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class Controller {
    @FXML
    private ComboBox fractalComboBox;

    public void buildFractal(javafx.event.ActionEvent actionEvent) throws InterruptedException {
        System.out.println(
                "########################### \n" +
                "### Fractal is building \n" +
                "### using value '"+fractalComboBox.getValue()+"' \n" +
                "###########################");


        new SierpinskiDreieck();


    }

}

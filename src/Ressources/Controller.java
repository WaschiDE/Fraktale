package Ressources;

import Fractal.SierpinskiDreieck;
import Fractal.SierpinskiTeppich;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.event.ActionEvent;

public class Controller {
    @FXML
    private ComboBox fractalComboBox;

    @FXML
    public void buildFractal(ActionEvent actionEvent) throws InterruptedException {
        System.out.println(
                "########################### \n" +
                        "### Fractal is building \n" +
                        "### using value '" + fractalComboBox.getValue() + "' \n" +
                        "###########################");

        FractalCanvas.context.clearRect(0, 0, 1000, 1000);


        if (fractalComboBox.getSelectionModel().getSelectedIndex() == -1) {
            System.out.println("null");
        } else if (fractalComboBox.getSelectionModel().getSelectedIndex() == 0) {
            SierpinskiTeppich sierpinskiTeppich = new SierpinskiTeppich();
            sierpinskiTeppich.drawSierpinskiTeppich();
        } else if (fractalComboBox.getSelectionModel().getSelectedIndex() == 1) {
            SierpinskiDreieck sierpinskiDreieck = new SierpinskiDreieck();
            sierpinskiDreieck.drawSierpinskiDreieck();
        }
    }

    @FXML
    public void resetCanvas(ActionEvent actionEvent) throws InterruptedException {
    FractalCanvas.setMiddlepoint(new double[]{500,500});
    FractalCanvas.setZoomFaktor(1);

    }

}

package Fractal;

import Ressources.FractalCanvas;
import javafx.scene.paint.Color;

public class SierpinskiDreieck{

    public void drawSierpinskiDreieck(){
        FractalCanvas.context.setFill(Color.BLACK);
        FractalCanvas.context.setStroke(Color.BLACK);
        FractalCanvas.context.setLineWidth(5);

        FractalCanvas.context.strokeLine(40, 10, 10, 40);
        FractalCanvas.context.strokeRect(50,50,50,50);
    }

}

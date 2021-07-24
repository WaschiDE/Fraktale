package Ressources;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class FractalCanvas extends Canvas {

    public static GraphicsContext context;

    public FractalCanvas(){
        super(1000,1000);
        context = this.getGraphicsContext2D();
    }
}

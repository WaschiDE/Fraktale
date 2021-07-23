package Fractal;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class SierpinskiDreieck extends Canvas {

    private final GraphicsContext context = this.getGraphicsContext2D();

    public SierpinskiDreieck() {
        super(1000, 1000);

        context.setFill(Color.BLACK);
        context.setStroke(Color.GREEN);
        context.setLineWidth(5);

        context.strokeLine(40, 10, 10, 40);
        context.strokeRect(50,50,50,50);
        
        System.out.println("test");

    }
}

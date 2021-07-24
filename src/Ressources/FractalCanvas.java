package Ressources;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class FractalCanvas extends Canvas {

    public static GraphicsContext context;
    private static double zoomFaktor;

    private static double[] middlepoint;
    private double lastX;
    private double lastY;

    public FractalCanvas() {
        super(1000, 1000);
        context = this.getGraphicsContext2D();

        this.zoomFaktor = 1;
        this.middlepoint = new double[]{500, 500};

        setOnScroll(event -> {
            if (event.getDeltaY() > 0) {
                for (int i = 0; i < Math.abs(event.getDeltaY() / 40); i++) {
                    this.zoomFaktor = this.zoomFaktor / Math.pow(2, 0.25);
                    if (this.zoomFaktor > 1) {
                        this.zoomFaktor = 1;
                    }
                }

                this.middlepoint[0] = this.middlepoint[0] + ((event.getX() - 500) * this.zoomFaktor / 4);
                this.middlepoint[1] = this.middlepoint[1] + ((500 - event.getY()) * this.zoomFaktor / 4);
                //System.out.println("Zoom-In-Event: " + this.middlepoint[0] + " " + this.middlepoint[1] + " Zoom: 1000px =" + this.zoomFaktor * 1000 + "unit");

            }
            if (event.getDeltaY() < 0) {
                for (int i = 0; i < Math.abs(event.getDeltaY() / 40); i++) {
                    this.zoomFaktor = this.zoomFaktor * Math.pow(2, 0.25);
                    if (this.zoomFaktor > 1) {
                        this.zoomFaktor = 1;
                    }
                }

                this.middlepoint[0] = this.middlepoint[0] - ((event.getX() - 500) * this.zoomFaktor / 4);
                this.middlepoint[1] = this.middlepoint[1] - ((500 - event.getY()) * this.zoomFaktor / 4);
                //System.out.println("Zoom-Out-Event: X: " + this.middlepoint[0] + " Y: " + this.middlepoint[1] + " Zoom: 1000px =" + this.zoomFaktor * 1000 + "unit");
            }

        });

        setOnMousePressed(event -> {
            this.lastX = event.getX();
            this.lastY = event.getY();
        });

        setOnMouseDragged(event -> {

            this.middlepoint[0] = this.middlepoint[0] - (event.getX() - this.lastX) * this.zoomFaktor;
            this.middlepoint[1] = this.middlepoint[1] + (this.lastY - event.getY()) * this.zoomFaktor;
            this.lastX = event.getX();
            this.lastY = event.getY();

            //System.out.println("Dragevent: " + this.middlepoint[0] + " " + this.middlepoint[1] + " Zoom: 1000px =" + this.zoomFaktor * 1000 + "unit");

        });
    }

    public static double[] getLeftUpperCorner() {
        return new double[]{middlepoint[0] - (500 * zoomFaktor),middlepoint[1] - (500 * zoomFaktor)};
    }

//    public double[] getRigthBottomCorner() {
//        return new double[]{this.middlepoint[0] + (500 * this.zoomFaktor),this.middlepoint[1] - (500 * this.zoomFaktor)};
//    }

    public static double getZoomFaktor() {
        return zoomFaktor;
    }

    public static void setMiddlepoint(double[] middlepoint) {
        FractalCanvas.middlepoint = middlepoint;
    }

    public static void setZoomFaktor(double zoomFaktor) {
        FractalCanvas.zoomFaktor = zoomFaktor;
    }
}

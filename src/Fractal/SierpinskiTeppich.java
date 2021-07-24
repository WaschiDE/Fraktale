package Fractal;


import Ressources.FractalCanvas;
import javafx.scene.paint.Color;

public class SierpinskiTeppich {

    public void drawSierpinskiTeppich() {
        FractalCanvas.context.setStroke(Color.BLACK);

        FractalCanvas fractalCanvas = new FractalCanvas();

        System.out.println(fractalCanvas.getRigthBottomCorner()[0]);
        System.out.println(fractalCanvas.getRigthBottomCorner()[1]);



        int i;
        int j;
        int k = 0;

        int stufe = 2;
        double fieldsize;
        int canvasesize = 1000;

        while (k <= stufe) {
            fieldsize = canvasesize / Math.pow(3, k);
            if (fieldsize < 1) {
                break;
            }
            i = 0;
            while (i < Math.pow(3, k)) {
                j = 0;
                while (j < Math.pow(3, k)) {
                    if (inCarpet(i, j)) {
                        FractalCanvas.context.fillRect((fieldsize * i - fractalCanvas.getLeftUpperCorner()[0])/fractalCanvas.getZoomFaktor() , (-fieldsize * j + fractalCanvas.getLeftUpperCorner()[1])/fractalCanvas.getZoomFaktor(), fieldsize/fractalCanvas.getZoomFaktor(), fieldsize/fractalCanvas.getZoomFaktor());
                    }
                    j += 1;
                }
                i += 1;
            }
            k += 1;
        }
    }

    public boolean inCarpet(int x, int y) {
        while (x != 0 && y != 0) {
            if (x % 3 == 1 && y % 3 == 1) {
                return true;
            }
            x = x / 3;
            y = y / 3;
        }
        return false;
    }
}


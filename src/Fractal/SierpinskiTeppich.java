package Fractal;


import Ressources.FractalCanvas;
import javafx.scene.paint.Color;

public class SierpinskiTeppich {

    public void drawSierpinskiTeppich() {
        FractalCanvas.context.setStroke(Color.BLACK);
        FractalCanvas.context.setFill(Color.BLACK);


        System.out.println(FractalCanvas.getLeftUpperCorner()[0]);
        System.out.println(FractalCanvas.getLeftUpperCorner()[1]);

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
                        FractalCanvas.context.fillRect(
                                (fieldsize * i - FractalCanvas.getLeftUpperCorner()[0])/FractalCanvas.getZoomFaktor() ,
                                (fieldsize * j - FractalCanvas.getLeftUpperCorner()[1])/FractalCanvas.getZoomFaktor(),
                                fieldsize/FractalCanvas.getZoomFaktor(),
                                fieldsize/FractalCanvas.getZoomFaktor()
                        );

                        System.out.println((fieldsize * j - FractalCanvas.getLeftUpperCorner()[1])/FractalCanvas.getZoomFaktor());
                        System.out.println((fieldsize * j - FractalCanvas.getLeftUpperCorner()[1])/FractalCanvas.getZoomFaktor());
                        System.out.println(fieldsize/FractalCanvas.getZoomFaktor());
                        System.out.println(fieldsize/FractalCanvas.getZoomFaktor());

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


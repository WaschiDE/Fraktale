package Fractal;


import Ressources.FractalCanvas;
import javafx.scene.paint.Color;

public class SierpinskiTeppich{

    public void drawSierpinskiTeppich(){
        FractalCanvas.context.setFill(Color.BLACK);
        FractalCanvas.context.setStroke(Color.BLACK);
        FractalCanvas.context.setLineWidth(5);


        int stufe = 9;
        int k = 0;
        double fieldsize;
        int canvasesize = 1000;
        int i;
        int j;
        int m = 0;

        while(k <= stufe){
             fieldsize = canvasesize / Math.pow(3,k);
             i = 0;
             while(i < Math.pow(3,k)){
                 j = 0;
                 while(j < Math.pow(3,k)){
                     if(inCarpet(i,j)){
                         if(fieldsize >= 1) {
                             m += 1;
                             FractalCanvas.context.fillRect(fieldsize * i, fieldsize * j, fieldsize, fieldsize);
                         }
                     }
                     j+=1;
                 }
                 i+=1;
             }
             k+=1;
        }
        System.out.println(m);
    }
    public boolean inCarpet(int x,int y){
        while(x != 0 && y != 0){
            if(x % 3 ==1 && y % 3 == 1){
                return true;
            }
            x = x / 3;
            y = y / 3;
        }
        return false;
    }
}


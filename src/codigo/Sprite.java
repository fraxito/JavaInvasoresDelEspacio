
package codigo;

import java.awt.Graphics2D;
import java.awt.Image;

/**
 *
 * @author xp
 */
public abstract class Sprite {

   private int x = 0;
   private int y = 0;
   private int velocidad;
   private int ancho;
   private int alto;
   private int fila;
   private int columna;
   private int fila2;
   private int columna2;

   abstract public void mueve();
   
   public void dibujaSprite(Graphics2D g2, Image i, int numeroImagen){
       if (numeroImagen == 1){
        g2.drawImage(i,               //la imagen con todos los sprites
         this.getX(),                   //posición X en el jPanel
         this.getY(),                   //posición Y en el jPanel
         this.getX()+ getAncho(),  //ancho en el jPanel
         this.getY()+ getAlto(),   //alto en el jPanel
         this.getFila() ,                //posición inicial x dentro del sprite
         this.getColumna(),             //posición inicial y dentro del sprite
         this.getFila() + getAncho() ,              //ancho en el sprite  
         this.getColumna() + getAlto() ,               //alto en el sprite
         null);
       }
       else {
        g2.drawImage(i,               //la imagen con todos los sprites
         this.getX(),                   //posición X en el jPanel
         this.getY(),                   //posición Y en el jPanel
         this.getX()+ getAncho(),  //ancho en el jPanel
         this.getY()+ getAlto(),   //alto en el jPanel
         this.getFila2() ,                //posición inicial x dentro del sprite
         this.getColumna2(),             //posición inicial y dentro del sprite
         this.getFila2() + getAncho() ,              //ancho en el sprite  
         this.getColumna2() + getAlto() ,               //alto en el sprite
         null);
       }
   }
   
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getFila2() {
        return fila2;
    }

    public void setFila2(int fila2) {
        this.fila2 = fila2;
    }

    public int getColumna2() {
        return columna2;
    }

    public void setColumna2(int columna2) {
        this.columna2 = columna2;
    }
}

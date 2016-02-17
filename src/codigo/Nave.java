/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author xp
 */
public class Nave {
   public Image imagen = null;
   private int x = 0;
   private int y = 0;
   private boolean pulsadoIzquierda = false;
   private boolean pulsadoDerecha = false;
   private int anchoMundo;
   
   public Nave (int _anchoMundo){
       try{
           imagen = ImageIO.read(getClass().getResource("/imagenes/nave.png"));
           this.anchoMundo = _anchoMundo;
       }
       catch(IOException e){
       
       }
   }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (x>0){
            this.x = x;
        }
    }

    public boolean isPulsadoIzquierda() {
        return pulsadoIzquierda;
    }

    public void setPulsadoIzquierda(boolean pulsadoIzquierda) {
        this.pulsadoIzquierda = pulsadoIzquierda;
        
    }

    public boolean isPulsadoDerecha() {
        return pulsadoDerecha;
    }

    public void setPulsadoDerecha(boolean pulsadoDerecha) {
        this.pulsadoDerecha = pulsadoDerecha;
        
    }
    public void mueve(){
        if (this.pulsadoIzquierda && this.x >0){
            this.x = this.x - 1;
        }
        if (this.pulsadoDerecha && this.x < anchoMundo-imagen.getWidth(null)){
            this.x = this.x + 1;
        }
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

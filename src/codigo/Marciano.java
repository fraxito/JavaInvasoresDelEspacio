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
public class Marciano {
   public Image imagen = null;
   public Image imagen2 = null;
   
   private int x = 0;
   private int y = 0;
   
    public Marciano() {
        try {
            imagen = ImageIO.read(getClass().getResource("/imagenes/marcianito1.png"));
            imagen2 = ImageIO.read(getClass().getResource("/imagenes/marcianito2.png"));
        } catch (IOException e) {

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
    
    public void mueve(boolean _direccionMarciano){
        
        if (_direccionMarciano ){
            this.x = this.x - 1;
        }
        if (!_direccionMarciano ){
            this.x = this.x + 1;
        }
    }
   
}

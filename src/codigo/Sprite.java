
package codigo;

import java.awt.Image;

/**
 *
 * @author xp
 */
public abstract class Sprite {
   public Image imagen = null;
   public Image imagen2 = null;
   private int x = 0;
   private int y = 0;
   private int velocidad;

   abstract public void mueve();
   
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
}

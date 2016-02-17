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
public class Disparo {

    public Image imagen = null;
    private int x = 0;
    private int y = 0;
    private int altoMundo;
    private boolean disparado = false;

    public Disparo(int _altoMundo) {
        try {
            imagen = ImageIO.read(getClass().getResource("/imagenes/disparo.png"));
            this.altoMundo = _altoMundo;
        } catch (IOException e) {

        }
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void mueve() {
        if (this.y > 0) {
            this.y = this.y - 1;
        }
    }

    public boolean isDisparado() {
        return disparado;
    }

    public void setDisparado(boolean disparado) {
        this.disparado = disparado;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    
    public void posicionaDisparo(Nave n){
        this.x = n.getX() + n.imagen.getWidth(null)/2 - this.imagen.getWidth(null)/2;
        this.y = n.getY();
    }
}

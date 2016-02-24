/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;


/**
 *
 * @author xp
 */
public class Disparo extends Sprite{

    public Disparo() {
        this.setVelocidad(8);
    }

    public void mueve() {
        if (this.getY() > -10) {
            this.setY(this.getY() - this.getVelocidad()) ;
        }
        
    }

    public void posicionaDisparo(Nave n){
        this.setX(n.getX())  ;
        this.setY(n.getY()) ;
    }
}

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
public class Marciano extends Sprite{

    public Marciano() {
        this.setVelocidad(1);
        this.setAncho(110/3);
        this.setAlto(80/3);
        this.setFila(19/3);
        this.setColumna(15/3);
        this.setFila2(165/3);
        this.setColumna2(15/3);
    }

    public void mueve(boolean _direccionMarciano){
        if (_direccionMarciano ){
            this.setX(this.getX() - this.getVelocidad());
        }
        if (!_direccionMarciano ){
            this.setX(this.getX() + this.getVelocidad());
        }
    } 

    @Override
    public void mueve() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

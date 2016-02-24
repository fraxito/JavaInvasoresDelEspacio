
package codigo;

/**
 *
 * @author xp
 */
public class Nave extends Sprite{

   private boolean pulsadoIzquierda = false;
   private boolean pulsadoDerecha = false;
   private int anchoMundo;
   
   public Nave (int _anchoMundo){
       this.setVelocidad(1);
        this.setAncho(75);
        this.setAlto(55);
        this.setFila(150);
        this.setColumna(635);

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
        if (this.pulsadoIzquierda && this.getX() >0){
            this.setX(this.getX() - this.getVelocidad());
        }
        if (this.pulsadoDerecha && this.getX() < anchoMundo - this.getAncho()){
            this.setX(this.getX() + this.getVelocidad());
        }
    }


}

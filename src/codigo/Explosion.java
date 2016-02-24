
package codigo;

/**
 *
 * @author xp
 */
public class Explosion extends Sprite{

    private int tiempoDeVida = 20;
    
    public Explosion() {
    }
        
    @Override
    public void mueve() {
        
    }

    public int getTiempoDeVida() {
        return tiempoDeVida;
    }

    public void setTiempoDeVida(int tiempoDeVida) {
        this.tiempoDeVida = tiempoDeVida;
    }
    
}

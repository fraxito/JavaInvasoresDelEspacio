/**
 *
 * @author Jorge Cisneros
 */

package codigo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.Timer;


public class VentanaJuego extends javax.swing.JFrame {

    static int ANCHOPANTALLA = 600;
    static int ALTOPANTALLA = 750;
    
    BufferedImage buffer = null;
    
    Timer temporizador = new Timer(10,new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            bucleDelJuego();
        }
    });
    
    Nave miNave = new Nave(ANCHOPANTALLA);
    ArrayList <Disparo> listaDisparos = new ArrayList();
    
    ArrayList <Marciano> listaMarcianos = new ArrayList();
    
    //variable booleana que gobierna el movimiento de los marcianos
    boolean direccionMarcianos = false;
      
    //contador para saber el numero de veces que se ha ejecutado el bucle de animacion
    int contador = 0;
    boolean cambiaImagen = false;        
            
    /**
     * Creates new form VentanaJuego
     */
    public VentanaJuego() {
        initComponents();
        this.setSize(ANCHOPANTALLA+15, ALTOPANTALLA);

        //creamos los marcianos y los añado a la lista
        for (int i=0; i< 5; i++){
            for (int j=0; j<10; j++){
                Marciano miMarciano = new Marciano();
                miMarciano.setX(j* (15 + miMarciano.imagen.getWidth(null)));
                miMarciano.setY(i* (10 + miMarciano.imagen.getHeight(null)));
                listaMarcianos.add(miMarciano);
            }
        }
        //creamos el buffer con el tamaño del jPanel
        buffer = (BufferedImage) jPanel1.createImage(ANCHOPANTALLA, ALTOPANTALLA);
        buffer.createGraphics();
        
        miNave.setX(ANCHOPANTALLA /2);
        miNave.setY(ALTOPANTALLA - 100);
        temporizador.start();
    }
   
    private void pintaDisparos(Graphics2D g2){
        for (int i = 0; i < listaDisparos.size(); i++) {
            Disparo aux;
            aux = listaDisparos.get(i);
            //recoloco el disparo
            aux.mueve();
            //si la posicion Y del disparo es menor o igual a 0, es que
            //ha llegado arriba del todo. En ese caso tengo que eliminarlo
            //si no, lo pinto
            if (aux.getY() <= -10){
                listaDisparos.remove(aux);
            }
            else{
            //pinto el disparo
                g2.drawImage(aux.imagen, aux.getX(), aux.getY(), null);
            }
        }
    }

    private void pintaMarcianos(Graphics2D g2){
        boolean cambia = false;
        for (int i = 0; i < listaMarcianos.size(); i++) {
            Marciano aux;
            aux = listaMarcianos.get(i);
            //recoloco el marciano
            aux.mueve(direccionMarcianos);
            if (aux.getX()+aux.imagen.getWidth(null) > ANCHOPANTALLA){
                cambia = true;
            } 
            if (aux.getX() <=0){
                cambia = true;
            }             
            //pinto el marciano
            if (cambiaImagen){
                g2.drawImage(aux.imagen, aux.getX(), aux.getY(), null);
            }
            else{
                g2.drawImage(aux.imagen2, aux.getX(), aux.getY(), null);
            }

        }
        if (cambia){ //si es true es que algún marciano ha tocado la pared derecha
            for (Marciano aux : listaMarcianos) {
                aux.setY(aux.getY() + aux.imagen.getHeight(null) /2 );
            }
            if (direccionMarcianos) {
                direccionMarcianos = false;}
            else {direccionMarcianos = true;}
            //direccionMarcianos = direccionMarcianos? false:true;
        }
    }
    
    private void chequeaColision(){
        //creo un marco para guardar el borde de la imagen del marciano
        Rectangle2D.Double rectanguloMarciano = new Rectangle2D.Double();
        //creo un marco para guardar el borde de la imagen del disparo
        Rectangle2D.Double rectanguloDisparo = new Rectangle2D.Double();

        for (int j=0; j<listaDisparos.size(); j++){
            Disparo d = listaDisparos.get(j);
            //asigno el marco a la posición del disparo
            rectanguloDisparo.setFrame(d.getX(),d.getY(), d.imagen.getWidth(null), d.imagen.getHeight(null));
            for(int i = 0; i < listaMarcianos.size(); i++){
                Marciano m = listaMarcianos.get(i);
                //asigno el marco a la posición del marciano
                rectanguloMarciano.setFrame(m.getX(),m.getY(), m.imagen.getWidth(null), m.imagen.getHeight(null));
                if (rectanguloDisparo.intersects(rectanguloMarciano)){
                    listaMarcianos.remove(m);
                    listaDisparos.remove(d);
                }
            }
        }
        
    }
    
    private void bucleDelJuego(){
        contador++;
        if (contador % 50 == 0){
            if (cambiaImagen) {
                cambiaImagen = false;}
            else {cambiaImagen = true;}
        }
        System.out.println(contador);
        //primero apunto al buffer
        Graphics2D g2 = (Graphics2D) buffer.getGraphics();
        //pinto un rectángulo negro del tamaño del jPanel
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, ANCHOPANTALLA, ALTOPANTALLA);
        ////////////////////////////////////////////////////
        
        pintaDisparos(g2);
        pintaMarcianos(g2);
        chequeaColision();
        //recoloco la nave
        miNave.mueve();
        //pinto la nave
        g2.drawImage(miNave.imagen, miNave.getX(), miNave.getY(), null);
        
        ///////////////////////////////////////////////////
        //apunto al jPanel y dibujo el buffer sobre el jPanel
        g2 = (Graphics2D) jPanel1.getGraphics();
        g2.drawImage(buffer, 0, 0,null);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
      switch (evt.getKeyCode()){
          case KeyEvent.VK_LEFT : { miNave.setPulsadoIzquierda(true); } break;
          case KeyEvent.VK_RIGHT : { miNave.setPulsadoDerecha(true);} break;
          case KeyEvent.VK_SPACE : { 
              // creo un disparo y lo añado al arrayList
              Disparo d = new Disparo();
              d.setDisparado(true);
              d.posicionaDisparo(miNave);
              listaDisparos.add(d);
//              if (numeroDisparosEnPantalla < listaDisparos.size())
//                {
//                    numeroDisparosEnPantalla++;
//                }
            } break;
      }  
  
        
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
      switch (evt.getKeyCode()){
          case KeyEvent.VK_LEFT : { miNave.setPulsadoIzquierda(false);} break;
          case KeyEvent.VK_RIGHT : { miNave.setPulsadoDerecha(false);} break;
      }
    }//GEN-LAST:event_formKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaJuego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

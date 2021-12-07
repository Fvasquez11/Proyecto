package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaOrden;

/**
 *
 * @author fvasq
 */
public class ControladorOrden implements ActionListener{
    
    private VistaOrden ordenVista;

    public ControladorOrden() {
        this.ordenVista = new VistaOrden();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
    
    public void iniciarOrden(){
        this.ordenVista.setVisible(true);
        System.out.println("Se inició la ventana Orden");
    }
}

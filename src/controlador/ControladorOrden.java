/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaOrden;

/**
 *
 * @author fvasq
 */
public class ControladorOrden implements ActionListener{
    
    private VistaOrden vistaOrden;

    public ControladorOrden() {
        this.vistaOrden = new VistaOrden();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void iniciarOrden(){
        this.vistaOrden.setVisible(true);
        System.out.println("Se inició la ventana Orden");
    }
}

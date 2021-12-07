package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaMenu;

/**
 *
 * @author fvasq
 */
public class ControladorMenu implements ActionListener{
    
    private VistaMenu menuVista;

    public ControladorMenu() {
        this.menuVista = new VistaMenu();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == menuVista.nuevaOrden){
            System.out.println("Se presionó el botón Nueva Orden");
            menuVista.dispose();
            ControladorOrden cOrden = new ControladorOrden();
            cOrden.iniciarOrden();
        }
        if(ae.getSource() == menuVista.listaOrdenes){
            System.out.println("Se presionó el botón Lista Ordenes");
            menuVista.setVisible(false);
            ControladorLista cLista = new ControladorLista();
            cLista.iniciarLista();
        }
    }
    
    public void iniciarMenu(){
        menuVista.setVisible(true);
        menuVista.setLocationRelativeTo(null);
        menuVista.listaOrdenes.addActionListener(this);
        menuVista.nuevaOrden.addActionListener(this);
    }
}

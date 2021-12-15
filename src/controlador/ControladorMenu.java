package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaMenu;

/**
 *
 * @author Fernando.vasquez- Paz.muñoz - Francheska.Cardenas - Elizabeth.Henríquez
 */
public class ControladorMenu implements ActionListener{
    static private VistaMenu menuVista;
// -------------------------------------------------------------
    public ControladorMenu() {
        this.menuVista = new VistaMenu();
    }
// -------------------------------------------------------------
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == menuVista.nuevaOrden){
            menuVista.dispose();
            ControladorOrden cOrden = new ControladorOrden();
            cOrden.iniciarOrden();
        }
        if(ae.getSource() == menuVista.listaOrdenes){
            menuVista.dispose();
            ControladorLista cLista = new ControladorLista();
            cLista.visibilizar();
        }
    }
// -------------------------------------------------------------
    public void iniciarMenu(){
        menuVista.setVisible(true);
        menuVista.setLocationRelativeTo(null);
        menuVista.listaOrdenes.addActionListener(this);
        menuVista.nuevaOrden.addActionListener(this);
        //menuVista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

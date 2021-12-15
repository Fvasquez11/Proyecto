package main;

import controlador.ControladorLista;
import controlador.ControladorMenu;

/**
 *
 * @author Fernando.vasquez- Paz.muñoz - Francheska.Cardenas - Elizabeth.Henríquez
 */
public class Main {
    public static void main(String[] args) {
        ControladorLista.iniciarLista();
        ControladorMenu cMenu = new ControladorMenu();
        cMenu.iniciarMenu(); 
    }  
}

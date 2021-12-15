package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Date;
import modelo.Orden;
import vista.VistaOrden;

/**
 *
 * @author Fernando.vasquez- Paz.muñoz - Francheska.Cardenas - Elizabeth.Henríquez
 */
public class ControladorOrden implements ActionListener{
    private VistaOrden ordenVista;
    private int counter;
// -------------------------------------------------------------
    public ControladorOrden() {
        this.ordenVista = new VistaOrden();
        this.counter = 0;
    }
// -------------------------------------------------------------
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == ordenVista.volverMenu){  //BOTON  VOLVER
            ordenVista.dispose();                    //Cerrar la ventana
            ControladorMenu cMenu = new ControladorMenu();  // Que se abra la vista de Menu 
            cMenu.iniciarMenu();
        }
        if(ae.getSource() == ordenVista.crearOrden){  //BOTON CREAR ORDEN
            guardarOrden();                          //Se llama el metodo que guarda la informacion      
            limpiar();                               // Se llama el metodo que limpia 
        }
    }
// -------------------------------------------------------------
    public void iniciarOrden(){
        this.ordenVista.setVisible(true);
        ordenVista.volverMenu.addActionListener(this);   //que los botones"escuchen"
        ordenVista.crearOrden.addActionListener(this);   // los botones ""esuchcen"
        this.ordenVista.setLocationRelativeTo(null);     //centrar la ventana
        ordenVista.rutC.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e ){
            formatoRut();
            } 
        });
    }
// -------------------------------------------------------------
    public void guardarOrden(){   //Guardar la Informacion que Ingrese el Usuario 
        Orden newOrden = new Orden();
        String nombre = ordenVista.nombreC.getText();
        String rut = ordenVista.rutC.getText();
        String direccion = ordenVista.direccionC.getText();
        String articulo  = ordenVista.articulosC.getText();
        String mes = ordenVista.mesDespacho.getSelectedItem().toString(); //fecha - combo box mes 
        String año = ordenVista.añoDespacho.getSelectedItem().toString();//fecha - combo box año
        String dia = ordenVista.diaDespacho.getSelectedItem().toString();//fecha - combo box dia
        newOrden.nombre = nombre;
        newOrden.rut = rut;
        newOrden.direccion = direccion;
        newOrden.articulos = articulo.split(" ");
        newOrden.despacho = new Date(Integer.valueOf(año)-1900, getMes(mes), Integer.valueOf(dia));
        newOrden.emision = new Date();
        ControladorLista.agregarOrden(newOrden);
        counter++;
    }
// -------------------------------------------------------------   
    public void limpiar(){   // Limpiar las casillas para agregar otro pedido 
        ordenVista.nombreC.setText("");
        ordenVista.rutC.setText("");
        ordenVista.direccionC.setText("");
        ordenVista.añoDespacho.setSelectedItem("2021");
        ordenVista.mesDespacho.setSelectedItem("Enero");
        ordenVista.diaDespacho.setSelectedItem("1"); 
        ordenVista.articulosC.setText("");
    }
// -------------------------------------------------------------
    public void formatoRut(){  //Formato rut para que se ponga el punto y guion
        String newRut = "";
        String rut = ordenVista.rutC.getText();
        rut = rut.replaceAll("[^0-9]", "");
        if(rut.length() > 0){
            String resto = rut.substring(rut.length()-1);
            String sub = rut.substring(0,rut.length()-1);
            newRut = "-"+ resto;
            while(sub.length()>3){
                resto = sub.substring(sub.length()-3);
                sub = sub.substring(0,sub.length()-3);
                newRut = "."+ resto + newRut;
            }

            newRut= sub + newRut;
            ordenVista.rutC.setText(newRut);
        }
    }
// -------------------------------------------------------------
    public int getMes(String mes){
        switch(mes){
            case "Enero":
                return 0;
            case "Febrero":
                return 1;
            case "Marzo":
                return 2;
            case "Abril":
                return 3;
            case "Mayo":
                return 4;
            case "Junio":
                return 5;
            case "Julio":
                return 6;
            case "Agosto":
                return 7;
            case "Septiembre":
                return 8;
            case "Octubre":
                return 9;
            case "Noviembre":
                return 10;
            case "Diciembre":
                return 11;   
            default:
                return 0;
        }
    }
}

package modelo;

import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author fvasq
 */
public class Orden {
    public int id;
    public Date emision;
    public String nombre;
    public int rut;
    public String[] articulos;
    public String direccion;
    public boolean preparada;
    public Date despacho;
// -------------------------------------------------------------
    public void displayOrden(){
        System.out.println("Id: "+id);
        System.out.println("{ Emision: " + emision.toString());
        System.out.println(" Nombre: " + nombre);
        System.out.println(" Rut: " + rut);
        System.out.println(" Articulos: " + Arrays.toString(articulos));
        System.out.println(" Dirección: " + direccion);
        System.out.println(" Preparada: " + preparada);
        System.out.println(" Despacho: " + despacho.toString());
    }
}  // end class Orden

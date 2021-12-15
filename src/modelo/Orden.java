package modelo;

import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author Fernando.vasquez- Paz.muñoz - Francheska.Cardenas - Elizabeth.Henríquez
 */
public class Orden {
    public int id;
    public Date emision;
    public String nombre;
    public String rut;
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
// -------------------------------------------------------------
    public String[] getDatos(){
        String[] Datos = new String [8];
        Datos[0] = Integer.toString(id);
        Datos[1] = emision.toString();
        Datos[2] = nombre;
        Datos[3] = rut;
        Datos[4] = Arrays.toString(articulos);
        Datos[5] = direccion;
        Datos[6] = Boolean.toString(preparada);
        Datos[7] = despacho.toString();    
        return  Datos;
    }
}  // end class Orden

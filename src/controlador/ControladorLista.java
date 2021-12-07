package controlador;

import java.util.Date;
import modelo.LinkList;
import modelo.Orden;

/**
 *
 * @author fvasq
 */
public class ControladorLista {
    
    public void test(){
        LinkList lista = new LinkList();
        
        Orden orden = new Orden();
        orden.id=1;
        Date tempDateEm = new Date(121,11,1);
        orden.emision = tempDateEm;
        orden.nombre = "Fernando";
        orden.rut = 123456789;
        String[] tempArray = {"Lapiz", "Papel"};
        orden.articulos = tempArray;
        orden.direccion = "Calle Falsa 123";
        orden.preparada = true;
        Date tempDateDesp = new Date(121,11,12);
        orden.despacho = tempDateDesp;
        
        Orden orden2 = new Orden();
        orden2.id=2;
        Date tempDateEm2 = new Date(121,11,1);
        orden2.emision = tempDateEm;
        orden2.nombre = "Fernando";
        orden2.rut = 123456789;
        String[] tempArray2 = {"Cuaderno", "Carpeta"};
        orden2.articulos = tempArray2;
        orden2.direccion = "Calle Falsa 123";
        orden2.preparada = true;
        Date tempDateDesp2 = new Date(121,11,10);
        orden2.despacho = tempDateDesp2;
        
        Orden orden3 = new Orden();
        orden3.id=3;
        Date tempDateEm3 = new Date(121,11,1);
        orden3.emision = tempDateEm;
        orden3.nombre = "Fernando";
        orden3.rut = 123456789;
        String[] tempArray3 = {"Mochila", "Goma"};
        orden3.articulos = tempArray3;
        orden3.direccion = "Calle Falsa 123";
        orden3.preparada = true;
        Date tempDateDesp3 = new Date(121,11,20);
        orden3.despacho = tempDateDesp3;
        
        Orden orden4 = new Orden();
        orden4.id=4;
        Date tempDateEm4 = new Date(121,11,1);
        orden4.emision = tempDateEm;
        orden4.nombre = "Fernando";
        orden4.rut = 123456789;
        String[] tempArray4 = {"Calculadora", "Carpeta"};
        orden4.articulos = tempArray4;
        orden4.direccion = "Calle Falsa 123";
        orden4.preparada = true;
        Date tempDateDesp4 = new Date(121,11,2);
        orden4.despacho = tempDateDesp4;
        
        lista.insertSorted(1, orden);
        lista.insertSorted(2, orden2);
        lista.insertSorted(3, orden3);
        lista.insertSorted(4, orden4);
        
        lista.displayList();
    }
}

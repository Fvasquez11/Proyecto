package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.LinkList;
import modelo.Orden;
import vista.VistaLista;

/**
 *
 * @author Fernando.vasquez- Paz.muñoz - Francheska.Cardenas - Elizabeth.Henríquez
 */
public class ControladorLista implements ActionListener{
    public static VistaLista listaVista;
    public static LinkList list;
    public static ArrayList<Orden> ordenes;
// -------------------------------------------------------------
    public ControladorLista() {
        listaVista.btnVolver.addActionListener(this);
        listaVista.btnEliminar.addActionListener(this);
        listaVista.btnDespachado.addActionListener(this); 
        listaVista.tableOrdenes.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                listaVista.tableDespachos.clearSelection();
            }
            @Override
            public void focusLost(FocusEvent fe) {
            }
        });
        listaVista.tableDespachos.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                listaVista.tableOrdenes.clearSelection();
            }
            @Override
            public void focusLost(FocusEvent fe) {
            }
        });
    }
// -------------------------------------------------------------
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == listaVista.btnVolver){
            listaVista.dispose();
            ControladorMenu cMenu = new ControladorMenu();  // Que se abra la vista de Menu 
            cMenu.iniciarMenu();
        }
        if(ae.getSource() == listaVista.btnDespachado){
            despacharOrden();
            actualizarDespacho();
        }
        if(ae.getSource() == listaVista.btnEliminar){
            int o = listaVista.tableOrdenes.getSelectedRow();
            int d = listaVista.tableDespachos.getSelectedRow();
            if(o != -1){
                eliminarOrden(o);
            }
            if(d != -1){
                int id = Integer.parseInt((String) listaVista.tableDespachos.getModel().getValueAt(d, 0));
                eliminarDespacho(id);
            }
        }
    }
// -------------------------------------------------------------
    public static void iniciarLista(){
        ControladorLista.listaVista = new VistaLista();
        ControladorLista.ordenes = new ArrayList<Orden>();
        ControladorLista.list = new LinkList();
    }
// -------------------------------------------------------------
    public void visibilizar(){
        listaVista.setVisible(true);
        listaVista.setLocationRelativeTo(null);
    }
// -------------------------------------------------------------
    public void agregarDespacho(int id, Orden orden){
        list.insertSorted(id, orden);
    }
// -------------------------------------------------------------
    public static void agregarOrden(Orden orden){
        ordenes.add(orden);
        DefaultTableModel model = (DefaultTableModel) listaVista.tableOrdenes.getModel();
        model.addRow(ordenes.get(ordenes.size()-1).getDatos());
    }
// -------------------------------------------------------------
    public static void actualizarDespacho(){
        ArrayList<Orden> allOrdenes = list.getAll();
        DefaultTableModel model = (DefaultTableModel) listaVista.tableDespachos.getModel();
        model.setRowCount(0);
        for (int i = 0; i < allOrdenes.size(); i++) {
            Orden temp = allOrdenes.get(i);
            model.addRow(temp.getDatos());
        }
    }
// -------------------------------------------------------------
    public static void despacharOrden(){
        DefaultTableModel model = (DefaultTableModel) listaVista.tableOrdenes.getModel();
        int row = listaVista.tableOrdenes.getSelectedRow();
        if(row >= 0){
            Orden temp = ordenes.get(row);
            list.insertSorted(temp.id, temp);
            ordenes.remove(row);
            model.removeRow(row);  
        }      
    }
// -------------------------------------------------------------
    public void eliminarOrden(int id){
        DefaultTableModel model = (DefaultTableModel) listaVista.tableOrdenes.getModel();
        ordenes.remove(id);
        model.removeRow(id);
    }
// -------------------------------------------------------------
    public void eliminarDespacho(int id){
        DefaultTableModel model = (DefaultTableModel) listaVista.tableDespachos.getModel();
        list.delete(id);
        actualizarDespacho();
    }
}

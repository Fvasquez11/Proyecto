package modelo;

/**
 *
 * @author Fernando.vasquez- Paz.muñoz - Francheska.Cardenas - Elizabeth.Henríquez
 */
public class Link {
    public int iData;               // data item
    public Orden dData;             // data item
    public Link next;               // next link in list
// -------------------------------------------------------------
    public Link(int id, Orden dd){  // constructor
        iData = id;                 // initialize data
        dData = dd;                 // ('next' is automatically
    }                               //  set to null)
// -------------------------------------------------------------
    public void displayLink(){      // display ourself
        System.out.print("{" + iData + "} ");
        if(next != null){
        System.out.print("{" + next.iData +"} ");
        }
        dData.displayOrden();
    }
}  // end class Link



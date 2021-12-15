package modelo;

import java.util.ArrayList;

/**
 *
 * @author Fernando.vasquez - Paz.muñoz - Francheska.Cardenas - Elizabeth.Henríquez
 */
public class LinkList {
    private Link first;            // ref to first link on list
// -------------------------------------------------------------
    public LinkList(){              // constructor
      first = null;                 // no links on list yet
    }
// -------------------------------------------------------------
    public boolean isEmpty(){       // true if list is empty
      return (first==null);
    }
// -------------------------------------------------------------
    public void insertFirst(int id, Orden dd){ // insert at start of list
        Link newLink = new Link(id, dd); // make new link
        newLink.next = first;       // newLink --> old first
        first = newLink;            // first --> newLink
    }
// -------------------------------------------------------------
    public Link deleteFirst(){      // delete first item
        if (first == null){         // if list is empty
            return null;
        }
        // (if list is not empty)
        Link temp = first;          // save reference to link
        first = first.next;         // delete it: first-->old next
        return temp;                // return deleted link
    }
// -------------------------------------------------------------
    public void delete(int id){
        if (first == null){
            return;
        }
        Link current = first;
        if(current.iData == id){
            deleteFirst();
            return;
        }
        while(current.next != null){
            if(current.next.iData == id){
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
// -------------------------------------------------------------
    public void insertLast(int id, Orden dd){ // insert at the end of the list
        Link newLink = new Link(id, dd); // make a new link
        Link current = first;   // start at the head
        while(current.next != null){ // 
            current = current.next;
        }
        current.next = newLink;
    }
// -------------------------------------------------------------
    public void insertSorted(int id, Orden dd){
        Link newLink = new Link(id,dd);
        Link previous = null;
        Link current = first;
        
        while(current != null){
            if(dd.despacho.before(current.dData.despacho)){
                break;
            }
            else{
                previous = current;
                current = current.next;
            }
        }
        if (previous == null){
            first = newLink;
            first.next = current;
        }
        else{
            previous.next = newLink;
            newLink.next = current;     
        }
    }
// -------------------------------------------------------------
    public Orden getLast(){
        Link current = first;
        while(current.next != null){
            current = current.next;
        }
        return current.dData;
    }
// -------------------------------------------------------------
    public void displayList(){
        System.out.print("List (first-->last): ");
        Link current = first;        // start at beginning of list
        while(current.next != null){ // until end of list,
            current.displayLink();   // print data
            current = current.next;  // move to next link
        }
        current.displayLink();
        System.out.println("");
    }
// -------------------------------------------------------------
    public ArrayList getAll(){
        ArrayList nodes = new ArrayList<>();
        Link current = first;
        while(current != null){
            nodes.add(current.dData);
            current = current.next;
        }
        return nodes;
    }
}  // end class LinkList

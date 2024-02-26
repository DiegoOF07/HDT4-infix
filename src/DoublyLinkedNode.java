package src;
/**
 * @author Diego Flores y Juan Solís
 * @description Clase encargada de modelar un Nodo para una cadena doblemente encadenada
 */

public class DoublyLinkedNode <T> {
    private T value;
    private DoublyLinkedNode<T> next;
    private DoublyLinkedNode<T> previous;

    /**
     * @description Constructor de la clase
     * @param value El valor del nodo
     */
    public DoublyLinkedNode(T value){
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    /** 
     * @description Método encargado de obtener el valor del nodo
     * @return El valor del nodo
    */
    public T getValue() {
        return value;
    }

    /**
     * @description Método encargado de asignarle un valor al nodo
     * @param value El valor a asignar
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * @description Método encargado de obtener el siguiente nodo
     * @return El siguiente nodo
     */
    public DoublyLinkedNode<T> getNext() {
        return next;
    }

    /**
     * @description Método encargado de asignarle un siguiente nodo al nodo actual
     * @param next El siguiente nodo
     */
    public void setNext(DoublyLinkedNode<T> next) {
        this.next = next;
    }

    /**
     * @description Método encargado de obtener el nodo anterior
     * @return El nodo anterior
     */
    public DoublyLinkedNode<T> getPrevious() {
        return previous;
    }

    /**
     * @description Método encargado de asignarle un nodo anterior al nodo actual
     * @param previous El nodo anterior
     */
    public void setPrevious(DoublyLinkedNode<T> previous) {
        this.previous = previous;
    }
}
/**
 * @author Diego Flores & Juan Sólis
 * @description Clase encargada de modelar un Nodo
 */
public class Node<T>{

    private T value;
    private Node<T> next;
    /**
     * @description Constructor de la clase
     * @param value
     */
    public Node(T value){
        this.value = value;
        this.next = null;
    }

    /**
     * @description Obtiene el valor del nodo
     * @return T
     */
    public T getValue() {
        return value;
    }

    /**
     * @description Asigna un valor al nodo
     * @param value
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * @description Obtiene el siguiente nodo
     * @return Node
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * @description Asigna el siguiente nodo
     * @param next
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }
    
}
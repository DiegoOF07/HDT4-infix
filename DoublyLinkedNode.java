/**
 * @author Diego Flores y Juan Solís
 * @description Clase encargada de modelar un Nodo para una cadena doblemente encadenada
 */

public class DoublyLinkedNode <T> implements IStack<T>{
    private T value;
    private DoublyLinkedNode<T> next;
    private DoublyLinkedNode<T> previous;

    /*
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

    /**
     * @description Método encargado de agregar un elemento a la parte superior de la pila
     * @param value El valor que se va a agregar
     */
    public void push(T value) {
        if(this.value!=null){
            DoublyLinkedNode<T> current = new DoublyLinkedNode<T>(value);
            this.setNext(current);
            current.setPrevious(this);
        }else{
            this.setValue(value);
        }
    }

    /**
     * @description Elimina y devuelve el elemento de la parte superior de la pila
     * @return El elemento en la parte superior de la pila o null en caso de estar vacía
     */
    public T pop() {
        if(this.value!=null){
            this.setPrevious(this.getPrevious().getPrevious());
            return this.getNext().getValue();
        }
        return null;
    }

    /**
     * @description Retorna el elemento que se encuentra en la parte superior de la pila sin eliminarlo
     * @return El elemento en la parte superior de la pila o null en caso de estar vacía
     */
    public T peek() {
        if(this.value!=null){
            return this.getValue();
        }
        return null;
    }
}
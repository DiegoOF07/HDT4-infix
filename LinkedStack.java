/**
 * @author Diego Flores y Juan Solís
 * @description Implementación de una pila utilizando una lista enlazada
 * @param <T> El tipo de dato de la pila
 */

public class LinkedStack <T> implements IStack<T> {
    private Node<T> top;

    /**
     * @description Constructor de la clase
     */
    public LinkedStack() {
        top = null;
    }

    /**
     * @description Método encargado de agregar un elemento a la parte superior de la pila
     * @param value El valor que se va a agregar
     */
    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.setNext(top);
        top = newNode;
    }

    /**
     * @description Elimina y devuelve el elemento de la parte superior de la pila
     * @return El elemento en la parte superior de la pila o null en caso de estar vacía
     */
    public T pop() {
        if (top != null) {
            T value = top.getValue();
            top = top.getNext();
            return value;
        }
        return null;
    }

    /**
     * @description Retorna el elemento que se encuentra en la parte superior de la pila sin eliminarlo
     * @return El elemento en la parte superior de la pila o null en caso de estar vacía
     */
    public T peek() {
        if (top != null) {
            return top.getValue();
        }
        return null;
    }
}
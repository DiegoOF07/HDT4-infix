package src;
/**
 * @author Diego Flores y Juan Solís
 * @description Implementación de una pila utilizando una lista enlazada
 * @param <T> El tipo de dato de la pila
 */

public class DoublyLinkedStack<T> implements IStack<T>{

    private DoublyLinkedNode<T> lastNode;
    
    /**
     * @description Constructor de la clase
     */
    public DoublyLinkedStack(){
        this.lastNode = new DoublyLinkedNode<T>(null);
    }
    
    /**
     * @description Método encargado de agregar un elemento a la parte superior de la pila
     * @param value El valor que se va a agregar
     */
    public void push(T value) {
        if(lastNode.getValue()!=null){
            DoublyLinkedNode<T> current = new DoublyLinkedNode<T>(value);
            lastNode.setNext(current);
            current.setPrevious(lastNode);
            lastNode = current;
        }else{
            lastNode.setValue(value);
        }
    }

    /**
     * @description Elimina y devuelve el elemento de la parte superior de la pila
     * @return El elemento en la parte superior de la pila o null en caso de estar vacía
     */
    public T pop() {
        if(lastNode!=null){
            if(lastNode.getPrevious()==null){
                return lastNode.getValue();
            }else{
                lastNode=lastNode.getPrevious();
                return lastNode.getNext().getValue();
            }
        }
        return null;
    }

    /**
     * @description Retorna el elemento que se encuentra en la parte superior de la pila sin eliminarlo
     * @return El elemento en la parte superior de la pila o null en caso de estar vacía
     */
    public T peek() {
        if(lastNode.getValue()!=null){
            return lastNode.getValue();
        }
        return null;
    }
}
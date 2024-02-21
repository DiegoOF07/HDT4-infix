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
    @Override
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
    @Override
    public T pop() {
        if(lastNode.getValue()!=null){
            lastNode=lastNode.getPrevious();
            return lastNode.getNext().getValue();
        }
        return null;
    }
}


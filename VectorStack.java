import java.util.Vector;

/**
 * @author Diego Flores y Juan Solís
 * @description Implementación de una pila utilizando Array
 * @param <T> El tipo de dato de la pila
 */

public class VectorStack<T> implements IStack<T> {

    private Vector<T> stack;

    /**
     * @description Constructor de la clase
     */
    public VectorStack(){
        stack = new Vector<T>();
    }

    /**
     * @description Método encargado de agregar un elemento a la parte superior de la pila
     * @param value El valor a agregar
     */
    @Override
    public void push(T value) {
        stack.add(value);
    }

    /**
     * @description Elimina y devuelve el elemento de la parte superior de la pila
     * @return El elemento en la parte superior de la pila o null si está se encuentra vacía
     */
    @Override
    public T pop() {
        if(!stack.isEmpty()){
            return stack.remove(stack.size()-1);
        }
        return null;
    }

    /**
     * @description Retorna el elemento que se encuentra en la parte superior de la pila sin eliminarlo
     * @return El elemento en la parte superior de la pila o null si está se encuentra vacía
     */
    public T peek() {
        if (!stack.isEmpty()) {
            return stack.get(stack.size() - 1);
        }
        return null;
    }
}

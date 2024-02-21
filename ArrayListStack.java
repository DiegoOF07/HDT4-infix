import java.util.ArrayList;

/**
 * @author Diego Flores y Juan Solís
 * @description Implementación de una pila utilizando ArrayList
 * @param <T> El tipo de dato de la pila
 */

public class ArrayListStack <T> implements IStack<T> {
    private ArrayList<T> stack;

    /**
     * @description Constructor de la clase
     */
    public ArrayListStack() {
        stack = new ArrayList<>();
    }

    /**
     * @description Método encargado de agregar un elemento a la parte superior de la pila
     * @param value El valor a agregar
     */
    public void push(T value) {
        stack.add(value);
    }

    /**
     * @description Elimina y devuelve el elemento de la parte superior de la pila
     * @return El elemento en la parte superior de la pila o null si está se encuentra vacía
     */
    public T pop() {
        if (!stack.isEmpty()) {
            return stack.remove(stack.size() - 1);
        }
        return null;
    }
}
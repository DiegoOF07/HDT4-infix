/**
 * @author Diego Flores y Juan Solís
 * @creationDate 20/02/2024
 * @description Interfaz que define los métodos para el funcionamiento de la pila
 */

 public interface IStack<T> {
    /**
    * @description Agrega un elemento a la parte superior de la pila
    * @param value
    */
    public void push(T value);

    /**
    * @description Elimina y retorna el elemento que se encuentra en la parte superior de la pila
    * @return T
    */
    public T pop();

    /**
     * Retorna el elemento que se encuentra en la parte superior de la pila sin eliminarlo
     * @return T
     */
    T peek();
}

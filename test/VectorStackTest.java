package test;
import org.junit.*;
import src.VectorStack;

/**
 * @author: Diego Flores y Juan Solís
 * @description: Clase que se encarga de probar la funcionalidad de la pila implementada con un vector
 */

public class VectorStackTest {
    /**
     * @description Prueba para verificar que el método push funcione correctamente implementado con un vector
     * (La prueba está hecha para no fallar)
     */
    @Test
    public void testCorrectPush() {
        VectorStack<Integer> stack = new VectorStack<>();
        stack.push(9);
        stack.push(18);
        stack.push(27);
        Assert.assertEquals(3, stack.peek().intValue());
    }

    /**
     * @description Prueba para verificar que el método pop funcione correctamente implementado con un vector
     * (La prueba está hecha para no fallar)
     */
    @Test
    public void testCorrectPop() {
        VectorStack<Integer> stack = new VectorStack<>();
        stack.push(9);
        stack.push(27);
        Assert.assertEquals(27, stack.pop().intValue());
        Assert.assertEquals(9, stack.pop().intValue());
        Assert.assertEquals(null, stack.pop());
    }
}

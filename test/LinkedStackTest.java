package test;
import org.junit.*;
import src.LinkedStack;

/**
 * @author: Diego Flores y Juan Solís
 * @description: Clase que se encarga de probar la funcionalidad de la pila implementada de una lista encadenada
 */
public class LinkedStackTest {
    /**
     * @description Prueba para verificar que el método push funcione correctamente implementado con una stack encadenada trayendo el último elemento agregado
     * (La prueba está hecha para no fallar)
     */
    @Test
    public void testCorrectPush() {
        LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(9);
        stack.push(18);
        stack.push(27);
        Assert.assertEquals(27, stack.peek().intValue());
    }

    /**
     * @description Prueba para verificar que el método pop funcione correctamente implementado con una stack encadenada trayendo el último elemento agregado
     * (La prueba está hecha para no fallar)
     */
    @Test
    public void testCorrectPop() {
        LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(9);
        stack.push(18);
        stack.push(27);
        Assert.assertEquals(27, stack.pop().intValue());
        Assert.assertEquals(18, stack.pop().intValue());
        Assert.assertEquals(9, stack.pop().intValue());
    }

    /**
     * @description Prueba para verificar que el método pop  funcione correctamente implementado con una stack encadenada al esperar un resultado 
     * diferente al correcto
     * (La prueba está hecha para fallar)
     */
    @Test
    public void testIncorrectPop() {
        LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(9);
        stack.push(27);
        stack.push(18);
        Assert.assertEquals(27, stack.pop().intValue());
        Assert.assertEquals(9, stack.pop().intValue());
        Assert.assertEquals(null, stack.pop());
    }
}



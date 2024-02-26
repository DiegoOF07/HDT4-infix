package test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.*;
import src.Calculator;

/**
 * @author: Diego Flores y Juan Solís
 * @description: Clase que se encarga de probar la funcionalidad de la calculadora
 */

public class CalculatorTest {
    /**
     * @description Prueba para verificar que el método add funcione correctamente
     * (La prueba está hecha para no fallar)
     */
    @Test
    public void testCorrectCalculateAddOperation() {
       Calculator calculator = Calculator.getInstance();
        int operationResult = calculator.add(8, 3);
        assertEquals(11, operationResult);
    }

    /**
     * @description Prueba para verificar que el método subtract funcione correctamente
     * (La prueba está hecha para no fallar)
     */
    @Test
    public void testCorrectCalculateSubtractOperation() {
        Calculator calculator = Calculator.getInstance();
        int operationResult = calculator.subtract(3, 8);
        assertEquals(5, operationResult);
    }

    /**
     * @description Prueba para verificar que el método multiply funcione correctamente
     * (La prueba está hecha para no fallar)
     */
    @Test
    public void testCorrectCalculateMultiplyOperation() {
        Calculator calculator = Calculator.getInstance();
        int operationResult = calculator.multiply(2, 4);
        assertEquals(12, operationResult);
    }

    /**
     * @description Prueba para verificar que el método divide funcione correctamente
     * (La prueba está hecha para fallar)
     */
    @Test
    public void testIncorrectCalculateDivideOperation() {
        Calculator calculator = Calculator.getInstance();
        int operationResult = calculator.divide(3, 9);
        assertEquals(4, operationResult);
    }
}
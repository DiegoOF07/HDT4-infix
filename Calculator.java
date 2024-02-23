/**
 * @author Diego Flores y Juan Solís
 * @creationDate 23/02/2024
 * @description Clase Calculadora que realiza las operaciones básicas de suma, resta, mutiplicación y división
 */

public class Calculator {
    private static Calculator instance;
    private Calculator() {}

    /**
     * @description Método encargado de crear una instancia de la calculadora
     * @return Una instancia de la calculadora
     */
    public static synchronized Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
        }
        return instance;
    }

    /**
     * Selecciona la operación a realizar entre dos números dependiendo el operador ingresado
     *
     * @param operator El operador de la operación a realizar
     * @param a El primer número
     * @param b El segundo número
     * @return La operación a realizar
     * @throws IllegalArgumentException Si el operador ingresado no es válido
     */
    public int calculate(char operator, int a, int b) {
        switch (operator) {
            case '+':
                return add(a, b);
            case '-':
                return subtract(a, b);
            case '*':
                return multiply(a, b);
            case '/':
                return divide(a, b);
            default:
                throw new IllegalArgumentException("El carácter " + operator + " no puede ser interpretado como operador");
        }
    }

    /**
     * Suma dos números enteros
     *
     * @param a El primer número
     * @param b El segundo número
     * @return La suma de los dos números enteros
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Resta dos números enteros
     *
     * @param a El primer número
     * @param b El segundo número
     * @return La resta de los dos números enteros
     */
    public int subtract(int a, int b) {
        return a - b;
    }

    /**
     * Multiplica dos números enteros
     *
     * @param a El primer número
     * @param b El segundo número
     * @return La multiplicación de los dos números enteros
     */
    public int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Divide dos números enteros
     *
     * @param a El primer número
     * @param b El segundo número
     * @return La división de los dos números enteros o el valor de 0 si se intenta dividir entre 0
     * @throws IllegalArgumentException Si se intenta realizar una división entre 0
     */
    public int divide(int a, int b) {
        if (b != 0) {
            double c = a / b;
            return (int) Math.round(c);
        } else {
            System.out.println("\nResultado: No se puede realizar una división entre 0");
            throw new IllegalArgumentException("No se puede realizar una división entre 0");
        }
    }
}
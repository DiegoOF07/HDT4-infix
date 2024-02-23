import java.util.Scanner;

/**
 * @autor Diego Flores y Juan Solís
 * @description Clase controladora de la implementación de la pila a utilizar
 */

public class StackController {
    /**
     * @description Método encargado de crear una instancia de la pila
     * @param stackSelected El tipo de pila a crear
     * @return Una instancia de la pila o null en caso de haber seleccionado una opción inválida
     */
    public static IStack<String> createStack(String stackSelected) {
        switch (stackSelected) {
            case "1":
                System.out.println("Se ha creado una pila con ArrayList");
                return new ArrayListStack<>();
            case "2":
                System.out.println("Se ha creado una pila con Vector");
                return new VectorStack<>();
            case "3":
                return selectListImplementation();
            default:
                return null;
        }
    }

    /**
     * @description Método encargado de seleccionar la implementación de la lista (encadenada o doblemente encadenada)
     * @return Una instancia de la lista seleccionada o null en caso de haber seleccionado una opción inválida
     */
    private static IStack<String> selectListImplementation() {
        System.out.println("\n1. Simplemente encadenada");
        System.out.println("2. Doblemente encadenada");
        System.out.print("Seleccione la implementación de la lista: ");

        Scanner sc = new Scanner(System.in);
        String listSelected = sc.nextLine();

        switch (listSelected) {
            case "1":
                System.out.println("Se ha creado una pila con lista simplemente encadenada");
                return new LinkedStack<>();
            case "2":
                System.out.println("Se ha creado una pila con lista doblemente encadenada");
                return new DoublyLinkedStack<>();
            default:
                return null;
        }
    }
}
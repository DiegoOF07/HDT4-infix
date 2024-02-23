import java.util.Scanner;

/**
 * @autor Diego Flores y Juan Solís
 * @description Clase principal del programa
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nPROGRAMA PARA EVALUAR EXPRESIONES INFIX");
        System.out.println("1. ArrayList");
        System.out.println("2. Vector");
        System.out.println("3. Lista");
        System.out.print("Seleccione la implementación del stack: ");
        String stackSelected = sc.nextLine();

        IStack<String> stack = StackController.createStack(stackSelected);
        if (stack != null) {
            // Program
        } else {
            System.out.println("Asegurese de seleccionar una opción válida para la implementación del stack");
        }

        sc.close();
    }
}
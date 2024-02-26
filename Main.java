import java.util.Scanner;

/**
 * @autor Diego Flores y Juan Solís
 * @description Clase principal del programa
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackController stackController = new StackController();

        System.out.println("\nPROGRAMA PARA EVALUAR EXPRESIONES INFIX");
        System.out.println("1. ArrayList");
        System.out.println("2. Vector");
        System.out.println("3. Lista");
        System.out.print("Seleccione la implementación del stack: ");
        String stackSelected = sc.nextLine();
        stackController.factoryCreateStack(stackSelected);

        try {
            System.out.println("(Puede ingresar varias expresiones infix en el archivo dando saltos de línea)");
            stackController.manageOperations();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al realizar la operación");
        }

        sc.close();
    }
}
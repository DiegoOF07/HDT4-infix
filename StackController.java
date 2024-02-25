import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

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

    /**
     * @description Método que determina la jerarquía de un caracter
     * @param operator
     * @return int
     */
    public int precedence(char operator){
        if(operator=='^') return 3;
        else if (operator == '*' || operator=='/') return 2;
        else if (operator == '+' || operator=='-') return 1;
        else return 0;
    }

    /**
     * @description Método que convierte las expresiones InFix en PostFix
     * @param infixExpressions
     * @return ArrayList<String> expresiones postfix
     */
    public ArrayList<String> infixToPostfix(ArrayList<String> infixExpressions){
        Stack<Character> stack = new Stack<>(); 
        ArrayList<String> postfixExpressions = new ArrayList<>();
        String output = "";
        for (String expression : infixExpressions) {
            stack.add('#');
            char digits[] = expression.replace(" ", "").toCharArray();
            for (Character character : digits) {
                if(Character.isLetterOrDigit(character)){
                    output+= character;
                }else if(character.equals('(')){
                    
                    stack.add(character);
                }else if(character.equals('^')){
                   
                    stack.add(character);
                }else if(character.equals(')')){
                   
                    while(!stack.peek().equals('#') && !stack.peek().equals('(')){
                        output += stack.pop();
                        
                    }
                    stack.pop();
                }else{
                    if(precedence(character) > precedence(stack.peek()))stack.push(character);
                        
                    else{
                        while(!stack.peek().equals('#') && precedence(character) <= precedence(stack.peek())){
                            output += stack.pop();
                        }
                        stack.add(character);
                    }
                }
            }
            while (!stack.peek().equals('#')) {
                output += stack.pop();
            }
            postfixExpressions.add(output);
            output = "";
        }
        return postfixExpressions;
    }
}
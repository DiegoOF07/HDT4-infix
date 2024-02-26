package src;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @autor Diego Flores y Juan Solís
 * @description Clase controladora de la implementación de la pila a utilizar
 */

public class StackController {
    /**
     * @description Método encargado de crear una instancia de la pila
     * @param stackSelected El tipo de pila a crear
     */
    
    private IStack<Character> stackInfixPostfix;
    private IStack<String> stackPostfixResult;
    private Reader reader = new Reader("datos.txt");
    private boolean tipo = true;

    public void factoryCreateStack(String stackSelected) {
        switch (stackSelected) {
            case "1":
                System.out.println("Las pilas se trabajaran con la implementación de ArrayList");
                stackInfixPostfix = new ArrayListStack<>();
                stackPostfixResult = new ArrayListStack<>();
                break;
            case "2":
                System.out.println("Las pilas se trabajaran con la implementación de Vector");
                stackInfixPostfix = new VectorStack<>();
                stackPostfixResult = new VectorStack<>();
                break;
            case "3":
                tipo = false;
                selectListImplementation();
                break;
            default:
                System.out.println("Opción inválida");
        }
    }

    /**
     * @description Método encargado de seleccionar la implementación de la lista (encadenada o doblemente encadenada)
     */
    private void selectListImplementation() {
        System.out.println("\n1. Simplemente encadenada");
        System.out.println("2. Doblemente encadenada");
        System.out.print("Seleccione la implementación de la lista: ");

        Scanner sc = new Scanner(System.in);
        String listSelected = sc.nextLine();

        switch (listSelected) {
            case "1":
                System.out.println("Las pilas se trabajaran con la implementación de lista simplemente encadenada");
                stackInfixPostfix = new LinkedStack<>();
                stackPostfixResult = new LinkedStack<>();
                break;
            case "2":
                System.out.println("Las pilas se trabajaran con la implementación de lista doblemente encadenada");
                stackInfixPostfix = new DoublyLinkedStack<>();
                stackPostfixResult = new DoublyLinkedStack<>();
                break;
            default:
                System.out.println("Opción inválida");
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
        ArrayList<String> postfixExpressions = new ArrayList<>();
        String output = "";
        for (String expression : infixExpressions) {
            stackInfixPostfix.push('#');
            char digits[] = expression.replace(" ", "").toCharArray();

            for (Character character : digits) {
                if(Character.isLetterOrDigit(character)){
                    output+= character;

                }else if(character.equals('(')){
                    stackInfixPostfix.push(character);

                }else if(character.equals('^')){
                   
                    stackInfixPostfix.push(character);
                }else if(character.equals(')')){
                   
                    while(!stackInfixPostfix.peek().equals('#') && !stackInfixPostfix.peek().equals('(')){
                        output += stackInfixPostfix.pop();
                        
                    }
                    stackInfixPostfix.pop();

                }else{
                    if(precedence(character) > precedence(stackInfixPostfix.peek()))stackInfixPostfix.push(character);
                        
                    else{
                        while(!stackInfixPostfix.peek().equals('#') && precedence(character) <= precedence(stackInfixPostfix.peek())){
                            output += stackInfixPostfix.pop();
                        }
                        stackInfixPostfix.push(character);
                    }
                }
            }

            while (!stackInfixPostfix.peek().equals('#')) {
                output += stackInfixPostfix.pop();
            }
            postfixExpressions.add(output);
            output = "";
        }
        return postfixExpressions;
    }

    /**
     * @throws Exception
     * @description Método encargado de utilizar las lineas del archivo de texto para identificar las expresiones postfix y mostrar el resultado
     */
    public void manageOperations() throws Exception{
        File fileReader = new File("datos.txt");
        if(fileReader.exists()){
            for (String expresion : infixToPostfix(reader.read())) {
                char digits[] = expresion.replace(" ", "").toCharArray();
                boolean expresionValida = true;

                System.out.print("\nExpresión: " + expresion);

                if (digits.length < 3) {
                    System.out.println("\nResultado: La expresión es muy corta como para mostrar un resultado");
                    continue;
                }

                for(int i = 0; i<digits.length; i++){
                    stackPostfixResult.push(String.valueOf(digits[i]));
                    if(digits[i] == '+' || digits[i] == '-' || digits[i] == '*' || digits[i] == '/'){
                        try {
                            stackPostfixResult.pop();
                            Calculator calculatorInstance = Calculator.getInstance();
                            int newValue = calculatorInstance.calculate(digits[i], Integer.parseInt(stackPostfixResult.pop()), Integer.parseInt(stackPostfixResult.pop()));
                            stackPostfixResult.push(Integer.toString(newValue));
                        } catch (Exception e) {
                            expresionValida = false;
                        }
                    }
                }

                if (tipo) {
                    if (expresionValida) {
                        System.out.println("\nResultado: " + Integer.parseInt(stackPostfixResult.pop()));
                    } else {
                        System.out.println("\nResultado: La expresión postfix no es válida");
                    }
                } else {
                    System.out.println("\nSe implementó una lista");
                }
                
            }
            
        } else {
            System.out.println("\nNo sé encontró el archivo datos.txt, agreguelo a la carpeta de OurCalculator");
        } 
    }
}
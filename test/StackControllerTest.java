package test;
import org.junit.*;
import src.StackController;
import java.util.ArrayList;

/**
 * @author: Diego Flores y Juan Solís
 * @description: Clase que se encarga de probar la funcionalidad de la clase que controla a todas las pilas y hace la conversion
 * infix a postfix
 */
public class StackControllerTest {
    
    /**
     * @description Prueba para verificar que el método infixToPostfix realice correctamente las conversiones
     * (La prueba está hecha para no fallar)
     */
    @Test
    public void infixToPostfixTest(){
        StackController st = new StackController();
        ArrayList<String> expressions = new ArrayList<>();
        expressions.add("(5 + 2) * 8");
        st.factoryCreateStack("1");
        Assert.assertEquals("52+8*", st.infixToPostfix(expressions).get(0));
    }


}

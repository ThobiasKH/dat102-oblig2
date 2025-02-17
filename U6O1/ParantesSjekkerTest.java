package U6O1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParantesSjekkerTest {

    @Test
    public void testValidParentheses() {
        ParantesSjekker sjekker = new ParantesSjekker();

        String validStr1 = "{ [ ( ) ] }";
        String validStr2 = "{ [ ( ) ] }";
        assertTrue(sjekker.sjekkParanteser(validStr1), "The parentheses should be valid.");
        assertTrue(sjekker.sjekkParanteser(validStr2), "The parentheses should be valid.");
    }

    @Test
    public void testInvalidParentheses() {
        ParantesSjekker sjekker = new ParantesSjekker();

        String invalidStr1 = "{ [ ( ) }";
        String invalidStr2 = "[ ( ) ] }";
        String invalidStr3 = "{ [ ( ] ) }";
        assertFalse(sjekker.sjekkParanteser(invalidStr1), "The parentheses should be invalid.");
        assertFalse(sjekker.sjekkParanteser(invalidStr2), "The parentheses should be invalid.");
        assertFalse(sjekker.sjekkParanteser(invalidStr3), "The parentheses should be invalid.");
    }

    @Test
    public void testJavaProgram() {
        ParantesSjekker sjekker = new ParantesSjekker();

        String javaprogram = """
            class HelloWorld {
                public static void main(String[] args) {
                    System.out.println("Hello World!");
                }
            }
        """;
        assertTrue(sjekker.sjekkParanteser(javaprogram), "The Java program parentheses should be valid.");
    }
}

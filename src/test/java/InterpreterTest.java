import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class InterpreterTest {
    
    @Test
    void powAndSqrt(){
        Interpreter i= new Interpreter();
        List<String> expression = new ArrayList<>(List.of("22", "*", "4", "+", "2", "^", "3","+","#","9"));
        assertEquals(List.of("22", "*", "4", "+","8.0","+","#","9"),i.resolvePowAndSqrt(expression));
    }
}

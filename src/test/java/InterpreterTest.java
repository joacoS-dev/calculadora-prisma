import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class InterpreterTest {

    @Test
    void shuntingYard(){
        Interpreter interpreter= new Interpreter();
        List<String> expression= List.of("3","+","2","*","6","-","4","/","2","+","#","9");
        assertEquals(List.of("3","2","6","*","+","4","2","/","-","9","#","+"), interpreter.shuntingYard(expression));
    }

    @Test
    void shutingYardParenthesis(){
        Interpreter interpreter= new Interpreter();
        List<String> expression= List.of("3","+","2","*","6","/","(","3","+","2",")","+","1");
        assertEquals(List.of("3","2","6","*","3","2","+","/","+","1","+"),interpreter.shuntingYard(expression));
    }
}

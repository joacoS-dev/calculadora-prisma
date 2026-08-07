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

    @Test
    void calculateSimpleExpression(){
        Tokenizer tokenizer= new Tokenizer();
        Interpreter interpreter= new Interpreter();
        Calculator calculator= new Calculator();

        String expression= "22*2+3-1";
        Double calculatedExpression= interpreter.calculatExpression(expression);
        assertEquals(46.0, calculatedExpression);
    }

    @Test
    void calculateExpression(){
        Tokenizer tokenizer= new Tokenizer();
        Interpreter interpreter= new Interpreter();
        Calculator calculator= new Calculator();

        String expression= "22+9^2+#9";
        Double calculatedExpression= interpreter.calculatExpression(expression);
        assertEquals(106.0, calculatedExpression);
    }
}

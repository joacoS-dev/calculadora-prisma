import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.jupiter.api.Test;

import Calculator.Calculator;
import Calculator.Interpreter;
import Calculator.Tokenizer;

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

    @Test
    void calculateParenthesisExpression(){
        Tokenizer tokenizer= new Tokenizer();
        Interpreter interpreter= new Interpreter();
        Calculator calculator= new Calculator();

        String expression= "22+3^2+48/(2+2*(8+3))";
        Double calculatedExpression= interpreter.calculatExpression(expression);
        assertEquals(33.0, calculatedExpression);
    } 

    @Test
    void calculateNegativeNumberExpression(){
        Tokenizer tokenizer= new Tokenizer();
        Interpreter interpreter= new Interpreter();
        Calculator calculator= new Calculator();

        String expression= "10*(-2)+(-2)";
        Double calculatedExpression= interpreter.calculatExpression(expression);
        assertEquals(-22, calculatedExpression);
    }
    @Test
    void quickTest(){
        Tokenizer tokenizer= new Tokenizer();
        Interpreter interpreter= new Interpreter();
        Calculator calculator= new Calculator();

        String expression= "55*2*4*9";
        Double calculatedExpression= interpreter.calculatExpression(expression);
        assertEquals(3960.0, calculatedExpression);
    }
}

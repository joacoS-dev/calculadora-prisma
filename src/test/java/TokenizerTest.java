
import org.junit.jupiter.api.Test;

import Calculator.Tokenizer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

public class TokenizerTest {
    
    @Test
    void operators(){
        Tokenizer t= new Tokenizer();
        String expression= "43+2-55+(55-4)";
        List<String> result= t.tokenizeExpression(expression);
        assertEquals(List.of("43", "+", "2", "-", "55", "+", "(", "55", "-", "4", ")"), result);
    }

    @Test
    void negativeNumber(){
        Tokenizer t= new Tokenizer();
        String expression= "-5+33/(-3)";
        List<String> result= t.tokenizeExpression(expression);
        assertEquals(List.of("-5", "+", "33", "/", "(", "-3", ")"), result);
    }
}

import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Tokenizer tokenizer = new Tokenizer();
        List<String> tokens = tokenizer.tokenizeExpression("3+4*2/(1-5)^2^3");
        System.out.println(tokens);
    }
}

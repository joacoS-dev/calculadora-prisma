import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    
    public List<String> tokenizeExpression(String expression){
        List<String> result = new ArrayList<>();
        StringBuilder actualToken = new StringBuilder();
        for(int i=0; i<expression.length();i++){
            char c= expression.charAt(i);
            if(Character.isDigit(c) || c == '.'){
                actualToken.append(c);
            }else if(c == '-' && isNegative(result, actualToken)) {
                actualToken.append(c);
            }else{
                if(actualToken.length()>0){
                    result.add(actualToken.toString());
                    actualToken.setLength(0);
                }
                result.add(String.valueOf(c));
            }
        }
        if(actualToken.length()>0){
            result.add(actualToken.toString());
        }
        return result;
    }

    private boolean isNegative (List<String> tokens, StringBuilder actualToken){
        if(actualToken.length()!= 0){
            return false;
        }
        if(actualToken.isEmpty()){
            return true;
        }
        String lastToken= tokens.get(tokens.size()-1);
        return lastToken.equals("(");
    }
}

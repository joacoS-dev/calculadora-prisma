import java.util.ArrayList;
import java.util.List;

public class StringInterpreter{
   
    Calculator calculator= new Calculator();

    private void resolvePowAndSqrt(List<String> expression){
        for(int i=0; i < expression.size(); i++){
            if(expression.get(i) == "^"){
                expression.remove(i-1);
                expression.remove(i+1);
                expression.add(String.valueOf(calculator.pow(i-1, i+1)));
            }
        }
    }
}


/*case "^":
                double multipiedNum= calculator.pow(Double.parseDouble(expressionArray.get(i-1)), Double.parseDouble(expressionArray.get(i-+1)));
                expressionArray.remove(expressionArray.get(i-1));
                expressionArray.remove(expressionArray.get(i+1));
                expressionArray.add(String.valueOf(multipiedNum));
                break;
            case"#":
                double numSqrt= calculator.sqrt(Double.parseDouble(expressionArray.get(i+1)));
                expressionArray.remove(expressionArray.get(i-1));
                expressionArray.remove(expressionArray.get(i+1));
                expressionArray.add(String.valueOf(numSqrt));
                break; */
/*case "*":
                double multipiedNum= calculator.mul(Double.parseDouble(expressionArray.get(i-1)), Double.parseDouble(expressionArray.get(i-+1)));
                expressionArray.remove(expressionArray.get(i-1));
                expressionArray.remove(expressionArray.get(i+1));
                expressionArray.add(String.valueOf(multipiedNum));
                break;
            case"/":
                double dividedNum= calculator.div(Double.parseDouble(expressionArray.get(i-1)), Double.parseDouble(expressionArray.get(i+1)));
                expressionArray.remove(expressionArray.get(i-1));
                expressionArray.remove(expressionArray.get(i+1));
                expressionArray.add(String.valueOf(dividedNum));
                break;*/
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Interpreter{
   
    Calculator calculator= new Calculator();

    public Double shuntingYard(List<String> expression){
        List<String> queue= new ArrayList<>();
        Stack stack = new Stack<>();

        for(int i=0; i< expression.size(); i++){
            String token= expression.get(i);
            if(isNumber(token)){
                queue.add(token);
            }else{ //its an operator
                int stackPrescedence= getPrescedence((String) stack.peek());
                int tokenPrescedence=  getPrescedence(token);

                
            }
        }
    }

    private boolean isNumber(String token){
        try {
            {
                Double.parseDouble(token);
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isAsociativeLeft(String operator){
        return !operator.equals("^");
    }

    private int getPrescedence(String operator){
        switch(operator){
            case "#":
            case "^":
                return 1;
            case"*":
            case"/":
                return 2;
            case "+":
            case "-":
                return 3;
            default:
                return -1;
        }
    }
}
 /*public List<String> resolvePowAndSqrt(List<String> expression){
        for(int i=0; i < expression.size(); i++){
            if(expression.get(i).equals("^")){
                Double pow= calculator.pow(Double.parseDouble(expression.get(i-1)), Double.parseDouble(expression.get(i+1)));
                expression.set(i-1,String.valueOf(pow));
                expression.remove(i+1);
                expression.remove(i);
            }
        }
        return expression;
    }*/


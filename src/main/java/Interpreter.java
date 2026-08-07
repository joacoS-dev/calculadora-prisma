import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Interpreter{
   
    Calculator calculator= new Calculator();
    Tokenizer tokenizer= new Tokenizer();

    public double calculatExpression(String expression){
        List<String> tokenizedExpression= tokenizer.tokenizeExpression(expression);
        List<String> orderedExpression= shuntingYard(tokenizedExpression);
        for(int i=0; i<orderedExpression.size();i++){
            String token= orderedExpression.get(i);
            switch(token){
                case "*":
                double multiplicationResult= calculator.mul(Double.parseDouble(orderedExpression.get(i-1)),Double.parseDouble(orderedExpression.get(i-2)));
                orderedExpression.set(i, String.valueOf(multiplicationResult));
                orderedExpression.remove(i-1) ; 
                orderedExpression.remove(i-2);
                i=i-3;
                break;
                case"/":
                double divisionResult= calculator.div(Double.parseDouble(orderedExpression.get(i-2)), Double.parseDouble(orderedExpression.get(i-1)));
                orderedExpression.set(i, String.valueOf(divisionResult));
                orderedExpression.remove(i-1);
                orderedExpression.remove(i-2);
                i=i-3;
                break;
                case"+":
                double sumResult= calculator.add(Double.parseDouble(orderedExpression.get(i-2)), Double.parseDouble(orderedExpression.get(i-1)));
                orderedExpression.set(i, String.valueOf(sumResult));
                orderedExpression.remove(i-1);
                orderedExpression.remove(i-2);
                i=i-3;
                break;
                case"-":
                double subResult= calculator.sub(Double.parseDouble(orderedExpression.get(i-2)), Double.parseDouble(orderedExpression.get(i-1)));
                orderedExpression.set(i, String.valueOf(subResult));
                orderedExpression.remove(i-1);
                orderedExpression.remove(i-2);
                i=i-3;
                case"#":
                double sqrtResult=calculator.sqrt(Double.parseDouble(orderedExpression.get(i-1)));
                orderedExpression.set(i, String.valueOf(sqrtResult));
                orderedExpression.remove(i-1);
                i=i-2;
                break;
                case"^":
                double powResult=calculator.pow(Double.parseDouble(orderedExpression.get(i-1)),Double.parseDouble(orderedExpression.get(i+1)));
                orderedExpression.set(i, String.valueOf(powResult));
                orderedExpression.remove(i-1);
                orderedExpression.remove(i+1);
                i=i-3;
            }
        }
        return Double.parseDouble(orderedExpression.get(0));
    }

    public List<String> shuntingYard(List<String> expression){
        List<String> outputQueue= new ArrayList<>();
        Stack <String>operatorStack = new Stack<>();

        for(int i=0; i< expression.size(); i++){
            String token= expression.get(i);
            if(isNumber(token)){
                outputQueue.add(token);
            }else if(token.equals("(")){
                operatorStack.push(token);
            }else if(token.equals(")")){
                while(!operatorStack.peek().equals("(")){
                    outputQueue.add(String.valueOf(operatorStack.pop()));
                }
                operatorStack.pop();
            }else{ 
                int stackTopPrescedence=0;
                int tokenPrescedence=  getPrescedence(token);
                while(!operatorStack.isEmpty()){
                    stackTopPrescedence= getPrescedence((String) operatorStack.peek());
                    if(stackTopPrescedence > tokenPrescedence || stackTopPrescedence == tokenPrescedence && isAsociativeLeft(token)){//probar sacar asociative left
                    outputQueue.add(String.valueOf(operatorStack.pop()));
                    }else{
                        break;
                    }
                }
                operatorStack.push(token);
        }
        }
        while(!operatorStack.isEmpty()){
            outputQueue.add(operatorStack.pop());
        }
        return outputQueue;
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

    /*private boolean isOperator(String token){
        try {
            {
                Double.parseDouble(token);
                return false;
            }
        } catch (Exception e) {
            return true;
        }
    }*/

    private boolean isAsociativeLeft(String operator){
        return !operator.equals("^");
    }

    private int getPrescedence(String operator){
        switch(operator){
            case "#":
            case "^":
                return 3;
            case"*":
            case"/":
                return 2;
            case "+":
            case "-":
                return 1;
            default:
                return -1;
        }
    }

    /*for(int i=0; i< orderedExpression.size(); i++){
            String token= orderedExpression.get(i);
            if(token.equals("*")){
                double multiplicationResult= calculator.mul(Double.parseDouble(orderedExpression.get(i-1)),Double.parseDouble(orderedExpression.get(i-2)));
                orderedExpression.set(i, String.valueOf(multiplicationResult));
                orderedExpression.remove(i-1) ;
                orderedExpression.remove(i-2);
            }
        }*/
}





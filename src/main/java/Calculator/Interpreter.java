package Calculator;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Interpreter{
   
    Calculator calculator= new Calculator();
    Tokenizer tokenizer= new Tokenizer();

    public Double calculatExpression(String expression){
        List<String> tokenizedExpression= tokenizer.tokenizeExpression(expression);
        List<String> orderedExpression= shuntingYard(tokenizedExpression);
        Stack<Double> resultStack = new Stack<>();
        for(int i=0; i<orderedExpression.size();i++){
            String token= orderedExpression.get(i);
            switch(token){
                case "*":
                    Double a= resultStack.pop();
                    Double b= resultStack.pop();
                    resultStack.push(calculator.mul(b, a));
                    break;
                case"/":
                    Double c= resultStack.pop();
                    Double d= resultStack.pop();
                    resultStack.push(calculator.div(d, c));
                    break;
                case"+":
                    Double e= resultStack.pop();
                    Double f= resultStack.pop();
                    resultStack.push(calculator.add(f, e));
                    break;
                case"-":
                    Double g= resultStack.pop();
                    Double h= resultStack.pop();
                    resultStack.push(calculator.sub(h, g));
                    break;
                case"#":
                    Double j= resultStack.pop();
                    resultStack.push(calculator.sqrt(j));
                    break;
                case"^":
                    Double k= resultStack.pop();
                    Double m= resultStack.pop();
                    resultStack.push(calculator.pow(m, k));
                    break;
            }
            if(isNumber(token)){
                resultStack.push(Double.parseDouble(token));
            }
        }
        return resultStack.pop();
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
}





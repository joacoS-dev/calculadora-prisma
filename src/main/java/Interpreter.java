import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Interpreter{
   
    Calculator calculator= new Calculator();

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
                //recorrer stack hasta encontrar el primer "(" y mover los operadores de en medio a la queue y borrar los parentesis.
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
}


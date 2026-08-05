
public class Calculator {
    
    public Calculator(){};

    public double add(double a, double b){
        return a+b;
    }

    public double sub(double a, double b){
        return a-b;
    }

    public double  mul(double a, double b){
        return a*b;
    }

    public double div(double a, double b){
        return a/b;
    }

    public double pow(double a, double b){
        return Math.pow(a, b);
    }

    public double sqrt(double a){
        return Math.sqrt(a);
    }
}

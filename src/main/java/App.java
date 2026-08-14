import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import Calculator.Interpreter;
import Calculator.Tokenizer;
import NewsApi.HttpService;
import NewsApi.ShowArticle;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc= new Scanner(System.in);
        Interpreter interpreter= new Interpreter();
        ShowArticle newArticle= new ShowArticle();
        int time= LocalTime.now().getHour();
        String ASSIGN_A_NAME= "";
        String welcome;
        if(time<12){welcome= "Good moring";}else if(time<20){welcome="Good afternoon";}else{welcome="Good evening";}
        System.out.println("""
                
          ¡%s, %s!       )  (
          ═══════════════════════       )  (
                                        )  (
                                      .--------.
                                      |########|\\
         # System ready to operate #  |########| )
                                      |########|/
                                      '--------'                
        """.formatted(welcome,ASSIGN_A_NAME));
        System.out.println("Ingresa tu expresión:");
        String input= sc.nextLine();
        while(!input.equals("exit")){
            if(input.equals("news")){
                newArticle.showArticle();
                input= sc.nextLine();
            }else if(input.matches("^(?!.*[+\\-*/^]{2,})(?!.*\\(\\))(\\(?-?\\d+(\\.\\d+)?\\)?|[+\\-*/^\\(\\)])+$")){
                System.out.println("\nResult =" + interpreter.calculatExpression(input) + "\n");
                input= sc.nextLine();
            }else{
                System.out.println("\nCan't process your input");
                input= sc.nextLine();
            }   
        }
        if(time<19){
            System.out.println("¡Have a nice day!");
        }else{
             System.out.println("¡Good night!");
            }
        System.exit(0);
    } 
}

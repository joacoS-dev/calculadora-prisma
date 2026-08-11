import java.util.List;

import Api.HttpService;
import Calculator.Tokenizer;

public class App {
    public static void main(String[] args) throws Exception {
        HttpService httpService= new HttpService();
        httpService.getArticle();
    }
}

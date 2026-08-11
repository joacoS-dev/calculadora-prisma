import java.util.List;

import Calculator.Tokenizer;
import NewsApi.HttpService;

public class App {
    public static void main(String[] args) throws Exception {
        HttpService httpService= new HttpService();
        httpService.showArticle();
    }
}

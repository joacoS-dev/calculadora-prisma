package NewsApi;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import NewsApi.ArticleResponse.Article;

public class HttpService {

    public List<Article> getApiNew(){
        try {
            final HttpClient httpClient= HttpClient.newHttpClient();
            HttpRequest request= HttpRequest.newBuilder()
            .uri(URI.create("https://newsapi.org/v2/top-headlines?category=science&pageSize=1&apiKey=42a0951dff364b7685de4894c9c49f31"))
            .build();
            HttpResponse<String> response= httpClient.send(request, BodyHandlers.ofString());
            ObjectMapper mapper= new ObjectMapper();
            ArticleResponse responseArticle= mapper.readValue(response.body(), ArticleResponse.class);
            return responseArticle.getArticles();
        } catch (Exception e) {
            throw new RuntimeException("Error fetching news on API", e);
        }        
    }

    public void showArticle(){

        Article article= getApiNew().get(0);
        
        String RESET = "\u001B[0m";
        String CYAN = "\u001B[36m";
        String WHITE = "\u001B[37m";
        String GRAY = "\u001B[90m";
        String BOLD = "\u001B[1m";

        System.out.println();
        System.out.println(CYAN + "══════════════════════════════════════════════════════════" + RESET);
        System.out.println(BOLD + "                     📰 SCIENCE NEWS" + RESET);
        System.out.println(CYAN + "══════════════════════════════════════════════════════════" + RESET);

        System.out.println();
        System.out.println(BOLD + WHITE + article.getTitle() + RESET);

        System.out.println();
        System.out.println(GRAY + article.getDescription() + RESET);

        System.out.println();
        System.out.println(CYAN + "🔗 " + article.getUrl() + RESET);

        System.out.println();
        System.out.println(CYAN + "══════════════════════════════════════════════════════════" + RESET);
        System.out.println();
    }
}

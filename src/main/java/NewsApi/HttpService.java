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
            final HttpClient httpClient = HttpClient.newHttpClient();
            String PASTE_API_KEY="";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://newsapi.org/v2/top-headlines?category=science&pageSize=1&apiKey=" + PASTE_API_KEY))
                    .build();
            HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();
            ArticleResponse responseArticle = mapper.readValue(response.body(), ArticleResponse.class);
            return responseArticle.getArticles();
        } catch (Exception e) {
            throw new RuntimeException("Error fetching news on API", e);
        }
    }
}

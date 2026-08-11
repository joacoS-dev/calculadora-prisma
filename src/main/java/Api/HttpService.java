package Api;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class HttpService {

    public String getArticle(){
        try {
            final HttpClient httpClient= HttpClient.newHttpClient();
            HttpRequest request= HttpRequest.newBuilder()
            .uri(URI.create("https://newsapi.org/v2/sources?category=science&apiKey=42a0951dff364b7685de4894c9c49f31"))
            .build();
            HttpResponse<String> response= httpClient.send(request, BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            throw new RuntimeException("Error fetching news on API", e);
        }        
    }
}

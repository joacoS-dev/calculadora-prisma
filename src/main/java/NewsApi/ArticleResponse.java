package NewsApi;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticleResponse{
    @Override
    public String toString() {
        return "ArticleResponse [status=" + status + ", totalResults=" + totalResults + ", articles=" + articles + "]";
    }
    private String status;
    private int totalResults;
    private List<Article> articles;

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getTotalResults() {
        return totalResults;
    }
    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }
    public List<Article> getArticles() {
        return articles;
    }
    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Article{
        @Override
        public String toString() {
            return "Article [title=" + title + ", description="+ description + ", url=" + url + "]";
        }
        private String title;
        private String description;
        private String url;

        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }
        public String getUrl() {
            return url;
        }
        public void setUrl(String url) {
            this.url = url;
        }
    }
}
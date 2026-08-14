package NewsApi;
import NewsApi.ArticleResponse.Article;

public class ShowArticle {
    HttpService httpService= new HttpService();
    public void showArticle() {
    Article article = httpService.getApiNew().get(0);
    String RESET = "\u001B[0m";
    String WHITE = "\u001B[37m";
    String GRAY = "\u001B[90m";
    String BOLD = "\u001B[1m";

    System.out.println();
    System.out.println("══════════════════════════════════════════════════════════");
    System.out.println(BOLD + "                     📰 SCIENCE NEWS" + RESET);
    System.out.println("══════════════════════════════════════════════════════════");

    System.out.println();
    System.out.println(BOLD + WHITE + article.getTitle() + RESET);

    System.out.println();
    System.out.println(GRAY + article.getDescription() + RESET);

    System.out.println();
    System.out.println("🔗 " + article.getUrl());

    System.out.println();
    System.out.println("══════════════════════════════════════════════════════════");
    System.out.println();
}
}

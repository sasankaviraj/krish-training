import java.util.ArrayList;

//originator
public class Favorite {

    ArrayList<Article> articles = new ArrayList<>();

    public void addArticle(Article article){
        articles.add(article);
    }

    public ArrayList<Article> getArticles() {
        return (ArrayList<Article>) articles.clone();
    }

    public FavoriteMemento saveArticle(){
        return new FavoriteMemento(getArticles());
    }

    public void remove(FavoriteMemento favoriteMemento){
        articles = favoriteMemento.getArticles();
    }

    static class FavoriteMemento{
        ArrayList<Article> articles;

        public FavoriteMemento(ArrayList<Article> articles) {
            this.articles = articles;
        }

        private ArrayList<Article> getArticles() {
            return articles;
        }

        @Override
        public String toString() {
            return "FavoriteMemento{" +
                    "articles=" + articles +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "articles=" + articles +
                '}';
    }
}

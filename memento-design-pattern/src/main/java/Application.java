public class Application {

    public static void main(String[] args) {

        CareTaker careTaker = new CareTaker();

        Favorite favorite = new Favorite();

        favorite.addArticle(new Article("Article 1"));
        favorite.addArticle(new Article("Article 2"));
        careTaker.save(favorite);
        System.out.println(favorite);
        System.out.println(careTaker);

        favorite.addArticle(new Article("Article 3"));
        careTaker.save(favorite);
        System.out.println(favorite);
        System.out.println(careTaker);

        favorite.addArticle(new Article("Article 4"));
        careTaker.save(favorite);
        System.out.println(favorite);
        System.out.println(careTaker);

        favorite.addArticle(new Article("Article 5"));
        careTaker.save(favorite);
        System.out.println(favorite);
        System.out.println(careTaker);

        careTaker.remove(favorite);
        System.out.println(favorite);
        System.out.println(careTaker);

        careTaker.remove(favorite);
        System.out.println(favorite);
        System.out.println(careTaker);
    }
}

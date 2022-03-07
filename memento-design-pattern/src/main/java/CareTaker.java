import java.util.Stack;

public class CareTaker {

    Stack<Favorite.FavoriteMemento> history = new Stack<>();

    public void save(Favorite favorite){
        history.push(favorite.saveArticle());
    }

    public void remove(Favorite favorite){
        if (!history.isEmpty())
            favorite.remove(history.pop());
        else
            System.out.println("Cannot undo");
    }

    @Override
    public String toString() {
        return "CareTaker{" +
                "history=" + history +
                '}';
    }
}

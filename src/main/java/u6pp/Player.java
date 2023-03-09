package u6pp;
import java.util.ArrayList;
public class Player {
    String name;
    ArrayList<Card> playerhand = new ArrayList<Card>();
    Player(String me){
        name =me;
    }
    String getName(){
        return name;
    }
    ArrayList<Card> getHand(){
        return playerhand;
    }
}

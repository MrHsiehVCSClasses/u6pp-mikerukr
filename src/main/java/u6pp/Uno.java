package u6pp;

import java.util.ArrayList;

public class Uno {
    ArrayList<Player> player;
    CardStack playingdeck;
    CardStack discard;
    int playerIndex;
    boolean reversed;
    //constructor and instance variables
    Uno(ArrayList<Player> inPlayer, CardStack inDeck, CardStack inDiscard, int inPlayerIndex, boolean inReversed){
        player = inPlayer;
        playingdeck = inDeck;
        discard = inDiscard;
        playerIndex = inPlayerIndex;
        reversed = inReversed;
    }
    //tracks the amount of players
    public Uno(int PI) {
        playerIndex = PI;
        reversed = false;
        for (int i = 0; i < playerIndex; i++){
            Player myPlayer = new Player("" + i);
            player.add(myPlayer);
        }
    }
    //returns current turn
    Player getCurrentPlayer(){
        return player.get(playerIndex);
    }
    //next player turn
    Player getNextPlayer(){
        int add = 1;
        if (reversed==true){
            add*= -1;
        }
        if (playerIndex+ add >= player.size()){
            return player.get(0);
        }
        else if (playerIndex + add < 0){
            return player.get(player.size() - 1);
        }
        return player.get(playerIndex + add);
    }
    //gets the top card
    Card getTopDiscard(){
        return discard.playingdeck.get(discard.playingdeck.size()-1);
    }
    //returns the winner, if none returns null
    Player getWinner(){
        for (Player p : player){
            if (p.getHand().isEmpty() == true){
                return p;
            }
        }
        return null;
    }
    //plays the card
    boolean playCard(Card c, String s){
        boolean temp = false;
        if (c == null){
            getCurrentPlayer().getHand().add(playingdeck.pop());
            playingdeck.shuffle();
            if(playingdeck.peek() == null){
                playingdeck.shuffle();
            }

            int add = 1;
            if (reversed == true){
                add *= -1;
            }if (playerIndex + add >= player.size()){
                playerIndex = 0;
            }else if (playerIndex + add < 0){
                playerIndex = player.size() - 1;
            }else{
                playerIndex = playerIndex + add;
            }playingdeck.shuffle();
        }for (Card h : getCurrentPlayer().getHand()){
            if (c == h){
                temp = true;
            }
        }if (temp == false){
            return false;
        }if (c.canPlayOn(discard.peek())){
            discard.push(c);
            getCurrentPlayer().getHand().remove(c);
            nextPlayer(c);
            return true; 
        }
            return false;
    }
//next players move
    void nextPlayer(Card c){
        int add = 1;
        if (c.getValue()==Card.REVERSE&&reversed==true){
            add = 1;
        }else if (c.getValue()==Card.REVERSE||reversed==true){
            add *= -1;
        }if (c.getValue()== Card.SKIP && reversed == true){
            add = 2;
        }if (playerIndex + add >= player.size()){
            playerIndex = 0;
        }else if (playerIndex + add < 0){
            playerIndex = player.size() - 1;
        }else{
            playerIndex = playerIndex + add;
        }
    }
    //returns the players
    public ArrayList<Player> getPlayers() {
        return player;
    }
}
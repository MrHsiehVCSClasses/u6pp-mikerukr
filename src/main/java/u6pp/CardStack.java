package u6pp;

import java.util.ArrayList;
import java.util.Random;
public class CardStack{
    ArrayList<Card> playingdeck = new ArrayList<Card>();
    public CardStack() {
    }
    //checks whether deck is empty
    boolean isEmpty(){
    if (playingdeck.size()==0){
         return true;
        }
        return false;
    }
    //checks whether deck is empty
    Card peek(){
        if (playingdeck.isEmpty()==true){
        return null;
        }
    return playingdeck.get(playingdeck.size()-1);
    }
    //adds card to deck
    public void push(Card card) {
    playingdeck.add(card);
    }
    //returns size of deck
    int getSize(){
    return playingdeck.size() ;
    }
    //get a card
    Card pop(){
        Card temp = playingdeck.get(playingdeck.size()-1);
     playingdeck.remove(playingdeck.get(playingdeck.size()-1));
    return temp;
    }
    //clears the deck if empty
    void clear(){
        while(playingdeck.isEmpty()==false){
            playingdeck.remove(0);
        }
    }
    //adds new deck once out
    void addAll(CardStack stack){
        if(playingdeck.equals(stack.playingdeck)){
            return;
        }
        while(stack.isEmpty() == false){
            playingdeck.add(stack.playingdeck.get(0));
            stack.playingdeck.remove(0);
        }
    }
    //shuffles the deck
    void shuffle(){
        for (int i = 0; i < playingdeck.size();i++){
            Random myRandom = new Random();
            int ran;

            ran = myRandom.nextInt(playingdeck.size());

            Card temp;
            temp = playingdeck.get(ran);
            playingdeck.set(ran, playingdeck.get(i));
            playingdeck.set(i, temp);
        }
    }
}

package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javafx.scene.image.Image;


class PlayingCardException extends Exception {


	PlayingCardException (){
		super ();
	}
	PlayingCardException ( String reason ){
		super ( reason );
	}
}

class Card {

	static final String[] Suit = {"","Clubs", "Diamonds", "Hearts", "Spades" };
	static final String[] Rank = {"","A","2","3","4","5","6","7","8","9","10","J","Q","K"};


	private int cardRank; 
	private int cardSuit;  
	private Image cardVis;
	public Image getCardVis() {
		return cardVis;
	}


	public void setCardVis(Image cardVis) {
		this.cardVis = cardVis;
	}


	//card constructor
	public Card(int rank, int suit){ 
	
			cardRank = rank;
		
			cardSuit = suit;
	}


	public int getRank() { return cardRank; }
	public int getSuit() { return cardSuit; }
	public String toString() { return Rank[cardRank] + " " + Suit[cardSuit] + this.cardVis.toString();} 

}





class OneDeck {
	public List<Card> saveDeck;   
	public  List<Card> playDeck;

//Creates and saves copy of a deck
	public OneDeck()
	{
		try {
			saveDeck = new ArrayList<Card>();
			playDeck = new ArrayList<Card>();
			//creates the save deck
			for(int i =1;i<5;i++) {
				for(int s = 1;s<14;s++) {

					saveDeck.add(new Card(s,i));
				}
				
			}
			
			saveDeck.get(0).setCardVis(new Image(getClass().getResourceAsStream("ace_of_clubs.png")));
			saveDeck.get(1).setCardVis(new Image(getClass().getResourceAsStream("2_of_clubs.png")));
			saveDeck.get(2).setCardVis(new Image(getClass().getResourceAsStream("3_of_clubs.png")));
			saveDeck.get(3).setCardVis(new Image(getClass().getResourceAsStream("4_of_clubs.png")));
			saveDeck.get(4).setCardVis(new Image(getClass().getResourceAsStream("5_of_clubs.png")));
			saveDeck.get(5).setCardVis(new Image(getClass().getResourceAsStream("6_of_clubs.png")));
			saveDeck.get(6).setCardVis(new Image(getClass().getResourceAsStream("7_of_clubs.png")));
			saveDeck.get(7).setCardVis(new Image(getClass().getResourceAsStream("8_of_clubs.png")));
			saveDeck.get(8).setCardVis(new Image(getClass().getResourceAsStream("9_of_clubs.png")));
			saveDeck.get(9).setCardVis(new Image(getClass().getResourceAsStream("10_of_clubs.png")));
			saveDeck.get(10).setCardVis(new Image(getClass().getResourceAsStream("jack_of_clubs.png")));
			saveDeck.get(11).setCardVis(new Image(getClass().getResourceAsStream("queen_of_clubs.png")));
			saveDeck.get(12).setCardVis(new Image(getClass().getResourceAsStream("king_of_clubs.png")));
			//
			saveDeck.get(13).setCardVis(new Image(getClass().getResourceAsStream("ace_of_diamonds.png")));
			saveDeck.get(14).setCardVis(new Image(getClass().getResourceAsStream("2_of_diamonds.png")));
			saveDeck.get(15).setCardVis(new Image(getClass().getResourceAsStream("3_of_diamonds.png")));
			saveDeck.get(16).setCardVis(new Image(getClass().getResourceAsStream("4_of_diamonds.png")));
			saveDeck.get(17).setCardVis(new Image(getClass().getResourceAsStream("5_of_diamonds.png")));
			saveDeck.get(18).setCardVis(new Image(getClass().getResourceAsStream("6_of_diamonds.png")));
			saveDeck.get(19).setCardVis(new Image(getClass().getResourceAsStream("7_of_diamonds.png")));
			saveDeck.get(20).setCardVis(new Image(getClass().getResourceAsStream("8_of_diamonds.png")));
			saveDeck.get(21).setCardVis(new Image(getClass().getResourceAsStream("9_of_diamonds.png")));
			saveDeck.get(22).setCardVis(new Image(getClass().getResourceAsStream("10_of_diamonds.png")));
			saveDeck.get(23).setCardVis(new Image(getClass().getResourceAsStream("jack_of_diamonds.png")));
			saveDeck.get(24).setCardVis(new Image(getClass().getResourceAsStream("queen_of_diamonds.png")));
			saveDeck.get(25).setCardVis(new Image(getClass().getResourceAsStream("king_of_diamonds.png")));
			//
			saveDeck.get(26).setCardVis(new Image(getClass().getResourceAsStream("ace_of_hearts.png")));
			saveDeck.get(27).setCardVis(new Image(getClass().getResourceAsStream("2_of_hearts.png")));
			saveDeck.get(28).setCardVis(new Image(getClass().getResourceAsStream("3_of_hearts.png")));
			saveDeck.get(29).setCardVis(new Image(getClass().getResourceAsStream("4_of_hearts.png")));
			saveDeck.get(30).setCardVis(new Image(getClass().getResourceAsStream("5_of_hearts.png")));
			saveDeck.get(31).setCardVis(new Image(getClass().getResourceAsStream("6_of_hearts.png")));
			saveDeck.get(32).setCardVis(new Image(getClass().getResourceAsStream("7_of_hearts.png")));
			saveDeck.get(33).setCardVis(new Image(getClass().getResourceAsStream("8_of_hearts.png")));
			saveDeck.get(34).setCardVis(new Image(getClass().getResourceAsStream("9_of_hearts.png")));
			saveDeck.get(35).setCardVis(new Image(getClass().getResourceAsStream("10_of_hearts.png")));
			saveDeck.get(36).setCardVis(new Image(getClass().getResourceAsStream("jack_of_hearts.png")));
			saveDeck.get(37).setCardVis(new Image(getClass().getResourceAsStream("queen_of_hearts.png")));
			saveDeck.get(38).setCardVis(new Image(getClass().getResourceAsStream("king_of_hearts.png")));
			//
			saveDeck.get(39).setCardVis(new Image(getClass().getResourceAsStream("ace_of_spades.png")));
			saveDeck.get(40).setCardVis(new Image(getClass().getResourceAsStream("2_of_spades.png")));
			saveDeck.get(41).setCardVis(new Image(getClass().getResourceAsStream("3_of_spades.png")));
			saveDeck.get(42).setCardVis(new Image(getClass().getResourceAsStream("4_of_spades.png")));
			saveDeck.get(43).setCardVis(new Image(getClass().getResourceAsStream("5_of_spades.png")));
			saveDeck.get(44).setCardVis(new Image(getClass().getResourceAsStream("6_of_spades.png")));
			saveDeck.get(45).setCardVis(new Image(getClass().getResourceAsStream("7_of_spades.png")));
			saveDeck.get(46).setCardVis(new Image(getClass().getResourceAsStream("8_of_spades.png")));
			saveDeck.get(47).setCardVis(new Image(getClass().getResourceAsStream("9_of_spades.png")));
			saveDeck.get(48).setCardVis(new Image(getClass().getResourceAsStream("10_of_spades.png")));
			saveDeck.get(49).setCardVis(new Image(getClass().getResourceAsStream("jack_of_spades.png")));
			saveDeck.get(50).setCardVis(new Image(getClass().getResourceAsStream("queen_of_spades.png")));
			saveDeck.get(51).setCardVis(new Image(getClass().getResourceAsStream("king_of_spades.png")));
			
			//copies save deck to the playdeck
			for (int i = 0;i<saveDeck.size(); i++) {
				playDeck.add(saveDeck.get(i));
			}
		}
		catch(Exception PlayingCardException) {
			new PlayingCardException("oopsies");
		}
	
		
///		
	}
//shuffles any given deck
	public void shuffle()
	{
		for(int i = 0;i<playDeck.size();i++) {
			int random = (int)(Math.random() * playDeck.size() );
			int rank = playDeck.get(random).getRank();
			int suit = playDeck.get(random).getSuit();

			playDeck.remove(random);
			try {
				playDeck.add(new Card(rank, suit));
			}catch(Exception e) {
				System.out.println("issue with shuffle method");
			}

		}

	}
//returns a list of cards of specified size
//removes cards that are in this list
	public List<Card> deal(int numberCards) throws PlayingCardException
	{
		List<Card> reList = null;
try {
		if(numberCards>playDeck.size()) {
			throw new PlayingCardException("Not enough cards to deal");

		}
		else 
		{
			reList = new ArrayList<Card>();

			for(int i = 0;i<numberCards;i++) {
				reList.add(playDeck.get(i));	

			}
			for(int i = 0;i<reList.size();i++) {
				playDeck.remove(reList.get(i));
			}

		}

		return reList;
}catch(Exception e) {
	return reList;
}
	}
//resets the deck back to the saved deck copy
	public void reset()
	{
		playDeck.clear();
		for (int i = 0;i<saveDeck.size(); i++) {
			playDeck.add(saveDeck.get(i));
			}
	}

//returns amount of cards in deck
	public int remainSize()
	{
		return playDeck.size();
	}
	public String toString()
	{
		return ""+playDeck;
	}
}

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

//Card Definition
class Card {

	static final String[] Suit = {"","Clubs", "Diamonds", "Hearts", "Spades" };
	static final String[] Rank = {"","A","2","3","4","5","6","7","8","9","10","J","Q","K"};

	//Rank, Suit and Image
	private int cardRank; 
	private int cardSuit;  
	private Image cardVis;

	public Image getCardVis() {
		return cardVis;
	}

	//Assigns image to a card
	public void setCardVis(Image cardVis) {
		this.cardVis = cardVis;
	}


	//Card constructor
	public Card(int rank, int suit){ 

		cardRank = rank;

		cardSuit = suit;
	}


	public int getRank() { return cardRank; }
	public int getSuit() { return cardSuit; }
	public String toString() { return Rank[cardRank] + " " + Suit[cardSuit] + this.cardVis.toString();} 

}




//Deck definition using a list of cards
class OneDeck {

	public List<Card> saveDeck;   
	public  List<Card> playDeck;

	//Creates deck
	public OneDeck()
	{
		try {
			saveDeck = new ArrayList<Card>();
			playDeck = new ArrayList<Card>();
			//Creates the save deck
			for(int i =1;i<5;i++) {
				for(int s = 1;s<14;s++) {

					saveDeck.add(new Card(s,i));
				}

			}
			//Adding all of the respective images to each card
			saveDeck.get(0).setCardVis(new Image(getClass().getResourceAsStream("Cards/ace_of_clubs.png")));
			saveDeck.get(1).setCardVis(new Image(getClass().getResourceAsStream("Cards/2_of_clubs.png")));
			saveDeck.get(2).setCardVis(new Image(getClass().getResourceAsStream("Cards/3_of_clubs.png")));
			saveDeck.get(3).setCardVis(new Image(getClass().getResourceAsStream("Cards/4_of_clubs.png")));
			saveDeck.get(4).setCardVis(new Image(getClass().getResourceAsStream("Cards/5_of_clubs.png")));
			saveDeck.get(5).setCardVis(new Image(getClass().getResourceAsStream("Cards/6_of_clubs.png")));
			saveDeck.get(6).setCardVis(new Image(getClass().getResourceAsStream("Cards/7_of_clubs.png")));
			saveDeck.get(7).setCardVis(new Image(getClass().getResourceAsStream("Cards/8_of_clubs.png")));
			saveDeck.get(8).setCardVis(new Image(getClass().getResourceAsStream("Cards/9_of_clubs.png")));
			saveDeck.get(9).setCardVis(new Image(getClass().getResourceAsStream("Cards/10_of_clubs.png")));
			saveDeck.get(10).setCardVis(new Image(getClass().getResourceAsStream("Cards/jack_of_clubs2.png")));
			saveDeck.get(11).setCardVis(new Image(getClass().getResourceAsStream("Cards/queen_of_clubs2.png")));
			saveDeck.get(12).setCardVis(new Image(getClass().getResourceAsStream("Cards/king_of_clubs2.png")));
			//
			saveDeck.get(13).setCardVis(new Image(getClass().getResourceAsStream("Cards/ace_of_diamonds.png")));
			saveDeck.get(14).setCardVis(new Image(getClass().getResourceAsStream("Cards/2_of_diamonds.png")));
			saveDeck.get(15).setCardVis(new Image(getClass().getResourceAsStream("Cards/3_of_diamonds.png")));
			saveDeck.get(16).setCardVis(new Image(getClass().getResourceAsStream("Cards/4_of_diamonds.png")));
			saveDeck.get(17).setCardVis(new Image(getClass().getResourceAsStream("Cards/5_of_diamonds.png")));
			saveDeck.get(18).setCardVis(new Image(getClass().getResourceAsStream("Cards/6_of_diamonds.png")));
			saveDeck.get(19).setCardVis(new Image(getClass().getResourceAsStream("Cards/7_of_diamonds.png")));
			saveDeck.get(20).setCardVis(new Image(getClass().getResourceAsStream("Cards/8_of_diamonds.png")));
			saveDeck.get(21).setCardVis(new Image(getClass().getResourceAsStream("Cards/9_of_diamonds.png")));
			saveDeck.get(22).setCardVis(new Image(getClass().getResourceAsStream("Cards/10_of_diamonds.png")));
			saveDeck.get(23).setCardVis(new Image(getClass().getResourceAsStream("Cards/jack_of_diamonds2.png")));
			saveDeck.get(24).setCardVis(new Image(getClass().getResourceAsStream("Cards/queen_of_diamonds2.png")));
			saveDeck.get(25).setCardVis(new Image(getClass().getResourceAsStream("Cards/king_of_diamonds2.png")));
			//
			saveDeck.get(26).setCardVis(new Image(getClass().getResourceAsStream("Cards/ace_of_hearts.png")));
			saveDeck.get(27).setCardVis(new Image(getClass().getResourceAsStream("Cards/2_of_hearts.png")));
			saveDeck.get(28).setCardVis(new Image(getClass().getResourceAsStream("Cards/3_of_hearts.png")));
			saveDeck.get(29).setCardVis(new Image(getClass().getResourceAsStream("Cards/4_of_hearts.png")));
			saveDeck.get(30).setCardVis(new Image(getClass().getResourceAsStream("Cards/5_of_hearts.png")));
			saveDeck.get(31).setCardVis(new Image(getClass().getResourceAsStream("Cards/6_of_hearts.png")));
			saveDeck.get(32).setCardVis(new Image(getClass().getResourceAsStream("Cards/7_of_hearts.png")));
			saveDeck.get(33).setCardVis(new Image(getClass().getResourceAsStream("Cards/8_of_hearts.png")));
			saveDeck.get(34).setCardVis(new Image(getClass().getResourceAsStream("Cards/9_of_hearts.png")));
			saveDeck.get(35).setCardVis(new Image(getClass().getResourceAsStream("Cards/10_of_hearts.png")));
			saveDeck.get(36).setCardVis(new Image(getClass().getResourceAsStream("Cards/jack_of_hearts2.png")));
			saveDeck.get(37).setCardVis(new Image(getClass().getResourceAsStream("Cards/queen_of_hearts2.png")));
			saveDeck.get(38).setCardVis(new Image(getClass().getResourceAsStream("Cards/king_of_hearts2.png")));
			//
			saveDeck.get(39).setCardVis(new Image(getClass().getResourceAsStream("Cards/ace_of_spades.png")));
			saveDeck.get(40).setCardVis(new Image(getClass().getResourceAsStream("Cards/2_of_spades.png")));
			saveDeck.get(41).setCardVis(new Image(getClass().getResourceAsStream("Cards/3_of_spades.png")));
			saveDeck.get(42).setCardVis(new Image(getClass().getResourceAsStream("Cards/4_of_spades.png")));
			saveDeck.get(43).setCardVis(new Image(getClass().getResourceAsStream("Cards/5_of_spades.png")));
			saveDeck.get(44).setCardVis(new Image(getClass().getResourceAsStream("Cards/6_of_spades.png")));
			saveDeck.get(45).setCardVis(new Image(getClass().getResourceAsStream("Cards/7_of_spades.png")));
			saveDeck.get(46).setCardVis(new Image(getClass().getResourceAsStream("Cards/8_of_spades.png")));
			saveDeck.get(47).setCardVis(new Image(getClass().getResourceAsStream("Cards/9_of_spades.png")));
			saveDeck.get(48).setCardVis(new Image(getClass().getResourceAsStream("Cards/10_of_spades.png")));
			saveDeck.get(49).setCardVis(new Image(getClass().getResourceAsStream("Cards/jack_of_spades2.png")));
			saveDeck.get(50).setCardVis(new Image(getClass().getResourceAsStream("Cards/queen_of_spades2.png")));
			saveDeck.get(51).setCardVis(new Image(getClass().getResourceAsStream("Cards/king_of_spades2.png")));

			//Saves a copy of the un-altered deck
			for (int i = 0;i<saveDeck.size(); i++) {
				playDeck.add(saveDeck.get(i));
			}
		}

		catch(Exception PlayingCardException) {
			new PlayingCardException("Something went wrong when building the deck");
		}

	}
	//Shuffles the playing deck using RNG
	public void shuffle()
	{
		for(int i = 0;i<playDeck.size();i++) {
			int random = (int)(Math.random() * playDeck.size() );

			Card temp = playDeck.get(i);
			playDeck.set(i, playDeck.get(random));
			playDeck.set(random, temp);
		}

	}
	//Deals cards from the deck
	public List<Card> deal(int numberCards) throws PlayingCardException
	{
		List<Card> reList = null;

		try {

			if(numberCards>playDeck.size()) {

				throw new PlayingCardException("Not enough cards to deal");

			}
			else 
			{
				//Deals the cards in the form of a list and takes those cards out of the deck
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
	
	//Resets the deck back to the saved deck copy
	public void reset()
	{
		playDeck.clear();
		for (int i = 0;i<saveDeck.size(); i++) {
			playDeck.add(saveDeck.get(i));
		}
	}

	//Returns amount of cards in deck
	public int remainSize()
	{
		return playDeck.size();
	}
	public void toString1()
	{
		for(int i = 0;i<playDeck.size();i++) {

			System.out.println(playDeck.get(i));

		}

	}
}

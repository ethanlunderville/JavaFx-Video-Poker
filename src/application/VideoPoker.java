package application;


import java.util.*;

public class VideoPoker {
	//Used in contcounter method
	int a = 0;
	
	private List<Card> playerHand;

	public static int getPlayerBalance() {
		return playerBalance;
	}

	public static void setPlayerBalance(int playerBalance) {
		VideoPoker.playerBalance = playerBalance;
	}

	private static int playerBalance = 100;
	private static int playerBet;
	
	public static int getPlayerBet() {
		return playerBet;
	}

	public static void setPlayerBet(int playerBet) {
		VideoPoker.playerBet = playerBet;
	}

	public VideoPoker(List<Card> hand)
	{
		this.playerHand = hand;
	}
	
	//This method checks the hand of the player to see if the deck is worthy of a payout
	public String checkHands()
	{
		//Checks if the hand contains all the correct ranks of a royal flush and then checks if they are all the same suit
		if ((cont(1, playerHand) & cont(10, playerHand) &
				cont(12, playerHand)& cont(11, playerHand)&
				cont(13, playerHand) && sameSuit(playerHand))) {


			playerBalance = playerBalance + (playerBet*250);
			return "Royal Flush!";

		}
		else {
			//Copies cards to a new list and sorts the new list based on rank
			List<Card> m = new ArrayList<Card>();
			for(int i = 0 ;i < playerHand.size(); i++) {
				m.add(playerHand.get(i));
			}
			
			bubbleSortRank(m, m.size());
			//Checks if they are all the same suit and if the rank is ascending with the newly sorted hand
			if (sameSuit(m) && AscendingRank(m)) {

				playerBalance = playerBalance + (playerBet*50);
				return "Straight Flush!";
			}	 
			else 	
			//Checks if the rank of the cards in the hand are all ascending but are not of the same suit
				if (!sameSuit(m) && AscendingRank(m)) {

					playerBalance = playerBalance + (playerBet*4);
					return "Straight!";
				}
				else {
			//Checks if cards are of the same suit but are not ascending in rank
					if (sameSuit(m) && !AscendingRank(m)) {

						playerBalance = playerBalance + (playerBet*6);
						return"Flush!";
					}

					else {
			//Checks if four of the cards are of the same rank
						if (sameRank4(m)) {
							playerBalance = playerBalance + (playerBet*25);
							return "Four of a kind!";
						}
						else {
			//Checks if there are 3 cards of the same rank
							if (threeOfKind(m)) {

								playerBalance = playerBalance + (playerBet*3);
								return "Three of a kind!";
							}
							else {
			//Checks if there is three of one suit and two of another
								if (threeAnd2(m)) {

									playerBalance = playerBalance + (playerBet*9);
									return "Full House!";
								}
								else {
			//Checks if there are two pairs with the same rank
									if (twoPairs(m)) {

										playerBalance = playerBalance + (playerBet*2);
										return "Two pair!";
									}
									else
			//Checks to see if the hand contains 2 jacks,kings or queens
										if (contCounter(11, playerHand) == 2
										|| contCounter(12, playerHand) == 2
										|| contCounter(13, playerHand) == 2) {

											playerBalance = playerBalance + (playerBet*1);
											return "Jacks or better!";
										}
										else
											playerBalance = playerBalance - playerBet;
			//If the hand was not a winning one
									return "Not a winning combo";
								}
							}
						}
					}
				}
		}
	}
	//Returns true if there are two pairs of the same rank within the hand

//CARDS SHOULD BE SORTED BY RANK BEFORE USING ANY OF THESE
	
//Returns true if the deck contains two pairs of a given rank
//Should only be called if threeOfakind method returns false
private boolean twoPairs(List<Card> e) {
		int counter = 0;
		for(int i = 1 ;i<e.size(); i++) {
			if(e.get(i).getRank()==e.get(i-1).getRank()) {
				counter++;
			}
		}
		if(counter==2) {
			return true;
		}
		return false;
	}
	//Returns true if the hand contains the rank specified in the first parameter
//Returns true if the provided hand contains the value specified in the first parameter
private boolean cont(final int rank, final List<Card> list ){

		for (int i = 0 ;i<list.size(); i++) {
			if(list.get(i).getRank()==rank) {

				return true;
			}

		}
		return false;
	}
	//Returns the amount of time that the value specified in the first parameter appears in the list
	
//Returns the frequency that a card appears within a list as an int
private int contCounter(final int rank, final List<Card> list ){
	
		a=0; 
		for (int i = 0 ;i<list.size(); i++) {
			if(list.get(i).getRank()==rank) {

				a=a+1;
			}

		}
		return a;
	}
	//Returns true if the whole hand is the same rank
//Checks if all of the cards are the same rank
private boolean sameRank(final List<Card> list) {
		int counter = 0;
		for (int i = 1 ;i<list.size(); i++) {
			if( list.get(i).getRank()==list.get(i-1).getRank()) {
				i++;
			}else {return false;}

		}
		return true;
	}
	//Returns true if the whole hand is the same suit
//Checks if all of the cards are the same suit
private boolean sameSuit(final List<Card> list) {
		int counter = 0;
		for (int i = 1 ;i<list.size(); i++) {
			if( list.get(i).getSuit()==list.get(i-1).getSuit()) {

			}else {return false;}

		}
		return true;
	}
	//Returns true if 4 of the cards within a hand are the same suit
//Checks if four of the cards are the same suit
private boolean sameSuit4(final List<Card> list) {
		//CARDS MUST BE SORTED FOR THIS METHOD TO WORK
		int counter = 0;

		if (list.get(0).getSuit()==list.get(1).getSuit()&&
				list.get(list.size()-1).getSuit()==list.get(list.size()-2).getSuit()) {
			return false;

		} 

		for (int i = 1 ;i<list.size(); i++) {
			if( list.get(i).getSuit()==list.get(i-1).getSuit()) {
				counter++;
			}
		}
		if(counter==3) {
			return true;
		}
		return false;
	}
	//Returns true if 4 of the cards within a hand are the same rank
//Checks if four of the cards are the same rank
private boolean sameRank4(final List<Card> list) {

		//CARDS MUST BE SORTED FOR THIS METHOD TO WORK
		int counter = 0;
		if (list.get(0).getRank()==list.get(1).getRank()&&
				list.get(list.size()-1).getRank()==list.get(list.size()-2).getRank()) {
			return false;

		} 




		for (int i = 1 ;i<list.size(); i++) {
			if( list.get(i).getRank()==list.get(i-1).getRank()) {
				counter++;
			}
		}
		if(counter==3) {
			return true;
		}
		return false;
	}
	//returns true if there are at least three cards of the same kind in the hand
//Checks if at least three of the cards are of the same rank
private static boolean threeOfKind(List<Card> e) {

		if(e.get(0).getRank()==e.get(1).getRank()&& e.get(1).getRank()!=e.get(2).getRank()||
				e.get(4).getRank()==e.get(3).getRank()&&e.get(3).getRank()!=e.get(2).getRank()) {
			return false;

		}

		for(int i = 0 ;i<3; i++) {

			if((e.get(i).getRank())==(e.get(i+1).getRank())&&(e.get(i+1).getRank())==(e.get(i+2).getRank()))
			{
				return true;
			}	
		}
		return false;
	}
	//returns true if there are three cards of the same kind and two of another kind in the hand
//Checks if at least three of the cards are of the same rank and that the other two cards 
private static boolean threeAnd2(List<Card> e) {

		for(int i = 0 ;i<3; i++) {

			if((e.get(i).getRank())==(e.get(i+1).getRank())&&(e.get(i+1).getRank())==(e.get(i+2).getRank()))
			{
				return true;
			}	
		}
		return false;
	}
	//Bubble sorts the rank from least to greatest
//Bubble sort algorithm by rank
private	static void bubbleSortRank(List<Card> e, int n)
	{               
		if(n==1) {

			return;
		}		
		for (int i=0; i<n-1; i++)     
		{
			if (e.get(i).getRank() > e.get(i+1).getRank())      
			{                         
				Card temp = e.get(i);

				e.set(i, e.get(i+1));

				e.set(i+1, temp);
			}
		}    
		bubbleSortRank(e, n-1);         
	}
	//Bubble sorts the suit from least to greatest
//Bubble sort algorithm by suit
private	static void bubbleSortSuit(List<Card> e, int n)
	{               
		if(n==1) {

			return;
		}		
		for (int i=0; i<n-1; i++)    
		{
			if (e.get(i).getSuit() > e.get(i+1).getSuit())    
			{                      
				Card temp = e.get(i);
				e.set(i, e.get(i+1));
				e.set(i+1, temp);
			}
		}    
		bubbleSortSuit(e, n-1);         
	}
	//returns true if the rank of the cards is in order and is ascending by 1 with each new card
	//cards must be sorted by rank for this method to work
//Returns true if the cards 
private boolean AscendingRank(final List<Card> list) {
		
		for(int i =1 ;i<list.size(); i++) {
			if(list.get(i).getRank() != list.get(i-1).getRank()+1) {	
				return false;
			}

		}
		return true;
	}


}

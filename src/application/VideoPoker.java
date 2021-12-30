package application;


import java.util.*;

public class VideoPoker {
	private List<Card> playerHand;
	public static int getPlayerBalance() {
		return playerBalance;
	}
	public static void setPlayerBalance(int playerBalance) {
		VideoPoker.playerBalance = playerBalance;
	}
	private static int playerBalance =100;
	private static int playerBet;
	public static int getPlayerBet() {
		return playerBet;
	}
	public static void setPlayerBet(int playerBet) {
		VideoPoker.playerBet = playerBet;
	}
	int a = 0;

	public VideoPoker(List<Card> hand)
	{
		this.playerHand = hand;
	}
	public String checkHands()
	{

		if ((cont(1, playerHand) & cont(10, playerHand) &
				cont(12, playerHand)& cont(11, playerHand)&
				cont(13, playerHand) && sameSuit(playerHand))) {


			playerBalance = playerBalance + (playerBet*250);
			return "Royal Flush!";

		}
		else {
			List<Card> m = new ArrayList<Card>();
			for(int i = 0 ;i < playerHand.size(); i++) {
				m.add(playerHand.get(i));
			}
			bubbleSortRank(m, m.size());

			if (sameSuit(m) && AscendingRank(m)) {

				playerBalance = playerBalance + (playerBet*50);
				return "Straight Flush!";
			}	 
			else 	
				if (!sameSuit(m) && AscendingRank(m)) {

					playerBalance = playerBalance + (playerBet*4);
					return "Straight!";
				}
				else {

					m.clear();
					for(int i = 0 ;i < playerHand.size(); i++) {
						m.add(playerHand.get(i));
					}

					bubbleSortRank(m, m.size());

					if (sameSuit(m) && !AscendingRank(m)) {

						playerBalance = playerBalance + (playerBet*6);
						return"Flush!";
					}

					else {
						m.clear();
						for(int i = 0 ;i < playerHand.size(); i++) {
							m.add(playerHand.get(i));
						}

						bubbleSortRank(m, m.size());
						if (sameRank4(m)) {


							playerBalance = playerBalance + (playerBet*25);
							return "Four of a kind!";
						}
						else {

							m.clear();
							for(int i = 0 ;i < playerHand.size(); i++) {
								m.add(playerHand.get(i));
							}

							bubbleSortRank(m, m.size());

							if (threeOfKind(m)) {

								playerBalance = playerBalance + (playerBet*3);
								return "Three of a kind!";
							}
							else {
								m.clear();
								for(int i = 0 ;i < playerHand.size(); i++) {
									m.add(playerHand.get(i));
								}

								bubbleSortRank(m, m.size());

								if (threeAnd2(m)) {

									playerBalance = playerBalance + (playerBet*9);
									return "Full House!";
								}
								else {
									m.clear();
									for(int i = 0 ;i < playerHand.size(); i++) {
										m.add(playerHand.get(i));
									}

									bubbleSortRank(m, m.size());
									if (twoPairs(m)) {

										playerBalance = playerBalance + (playerBet*2);
										return "Two pair!";
									}
									else

										if (contCounter(10, playerHand) == 2
										|| contCounter(11, playerHand) == 2
										|| contCounter(12, playerHand) == 2
										|| contCounter(13, playerHand) == 2) {

											playerBalance = playerBalance + (playerBet*1);
											return "Jacks or better!";
										}
										else
											playerBalance = playerBalance - playerBet;
									return "Not a winning combo";
								}
							}
						}
					}
				}
		}
	}

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
	private boolean cont(final List<Card> list, final int rank, final int suit){

		for (int i = 0 ;i<list.size(); i++) {
			if( list.get(i).getRank()==rank && list.get(i).getSuit()==suit) {
				return true;
			}

		}
		return false;
	}
	private boolean cont(final List<Card> list, final int suit){

		for (int i = 0 ;i<list.size(); i++) {
			if(list.get(i).getSuit()==suit) {
				return true;
			}

		}
		return false;
	}
	private boolean cont(final int rank, final List<Card> list ){

		for (int i = 0 ;i<list.size(); i++) {
			if(list.get(i).getRank()==rank) {

				return true;
			}

		}
		return false;
	}
	private int contCounter(final int rank, final List<Card> list ){
		a=0;
		for (int i = 0 ;i<list.size(); i++) {
			if(list.get(i).getRank()==rank) {

				a=a+1;
			}

		}
		return a;
	}
	private boolean sameRank(final List<Card> list) {
		int counter = 0;
		for (int i = 1 ;i<list.size(); i++) {
			if( list.get(i).getRank()==list.get(i-1).getRank()) {
				i++;
			}else {return false;}

		}
		return true;
	}
	private boolean sameSuit(final List<Card> list) {
		int counter = 0;
		for (int i = 1 ;i<list.size(); i++) {
			if( list.get(i).getSuit()==list.get(i-1).getSuit()) {

			}else {return false;}

		}
		return true;
	}
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
	private static boolean threeAnd2(List<Card> e) {
		for(int i = 0 ;i<3; i++) {

			if((e.get(i).getRank())==(e.get(i+1).getRank())&&(e.get(i+1).getRank())==(e.get(i+2).getRank()))
			{
				return true;
			}	
		}
		return false;
	}
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
	private boolean AscendingRank(final List<Card> list) {
		for(int i =1 ;i<list.size(); i++) {
			if(list.get(i).getRank() != list.get(i-1).getRank()+1) {	
				return false;
			}

		}
		return true;
	}



}

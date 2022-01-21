package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Scene2Controller {

	@FXML
	TextField nameTextField;
	@FXML
	ImageView one, two, three, four, five;

	private Stage stage;
	private Scene scene;
	private Parent root;

	private OneDeck deck = new OneDeck();
	
	List<Card> hand = new ArrayList<Card>();
	List<Card> updatedHand = new ArrayList<Card>() ;

	//Deletes duplicates from a list of cards ensuring that there is at most 1 instance of any given card within a list of cards
	public void deleteDuplicates() {
		for (int i = 0 ;i<updatedHand.size(); i++) {
			for(int z= 0 ;z<updatedHand.size(); z++) {
				if(z != i && updatedHand.get(i) == updatedHand.get(z)) {

					updatedHand.remove(z);
					z--;


				}

			}

		}
		System.out.println(updatedHand);

	}

	//Sets up scene 3
	public void S3(ActionEvent event) throws IOException {


		//Deletes the duplicates from the hand
		deleteDuplicates();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene3.fxml"));	
		root = loader.load();	

		Scene3Controller Scene3Controller = loader.getController();
		//Sends the selected cards to the next scene
		Scene3Controller.transport(updatedHand);
		//Transports the deck to the scene three controller
		Scene3Controller.transport(deck);
		
		//Displays selected cards as well as the newly drawn cards in one hand
		Scene3Controller.try1();

		//General JavaFx rendering code
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}
	//Gets a random hand and displays it
	public void try1() {
		
		deck.shuffle();
		
		try {
			
			hand = deck.deal(5);
			
		} catch (PlayingCardException e) {
			e.printStackTrace();
		}

		one.setImage(hand.get(0).getCardVis());
		two.setImage(hand.get(1).getCardVis());
		three.setImage(hand.get(2).getCardVis());
		four.setImage(hand.get(3).getCardVis());
		five.setImage(hand.get(4).getCardVis());
	}



	public OneDeck getDeck() {
		return deck;
	}


	public void setDeck(OneDeck k) {
		this.deck = k;
	}

	//These methods add the clicked on cards to the new deck that will be past to the next scene 
	//and will be a part of the final deck
	
	public void handleClick1() {

		updatedHand.add(hand.get(0));


	}
	public void handleClick2() {

		updatedHand.add(hand.get(1));

	}
	public void handleClick3() {

		updatedHand.add(hand.get(2));

	}
	public void handleClick4() {

		updatedHand.add(hand.get(3));

	}
	public void handleClick5() {

		updatedHand.add(hand.get(4));

	}




}

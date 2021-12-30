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

	private OneDeck k = new OneDeck();
	
	List<Card> hand = new ArrayList<Card>();
	List<Card> updatedHand = new ArrayList<Card>() ;


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


	public void S3(ActionEvent event) throws IOException {


		//deletes the duplicates from the hand
		deleteDuplicates();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene3.fxml"));	
		root = loader.load();	

		Scene3Controller Scene3Controller = loader.getController();
		//Sends the selected cards to the next scene
		Scene3Controller.transport(updatedHand);
		
		Scene3Controller.transport(k);
		//displays selected cards as well as new cards
		Scene3Controller.try1();


		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

	public void try1() {
		
		k.shuffle();
		
		try {
			
			hand = k.deal(5);
			
		} catch (PlayingCardException e) {
			e.printStackTrace();
		}

		one.setImage(hand.get(0).getCardVis());
		two.setImage(hand.get(1).getCardVis());
		three.setImage(hand.get(2).getCardVis());
		four.setImage(hand.get(3).getCardVis());
		five.setImage(hand.get(4).getCardVis());
	}



	public OneDeck getK() {
		return k;
	}


	public void setK(OneDeck k) {
		this.k = k;
	}

	//the methods add the clicked on cards to the new deck that will be past to the next scene 
	
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

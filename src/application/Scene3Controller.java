package application;

import java.io.IOException;
import java.util.List;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Scene3Controller {

	@FXML
	TextField nameTextField;
	@FXML
	ImageView six, seven, eight, nine, ten;
	@FXML
	Label handResult;


	private Stage stage;
	private Scene scene;
	private Parent root;
	private List<Card> handT;
	private OneDeck deck;


	//Sets up scene 1
	public void S1(ActionEvent event) throws IOException {
		//Loads FXML
		FXMLLoader loader = new FXMLLoader(getClass().getResource("graphicorg.fxml"));	
		root = loader.load();	
		Scene1Controller Scene1Controller = loader.getController();
		//Updates player balance in scene 1
		Scene1Controller.UpdateBal();
		//Checks if you ran out of money a closes the program if you did
		if(VideoPoker.getPlayerBalance()<1) {

			Alert o = new Alert(AlertType.WARNING);
			o.setContentText("You do not have enough money to play again!");
			o.showAndWait();
			Platform.exit();
		}
		//General JavaFx rendering code
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();


	}
	//For sending hands between controllers
	public void transport(List<Card> l) {
		this.handT=l;

	}
	//For sending decks between controllers
	public void transport(OneDeck deck) {
		this.deck=deck;

	}
	//Adds however many cards to those that the player selected in order to make a hand consisting of five cards
	public void try1()  {
		List<Card> temp = null;
		
		try {
			
			temp = deck.deal(5-handT.size());
			
		} catch (PlayingCardException e) {

			e.printStackTrace();
		}
		
		for(int i = 0;i<temp.size();i++) {
			
			handT.add(temp.get(i));

		}
		//Populates the GUI with images of the updates hand
		six.setImage(handT.get(0).getCardVis());
		seven.setImage(handT.get(1).getCardVis());
		eight.setImage(handT.get(2).getCardVis());
		nine.setImage(handT.get(3).getCardVis());
		ten.setImage(handT.get(4).getCardVis());

		//Checks the hand and displays the result
		VideoPoker videoPoker = new VideoPoker(handT);
		
		handResult.setText(videoPoker.checkHands());

	}
	//Stops the program
	public void exit(ActionEvent event) {
		Platform.exit();
	}

}

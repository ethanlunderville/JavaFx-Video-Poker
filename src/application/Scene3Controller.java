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
	Label handl;
	
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	private List<Card> handT;
	private OneDeck deck;
	
	
	
	public void S1(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("graphicorg.fxml"));	
		root = loader.load();	
		
		
		
		//Automatically checks the playerHand within the constructor of the 
		// video poker object and updates the values of the static balance 
		// found within the videopoker class
		
		
		
		Scene1Controller Scene1Controller = loader.getController();
		Scene1Controller.UpdateBal();
	
		
		//root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));	
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

		
	}
	public void transport(List<Card> l) {
		this.handT=l;
		
	}
	public void transport(OneDeck deck) {
		this.deck=deck;
		
	}
	
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
	System.out.println(six);
	six.setImage(handT.get(0).getCardVis());
	seven.setImage(handT.get(1).getCardVis());
	eight.setImage(handT.get(2).getCardVis());
	nine.setImage(handT.get(3).getCardVis());
	ten.setImage(handT.get(4).getCardVis());
	
	VideoPoker videoPoker = new VideoPoker(handT);
	handl.setText(videoPoker.checkHands());
	
}
	
	
	
	public void exit(ActionEvent event) {
		Platform.exit();
	}
	
	
}

package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Scene1Controller {

	@FXML
	TextField BetField;
	@FXML
	Label bal;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	private String bet;
	
	
	
	
	
	
	public void S2(ActionEvent event) throws IOException {
		
		bet = BetField.getText();
		VideoPoker.setPlayerBet(Integer.parseInt(bet));
		System.out.println(bet);

		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));	
		root = loader.load();	
		
		Scene2Controller Scene2Controller = loader.getController();
		Scene2Controller.try1();
		
		
		//root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));	
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

		
	}
	
	public void UpdateBal() {
		int balance = VideoPoker.getPlayerBalance();
		bal.setText("Player Balance: $" + balance);
		
	}
	
	
	
	
	
}
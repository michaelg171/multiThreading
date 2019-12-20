package application.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.Model.Park;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class MainController implements EventHandler<ActionEvent>, Initializable {
	public static int flag=0;
	@FXML
	Button B;
	Button D;
	Button G;
	Button R;
	Button TR;
	Button TY;
	Button X;
	public static Button Temp;
	/*initialize will initialize the fxml file and auto populating any data that
	 * needs to be populated for the user to view initially by calling the park.load to 
	 * load the park object with data.
	 *@param: location: URL, resources: ResourceBundle */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Park park = new Park("jurassic");
		park.Load("zones.csv", "dinos.csv");
	}
	/* Handle will handle which buttn is presssed on the main FXML
	 * depending on which button is pressed will dicate which zone is opened
	 * the zone will be selected based on the Temp varible which contains
	 * the letter from the button
	 * @param: event: ActionEvent*/
	@Override
	public void handle(ActionEvent event) {
		Temp = (Button)event.getSource();
		try{
			Stage primaryStage = Main.stage;
			Parent root = FXMLLoader.load(getClass().getResource("/Zone.fxml"));
			Scene scene =new Scene(root, 800, 800);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		 }catch(Exception e) {
			e.printStackTrace();
		}
	}
}

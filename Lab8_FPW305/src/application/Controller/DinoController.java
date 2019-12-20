package application.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import application.Model.Dinosaur;
import application.Model.Zone;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class DinoController implements EventHandler<ActionEvent>, Initializable{
	@FXML
	ImageView DinoImage;
	@FXML
	Label NameLabel;
	@FXML
	Label ZoneLabel;
	@FXML
	Button HomeButton;
	@FXML
	Label species;
	public static String name;
	public static String spec;
	public static ArrayList<Dinosaur>images=new ArrayList<Dinosaur>();
	
	int flag = 0;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		images  = Main.park.findDinos(MainController.Temp.getText());
		Dinosaur temp = images.get(0);
		Zone zonecode = Main.park.findZone(temp.getCode());
		ZoneLabel.setText(zonecode.getName()+" "+"Zone"+" "+"("+zonecode.getCode()+")");
		
		Thread t1 = new Thread(new Task(){

			@Override
			protected Object call() throws Exception {
				
				for(int i =0; i<images.size(); i++){
					
					name = images.get(i).getName();
					name = name.toLowerCase();
					spec =images.get(i).getSpecies();
					Image img = new Image("images/"+name+".jpg");
					DinoImage.setImage(img);
					
					Platform.runLater(new Runnable() {
						public void run() {
							NameLabel.setText(name+"\n");
						}
					});
					Platform.runLater(new Runnable() {
						public void run() {
							species.setText(spec);
						}
					});
					if(i==images.size()-1){
						i=0;
					}
					Thread.sleep(10000);
				}
				
				return null;
			}
			
		});
		t1.start();
			
	}

	@Override
	public void handle(ActionEvent arg0) {
		try {
			Stage primaryStage = Main.stage;
			Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
			Scene scene =new Scene(root, 600, 600);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		 }catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}

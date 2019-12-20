package application.Controller;
/**@author Richard Michael Galind FPW-305
 * ZoneController handles the Zone FXML file
 * */
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import application.Model.Dinosaur;
import application.Model.Zone;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ZoneController implements EventHandler<ActionEvent>, Initializable{
	Button Home;
	@FXML
	Button New;
	@FXML
	Button Relocate;
	@FXML
	TextField NewName;
	@FXML
	TextField NewType;
	@FXML
	TextField ReloName;
	@FXML
	TextField ZoneCode;
	@FXML
	Label Threats;
	@FXML
	Label Title;
	@FXML
	Label label1;
	@FXML
	ObservableList<String> list = FXCollections.observableArrayList();
	@FXML
	ArrayList<Dinosaur>dinos = new ArrayList<Dinosaur>();
	@FXML
	ListView<String> listView;
	@FXML
	Label num;
	@FXML
	RadioButton Yes;
	@FXML
	RadioButton No;
	@FXML
	Pane pane1;
	@FXML
	Label reloTag;
	Zone z;
	/*initialize will initialize the fxml file and auto populating any data that
	 * needs to be populated for the user to view initially
	 *@param: location: URL, resources: ResourceBundle*/

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		pane1.styleProperty();	
		z = Main.park.findZone(MainController.Temp.getText());
		dinos = Main.park.findDinos(MainController.Temp.getText());
	
			for(int i =0; i<dinos.size();i++) {
				Dinosaur d = dinos.get(i);
				list.add(d.toString());
			}
			listView.setItems(list);
			Title.setText(z.toString());
			Threats.setText(z.getLevel());
			num.setText(String.valueOf(dinos.size()));
			Main.park.Save("dinos.csv");
	}		

	/* Handle will take the home button when it is pressed it will take the 
	 * user back to the Main fxml frame
	 * @param: event: ActionEvent*/
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
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
	/* 
	 * New will hand the action event of the new dinosaur button when pressed
	 * a new dinosaur object will be created and added to the hashmap
	 * the data will then be saved to a data file.
	 * * @param: event: ActionEvent*/
	public void New(ActionEvent event) {
		
		Dinosaur dtemp=null;
		if(Yes.isSelected()) {
			 dtemp = new Dinosaur(NewName.getText(), NewType.getText(), "false",z.getCode() );
		}else if(No.isSelected()) {
			 dtemp = new Dinosaur(NewName.getText(),NewType.getText(),"true", z.getCode());
		}
		Main.park.addDino(dtemp);
		try{
			Stage primaryStage = Main.stage;
			Parent root = FXMLLoader.load(getClass().getResource("/Zone.fxml"));
			Scene scene =new Scene(root, 800, 800);
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
		listView.setItems(list);
		Main.park.Save("dinos.csv");
	}
	/*
	 *Relocate action event will handle when the relocate button is pressed
	 *it will check for the hashmap for the dinosaur and remove and 
	 *place into a new group of dinosaurs based on the Zone code 
	 * @param: event: ActionEvent*/
	public void Relocate(ActionEvent event) {
		String name =ReloName.getText();
		String zCode =ZoneCode.getText();
		
		for(int i=0;i<dinos.size();i++) {
			Dinosaur temp = dinos.get(i);
			if(temp.getName().equals(name)) {
				Main.park.Relocate(temp, temp.getCode(), zCode);
				break;
			}
		}
		reloTag.setText("Relocation is a Success!");
		Main.park.Save("dinos.csv");
	}
	public void Views(ActionEvent event) {
		// TODO Auto-generated method stub
		
		try {
			Stage primaryStage = Main.stage;
			Parent root = FXMLLoader.load(getClass().getResource("/Dinosaur.fxml"));
			Scene scene =new Scene(root, 600, 600);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		 }catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}

package application;
	
import application.Model.Park;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
/** @Author Richard Michael Galindo FPW305 
/**
 * main method that extends Application which sets up the javafx pane
 by getting the data from the Main.fxml file. and displaying*/

public class Main extends Application {
public static Stage stage;
public static Park park;	
//////////////////////////////////////////////////
//
////////////////////////////////////////////////
	@Override
public void start(Stage primaryStage) {
		park = new Park("Michael park");
		park.Load("zones.csv", "dinos.csv");
		
		try {
			stage = primaryStage;
			Parent root = FXMLLoader.load(getClass().getResource("../Main.fxml"));
			Scene scene =new Scene(root, 600, 600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
///////////////////////////////////////////////////////
//
////////////////////////////////////////////////////
public static void main(String[] args) {
		launch(args);
	}
}

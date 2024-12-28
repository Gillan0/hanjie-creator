package main.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			HanjieGridUI grid = new HanjieGridUI();
			
			BorderPane root = new BorderPane();
			
			root.setRight(grid.createGrid());
			
			Scene scene = new Scene(root, 400, 400, Color.WHITE);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Hanjie creator");
			
			Image icon = new Image(getClass().getResourceAsStream("/assets/logoCDV.png"));
			primaryStage.getIcons().add(icon);
			
			primaryStage.setWidth(720);
			primaryStage.setHeight(540);
			
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}

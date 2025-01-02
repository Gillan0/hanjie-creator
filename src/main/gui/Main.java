package main.gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.logic.HanjieSolver;
import main.model.HanjieGrid;

public class Main extends Application {

	private HanjieGrid hanjieGrid;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			hanjieGrid = new HanjieGrid(25);
			
			ScrollPane root = new ScrollPane();
			BorderPane borderPane = new BorderPane();
			HanjieGridUI grid = new HanjieGridUI(hanjieGrid);
			
			borderPane.setTop(createTopPane());
			borderPane.setBottom(createBottomPane());
			borderPane.setLeft(createLeftPane());
			borderPane.setRight(grid.createGrid());
			
			HBox hbox = new HBox(10);
		    hbox.getChildren().addAll(borderPane);    
		    hbox.setAlignment(Pos.CENTER);

		    
		    root.setContent(hbox);
		    root.setFitToWidth(true);
		    root.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		    root.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
			
			Scene scene = new Scene(root, 400, 400, Color.WHITE);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Hanjie creator");
			
			Image icon = new Image(getClass().getResourceAsStream("/assets/logoCDV.png"));
			primaryStage.getIcons().add(icon);
			
			primaryStage.setWidth(720);
			primaryStage.setHeight(640);
			
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public StackPane createTopPane() {
	    
	    StackPane pane = new StackPane();
	    
	    Text title = new Text("Hanjie Creator");
	    title.setFont(new Font("Arial Black", 40));
	    
	    Text description = new Text(
	    		"""
	    		This software allows users to create and solve Hanjie (Picross) puzzles with ease. Users can draw their own patterns
	    	    directly on a customizable grid, and the software will check whether the puzzle is solvable. Additionally, the software 
	    	    offers the ability to import an image, automatically generating a Hanjie puzzle based on the image's pixel structure. 
	    	    """);

	    
	    description.setFont(new Font("Arial Rounded", 12));
	    
	    VBox layout = new VBox(10); 
	    layout.setAlignment(Pos.CENTER); 	
	    layout.getChildren().addAll(
	        title,
	        description
	    );
	
	    pane.getChildren().add(layout);
	
	    return pane;
	}	
	
	public StackPane createBottomPane() {
	    
	    StackPane pane = new StackPane();
	    
	    Text licence = new Text("Copyright © 2024 Antonino Gillard");
	    
	    licence.setFont(new Font("Arial Rounded", 12));
	    
	    VBox layout = new VBox(10); 
	    layout.setAlignment(Pos.CENTER); 	
	    layout.getChildren().addAll(
	        licence
	    );
	
	    pane.getChildren().add(layout);
	
	    return pane;
	}	
	
	public StackPane createLeftPane() {
	    
	    StackPane pane = new StackPane();


	    VBox layout = new VBox(10); 
	    layout.setAlignment(Pos.CENTER);

	    Button solve = new Button("Check Solvability");
	    solve.setOnAction(event -> {
	    	boolean isSolvable = false;
	    	try {
				HanjieSolver solver = new HanjieSolver(hanjieGrid);
				isSolvable = solver.solve();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	
	    	Alert alert = new Alert(AlertType.INFORMATION);
	    	
	    	alert.setTitle("Solving Hanjie");
	    	alert.setHeaderText(isSolvable ? "This Hanjie can be solved !" : "This Hanjie can not be solved !");
	    	alert.setContentText(isSolvable ? "You are free to export it." : "Please work on it again before exporting it.");
	    	
	    	alert.showAndWait();
	    });
	    
	    layout.getChildren().addAll(
	        new Button("Import a picture"),
	        new Text("Size : 25"),
	        solve,
	        new Button("Download")
	    );

	    pane.getChildren().add(layout);

	    return pane;
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}

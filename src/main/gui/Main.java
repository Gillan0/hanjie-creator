package main.gui;

import java.io.File;

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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import main.logic.HanjieSolver;
import main.model.HanjieGrid;
import main.util.ImageConverter;
import main.util.ImageGenerator;

public class Main extends Application {

	private HanjieGrid hanjieGrid;
	private HanjieGridUI grid;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			hanjieGrid = new HanjieGrid(35);
			grid = new HanjieGridUI(hanjieGrid);
			
			ScrollPane root = new ScrollPane();
			BorderPane borderPane = new BorderPane();
			
			borderPane.setTop(createTopPane());
			borderPane.setBottom(createBottomPane());
			borderPane.setLeft(createLeftPane(borderPane, primaryStage));
			borderPane.setRight(grid.getPane());
			
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
	
	public StackPane createLeftPane(BorderPane rootPane, Stage primaryStage) {
	    
	    StackPane pane = new StackPane();
	    VBox layout = new VBox(10); 
	    layout.setAlignment(Pos.CENTER);

	    Button refreshGrid = new Button("Clear grid");
	    refreshGrid.setOnAction(event -> {
	    	grid = new HanjieGridUI(new HanjieGrid(25));
	    	rootPane.setRight(grid.getPane());
	    });
	    
	    Button importPicture = new Button("Import a picture");
	    importPicture.setOnAction(event -> {
	    	try {
	    		FileChooser fileChooser = new FileChooser();
	    		fileChooser.setTitle("Open Resource File");
	    		fileChooser.getExtensionFilters().add(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
	    		File selectedFile = fileChooser.showOpenDialog(primaryStage);
	    		
	    		if (selectedFile != null) {
		    		ImageConverter.convertImageToHanjie(selectedFile, hanjieGrid);
			    	grid.refreshGrid();
			    	rootPane.setRight(grid.getPane());
	    		}

	    		
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    		Alert alert = new Alert(AlertType.ERROR);
	    		alert.setTitle("Error");
	    		alert.setHeaderText("Could not import the picture");
		    	alert.setContentText(e.toString());
		    	
		    	alert.showAndWait();
	    		
	    	}
	    });
	    

	    Button download = new Button("Download");
	    download.setOnAction(event -> {
			try {
				
				DirectoryChooser directoryChooser = new DirectoryChooser();
		        directoryChooser.setTitle("Select Folder to Save Grids");

		        File selectedDirectory = directoryChooser.showDialog(primaryStage);    		
	    		
		        if (selectedDirectory == null) {
		        	return;
		        }
		        
				ImageGenerator.generateImage(hanjieGrid, selectedDirectory);
				
		    	Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Downloading grids ...");
		    	alert.setHeaderText("Grids downloaded !");
		    	alert.setContentText("Both the puzzle grid and the solution grids have been generated.");
		    	
		    	alert.showAndWait();
			} catch (Exception e) {

		    	Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
		    	alert.setHeaderText("Could not generate the grids");
		    	alert.setContentText(e.toString());
		    	
		    	alert.showAndWait();
				
			}
		});
	    
	    
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
	    	refreshGrid,
	        importPicture,
	        new Text("Size : 35"),
	        solve,
	        download
	    );

	    pane.getChildren().add(layout);

	    return pane;
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}

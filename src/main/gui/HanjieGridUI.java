package main.gui;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import main.model.GridHeightException;
import main.model.GridWidthException;
import main.model.HanjieGrid;

public class HanjieGridUI {

    private static final int CELL_SIZE = 15; // Define the size of each cell
	private int GRID_SIZE; // Define the grid size

    private Rectangle[][] cells = new Rectangle[GRID_SIZE][GRID_SIZE];
    private Rectangle[][] cacheGrid = new Rectangle[GRID_SIZE][GRID_SIZE];
    private Color dragColor;
    
    private HanjieGrid hanjieGrid;
    
    private GridPane gridPane = new GridPane();
    private Pane layeredPane = new Pane();
    
    public HanjieGridUI(HanjieGrid hanjieGrid) {
    	this.hanjieGrid = hanjieGrid;
    	this.GRID_SIZE = hanjieGrid.getHeight();
    	this.cells = new Rectangle[GRID_SIZE][GRID_SIZE];
        this.cacheGrid = new Rectangle[GRID_SIZE][GRID_SIZE];
        createGrid();
    }
    
    public void createGrid() {
        layeredPane = new Pane();
        
        gridPane.setOnMousePressed(this::mouseAction);        
        gridPane.setOnMouseDragged(this::mouseAction);
        gridPane.setOnMouseReleased(event -> {
            cacheGrid = new Rectangle[GRID_SIZE][GRID_SIZE];
            dragColor = null;
        });
        
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                Rectangle cell = new Rectangle(CELL_SIZE, CELL_SIZE, Color.WHITE);
                
                cell.setStroke(Color.LIGHTGRAY);
                cell.setStrokeWidth(0.5);
                
                gridPane.add(cell, col, row);
                cells[row][col] = cell;
            }
        }
        
        
        gridPane.setLayoutX(0);
        gridPane.setLayoutY(0);
        layeredPane.getChildren().add(gridPane);

        // After the layout is done, draw the lines
        gridPane.layoutBoundsProperty().addListener(
        	(observable, oldBounds, newBounds) -> {
		        layeredPane.getChildren().removeIf(Line.class::isInstance);
		
		        double cellSize = newBounds.getWidth() / GRID_SIZE; // Dynamically calculate cell size
		
		        for (int i = 0; i <= GRID_SIZE; i++) {
		            if (i % 5 != 0) {
		            	continue;
		            }
		            // Horizontal line
		            Line horizontalLine = new Line(0, i * cellSize, newBounds.getWidth(), i * cellSize);
		            horizontalLine.setStroke(Color.DARKGRAY);
		            horizontalLine.setStrokeWidth(2.0); // Thicker line for visibility
		            layeredPane.getChildren().add(horizontalLine);
		
		            // Vertical line
		            Line verticalLine = new Line(i * cellSize, 0, i * cellSize, newBounds.getHeight());
		            verticalLine.setStroke(Color.DARKGRAY);
		            verticalLine.setStrokeWidth(2.0); // Thicker line for visibility
		            layeredPane.getChildren().add(verticalLine);
		            
		        }
        });

    }

    public Pane getPane() {
    	return layeredPane;
    }
    
    public void refreshGrid() throws GridHeightException, GridWidthException {
    	for (int i = 0; i < hanjieGrid.getHeight(); i++) {
    		for (int j = 0; j < hanjieGrid.getWidth(); j++) {
    			Rectangle cell = cells[i][j];
    			
    			cell.setFill(hanjieGrid.getElement(i, j) == 1 ? Color.BLACK : Color.WHITE);	
        	}
    	}
    }
    
    
    private void toggleColor(Rectangle cell) {
        if (cell.getFill().equals(Color.BLACK)) {
            cell.setFill(Color.WHITE);
        } else {
            cell.setFill(Color.BLACK);
        }
    }
    
    private void mouseAction(MouseEvent event) {

    	double localX = event.getX() - gridPane.getLayoutX();
        double localY = event.getY() - gridPane.getLayoutY();

        int x = (int) (localX / (CELL_SIZE + 1));
        int y = (int) (localY / (CELL_SIZE + 1));
        
        if (0 <= x && x < GRID_SIZE && 0 <= y && y < GRID_SIZE) {
            Rectangle cell = cells[y][x];
            if (dragColor == null) {
                dragColor = cell.getFill() == Color.BLACK ? Color.WHITE : Color.BLACK;
            }
            
            if (cacheGrid[y][x] == null && cell.getFill() != dragColor) {
                
                try {
                	toggleColor(cell);
                    cacheGrid[y][x] = cell;
					hanjieGrid.toggleElement(y, x);
				} catch (GridHeightException | GridWidthException e) {
					e.printStackTrace();
				}
            }
        }
    }
}

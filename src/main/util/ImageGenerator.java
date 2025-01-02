package main.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import main.model.GridHeightException;
import main.model.GridWidthException;
import main.model.HanjieGrid;

public class ImageGenerator {
	
	public static void generateImage(HanjieGrid grid) throws GridHeightException, GridWidthException, IOException {		
		ArrayList<ArrayList<Integer>> lineDescriptions = new ArrayList<>();
		ArrayList<ArrayList<Integer>> columnDescriptions = new ArrayList<>();
		
		for (int i = 0; i < grid.getHeight(); i++) {
			lineDescriptions.add((ArrayList<Integer>) grid.getLineDescription(i));
		}
		for (int j = 0; j < grid.getWidth(); j++) {
			columnDescriptions.add((ArrayList<Integer>) grid.getColumnDescription(j));
		}
		
		int maxLengthDescriptionLine = lineDescriptions.stream()
											.mapToInt(List::size)
											.max()
											.orElse(50) * 20;
		
		int maxLengthDescriptionColumn = columnDescriptions.stream()
												.mapToInt(List::size)
												.max()
												.orElse(50) * 20;
		
		int IMAGE_WIDTH = grid.getWidth() * 20 + maxLengthDescriptionLine;
		int IMAGE_HEIGHT = grid.getWidth() * 20 + maxLengthDescriptionColumn;
				
		BufferedImage unsolvedImage = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = unsolvedImage.createGraphics();

        drawBackground(grid, g2d, maxLengthDescriptionLine, maxLengthDescriptionColumn, IMAGE_HEIGHT, IMAGE_HEIGHT);
        drawDescriptions(g2d, columnDescriptions, columnDescriptions, maxLengthDescriptionLine, maxLengthDescriptionColumn);
                
        // Creates puzzle grid
        File emptyGrid = new File("hanjie.png");
        ImageIO.write(unsolvedImage, "png", emptyGrid);
        System.out.println("Image created successfully: " + emptyGrid.getAbsolutePath());

        g2d.dispose();
        
        fillSolvedGrid(grid, g2d, maxLengthDescriptionLine, maxLengthDescriptionColumn);
        
        // Creates the solution grid
        File solvedGrid = new File("hanjie_solved.png");
        ImageIO.write(unsolvedImage, "png", solvedGrid);
        System.out.println("Image created successfully: " + solvedGrid.getAbsolutePath());
    
	}
	
	/**
	 * 
	 * @param grid
	 * @param g2d
	 * @param maxLengthDescriptionLine
	 * @param maxLengthDescriptionColumn
	 * @param IMAGE_WIDTH
	 * @param IMAGE_HEIGHT
	 */
	private static void drawBackground(HanjieGrid grid,
										Graphics2D g2d,
										int maxLengthDescriptionLine,
										int maxLengthDescriptionColumn,
										int IMAGE_WIDTH,
										int IMAGE_HEIGHT) {		
		g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);

        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillRect(0, 0, maxLengthDescriptionLine, IMAGE_HEIGHT);
        g2d.fillRect(0, 0, IMAGE_WIDTH, maxLengthDescriptionColumn);

        // Draw grid 
        for (int i =0; i < grid.getHeight(); i++) {
        	
        	for (int j =0; j < grid.getWidth(); j++) {
        		
        		g2d.setColor(Color.LIGHT_GRAY);
                g2d.fillRect(maxLengthDescriptionLine + j * 20, maxLengthDescriptionColumn + i *20, 20, 20);
                g2d.setColor(Color.WHITE);
                g2d.fillRect(maxLengthDescriptionLine + j * 20 + 1, maxLengthDescriptionColumn + i * 20 + 1, 18, 18);    
                
                if (j % 5 == 0) {
        			g2d.setColor(Color.BLACK);
                    g2d.fillRect(maxLengthDescriptionLine + j * 20, 0, 2, IMAGE_HEIGHT);
                }
            }
        	
        	if (i % 5 == 0) {
        		g2d.setColor(Color.BLACK);
                g2d.fillRect(0, maxLengthDescriptionColumn + i *20, IMAGE_WIDTH, 2);
            }
        }
	}
	
	/**
	 * Draws all descriptions for each line and column of the HanjieGrid
	 * 
	 * @param g2d
	 * @param lineDescriptions
	 * @param columnDescriptions
	 * @param maxLengthDescriptionLine
	 * @param maxLengthDescriptionColumn
	 */
	private static void drawDescriptions(Graphics2D g2d, 
										ArrayList<ArrayList<Integer>> lineDescriptions,
										ArrayList<ArrayList<Integer>> columnDescriptions,
										int maxLengthDescriptionLine,
										int maxLengthDescriptionColumn) {
        g2d.setFont(new Font("Arial", Font.PLAIN, 12));
        g2d.setColor(Color.BLACK);
        FontMetrics metrics = g2d.getFontMetrics();
        
        for (int i = 0; i < lineDescriptions.size(); i++) {
            ArrayList<Integer> lineDescription = lineDescriptions.get(i);

            for (int j = 0; j < lineDescription.size(); j++) {
                String currentNumber = String.valueOf(lineDescription.get(j));

                // Calculate the adjusted position for centering
                int textWidth = metrics.stringWidth(currentNumber);
                int textHeight = metrics.getAscent() - metrics.getDescent();
                int x = maxLengthDescriptionLine - ((lineDescription.size() - j - 1) * 20 + 10) - textWidth / 2;
                int y = maxLengthDescriptionColumn + i * 20 + 5 + metrics.getAscent() - textHeight / 2 + 2;

                g2d.drawString(currentNumber, x, y);
            }
        }
        
        for (int i = 0; i < columnDescriptions.size(); i++) {
            ArrayList<Integer> columnDescription = columnDescriptions.get(i);

            for (int j = 0; j < columnDescription.size(); j++) {
                String currentNumber = String.valueOf(columnDescription.get(j));

                // Calculate the adjusted position for centering
                int textWidth = metrics.stringWidth(currentNumber);
                int textHeight = metrics.getAscent() - metrics.getDescent();
                int x = maxLengthDescriptionLine + i * 20 - textWidth / 2 + 10;
                int y = maxLengthDescriptionColumn - ((columnDescription.size() - j - 1) * 20 + 10) + metrics.getAscent() - textHeight / 2;

                g2d.drawString(currentNumber, x, y);
            }
        }
        
    }

	/**
	 * Fills the grid for the solution file of the HanjieGrid
	 * 
	 * @param grid
	 * @param g2d
	 * @param maxLengthDescriptionLine
	 * @param maxLengthDescriptionColumn
	 * @throws GridHeightException
	 * @throws GridWidthException
	 */
	private static void fillSolvedGrid(HanjieGrid grid, 
										Graphics2D g2d,
										int maxLengthDescriptionLine,
										int maxLengthDescriptionColumn) throws GridHeightException, GridWidthException {
        for (int i =0; i < grid.getHeight(); i++) {
        	
        	for (int j =0; j < grid.getWidth(); j++) {
        		
        		if (grid.getElement(i, j) != 1) {
        			continue;
        		}
        		
                g2d.setColor(new Color(25,25,25));
                g2d.fillRect(maxLengthDescriptionLine + j * 20 + 1, maxLengthDescriptionColumn + i * 20 + 1, 19, 19);    
                
        	}
        }
	}
	
}
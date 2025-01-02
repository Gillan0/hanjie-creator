package main.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;

import main.model.GridHeightException;
import main.model.HanjieGrid;
import test.model.HanjieGridTemplates;

public class ImageGenerator {

	private HanjieGrid grid;
	private BufferedImage unsolvedImage;
	private BufferedImage solvedImage;
	
	public static void generateImage(HanjieGrid g) throws Exception {
		HanjieGrid grid = g;
		
		ArrayList<ArrayList<Integer>> lineDescriptions = new ArrayList<>();
		ArrayList<ArrayList<Integer>> columnDescriptions = new ArrayList<>();
		
		for (int i = 0; i < grid.getHeight(); i++) {
			lineDescriptions.add((ArrayList<Integer>) grid.getLineDescription(i));
		}
		for (int j = 0; j < grid.getWidth(); j++) {
			columnDescriptions.add((ArrayList<Integer>) grid.getColumnDescription(j));
		}
		
		int maxLengthLine = lineDescriptions.stream()
											.mapToInt(List::size)
											.max()
											.orElse(50) * 20;
		
		int maxLengthColumn = columnDescriptions.stream()
				.mapToInt(List::size)
				.max()
				.orElse(50) * 20;
		
		int IMAGE_WIDTH = grid.getWidth() * 20 + maxLengthLine;
		int IMAGE_HEIGHT = grid.getWidth() * 20 + maxLengthColumn;
				
		BufferedImage unsolvedImage = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);
		
		// Get Graphics2D from BufferedImage
        Graphics2D g2d = unsolvedImage.createGraphics();


        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);

        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillRect(0, 0, maxLengthLine, IMAGE_HEIGHT);
        g2d.fillRect(0, 0, IMAGE_WIDTH, maxLengthColumn);

        // Draw grid 
        for (int i =0; i < grid.getHeight(); i++) {
        	
        	for (int j =0; j < grid.getWidth(); j++) {
        		
        		g2d.setColor(Color.LIGHT_GRAY);
                g2d.fillRect(maxLengthLine + j * 20, maxLengthColumn + i *20, 20, 20);
                g2d.setColor(Color.WHITE);
                g2d.fillRect(maxLengthLine + j * 20 + 1, maxLengthColumn + i * 20 + 1, 18, 18);    
                
                if (j % 5 == 0) {
        			g2d.setColor(Color.BLACK);
                    g2d.fillRect(maxLengthLine + j * 20, 0, 2, IMAGE_HEIGHT);
                }
            }
        	
        	if (i % 5 == 0) {
        		g2d.setColor(Color.BLACK);
                g2d.fillRect(0, maxLengthColumn + i *20, IMAGE_WIDTH, 2);
            }
        }
        
        
        // Draw line / column description
        g2d.setFont(new Font("Arial", Font.PLAIN, 12));
        g2d.setColor(Color.BLACK);
        FontMetrics metrics = g2d.getFontMetrics();
        
        for (int i = 0; i < grid.getHeight(); i++) {
            ArrayList<Integer> lineDescription = lineDescriptions.get(i);

            for (int j = 0; j < lineDescription.size(); j++) {
                String currentNumber = String.valueOf(lineDescription.get(j));

                // Calculate the adjusted position for centering
                int textWidth = metrics.stringWidth(currentNumber);
                int textHeight = metrics.getAscent() - metrics.getDescent();
                int x = maxLengthLine - ((lineDescription.size() - j - 1) * 20 + 10) - textWidth / 2;
                int y = maxLengthColumn + i * 20 + 5 + metrics.getAscent() - textHeight / 2 + 2;

                g2d.drawString(currentNumber, x, y);
            }
        }
        
        for (int i = 0; i < grid.getWidth(); i++) {
            ArrayList<Integer> columnDescription = columnDescriptions.get(i);

            for (int j = 0; j < columnDescription.size(); j++) {
                String currentNumber = String.valueOf(columnDescription.get(j));

                // Calculate the adjusted position for centering
                int textWidth = metrics.stringWidth(currentNumber);
                int textHeight = metrics.getAscent() - metrics.getDescent();
                int x = maxLengthLine + i * 20 - textWidth / 2 + 10;
                int y = maxLengthColumn - ((columnDescription.size() - j - 1) * 20 + 10) + metrics.getAscent() - textHeight / 2;

                g2d.drawString(currentNumber, x, y);
            }
        }
        

        File emptyGrid = new File("hanjie.png");
        ImageIO.write(unsolvedImage, "png", emptyGrid);
        System.out.println("Image created successfully: " + emptyGrid.getAbsolutePath());

        
        // Fill solved grid 
        for (int i =0; i < grid.getHeight(); i++) {
        	
        	for (int j =0; j < grid.getWidth(); j++) {
        		
        		if (grid.getElement(i, j) != 1) {
        			continue;
        		}
        		
                g2d.setColor(new Color(25,25,25));
                g2d.fillRect(maxLengthLine + j * 20 + 1, maxLengthColumn + i * 20 + 1, 19, 19);    
                
        	}
        }
        
        // Dispose the Graphics2D object
        g2d.dispose();
        
        // Save the image as a file
        File solvedGrid = new File("hanjie_solved.png");
        ImageIO.write(unsolvedImage, "png", solvedGrid);
        System.out.println("Image created successfully: " + solvedGrid.getAbsolutePath());
    
		
	}

	public static void main(String[] args) throws Exception {
		ImageGenerator.generateImage(HanjieGridTemplates.buildBreizhHanjieGrid());
	}
	
}
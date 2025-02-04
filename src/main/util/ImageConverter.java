package main.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.model.GridHeightException;
import main.model.GridWidthException;
import main.model.HanjieGrid;

public class ImageConverter {

	public static void convertImageToHanjie(File imgFile, HanjieGrid hanjieGrid) throws IOException, GridHeightException, GridWidthException {

		int FINAL_WIDTH = hanjieGrid.getWidth();
		int FINAL_HEIGHT = hanjieGrid.getHeight();
		
		BufferedImage imgWrite = new BufferedImage(FINAL_WIDTH, FINAL_HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = imgWrite.createGraphics();
		
		Integer[][] pixelGrid = getPixelGrid(imgFile, FINAL_HEIGHT, FINAL_WIDTH);
		

		File saveFile = new File("save.png");
		ImageIO.write(imgWrite, "png",	saveFile);
		
		for (int i=1; i<FINAL_WIDTH+1; i++) {
			for (int j=1; j<FINAL_HEIGHT+1; j++) {
				
				int gradX = - 2 * pixelGrid[i][j-1] - pixelGrid[i+1][j-1] - pixelGrid[i-1][j-1] 
						+ 2 * pixelGrid[i][j+1] + pixelGrid[i+1][j+1] + pixelGrid[i-1][j+1];
				
				int gradY = pixelGrid[i+1][j-1] - pixelGrid[i-1][j-1] 
						+ 2 *pixelGrid[i+1][j] - 2 *pixelGrid[i-1][j] 
						+ 1 *pixelGrid[i+1][j+1] - 1 *pixelGrid[i-1][j+1]; 
						
				gradX = gradX < 0 ? -gradX : gradX;
				gradY = gradY < 0 ? -gradY : gradY;
				
				int grad = gradX + gradY;
				
				g2d.setColor(grad < 255 ? Color.WHITE : Color.BLACK);
				g2d.fillRect(i, j, 1, 1);
				
				hanjieGrid.setElement(j-1, i-1, grad < 150 ? -1 : 1);
			}
		}
					
		g2d.dispose();
		
	}

	private static Integer[][] getPixelGrid(File imgFile, int FINAL_HEIGHT, int FINAL_WIDTH) throws IOException {
		Integer[][] pixelGrid = new Integer[FINAL_WIDTH + 2][FINAL_HEIGHT + 2];
		
		BufferedImage imgRead = ImageIO.read(imgFile);	
		
		for (int i=0; i<FINAL_WIDTH + 2; i++) {
			for (int j=0; j<FINAL_HEIGHT + 2; j++) {
				
				int iImgRead = (int) (i * ((double) imgRead.getWidth() / (FINAL_WIDTH + 2)));
				int jImgRead = (int) (j * ((double) imgRead.getHeight() / (FINAL_HEIGHT + 2)));

				Color pixelColor = new Color(imgRead.getRGB(iImgRead, jImgRead));
				int grayRGB = (pixelColor.getRed() + pixelColor.getBlue() + pixelColor.getGreen()) / 3;	
				
				pixelGrid[i][j] = grayRGB;
			}
		}
		
		return pixelGrid;
	}
	
}
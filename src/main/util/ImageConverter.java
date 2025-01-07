package main.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import main.logic.HanjieSolver;
import main.model.HanjieGrid;

public class ImageConverter {

	public static HanjieGrid convertImageToHanjie(String imageURI) throws Exception {
		File imgFile = new File(imageURI);
		BufferedImage imgRead = ImageIO.read(imgFile);	

		int FINAL_WIDTH = 25;
		int FINAL_HEIGHT = 25;
		
		HanjieGrid hanjieGrid = new HanjieGrid(FINAL_HEIGHT, FINAL_WIDTH);
		
		BufferedImage imgWrite = new BufferedImage(FINAL_WIDTH, FINAL_HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = imgWrite.createGraphics();
		
		Integer[][] pixelGrid = new Integer[FINAL_WIDTH+1][FINAL_HEIGHT+1];
		
		for (int i=0; i<FINAL_WIDTH+1; i++) {
			for (int j=0; j<FINAL_HEIGHT+1; j++) {
				
				int iImgRead = i*(imgRead.getWidth() / (FINAL_WIDTH+1) );
				int jImgRead = j*(imgRead.getHeight() / (FINAL_HEIGHT+1) );
				
				Color pixelColor = new Color(imgRead.getRGB(iImgRead, jImgRead));
				int grayRGB = (pixelColor.getRed() + pixelColor.getBlue() + pixelColor.getGreen()) / 3;	
				
				pixelGrid[i][j] = grayRGB;
			}
		}
		
		for (int i=1; i<FINAL_WIDTH; i++) {
			for (int j=1; j<FINAL_HEIGHT; j++) {
				
				int Gx = - 2 * pixelGrid[i][j-1] - pixelGrid[i+1][j-1] - pixelGrid[i-1][j-1] 
						+ 2 * pixelGrid[i][j+1] + pixelGrid[i+1][j+1] + pixelGrid[i-1][j+1];
				
				int Gy = pixelGrid[i+1][j-1] - pixelGrid[i-1][j-1] 
						+ 2 *pixelGrid[i+1][j] - 2 *pixelGrid[i-1][j] 
						+ 1 *pixelGrid[i+1][j+1] - 1 *pixelGrid[i-1][j+1]; 
						
				Gx = Gx < 0 ? -Gx : Gx;
				Gy = Gy < 0 ? -Gy : Gy;
				
				int G = Gx + Gy;
				
				g2d.setColor(G < 255 ? Color.WHITE : Color.BLACK);
				g2d.fillRect(i, j, 1, 1);
				
				hanjieGrid.setElement(j-1, i-1, G < 150 ? -1 : 1);
			}
		}
		
				
		g2d.dispose();
		
		
		return hanjieGrid;
		
	}
		//HanjieSolver hanjieSolver = new HanjieSolver(hanjieGrid);
		//hanjieSolver.solve();
		//ImageGenerator.generateImage(hanjieGrid);
	
	/*
	public static void main(String[] args) throws Exception {
		HanjieGrid hanjieGrid = new HanjieGrid(100,100);
		convertImageToHanjie("sample_images/crown_sample.jpg", hanjieGrid);	
	}
	*/
}
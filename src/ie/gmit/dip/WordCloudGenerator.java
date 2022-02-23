package ie.gmit.dip;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class WordCloudGenerator{
	public void generator(Map<String, Integer> frequency, List<Integer> values) throws Exception{
		
		Font font;
		int i = 0;
		
		FrequencyTable ft = new FrequencyTable();
		Random random = new Random();
		BufferedImage bi = new BufferedImage(900, 500, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics graphics = bi.getGraphics();		
	
		int x = 10, y = 30, fontSize = 0;
		int maxXCoord = 900, maxYCoord = 500;
		String word = null;
		int incrementX;
		int incrementY = 0;
		float a, r, g, b; // Values for alpha, red, green and blue.
		int size = values.size();
		
		/** 
		 * Loops through the ArrayList. Increments X axis as long as X < 900, if X > maxXCoord then it ends the while loop and Y is incremented.
		 * Running Time: O(n^2)
		 */
		while(y < maxYCoord) {			
			while(x < maxXCoord) {
				
				if(i < size) {
					fontSize = values.get(i);
				}
				else {
					break;
				}
				if(fontSize < 12) {
					fontSize = 12; // Sets minimum font size.
				}
				
				
				/**
				 * Sets random color by generating a random float for each component of the color.
				 */
				font = new Font(Font.SANS_SERIF, Font.ITALIC, fontSize);				
				a = random.nextFloat();
				r = random.nextFloat();
				g = random.nextFloat();
				b = random.nextFloat();
				Color randomColor = new Color(a, r, g, b);
				
				/**
				 * Gets the word using the current value. The word is taken from the HashMap in FrequencyTable class.
				 */
				word = ft.getKey(frequency, values.get(i));
				incrementX  = (int) ((fontSize * word.length()) * 0.75);
				incrementY = (int) (fontSize * 0.8);
				
				graphics.setColor(randomColor);
				graphics.setFont(font);
				graphics.drawString(word, x, y);
				
				x += incrementX;
				i++;
				if(i >= Menu.maxWords) {
					break;
				}
			}
			x = 10;
			y += incrementY;
		}
		
		graphics.dispose();
		ImageIO.write(bi, "png", new File(Menu.imageName));
	}
}
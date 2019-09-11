import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.imageio.stream.*;

public class Image 
{
	private int width, height; 
	private int[][] pixels;
   
	public Image(String filename) throws Exception 
	{ 
		this.read(filename); 
	}
	
	public int getWidth()
	{
		return this.width;
	}
	
	public int getHeight()
	{
		return this.height;
	}
	
	public int [][] getPixels(int [][] pixels, int height, int width)
	{
		pixels = new int [height][width]; 
		this.pixels = pixels;
		return this.pixels;  

	}
   
	public void read(String filename) throws Exception 
	{
		File fileImage = new File(filename);
        
        BufferedImage bufImage = ImageIO.read(fileImage);
		this.width = bufImage.getWidth();
		this.height = bufImage.getHeight();
		
		getPixels(this.pixels, this.height, this.width);
		for (int row = 0; row < this.height; row++)
      	{
         	for (int col = 0; col < this.width; col++)
         	{
         		this.pixels[row][col] = bufImage.getRGB(col,row);
         	}
        }
         
   }
   
   private BufferedImage createBufferedImage() 
   	{ 
      	BufferedImage bufImage = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
  
      	for (int row = 0; row < this.height; row++)
      	{
         	for (int col = 0; col < this.width; col++)
         	{
         		bufImage.setRGB(col, row, this.pixels[row][col]);
         	}
        }
         
      	return bufImage;
	}
   
   public void write(String filename) throws Exception 
   {
        File fileImage = new File(filename);
        String ext = filename.substring(filename.indexOf('.') + 1);
        BufferedImage bufImage = createBufferedImage();
        ImageIO.write(bufImage, ext, fileImage);
   }
   
   
	public void draw(Graphics gc, int x, int y)
	{
   		BufferedImage bufImage = createBufferedImage();
      	gc.drawImage(bufImage, x, y, null);
   	}
   	//Brian Moreno Code 
   	public void flipX(Graphics gc, int x,int y)
   	{
		BufferedImage bufImage = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
		int count = this.height-1;
      	for (int row = 0; row < this.height; row++)
      	{
            int count1 = this.width-1;
         	for (int col = 0; col < this.width; col++)
         	{
			   bufImage.setRGB(count1, row, this.pixels[row][col]);
               if(count1>0)
               {
                 count1--;
               }
         	}
            if(count>0)
            {
              count--;
            }
        }
       
      	gc.drawImage(bufImage, x, y, null);
      	
      	try
      	{
			File f = new File("animalsmirror.png"); 
			ImageIO.write(bufImage, "PNG", f);
		}
		catch (Exception e)
		{
         	e.printStackTrace();
      	}
			

	}
   	
   	public void flipY(Graphics gc, int x,int y)
	{
       
		BufferedImage bufImage = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
		int count = this.height-1;
      	for (int row = 0; row < this.height; row++)
      	{
            int count1 = this.width-1;
         	for (int col = 0; col < this.width; col++)
         	{
         	   bufImage.setRGB(count1, count, this.pixels[row][col]);
               if(count1>0)
               {
                 count1--;
               }
         	}
            if(count>0)
            {
              count--;
            }
        }
         
      	gc.drawImage(bufImage, x, y, null);
      	
      	try
      	{
			File f = new File("animalsupsidedown.png"); 
			ImageIO.write(bufImage, "PNG", f);
		}
		catch (Exception e)
		{
         	e.printStackTrace();
      	}
	}
	//Brian Moreno code ends
} 

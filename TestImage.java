import java.awt.*;
import javax.imageio.*; 

class TestImage 
{
	public static void main(String args[]) throws Exception 
	{	
		
    	Frame frame = new Frame("My Images");
      	frame.setSize(1024,768);
      	frame.setVisible(true);
      	Graphics gc = frame.getGraphics();
      
      	try 
      	{
         	Image im1 = new Image("animals.jpg");
         	im1.draw(gc, 10, 40);
         	im1.flipX(gc,300,40);
         	im1.flipY(gc,10,280);	
		} 
		catch (Exception e)
		{
         	e.printStackTrace();
      	}
	}
}

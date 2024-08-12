package processing;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;

import javax.imageio.ImageIO;


public class EdgeDetection {
    public BufferedImage detectEdge(BufferedImage src){
       //kernel for edge detection adding upto less than 1
       float edgeArr[]={1.0f, 0.0f, -1.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f,
    	               -1.0f};
       //creating the convolution operator
       ConvolveOp edgeOp=new ConvolveOp(new Kernel(3,3,edgeArr),ConvolveOp.EDGE_NO_OP,null);
     
       return edgeOp.filter(src, null);  //operating on image
    }
    
    
    public BufferedImage grayScale(BufferedImage src1)
    {
    	int height=src1.getHeight();
    	int  weight=src1.getWidth();
    	for(int i=0;i<height;i++)
    	{
    		for(int j=0;j<weight;j++)
    		{
    			  Color c = new Color(src1.getRGB(j, i));
                  int red = (int)(c.getRed() * 0.299);
                  int green = (int)(c.getGreen() * 0.587);
                  int blue = (int)(c.getBlue() *0.114);
                  Color newColor = new Color(red+green+blue,
                  
                  red+green+blue,red+green+blue);
                //  System.out.println(newColor);
                  src1.setRGB(j,i,newColor.getRGB());
    		}
    	}
    	return src1;
    }
    
    public static void main(String[] args)throws Exception {
       EdgeDetection obj=new EdgeDetection();
       BufferedImage src=ImageIO.read(new File("C://uploads/Banking/1_1.png/out.png")),
       dest1=obj.detectEdge(src);  //edge detection
       ImageIO.write(dest1, "png",new File("C://uploads/Banking/1_1.png/edgeout.png"));
    }
}
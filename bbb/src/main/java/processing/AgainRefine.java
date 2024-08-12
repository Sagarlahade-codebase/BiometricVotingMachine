package processing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class AgainRefine {

	/**
	 * @param args
	 */
	public static int threshold=-16777216;
	public static void getRefine(BufferedImage bi) throws IOException
	{
		
		int h=bi.getHeight();
		int w=bi.getWidth();
		 double neighbors[][] = {};
		
		for(int i=0;i<h;i++)
		{
			for(int j=0;j<w;j++)
			{
				
				if(bi.getRGB(i, j)==threshold)
				{
				
				
	                
					neighbors[0][0] = bi.getRGB(i-1, j-1); // getRGB returns r,g,b byte values of a single int pixel
	                neighbors[0][1] = bi.getRGB(i, j-1);
	                neighbors[0][2] = bi.getRGB(i+1, j-1);
	                neighbors[1][0] = bi.getRGB(i-1, j);
	                neighbors[1][1] = bi.getRGB(i, j); // central pixel (x,y) ?
	                neighbors[1][2] = bi.getRGB(i+1, j);
	                neighbors[2][0] = bi.getRGB(i-1, j+1);
	                neighbors[2][1] = bi.getRGB(i, j+1);
	                neighbors[2][2] = bi.getRGB(i+1, j+1);
					
	              int c=  match(neighbors);
	                if(c>=5)
	                {
	                	bi.setRGB(i, j, threshold);
	                	neighbors=null;
	                	//System.out.println("neighbors size final---------:"+neighbors.length);
	                	
	                }else{
	                	bi.setRGB(i, j, 16777215);
	                }
				} else{
					
					bi.setRGB(i, j, 16777215);
				}
	                
			}
		}
		
		
		ImageIO.write(bi, "png", new File("C://uploads/Banking/1_2.png/out.png"));
	}
	
	
	
	public static int match(double[][] neigh)
	{
		int count=0;
		
		 for (double[] neighbor : neigh)
	        {
			 
			 System.out.println(neighbor.length);
				 /*if(neighbor==threshold)
				 {
					 count++;
				 }
			 */
	        }
		 return count;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String path="C://uploads/Banking/1_2.png/thin1_2.png";
		
		try {
			
			BufferedImage img=ImageIO.read(new File(path));
			
			RefineImage.getRefine(img);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}

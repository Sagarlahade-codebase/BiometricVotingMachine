package processing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class RefineImage {

	/**
	 * @param args
	 */
	public static int threshold=-16777216;
	public static BufferedImage getRefine(BufferedImage bi) throws IOException
	{
		//BufferedImage out=null;
		int edgeCount=0;
		
		int h=bi.getHeight();
		int w=bi.getWidth();
		
		 int neighbors[][] =new int[4][4];
		try{
			
			for(int i=1;i<w-1;i++)
		{
			for(int j=1;j<h-1;j++)
			{
				//System.out.println(bi.getRGB(i, j));
				
				if(bi.getRGB(i, j)!=threshold)
				{
					
						
						bi.setRGB(i, j, 16777215);
					}
				else{
				

					//System.out.println(i  +"   "+j);
				
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
	                if(c>=3)
	                {
	                	bi.setRGB(i, j, threshold);
	                	
	                }else{
	                	bi.setRGB(i, j, 16777215);
	                	edgeCount++;
	                	
	                }
	                
				} 
			}
		}
		System.out.println("image write successfully-------------");
		
		//ImageIO.write(bi, "png", new File("C://uploads/Banking/1_2.png/finalout.png"));
		}catch(Exception e)
		
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		System.out.println(h+"   "+w);
	//	System.out.println("edgeCount::"+edgeCount);
		return bi;
	}
	
	
	
	public static int match(int[][] neigh)
	{
		int count=0;
		
		 for (int i=0;i<3;i++)
	        {
			 for(int j=0;j<3;j++)
			 {
			 
			 
				 if(neigh[i][j]==threshold)
				 {
					 count++;
				 }
			 
	        }
	        }
		 return count;
	}
	
	
	public static void getRGB(BufferedImage bi)
	{
		int co=0;
		for(int i=0;i<bi.getWidth();i++)
	
		{
			for(int j=0;j<bi.getHeight();j++)
			{
				if(bi.getRGB(i, j)==threshold)
				{
					co++;
				}
				//System.out.println(bi.getRGB(i, j));
			}
		}

		System.out.println("co:"+co);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String path="C://uploads/Banking/1_2.png/obifuout.png";
		
		try {
			
			BufferedImage img=ImageIO.read(new File(path));
			
			System.out.println("take image--------");
			RefineImage.getRefine(img);
			
			//RefineImage.getRGB(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}

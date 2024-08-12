
package processing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bifurcations {

	
	public static int threshold=-16777216;
	public static void getRefine(BufferedImage bi) throws IOException
	{
		int edgeCount=0;
		
		int h=bi.getHeight();
		int w=bi.getWidth();
		int center=0;
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
					
					center=bi.getRGB(i, j);
					
					if(bi.getRGB(i-1, j-1)==threshold)
					{  
						bi.setRGB(i, j, 16777215);
						continue;
						
					}
					else
					if(bi.getRGB(i-1, j-1)==threshold)
					{
						bi.setRGB(i, j, 16777215);
						continue;
					}
					
					/*else
	                
	                if( bi.getRGB(i-1, j+1)==threshold)
	                {
	                	bi.setRGB(i, j, 16777215);
	                	continue;
	                }
	                else
	               if( bi.getRGB(i+1, j+1)==threshold)
	               {
	            	   bi.setRGB(i, j, 16777215);
	               }*/
					
	            
	                
	                
				} 
			}
		}
			
			
			
			
		System.out.println("image write successfully-------------");
		
		ImageIO.write(bi, "png", new File("C:/uploads/Banking/1_2.png/obifuout.png"));
		}catch(Exception e)
		
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		//System.out.println(h+"   "+w);
	//	System.out.println("edgeCount::"+edgeCount);
	}
	
	
	
	public static int match(int[][] neigh,int center)
	{
		int count=0;
		
		 for (int i=0;i<3;i++)
	        {
			 for(int j=0;j<3;j++)
			 {
			 
			 
				 if(neigh[i][j]==center)
				 {
						//bi.setRGB(i, j, 16777215);
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
		
		String path="C://uploads/Banking/1_2.png/out.png";
		
		try {
			
			BufferedImage img=ImageIO.read(new File(path));
			
			System.out.println("take image--------");
		Bifurcations.getRefine(img);
			
			//RefineImage.getRGB(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}

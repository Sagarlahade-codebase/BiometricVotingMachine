package processing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CountBifurcation {
	
	public static int threshold=-16777216;
	public static int getCount(BufferedImage bi) throws IOException
	{
		int count=0;
		int buffCount=0;
		int h=bi.getHeight();
		int w=bi.getWidth();
		 double neighbors[][] = {};
		
		for(int i=1;i<w-1;i++)
		{
			for(int j=1;j<h-1;j++)
			{
				
				if(bi.getRGB(i, j)==threshold)
				{
			
					if(bi.getRGB(i, j-1)==threshold || bi.getRGB(i+1, j) ==threshold || bi.getRGB(i-1, j)==threshold ||   
	             
	               bi.getRGB(i, j+1)==threshold ){
						
						count++;
						//bi.setRGB(i, j,16777000);
					}
					
	              
				}/* else{
					
					bi.setRGB(i, j, 16777215);
				}*/
	                
			}
		}
		
		System.out.println("Bifurcation point:"+count/100);
		//ImageIO.write(bi, "png", new File("C://uploads/Banking/1_2.png/1out.png"));
		buffCount=count/100;
		return buffCount;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String path="C://uploads/Banking/1_2.png/out.png";
		
		try {
			
			BufferedImage img=ImageIO.read(new File(path));
			
			CountBifurcation.getCount(img);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}

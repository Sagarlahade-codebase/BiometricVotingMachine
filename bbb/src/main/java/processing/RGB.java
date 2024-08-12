package processing;

import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

public class RGB {
	  static int[][] valueA;
	  static int[][] valueB;
	  static int[][] valueG;
    
    public static BufferedImage getImage(String imageName) {
 try {
  File input = new File(imageName);
  BufferedImage image = ImageIO.read(input);
  return image;
 } catch (IOException ie) {
  System.out.println("Error:" + ie.getMessage());
 }
 return null;
    }
    public static int [][] getRGB(BufferedImage img) {
        int w1 = img.getWidth();
        int h1 = img.getHeight();
        int value[][] = new int[w1][h1];
        for (int i = 0; i < w1; i++) {
            for (int j = 0; j < h1; j++) {
                value[i][j] = img.getRGB(i, j); // store value
                System.out.println(  value[i][j]);
            }
        }
        
        return value;
    }
    public static int [][] getR(BufferedImage img) {
        int w1 = img.getWidth();
        int h1 = img.getHeight();
        int value;
        int valueR[][] = new int[w1][h1];
        for (int i = 0; i < w1; i++) {
            for (int j = 0; j < h1; j++) {
                value = img.getRGB(i, j); // store value
                System.out.println("rgb::"+value);
                valueR[i][j] = getRed(value);
                System.out.println("Red channel:"+ valueR[i][j]);
            }
        }
        return valueR;
    }
   
    public static int [][] getG(BufferedImage img) {
        //
    	  int w1 = img.getWidth();
          int h1 = img.getHeight();
          int value;
          int valueG[][] = new int[w1][h1];
          for (int i = 0; i < w1; i++) {
              for (int j = 0; j < h1; j++) {
                  value = img.getRGB(i, j); // store value
                  valueG[i][j] = getGreen(value);
                 System.out.println("blue channel:" +valueG[i][j]);
              }
          }
    	
        return valueG;
             
    }
    public static int [][] getB(BufferedImage img) {
        //
    	 int w1 = img.getWidth();
         int h1 = img.getHeight();
         int value;
         int valueB[][] = new int[w1][h1];
         for (int i = 0; i < w1; i++) {
             for (int j = 0; j < h1; j++) {
                 value = img.getRGB(i, j); // store value
                 valueB[i][j] = getBlue(value);
                System.out.println("blue channel:" +valueB[i][j]);
             }
         }
   	
      
        return valueB;
    }
    public static int [][] getA(BufferedImage img) {
      
    	 int w1 = img.getWidth();
         int h1 = img.getHeight();
         int value;
         int valueA[][] = new int[w1][h1];
         for (int i = 0; i < w1; i++) {
             for (int j = 0; j < h1; j++) {
                 value = img.getRGB(i, j); // store value
                 valueA[i][j] = getAlpha(value);
                 //System.out.println("Alpha channel:" +valueA[i][j]);
             }
         }
   	
     
    	
		//
        return valueA;
    }
    
    
    public int[] printPixel(int pixel,int h,int w)
	{
		int[] rgb=new int[+h*w];
		for(int i=0;i<h*w;i++)
		{
			rgb[i]=pixel;
		}
		return rgb;
	}
    public static int getAlpha(int rgb) {
    	System.out.println("red:"+((rgb >> 24) & 0xFF));
        return (rgb >> 24) & 0xFF;
    }
    public static int getRed(int rgb) {
    	System.out.println("red:"+((rgb >> 16) & 0xFF));
        return (rgb >> 16) & 0xFF;
    }
    public static int getGreen(int rgb) {
    	System.out.println("red:"+((rgb >> 8) & 0xFF));
        return (rgb >> 8) & 0xFF;
    }
    public static int getBlue(int rgb) {
    	System.out.println("red:"+(rgb & 0xFF));
        return rgb & 0xFF;
    }
    public static void main(String[] args) {
    	String imageName="C:\\Users\\Public\\Pictures\\Sample Pictures\\Koala.jpg";
       // int value[][]=getRGB(getImage(imageName));
        int valueR[][]=getR(getImage(imageName));
       // int valueG[][]=getG(getImage(imageName));
        //int valueB[][]=getB(getImage(imageName));
        //int valueA[][]=getA(getImage(imageName));
        //int valueR[][]=getR(getImage("C:/Users/Public/Pictures/Sample Pictures//Koala.jpg"));
        
       
    } 
}

package com.project.controller;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.project.bean.FingerBean;
import com.project.daoImplementation.UserImpl;
import com.project.daoInterface.UserInterface;

import processing.Binarize;
import processing.CountBifurcation;
import processing.Image;
import processing.RGB;
import processing.RefineImage;

/**
 * Servlet implementation class UploadFingerServlet
 */
@MultipartConfig(maxFileSize=1024*1024*50)
@WebServlet("/UploadFingerServlet")
public class UploadFingerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadFingerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	InputStream is=null;
	String name="";
	BufferedImage bi=null;
	String path="";
	File uploadPath=null;
	String exten="";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		HttpSession session=request.getSession();
		int id=(Integer)session.getAttribute("id");
		path=request.getServletContext().getRealPath("/input");
		//path="D://Register";
		
		
		
		Part part=request.getPart("file");
		if(part!=null);
		{
			is=part.getInputStream();
			name=getFileName(part);
			File ff=new File(path+"/"+id+"/"+name);
			
			
			if(!ff.isDirectory())
			{
				ff.mkdirs();
			}
			 int extensionIndex = name.lastIndexOf(".");
		     exten = name.substring(extensionIndex + 1);
			bi=ImageIO.read(is);
			uploadPath=new File(ff.getAbsolutePath()+"/"+name);
			ImageIO.write(bi, exten,uploadPath );
		}
		
		 BufferedImage original, grayscale, binarized;
	        original=ImageIO.read(uploadPath);
	        
	       // RGB rgb=new Rgb();
	        RGB.getRGB(original);
	        
	        Binarize bb=new Binarize();
	        grayscale=Binarize.toGray(original);
	        
	        String storeBinary=uploadPath.getParent();
	        File file1 = new File(storeBinary+"/"+"gray"+name);
			ImageIO.write(grayscale, exten, file1);
		
 /*****************Binary image********************/
	        
	        binarized=Binarize.binarize(grayscale);
	       
	       
	        File file = new File(storeBinary+"/"+"binary"+name);
			ImageIO.write(binarized, exten, file);			
			System.out.println("binary image created.........");
			Image thin=new Image();
			int [] [] givenImage =	thin.Interarray(binarized);
			int [] [] thinn = thin.doZhangSuenThinning(givenImage, false);
			
			 for (int y = 0; y < givenImage.length; y++) {
				 
		            for (int x = 0; x < givenImage[y].length; x++) {
		 
		                if (givenImage[y][x] == 1) {
		                	original.setRGB(x, y, Color.BLACK.getRGB());
		 
		                } else {
		                	original.setRGB(x, y, Color.WHITE.getRGB());
		                }
		 
		 
		            }
		        }
			 File thinfile=new File(storeBinary+"/"+"thin"+name);
		        ImageIO.write(original, exten, thinfile );
		        System.out.println("Successfully thined");
		        
		        BufferedImage thin1=ImageIO.read( new File(storeBinary+"/"+"thin"+name));
		        BufferedImage refine=RefineImage.getRefine(thin1);
		        
		        File refine1=new File(storeBinary+"/"+"refine"+name);
		        ImageIO.write(refine, exten, refine1 );
		        
		    int BuffCount=CountBifurcation.getCount(refine);
		    System.out.println("BuffCount::"+BuffCount);
		    
		    UserInterface ui=new UserImpl();
		    	    FingerBean fb=new FingerBean(uploadPath.getAbsolutePath(), file1.getAbsolutePath(), file.getAbsolutePath(), thinfile.getAbsolutePath(), refine1.getAbsolutePath(), BuffCount, id);
		    int j=ui.uploadFingerPrint(fb);
		    if(j>0)
		    {
		    	request.setAttribute("path", uploadPath.getAbsolutePath());
		    	
			    request.getRequestDispatcher("/rrr.jsp").forward(request, response);
		
		    }
		    
		    
	}

	
	private String getFileName(Part part)
	{
		String name1=part.getHeader("content-disposition");
		System.out.println(part.getHeaderNames().toString());
		System.out.println("name:"+name1);
		name1=name1.substring(name1.lastIndexOf("filename")+10, name1.length()-1);
		return name1;
	}
}

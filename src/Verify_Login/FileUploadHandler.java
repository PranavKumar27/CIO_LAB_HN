package Verify_Login;

import java.io.File;  
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.FileCleanerCleanup;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileCleaningTracker;


public class FileUploadHandler extends HttpServlet{

	  String UPLOAD_DIRECTORY = "C:/temp";
	  String HOST_IP_UPLOAD_PAGE="11.1.205.";
	   
	   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   HOST_IP_UPLOAD_PAGE="11.1.205.";
		   
	   
		   // isMultipartContent() is static method of the class ServletFileUpload which return boolean data
		   // Utility method that determines whether the request contains multipart content.
		   Boolean b=ServletFileUpload.isMultipartContent(request);
		   
		  
		   System.gc();
	      if(b)
	      {
	    	  try{
	    	  	  // Constructs an unconfigured instance of DiskFileItemFactory class. The resulting factory may be configured by calling the appropriate setter methods.
	               DiskFileItemFactory dskFileItem = new DiskFileItemFactory();
	               
	               // Create a new file upload handler on DiskFileItemFactory. DiskFileItemFactory has can set repository paths, threshold sizes.
	               // https://commons.apache.org/proper/commons-fileupload/using.html
	               
	               ServletFileUpload ServFlUpload= new ServletFileUpload(dskFileItem);
	               
	               // multiparts is a list of FileItem instances parsed from the request, in the order that they were transmitted.
	               List<FileItem> multiparts = ServFlUpload.parseRequest(request);
	               
	               
	            		   
	            		   
	                //List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
	               
	            // Processing the uploaded items using iterator usage.
	               
	               Iterator<FileItem> itr=multiparts.iterator();
	               
	               
	               while (itr.hasNext()) 
	               {
	            	    FileItem item = itr.next();

	            	    if (item.isFormField()) 
	            	    {
	            	    	System.out.println("Trying to call processFormField()");
	            	    	processFormField(item,request,response) ;
	            	    	System.out.println("return from processFormField successfully");
	            	    }
	            	    else 
	            	    {
	            	    	System.out.println("Trying to call processUploadedFile()");
	            	    	try 
	            	    	{
								processUploadedFile(item,request,response);
							} 
	            	    	catch (Exception e) 
	            	    	{
								request.setAttribute("File_Upload_Status", "No File Selected\n");
			                	request.getRequestDispatcher("/Test.jsp").forward(request, response);
								e.printStackTrace();
							}
	            	    	System.out.println("return from processUploadedFile successfully");
	            	    }
	              }
	    	  }
	              
	              catch(Exception ex)
	              {
	            	  System.out.println("A fatal Sever exception occured during file UPLOAD/Handling. Report admin");
	            	  ex.printStackTrace();
	              }
	               //File uploaded successfully proceed to flash else Send the message back as not file uploaded and stop.

	                // File upload was success. IP is also validated. Now try to call Flash servlet.
	                // creating object of Flash_Device which calls bat file to flash CEP -based-controllers
	                	
	               Flash_Device fd = new Flash_Device();
	 	           fd.service(request, response);
	 	           
	 	           // Cleanup Process
	 	           
	     
	   }
	 }
	    void processFormField(FileItem item,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	    {
	    	
	    	System.out.println("Inside item.isFormField()-- True");
   	     	System.out.println("Got a form field: " + item.getFieldName()+ " " +item.getString());
   	     	
   	     	String IP_new=item.getString();
   	     	try{
   	     		int n=Integer.parseInt(IP_new);
	   	     	if(!(0<n && n<256))
	   	     	{
	   	     		request.setAttribute("IPERROR", "Please provide valid index b/w 1 to 255");
	   	     		request.getRequestDispatcher("/Test.jsp").forward(request, response);
	   	     		return;
	   	     	}
   	     	}
   	     	catch(Exception ex)
   	     	{
   	     		request.setAttribute("IPERROR", "Please provide valid index b/w 1 to 255 and then select F/W file");
	     		request.getRequestDispatcher("/Test.jsp").forward(request, response);
	     		return;
   	     	}
   	     	
   	     	
   	     		
   	     	HOST_IP_UPLOAD_PAGE+=item.getString();
        	  System.out.println("IP="+HOST_IP_UPLOAD_PAGE);
        	 if(HOST_IP_UPLOAD_PAGE.equalsIgnoreCase("11.1.205."))
        	 	{
        		 request.setAttribute("IPERROR", "Please provide both Device Index and Select file inorder to flash");
        	 	 request.getRequestDispatcher("/Test.jsp").forward(request, response);
        	 	 return;
       		}
	    }
	    void processUploadedFile(FileItem item,HttpServletRequest request,HttpServletResponse response) throws Exception
	    {
	    	
	    	String fname = null;
            String fsize = null;
            String ftype = null;
            
	    	System.out.println("Inside item.isFormField()  -- False ");
    		
    		System.out.println("IP= in Form Field Flase case "+HOST_IP_UPLOAD_PAGE);
    		
    		System.out.println("Upload Directory Before="+UPLOAD_DIRECTORY);

    		try
    		{
	    		Runtime run =Runtime.getRuntime();
	    		String PATH="cmd /c start cmd.exe /c C:/temp/MKDIR.bat " + HOST_IP_UPLOAD_PAGE;
	    		Process process=run.exec(PATH);
	    		System.out.println("Directory created successully");
	    		
	    		//UPLOAD_DIRECTORY+="/"+HOST_IP_UPLOAD_PAGE;
	    		
	    		System.out.println("Upload Directory After="+UPLOAD_DIRECTORY);
	    		
    		}
    		catch(Exception e){
    			System.out.println("Directory creation failed");
    			e.printStackTrace();
    		}
    		
    		
    		//String filename=item.getName();
    		
    		//File f= new File(filename);
    		
    		//fname=filename;
    		
    		
    		fname = new File(item.getName()).getName();
    		System.out.println("Filename obtained successfully fname="+fname);
            //fsize = new Long(item.getSize()).toString();
            //ftype = item.getContentType();
    		
    		// if file is not selected we return the control back.
    		if(fname.equalsIgnoreCase(""))
    		{
    			request.setAttribute("File_Upload_Status", "Please provide both Index and select file."); 
                request.setAttribute("IP_ADDR",HOST_IP_UPLOAD_PAGE);
    			return;
    		}
    		
    		// Creating new file object ff where argument is the path. The base path is UPLOAD_DIRECTORY, File.separator is '/' and fname is the filename
    		
    		
    		File ff = new File(UPLOAD_DIRECTORY + File.separator + fname);
    		System.out.println("ff="+ff);
    		// Fileitem item has write(File file)
    		// A convenience method to write an uploaded item to disk.
    		
    		System.out.println("ff write starts here=");
            item.write(ff);
            System.out.println("ff write completes here=");
            
            System.out.println("fname="+fname);
            request.setAttribute("FILENAME", fname);
            request.setAttribute("File_Upload_Status", "File Uploaded Successfully"); 
            request.setAttribute("Device_Status", "Device index under flash is "+HOST_IP_UPLOAD_PAGE);
            request.setAttribute("IP_ADDR",HOST_IP_UPLOAD_PAGE);
	    }
	    
	    public static DiskFileItemFactory newDiskFileItemFactory(ServletContext context,File repository)
	    {
	    	FileCleaningTracker fileCleaningTracker = FileCleanerCleanup.getFileCleaningTracker(context);
	    	DiskFileItemFactory factory = new DiskFileItemFactory(DiskFileItemFactory.DEFAULT_SIZE_THRESHOLD,repository);
	    	factory.setFileCleaningTracker(fileCleaningTracker);
	    	return factory;
}
}

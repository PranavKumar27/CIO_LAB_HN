package Verify_Login;

import java.util.*;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

public class Flash_Device extends HttpServlet {
	
		
          public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
				// Collect Parameters
				
			   
        	  
			
        	  String HOST_IP=(String)request.getAttribute("IP_ADDR"); 
        	   System.out.println("in Flash Servlet IP="+HOST_IP);
        	   
        	   
        	   String Filename=(String)request.getAttribute("FILENAME");
			   System.out.println("FileName in Flash servlet="+Filename);
			   
			   
			   String Message=(String)request.getAttribute("File_Upload_Status");
			   System.out.println("FileUpload message in Flash servlet="+Message);
			   
			   
				
        	   if(HOST_IP.equalsIgnoreCase("11.1.205."))
        	   {
        		   System.out.println("Host ip is null");
        		   if(request.getAttribute("IPERROR")==null)
        		   {
        			   request.setAttribute("IPERROR", "Please provide IP to proceed further");
        		   }
        		   RequestDispatcher rd= request.getRequestDispatcher("Test.jsp"); 
				   rd.forward(request, response);
        	   }
        	   else if(Filename==null)
        	   {
        		   System.out.println("FileName is null");
        		   if(Message==null)
        			   request.setAttribute("File_Upload_Status", "Please select FileName to proceed further");
        		   RequestDispatcher rd= request.getRequestDispatcher("Test.jsp"); 
				   rd.forward(request, response);
        	   }
        	   else if(Message.equals("File Uploaded Successfully"))
        	   {
        		System.out.println("messaqe Uploaded Successfully- from FlashDevices.java");
        		System.out.println("FileName in Flash servlet="+Filename);
        		System.out.println("Flash Servlet IP="+HOST_IP);
        	   System.out.println("Trying to launch CMD");
				Runtime run =Runtime.getRuntime();
				//run.exec("cmd.exe /c start cmd.exe");
				/*String SSH_UOC="cmd /c start cmd.exe /c ssh root@"+HOST_IP+" cat /usr/honeywell/bin/app_ident.txt"+";"+"sleep 50s";
				run.exec(SSH_UOC);
				
				
				String SCP_PATH="scp -o \"StrictHostKeyChecking no\" C:\\temp\\pranav.sh root@" +HOST_IP+":/usr/honeywell/bin/pranav.sh" ;  
				
				System.out.println("SCP_PATH="+SCP_PATH);
				run.exec(SCP_PATH);
				System.out.println("Copy file to testbed now");
				
				
				String ENV_VAR="ssh -o \"StrictHostKeyChecking no\" root@" +HOST_IP+"HONEYWELL_APP_DIR=/usr/honeywell PATH=$PATH:/usr/honeywell/bin"; 
				System.out.println("ENV_VAR="+ENV_VAR);
				run.exec(ENV_VAR);
				System.out.println("Setting env vars in testbed now");
				
				
				String UPGRADE_REBOOT="cmd /c start cmd.exe /c ssh root@"+HOST_IP+" top"+";"+"sleep 50s";
				run.exec(UPGRADE_REBOOT);
				System.out.println("Upgrading the testbed now");
				
				//run.exec("cmd /c start cmd.exe /c C:/Users/h343128/workspace_Java/LAB1/src/Verify_Login/ping_Device.bat");
				System.out.println("SUCCESS");
				
				
				
				*/
				request.setAttribute("IP_addr",HOST_IP );
				String PATH="cmd /c start cmd.exe /c C:/temp/test.bat " + HOST_IP + " " + Filename + ";" + "sleep 5";
				request.setAttribute("Logs_Path", "C:/temp/"+HOST_IP);
				run.exec(PATH);
				
				
				//request.setAttribute("Upload", "Sucessfully Uplooaded");
				
				request.setAttribute("Flash_RESULT", "Flash Operation In Process. Device will Reboot, Please wait for some time.");
				RequestDispatcher rd=request.getRequestDispatcher("Test.jsp");
				rd.forward(request, response);		
				System.out.println("Retruning the control from Flash Device.java to Test.jsp");
				return;
        	   }
          }

}

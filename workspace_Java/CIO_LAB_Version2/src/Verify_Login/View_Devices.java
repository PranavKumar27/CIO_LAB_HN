package Verify_Login;
import java.util.*;
import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class View_Devices extends HttpServlet{
			
	public static List<Device> devices;
	
	public  void readDevice(){
		    if(devices==null){
		       devices = new ArrayList<Device>();
		       System.out.println("devices="+devices);
			   File file = new File("C:/Users/h343128/workspace_Java/LAB1/src/Verify_Login/UOC.csv");
			   System.out.println("Created file Object");
			   System.out.println("File="+file);
				try{
		            Scanner scan = new Scanner (file);
					while (scan.hasNextLine()) {
		                String line = scan.nextLine();
						String[] tokens = line.split(",");
						System.out.println("device="+devices);
						devices.add(new Device(tokens[0], tokens[1]));
		                System.out.println("Tokenizing variables");
		                System.out.println(tokens[0]+" "+tokens[1]);
		            }
		            scan.close();

		        }
				catch(Exception e)
				{
					e.printStackTrace();
				}
				}        
		    }
protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	HttpSession session=request.getSession();
	
	readDevice();
	
	request.setAttribute("dlist", devices);
	
	Iterator it=devices.iterator();
	System.out.println("it="+it);
	System.out.println("devices="+devices);
	

	session.setAttribute("MSG", "UOC_DEVICES LIST");
	
	RequestDispatcher rd=request.getRequestDispatcher("View.jsp");
	rd.forward(request, response);
}
	
}


			
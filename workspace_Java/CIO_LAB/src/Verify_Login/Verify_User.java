package Verify_Login;

import java.util.*;
import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class User {

		private int id;
		private String username;
		private String password;
		
		
		public User(int id, String username, String password) {
			this.id = id;
			this.username = username;
			this.password = password;
		}
		public int getId() {
			return id;
		}
		
		public String getUsername() {
			return username;
		}
		
		public String getPassword() {
			return password;
		}
		
		
	}

	class Users{
		
		public static List<User> users;
		
		public  void readUsers(){
	        if(null == users){
	            users = new ArrayList<User>();
				File file = new File("C:/Users/h343128/workspace_Java/LAB1/src/Verify_Login/Member.csv");
				System.out.println("Created file Object");
				System.out.println("File="+file);
				try{
	            Scanner scan = new Scanner (file);
				while (scan.hasNextLine()) {
	                String line = scan.nextLine();
					String[] tokens = line.split(",");
	                users.add(new User(Integer.parseInt(tokens[0]), tokens[1], tokens[2]));
	                System.out.println("Tokenizing variables");
	            }
	            scan.close();

	        }
			catch(Exception e)
			{
				
			}
			}        
	    }
		
		public boolean check(String name,String pswd) throws IOException
		{
			System.out.println("name="+name);
			System.out.println("pswd="+pswd);
			Users PK=new Users();
			PK.readUsers();
			Iterator<User> iterator = users.iterator();
			System.out.println("Created Iterator");
			System.out.println("Trying to launch CMD");
			//Runtime run =Runtime.getRuntime();
			//run.exec("cmd.exe /c start cmd.exe");
			//run.exec("cmd /c start /MIN cmd.exe /c ssh root@11.1.205.94");
			//run.exec("cmd /c start /MIN cmd.exe /c telnet");
			//System.out.println("SUCCESS");
			while (iterator.hasNext()) {
				System.out.println("Inside Iterator");
				User iteratorPK=iterator.next();
				System.out.println("iterator="+iterator);
				
				System.out.println(iteratorPK.getId() + "---"+ iteratorPK.getUsername()+ "---" + iteratorPK.getPassword());
				
				String name2=iteratorPK.getUsername();
				String pswd2=iteratorPK.getPassword();
				
				System.out.println("Name="+name2);
				System.out.println("Pswd="+pswd2);
				
				if((name2.equals(name)) & (pswd2.equals(pswd)))
					return true;		
			}
			System.out.println("Noo");
			System.out.println("iterator="+iterator);
			return false;
		}
	}
	public class Verify_User extends HttpServlet{
		public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
			// Collect Parameters
			
			String name=request.getParameter("username");
			String pswd=request.getParameter("password");
			
			System.out.println("username Received="+name);
			System.out.println("Password Received="+pswd);
			
			Users A=new Users();
			boolean V=A.check(name, pswd);
			
			System.out.println("V="+V);
			
			RequestDispatcher rd;
			if(V)
				{
						rd=request.getRequestDispatcher("Data.jsp");
						request.setAttribute("Result", "Welcome "+ name);
						rd.forward(request, response);
				}
			else
				{
					rd=request.getRequestDispatcher("Login.jsp");
					request.setAttribute("Result", "Wrong Username/Password Try Again");
					rd.forward(request, response);
				}
			
			
		}
		
	}
	


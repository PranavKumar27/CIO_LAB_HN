package Verify_Login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FTE_SCAN extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		request.setAttribute("FTE_STATUS", "This Feature is still under Development");
		request.getRequestDispatcher("Test.jsp").forward(request, response);
		return;
	}
}

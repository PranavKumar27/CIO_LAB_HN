package Verify_Login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BOOTP_SCAN {
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		request.setAttribute("BOOTP_STATUS", "This Feature is still under Development");
		request.getRequestDispatcher("Test.jsp").forward(request, response);
		return;
	}
}

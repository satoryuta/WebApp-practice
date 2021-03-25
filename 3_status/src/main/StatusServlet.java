package main;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import status.Status;
@WebServlet(urlPatterns={"/sts"})
public class StatusServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
		throws ServletException, IOException {

		
	Status sts = new Status();
	
	String Foutune = sts.getResult();
	
	PrintWriter out = response.getWriter();
	out.println("Your Foutune is " +Foutune  );
	
	
    }
}

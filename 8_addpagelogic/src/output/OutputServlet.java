package output;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/kadai8/sts"})
public class OutputServlet extends HttpServlet {

	public void doGet(HttpServletRequest request,
				HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String title=request.getParameter("title");
		String writer=request.getParameter("writer");
		String publisher=request.getParameter("publisher");
		String price=request.getParameter("price");
		String[] genre=request.getParameterValues("genre");
		String stock=request.getParameter("stock");
		String remarks=request.getParameter("remarks");
		
		int cnt;	
		if(genre == null) 
		{
			cnt = -1;
		}else {
			try {
				cnt = Integer.parseInt(genre[0]);
			}catch(NullPointerException e) {
				cnt = -1;
			}
		}
		
		if (cnt == -1) {
			out.print("ƒWƒƒƒ“ƒ‹‚ª–¢‘I‘ð‚Å‚·");
		}else {
			for(int i=0; i < genre.length; i++ ) {
				out.println("genre : "+ genre[i]);
			}
		}
		
		out.println("title :"+title);
		out.println("writer :"+writer);
		out.println("publisher :"+publisher);
		out.println("price :"+price);
		out.println("stock :"+stock);
		out.println("remarks :"+remarks);

	}
}

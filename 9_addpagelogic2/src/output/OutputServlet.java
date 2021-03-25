package output;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/kadai9/sts"})
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
	    boolean  stock = request.getParameter("stock").equals("1");
		String remarks=request.getParameter("remarks");
		
		String[] checkedchecked = {"","","","",""};
		
		int priceint ;
		
		int cnt = 0;	
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
			out.print("�W�����������I���ł�");
		}else {
			for(String s : genre) {
				checkedchecked[Integer.parseInt(s)] = "checked";
			}
		}
		

		
		
		out.println("<html>");
		out.println("<head>");
		out.println("  <title>���Гo�^�m�F���</title>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("  <h2>�����Ѝ݌ɊǗ��V�X�e��</h2>");
		out.println("    <h3>�@�y���Гo�^�m�F��ʁz</h3>");
		out.println("    <form action=\"http://localhost:8080/9_addpagelogic2/pages/greeting-in.jsp\">");
		out.println("      <table>");
		out.println("        <tr><td>�@�@</td><td>�^�C�g��</td><td><input type=\"text\" name=\"title\" disabled=\"disabled\" value=\""+ title +"\" /></td></tr>");
		out.println("        <tr><td></td><td>����</td><td><input type=\"text\" name=\"writer\" disabled=\"disabled\" value=\""+writer+"\"/></td></tr>");
		out.println("        <tr><td></td><td>�o�Ŏ�</td><td><input type=\"text\" name=\"publisher\" disabled=\"disabled\" value=\""+publisher+"\"/></td></tr>");
		out.println("        <tr><td></td><td>���i</td><td><input type=\"text\" name=\"price\" disabled=\"disabled\" value=\""+price+"\"/></td></tr>");
		out.println("        <tr><td></td><td>�W������</td><td>");
		out.println("          <input type=\"checkbox\" name=\"genre\" value=\"0\" disabled=\"disabled\" " + checkedchecked[0] + "/>���|");
		out.println("          <input type=\"checkbox\" name=\"genre\" value=\"1\" disabled=\"disabled\" " + checkedchecked[1] + "/>���p");
		out.println("          <input type=\"checkbox\" name=\"genre\" value=\"2\" disabled=\"disabled\" " + checkedchecked[2] + "/>�r�W�l�X");
		out.println("          <input type=\"checkbox\" name=\"genre\" value=\"3\" disabled=\"disabled\" " + checkedchecked[3] + "/>���{");
		out.println("          <input type=\"checkbox\" name=\"genre\" value=\"4\" disabled=\"disabled\" " + checkedchecked[4] + "/>�</td></tr>");
				
		
	    out.println("        <tr><td></td><td>�݌�</td><td>");

	    out.print("          <input type=\"radio\" name=\"stock\" value=\"1\"  disabled=\"disabled\" ");
		   if(stock == true) {
			   out.println(" checked ");
		   }
	    out.println("/>����");
	    out.println("          <input type=\"radio\" name=\"stock\" value=\"0\" disabled=\"disabled\" ");
	    if(stock == false) {
			   out.println(" checked ");
	    }
	    out.println("/>�Ȃ�</td></tr>");

	    out.println("        <tr><td></td><td>���l</td><td><textarea name=\"remarks\" cols=\"40\" rows=\"4\" disabled=\"disabled\" >"+remarks+"</textarea></td></tr>");
	    out.println("        <tr><td></td><td height=\"30\"></td><td></td></tr>");
	    out.println("        <tr><td></td><td></td><td align=\"right\">");
	    out.println("          <input type=\"submit\" value=\"�L�����Z��\" />");
		out.println("      </table>");
		out.println("    </form>");
		out.println("</body>");
		out.println("</html>");

		

	}
}







package Output;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Bean.BookBean;
import java.util.Arrays;
import java.util.List;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/kadai13/sts"})
public class OutputServlet extends HttpServlet {

	public void doGet(HttpServletRequest request,
				HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
	
		HttpSession sessoin = request.getSession();
		
		PrintWriter out = response.getWriter();
		//beanクラスのオブジェクト生成
		BookBean bbean = new BookBean();
		
		bbean.setTitle(request.getParameter("title"));
		bbean.setWritter(request.getParameter("writer"));
		bbean.setPublisher(request.getParameter("publisher"));
		bbean.setPrice(request.getParameter("price"));
		bbean.setStock(request.getParameter("stock").equals("1"));
		bbean.setRemarks(request.getParameter("remarks")	);
		List<String> genres = Arrays.asList("-1");
		try {
			 genres=Arrays.asList(request.getParameterValues("genre"));
		}catch(NullPointerException e) {
			
		}

		String[] checkedchecked = {"","","","",""};
		validate.Validator validator = new validate.Validator();

		int genre_cnt = 0;
		int cnt = 0;
		
		
		if(genres == null) 
		{
			cnt = -1;
		}
		else {
			try {
				cnt = Integer.parseInt(genres.get(0));
			}catch(NullPointerException e) {
				cnt = -1;
			}
		}
		if (cnt != -1) {
			for(int i = 0; i < genres.size(); i++) {
			checkedchecked[Integer.parseInt(genres.get(i))] = "checked";
			}
			genre_cnt = genres.size();
		}
		bbean.setGenreList(Arrays.asList(checkedchecked));
		
		
		
		boolean resultCheck = validator.requireCheck(bbean.getTitle(), bbean.getWritter(), bbean.getPrice(), genre_cnt);
		System.out.print(resultCheck);	
		
		sessoin.setAttribute("bookdata", bbean);
		
		if (resultCheck == false) {
			bbean.setErrorMsg(validator.errorsResult());
			request.getRequestDispatcher("/greeting-in.jsp").forward(request,response);
		}
		request.getRequestDispatcher("/greetingreturn.jsp").forward(request,response);


//		if  (resultCheck == false) {
//			out.println("<p>");
//			String errorsresult = validator.errorsResult();
//			out.println(errorsresult);	
//			out.println("</p>");
//		}else {
//			
//
//		out.println("<html>");
//		out.println("<head>");
//		out.println("  <title>書籍登録確認画面</title>");
//		out.println("</head>");
//		out.println("<body>");
//		
//		out.println("  <h2>■書籍在庫管理システム</h2>");
//		out.println("    <h3>　【書籍登録確認画面】</h3>");
//		
//		out.println("    <form action=\"http://localhost:8080/11_dispatch/greeting-in.jsp\">");
//		out.println("      <table>");
//		out.println("        <tr><td>　　</td><td>タイトル</td><td><input type=\"text\" name=\"title\" disabled=\"disabled\" value=\""+ title +"\" /></td></tr>");
//		out.println("        <tr><td></td><td>著者</td><td><input type=\"text\" name=\"writer\" disabled=\"disabled\" value=\""+writer+"\"/></td></tr>");
//		out.println("        <tr><td></td><td>出版社</td><td><input type=\"text\" name=\"publisher\" disabled=\"disabled\" value=\""+publisher+"\"/></td></tr>");
//		out.println("        <tr><td></td><td>価格</td><td><input type=\"text\" name=\"price\" disabled=\"disabled\" value=\""+price+"\"/></td></tr>");
//		out.println("        <tr><td></td><td>ジャンル</td><td>");
//		out.println("          <input type=\"checkbox\" name=\"genre\" value=\"0\" disabled=\"disabled\" " + checkedchecked[0] + "/>文芸");
//		out.println("          <input type=\"checkbox\" name=\"genre\" value=\"1\" disabled=\"disabled\" " + checkedchecked[1] + "/>実用");
//		out.println("          <input type=\"checkbox\" name=\"genre\" value=\"2\" disabled=\"disabled\" " + checkedchecked[2] + "/>ビジネス");
//		out.println("          <input type=\"checkbox\" name=\"genre\" value=\"3\" disabled=\"disabled\" " + checkedchecked[3] + "/>教養");
//		out.println("          <input type=\"checkbox\" name=\"genre\" value=\"4\" disabled=\"disabled\" " + checkedchecked[4] + "/>趣味</td></tr>");
//		
//	    out.println("        <tr><td></td><td>在庫</td><td>");
//
//	    out.print("          <input type=\"radio\" name=\"stock\" value=\"1\"  disabled=\"disabled\" ");
//		   if(stock) {
//			   out.println(" checked ");
//		   }
//	    out.println("/>あり");
//	    
//	    out.println("          <input type=\"radio\" name=\"stock\" value=\"0\" disabled=\"disabled\" ");
//	    if(stock == false) {
//			   out.println(" checked ");
//	    }
//	    out.println("/>なし</td></tr>");
//
//	    out.println("        <tr><td></td><td>備考</td><td><textarea name=\"remarks\" cols=\"40\" rows=\"4\" disabled=\"disabled\" >"+remarks+"</textarea></td></tr>");
//	    out.println("        <tr><td></td><td height=\"30\"></td><td></td></tr>");
//	    out.println("        <tr><td></td><td></td><td align=\"right\">");
//	    out.println("          <input type=\"submit\" value=\"キャンセル\" />");
//		out.println("      </table>");
//		out.println("    </form>");
//		out.println("</body>");
//		out.println("</html>");	
//
//	}
	}
}
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

@WebServlet(urlPatterns={"/kadai11/sts"})
public class OutputServlet extends HttpServlet {

	public void doGet(HttpServletRequest request,
				HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
	
		PrintWriter out = response.getWriter();
		//beanクラスのオブジェクト生成
		BookBean bbean = new BookBean();
		
		HttpSession sessoin = request.getSession();
		
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



	}
}
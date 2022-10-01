package ddit.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirectTest.do")
public class RedirectTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String userName = request.getParameter("username");
		
//		String tel = (String)request.getAttribute("tel");	//주소 뒤에 붙여서 오는건 parameter로 받아야 됨
		String tel = request.getParameter("tel");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf-8'><title>sendRedirect방식 연습</title></head>");
		out.println("<body>");
		
		out.println("<h3>sendRedirect 결과</h3>");
		out.println("<ul>");
		out.println("<li>이 름 : " + userName + "</li>");
		out.println("<li>전 화 : " + tel + "</li>");
		out.println("</ul>");
		
		out.println("</body>");
		out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

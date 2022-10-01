package ddit.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/requestTest02.do")
public class RequestTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String operator = request.getParameter("operator");
		double res = 0;
		switch(operator) {
		case "+" :
			res = num1+num2;
			break;
		case "-" :
			res = num1-num2;
			break;
		case "*" :
			res = num1*num2;
			break;
		case "/" :
			res = (double)num1/num2;
			break;
		case "%" :
			res = num1%num2;
			break;
		}
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf-8'><title>계산결과</title>");
		out.println("<style>h2{border : 1px solid black;" + 
				"	border-left: none;" + 
				"	border-right: none;" + 
				"	padding : 20px;}</style></head>");
		out.println("<body>");
		out.println("<h2>계산결과</h2>");
//		out.printf("%d %s %d = .2%f<br>", num1, operator, num2, res);
		out.println(num1 + " " + operator + " " + num2 +" = "+res);
		out.println("</body></html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package ddit.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieDelete.do")
public class CookieDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 저장된 쿠키 삭제하기
		// ==> 삭제하고자 하는 쿠키를 먼저 읽어온 후 해당 쿠키의 유지시간을 0으로 설정한 후 다시 저장한다.
		// 	   유지시간 설정 : 쿠키변수.setMaxAge(유지시간)
		Cookie[] cookieArr = request.getCookies();
		
		out.println("<html><head><meta charset='utf-8'><title>Cookie 정보 삭제</title></head>");
		out.println("<body>");
		
		out.println("<h3>저장된 Cookie 정보 삭제하기</h3>");
		
		if(cookieArr==null||cookieArr.length==0) {
			out.println("<h3> 저장된 쿠키가 하나도 없습니다.</h3>");
		}
		
		for(Cookie cookie : cookieArr) {
			String name = cookie.getName();		// '쿠키 key값' 구하기
			
			// 삭제를 원하는 쿠키인지 검사(예 : gender 삭제하기)
			if("gender".equals(name)) {
				// 찾은 쿠키의 유지시간을 0으로 설정
				cookie.setMaxAge(0);
				
				// 해당 쿠키를 다시 저장한다.
				response.addCookie(cookie);
			}
		}
		
		out.println("<a href='"+request.getContextPath()+"/ddit/cookie/cookieTest.jsp'>시작문서로가기</a>");
		out.println("</body></html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package ddit.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieRead.do")
public class CookieRead extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		// 저장된 쿠키정보 읽어오기
		// 1. 저장된 전체 쿠키 정보를 Request객체를 통해서 가져온다. ==> 가져온 쿠키정보들은 배열형태로 반환한다.
		// 형식) Cookie[] 쿠키배열변수 = request객체변수.getCookies();
		Cookie[] cookieArr = request.getCookies();
		
		out.println("<html><head><meta charset='utf-8'><title>Cookie 정보 읽기</title></head>");
		out.println("<body>");
		
		out.println("<h3>저장된 Cookie 정보 확인하기</h3>");
		
		if(cookieArr==null||cookieArr.length==0) {
			out.println("<h3> 저장된 쿠키가 하나도 없습니다.</h3>");
		}
		
		// 2. 쿠키 배열에서 쿠키 정보를 구해온다.
		for(Cookie cookie : cookieArr) {
			String name = cookie.getName();		// '쿠키 key값' 구하기
			
			// 한글로 저장된 vlaue값을 가져올 때는 디코딩해서 가져온다.
//			String value = cookie.getValue(); 	// '쿠키 value값' 구하기
			String value = URLDecoder.decode(cookie.getValue(), "utf-8");
			
			out.println("쿠키 key값 : "+name+"<br>");
			out.println("쿠키 value값 : " + value + "<br>");
		}
		out.println("<a href='"+request.getContextPath()+"/ddit/cookie/cookieTest.jsp'>시작문서로가기</a>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

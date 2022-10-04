package ddit.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieLoginServlet.do")
public class CookieLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		// id, password, checkbox값 구하기
		String  userid = request.getParameter("userid");
		String pass = request.getParameter("pass");
		
		String chkid = request.getParameter("chkid");
		
		// 우선 Cookie객체 생성
		Cookie loginCookie = new Cookie("USERID", userid);
		
		// Checkbox는 chkck된 것만 전송된다.
		if(chkid!=null) {	// 체크박스가 체크 되었을 때
			// 쿠키 저장하기
			response.addCookie(loginCookie);
		}else {	// 체크박스의 체크가 해제되었을 때
			// 쿠키 삭제하기
			loginCookie.setMaxAge(0);
			response.addCookie(loginCookie);
		}
		
		if("test".equals(userid) && "1234".equals(pass)) {	// 로그인 성공
			response.sendRedirect(request.getContextPath()+"/ddit/cookie/cookiemain.jsp");
		}else {
			response.sendRedirect(request.getContextPath()+"/ddit/cookie/cookieLogin.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package ddit.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ddit.vo.MemberVO;

@WebServlet("/dbsessionLogin.do")
public class DbsessionLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 전송되어 온 파라미터를 읽는다. (회원 ID, 패스워드)
		String userId = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		// 읽어온 정보를 VO객체에 저장
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(userId);
		memVo.setMem_pass(pass);
		
		// Dao객체 생성 (Service 객체가 없어서 Dao객체를 직접 생성)
		MemberDao dao = MemberDao.getInstance();
		
		// 세션 객체 생성
		HttpSession session = request.getSession();
		
		// DB에서 회원ID와 pass가 일치하는 회원정보 검색
		MemberVO loginMemVo = dao.getMember(memVo);
		
		// 로그인 성공 여부 판단
		if(loginMemVo!=null) {	// 로그인 성공
			session.setAttribute("loginMember", loginMemVo);
		}
		
		response.sendRedirect(request.getContextPath() + "/ddit/session/db_sessionLogin.jsp");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

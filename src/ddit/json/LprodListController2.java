package ddit.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ddit.vo.LprodVO;

@WebServlet("/lprodListController2.do")
public class LprodListController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		LprodDao dao = LprodDao.getInstance();	// DAO객체 생성
		
		List<LprodVO> lprodList = dao.getAllLprod();	// DB에서 자료 가져오기
		
		request.setAttribute("lprodList", lprodList);	// 자료를 Request 객체에 셋팅한다.
		
		// forward방식으로 View로 이동한다.
		RequestDispatcher rd = request.getRequestDispatcher("/ddit/json/lprodList.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

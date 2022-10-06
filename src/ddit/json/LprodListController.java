package ddit.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ddit.vo.LprodVO;

@WebServlet("/lprodListController.do")
public class LprodListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		LprodDao dao = LprodDao.getInstance();	// DAO객체 생성
		
		Gson gson = new Gson();	// Gson객체 생성
		List<LprodVO> lprodList = dao.getAllLprod();	// DB에서 자료 가져오기
		
		String jsonData = gson.toJson(lprodList);
		
//		System.out.println(jsonData);
		
		PrintWriter out = response.getWriter();
		
		out.print(jsonData);
		
		response.flushBuffer();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

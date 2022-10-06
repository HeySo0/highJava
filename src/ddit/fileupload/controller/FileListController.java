package ddit.fileupload.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddit.fileupload.service.FileInfoServiceImpl;
import ddit.fileupload.service.IFileInfoService;
import ddit.vo.FileInfoVO;

@WebServlet("/fileList.do")
public class FileListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DB에서 파일 정보를 List로 가져와 View로 보내는 Servlet
		
		// Service 객체 생성
		IFileInfoService service = FileInfoServiceImpl.getInstance();
		
		// DB에서 파일 목록을 가져와 List에 담는다.
		List<FileInfoVO> fileinfoList = service.getAllFileInfo();
		
		// 가져온 파일 목록을 Request객체에 저장한다.
		request.setAttribute("fileinfoList", fileinfoList);
		
		// View 페이지로 forwarding한다.
		request.getRequestDispatcher("/ddit/fileupload/fileList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

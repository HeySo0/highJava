package ddit.fileupload.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import ddit.vo.FileInfoVO;

/*
	- 서블릿 3.0 이상에서 파일 업로드를 하려면 서블릿에 @MultipartConfig애노테이션을 설정해야 한다.
	
	- @MultipartConfig애노테이션의 설정 변수들...
	1) location         : 업로드한 파일이 임시적으로 저장될 경로 지정(기본값 : "")
	2) fleSizeThreshold : 이 속성에 설정한 값보다 큰 파일이 전송되면 location에 지정한 임시 경로를 사용한다.
				  (단위 : byte, 기본값 : 0 (무조건 임시 디렉토리를 사용한다.))
	3) maxFileSize      : 1개의 파일의 최대 크기 (단위 : byte, 기본값 : -1L(무제한))
	4) maxRequestSize   : 서버로 전송되는 전체 Request객체의 최대 크기(모든 파일 크기 + formData)
				  (단위 : byte, 기본값 : -1L (무제한))
	 * */

@WebServlet("/fileUpload.do")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 30,
		maxRequestSize = 1024 * 1024 * 100
		// 10Mbyte, 30Mbyte, 100Mbyte
)
public class FileUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET방식으로 요청하면 file을 업로드할 Form문서로 포워딩한다.
		request.getRequestDispatcher("/ddit/fileupload/fileUploadForm.jsp").forward(request, response);;
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST방식으로 요청하면 업로드된 file을 처리한 후 파일 목록 페이지로 redirect한다.
		request.setCharacterEncoding("utf-8");
		
		// 업로드 된 파일들이 저장될 폴더 설정
		String uploadPath = "d:/d_other/uploadFiles";
		
		// 저장될 폴더가 없으면 새로 만든다.
		File file = new File(uploadPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		// 파일이 아닌 일반 데이터는 getParameter()메서드나 getParameterValues()메서드를 이용해서 구한다.
		String userName = request.getParameter("username");
		
		//-----------------------------------------------------------------------------------------------
		
		// 수신 받은 파일 데이터 처리하기
		String fileName = "";	// 원래의 파일명이 저장될 변수 선언
		
		// Upload한 파일의 목록을 저장할 List객체 생성
		List<FileInfoVO> fileinfoList = new ArrayList<FileInfoVO>();
		
		/*
			서블릿 3.0에서 UPLOAD와 관련하여 새롭게 추가된 객체 ==> Part객체
		- Part객체 구하기
		1) request객체.getParts() ==> 전체 Part객체를 Collection객체에 담아서 반환한다.
		2) request객체.getPart("part이름") ==> 지정된 'part이름'을 가진 개별 Part객체를 반환한다.
			'part'이름 ==> form태그 안의 입력요소의 name속성값으로 구별한다.
		 */
		
		// 전체 Part객체 개수만큼 반복처리
		for(Part part : request.getParts()) {
			fileName = extractFileName(part);	//파일명 구하기
		}
		
	}// doPost 메서드 끝
	
	
	//---------------------------------------------------------------------------------------------------
	/*
	- Part 구조
	1) 파일이 아닌 일반 데이터일 경우
	-------------------------13423i235hihl2i1366643477 ==> Part를 구분하는 구분선
	content-disposition : form-data; name="username"   ==> 파라미터명
													   ==> 빈줄
	홍길동											   ==> 파라미터 값
	-------------------------13423i235hihl2i1366643wea ==> Part를 구분하는 구분선
					:
					:
	 */
	
	/*
	2) 파일일 경우
	-------------------------13423i235hihl2i1366643we  						==> Part를 구분하는 구분선
	content-disposition : form-data; name="upFile1"; filename="test1.txt"	==> 파일 정보
	content-type : text/plain						   						==> 파일의 종류
													   						==> 빈줄
	abcd1234안녕하세요								   						==> 파일 내용

	 */
	//---------------------------------------------------------------------------------------------------
	
	
	// Part구조 안에서 파일명을 찾는 메서드
	private String extractFileName(Part part) {
		String fileName = "";
		String content = part.getHeader("content-disposition");
		String[] items = content.split(";");
		for(String item : items) {
			if(item.trim().startsWith("filename")) {	// Part가 파일인지 검사
				fileName = item.substring(item.indexOf("=")+2, item.length()-1);
			}
		}
		
		
		return fileName;
	}

}










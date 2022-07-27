package com.board.controller.action;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDAO;
import com.board.dto.BoardVO;

//myAction 인터페이스 상속받음 				뷰 : jsp형태의 파일을 만들것
public class BoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException, ServletException {

		String url = "/board/boardList.jsp";
		
		BoardDAO bDao = BoardDAO.getInstance();
//		List<BoardVO> boadList = bDao.selectAllBoards();
		
		
		//Page Start
		int page = 1;								//기본은 1페이지
		int limit = 10;								//페이지당 레코드 10개씩 보일 예정 
		int listCount = bDao.getListCount();		//전체 글의 개수 / limit 으로[1][2]...구현
		int maxpage = (int)((double)listCount/limit + 0.95);
		if(request.getParameter("page") != null) {	//페이지 정보를 넘겨받으면 해당정보 아니면 1페이지
			
			page = Integer.parseInt(request.getParameter("page"));
			
		}
		int num_start = page - 3;
		int num_end = page + 3;
		
		if(num_start < 1) {
			num_start = 1;
		}
		if(num_end > maxpage) {
			num_end = maxpage;
		}
		
		request.setAttribute("start", num_start);
		request.setAttribute("end", num_end);
		request.setAttribute("maxpage", maxpage);
//		System.out.println("끝페이지"+num_end);
		
		List<String> p_list = new ArrayList<String>();

		
		
		
		
		List<BoardVO> boadList = bDao.getBoardList(page, limit);
		bDao.getBoardList(page, limit);				//페이지 정보에 해당하는 10개 레코드 조회, 반환
		request.setAttribute("boardList", boadList);

		
		
		
//		System.out.println("전체페이지"+maxpage);
		
		
		

		for(int i = 0; i < maxpage ; i++) {
			p_list.add(String.valueOf(i+1));
//			p_list.add(String.valueOf("아무말"));
			
		}
//		System.out.println(p_list);
		request.setAttribute("list", p_list);
		request.setAttribute("page", page);
		
		//Page End
		RequestDispatcher dispatcher  = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
	}

}

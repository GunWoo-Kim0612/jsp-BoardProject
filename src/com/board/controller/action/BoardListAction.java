package com.board.controller.action;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

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
		List<BoardVO> boadList = bDao.selectAllBoards();
		
		
		request.setAttribute("boardList", boadList);
		
		
		RequestDispatcher dispatcher  = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
	}

}

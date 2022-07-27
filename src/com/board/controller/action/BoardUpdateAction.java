package com.board.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDAO;
import com.board.dto.BoardVO;

public class BoardUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		??이걸 여기 왜넣었음?
//		String url = "/board/checkPass.jsp";

		
		BoardVO mVo = new BoardVO();
		
		mVo.setNum( Integer.parseInt(request.getParameter("num")));
		mVo.setName( request.getParameter("name"));
		mVo.setPass( request.getParameter("pass"));
		mVo.setEmail( request.getParameter("email"));
		mVo.setTitle( request.getParameter("title"));
		mVo.setContent( request.getParameter("content"));
		
		BoardDAO mDao = BoardDAO.getInstance();
		
		mDao.updateBoard(mVo);
		
		
		new BoardListAction().execute(request, response);
//		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
//		dispatcher.forward(request, response);

	}

}

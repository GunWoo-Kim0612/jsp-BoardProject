package com.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDAO;
import com.board.dto.BoardVO;

public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		BoardVO bVo = new BoardVO();
		
		bVo.setName(request.getParameter("name"));
		bVo.setPass(request.getParameter("pass"));
		bVo.setEmail(request.getParameter("email"));
		bVo.setTitle(request.getParameter("title"));
		bVo.setContent(request.getParameter("content"));

		BoardDAO bDao = BoardDAO.getInstance();
		
		bDao.insertBoard(bVo);
		
//		BoadServlet 재실행 대신 coomand 는 board_list로 바뀐채로.. 결국 list액션이 수행됨
//		new BoardListAction().execute(request, response);
		
		
//		위의경우에 Boardservlet 새로고침마다 해당 command의 action이 계속 수행됨 (Write) 
//		따라서 list command로 바꿔주면 해결된다
		
		
		
		response.sendRedirect("BoardServlet?command=board_list");
	}

}

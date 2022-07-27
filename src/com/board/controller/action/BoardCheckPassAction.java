package com.board.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDAO;
import com.board.dto.BoardVO;

public class BoardCheckPassAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//비밀번호 대조 action

		String url = null;
		
		//hidden type 정보get
		String num = request.getParameter("num");			
		String pass = request.getParameter("pass");			
		
		
		BoardDAO bDao = BoardDAO.getInstance();
		
		BoardVO bVo = bDao.selectOneBoardByNum(num);				//해당 개시글의 PK인 num으로 정보 조회
		
		if(bVo.getPass().equals(pass)) {							//DB pass 와  입력받은 pass비교
			url = "/board/checkSueccess.jsp";						//성공> 
		} else {
			url = "/board/checkPass.jsp";							//실패> 메세지와 함께 현재페이지로...
			request.setAttribute("message", "비밀번호가 틀렸습니다.");
		}
		
		
		//이동
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}

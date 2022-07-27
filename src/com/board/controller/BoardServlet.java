package com.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.controller.action.Action;

@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardServlet() {
        super();
        
    }


    //프톤트 컨트롤러
    //command를 통해 액션 팩토리에 어떤 객체를 생성할지 요청받고
    //싱글톤 패턴 클래스인 AactionFactory를 통해 요청에 따른 Action객체를 생성
    //execute > 실행 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String command  = request.getParameter("command");				//커맨드 패턴  쿼리스트링으로 정보를 전달하는 방식   BoardServlet?command=board_list
		System.out.println("BoardServlet에서 요청 받음 " + command);
		
		
		ActionFactory af = ActionFactory.getInstance();					//요청에 해당하는 Action객체를 생성하기 위해 **팩토리** 역할을 수행하는 ActionFactory 객체 생성
		Action action = af.getAction(command);							//action객체 생성(요청에따른)
																		//각기다른 형태의 자식 타입들은  Action 타입으로 받아줌(다형성에 의해 부모클래스인 action타입으로 받을 수 있다)
		
		if(action != null) {
			action.execute(request, response);							//요청에따른 action객체 실행
		} 
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}

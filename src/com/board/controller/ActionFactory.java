package com.board.controller;

import com.board.controller.action.Action;
import com.board.controller.action.BoardListAction;
import com.board.controller.action.BoardUpdateAction;
import com.board.controller.action.BoardUpdateFormAction;
import com.board.controller.action.BoardCheckPassAction;
import com.board.controller.action.BoardCheckPassFormAction;
import com.board.controller.action.BoardDeleteAction;
import com.board.controller.action.BoardViewAction;
import com.board.controller.action.BoardWriteAction;
import com.board.controller.action.BoardWriteFormAction;

//싱글톤 패턴  1개 팩토리만 사용할 예정이기 때문에
public class ActionFactory {
	
	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory() {
		super();
	}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	
	//프론트 컨트롤러인 보더서블릿에서 넘어온 커맨드값을 가지고 어떤 액션컨트롤러를 생성해서 다시 프론트 컨트롤러로 보내줄지 결정한다.
	public Action getAction(String command) {
		Action action = null;
		
		System.out.println("ActionFactory : " + command);
		
		if(command.equals("board_list")) {
			action = new BoardListAction();
		} else if(command.equals("board_write_form")) {
			action = new BoardWriteFormAction();
		} else if (command.equals("board_write")) {
			action = new BoardWriteAction();
		} else if (command.equals("board_view")) {
			action  = new BoardViewAction();
		} else if (command.equals("board_check_pass_form")) {
			action = new BoardCheckPassFormAction();
		} else if (command.equals("board_check_pass")) {
			action = new BoardCheckPassAction();
		} else if (command.equals("board_update_form")) {
			action = new BoardUpdateFormAction();
		} else if (command.equals("board_update")) {
			action = new BoardUpdateAction();
		} else if (command.equals("board_delete_form")) {
			action = new BoardDeleteAction();
		}
			
		
		
		return action;
	}
}

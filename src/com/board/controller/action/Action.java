package com.board.controller.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//팩토리패턴  팩토리 클래스가 생성한 각각의 액션클래스에 상속될 인터페이스 
//각 액션클래스에서 메소드를 오버라이딩해 사용함
public interface Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws  IOException, ServletException;
}

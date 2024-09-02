package com.royal.controller;

import java.io.IOException;

import com.royal.controller.dao.StudentDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse respones) throws ServletException, IOException {
		int rno = Integer.parseInt(request.getParameter("rno"));
		StudentDao dao = new StudentDao();
		int rowsAffected = dao.deleteQry(rno);
		RequestDispatcher rd = null;
		if(rowsAffected >0) {
			rd = request.getRequestDispatcher("SecondServlet");	
			rd.forward(request, respones);
		}else {
			System.out.println("error");
		}
			
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

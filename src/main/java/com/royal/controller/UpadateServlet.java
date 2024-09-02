package com.royal.controller;

import java.io.IOException;

import com.royal.bean.StudentBean;
import com.royal.controller.dao.StudentDao;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpadateServlet extends HttpServlet{

		@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int id  = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("fname");
			int std = Integer.parseInt(request.getParameter("std"));
			int marks = Integer.parseInt(request.getParameter("marks"));
			
		StudentBean s = new StudentBean(name, std, marks,0);
		StudentDao dao = new StudentDao();
		int rowsAffected = dao.updateStudent(s);
		RequestDispatcher rd = null;
		if(rowsAffected > 0)
		{
			rd = request.getRequestDispatcher("SecondServlet");
			
		}else
		{
			rd = request.getRequestDispatcher("insert.html");
		}
		rd.forward(request, response);
		
	}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
		}

}

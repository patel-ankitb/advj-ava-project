package com.royal.controller;

import java.io.IOException;

import org.apache.catalina.filters.RequestDumperFilter;

import com.royal.bean.StudentBean;
import com.royal.controller.dao.StudentDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String name = req.getParameter("fname");
		int std = Integer.parseInt(req.getParameter("std"));
		int marks = Integer.parseInt(req.getParameter("marks"));
	
		System.out.println(name);
		System.out.println(std);
		System.out.println(marks);
	;
		
		StudentBean sbean = new StudentBean(name,std, marks, 0);
		StudentDao sdao = new StudentDao();
		int rowsAffected = sdao.insertQry(sbean);
		
		if(rowsAffected != 0)
		{
			System.out.println(" record stord");
		}else
		{ 
			System.out.println(" record cannot stord");
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("SecondServlet");
		rd.forward(req, resp);
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}

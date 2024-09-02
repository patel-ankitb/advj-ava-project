package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import com.royal.bean.StudentBean;
import com.royal.controller.dao.StudentDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {

protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
		StudentDao sdao = new StudentDao();
		
		ArrayList<StudentBean> list = sdao.displayAllRecord();
		
		out.print("<table border = '1'>");
		out.print("<tr>     ");
		out.print(" <td>rno</td>");
		out.print(" <td>name</td>");
		out.print(" <td>std</td>");
		out.print("<td>marks</td>");
		out.print("<td>ACTION</td>");
		out.print("</tr>");
		for(int i=0;i<list.size();i++)
		{
			StudentBean s = list.get(i);
			out.print("<tr>   " );
			out.print("<td>" + s.getRno()+"</td>");
			out.print("<td>" + s.getName()+"</td>");
			out.print("<td>" + s.getStd()+"</td>");
			out.print("<td>"+  s.getMarks()+"</td>");
			out.print(" <td><a href='EditServlet?rno="+ s.getRno()+" '>EDIT</a> | <a href='DeleteServlet?rno=" +s.getRno()+" '>DElETE</a></td>");
			out.print("</tr>");
			
		}
		out.print("</table>");
	}

}

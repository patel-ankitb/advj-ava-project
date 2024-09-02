package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.royal.bean.StudentBean;
import com.royal.controller.dao.StudentDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditServlet extends HttpServlet{

 @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 response.setContentType("text/html");
	 PrintWriter out = response.getWriter();
	 int id = Integer.parseInt(request.getParameter("id"));
	 StudentDao dao = new StudentDao();
	 StudentBean sbean = dao.getClass(id);
	 RequestDispatcher rd = null;
	 if(sbean != null)
	 {
		out.print( "<form action='FirstServlet' method='post'>");
	    out.print( " <h1>Student Registration</h1>");
	    out.print ("   <table> ");
	    out.print  ("      <tr>  ");
	    out.print ("          <td>First name: </td> ");
	    out.print ("           <td><input type='text' name='fname'></td> " );
	    out.print  ("      </tr> ");
	    out.print   ("    <tr>");
		out.print	("		<td>Std: </td> ");
		out.print	("		<td><input type='text' name='std'></td> " );
		out.print	("	</tr> ");
		out.print	("	<tr> ");
		out.print	("		<td>marks: </td>");
		out.print	("	<td><input type='text' name='marks'></td>");
		out.print	( "    </tr> ");
		out.print	(	"<tr>");
		out.print	("		<td><input type='submit'></td> " );
		out.print	("</tr> ");
		out.print	("	<tr>  ");
		out.print	("		<input type='edit'> " );
		out.print	("	</tr> ");
	    out.print   ( " </table> ");
	    out.print ("  </form> ");
	 }
	 else
	 {
		 rd = request.getRequestDispatcher("econdServlet");
	 }
	 rd.forward(request, response);
	}
 @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 doPost(request, response);
	}

}

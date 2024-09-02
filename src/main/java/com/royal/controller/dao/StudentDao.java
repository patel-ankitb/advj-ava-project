package com.royal.controller.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.royal.bean.StudentBean;
import com.royal.controller.util.DBConnection;

public class StudentDao {

	public int insertQry(StudentBean sbean) {
		String qry = "INSERT INTO Student (NAME, STD,marks) VALUES ('"+sbean.getName()+"', '"+sbean.getStd()+"','"+sbean.getMarks()+"')";
		Connection conn = DBConnection.getConnection();
		Statement stmt = null;
		int affectedRows = 0;
		
		if(conn != null) {
			try {
				stmt = conn.createStatement();
				affectedRows = stmt.executeUpdate(qry);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return affectedRows;
	}
	public int deleteQry(int rno) {
		String qry = "DELETE FROM Student WHERE rno = " + rno;
		Connection conn = DBConnection.getConnection();
		Statement stmt = null;
		int affectedRows = 0;
		
		if(conn != null) {
			try {
				stmt = conn.createStatement();
				affectedRows = stmt.executeUpdate(qry);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return affectedRows;
	}
	public int UpdateQuery(StudentBean sbean) {
		String qry = "UPDATE students SET name='"+sbean.getName()+"', std="+sbean.getStd()+" WHERE id = " + sbean.getMarks();
		Connection conn = DBConnection.getConnection();
		Statement stmt = null;
		int rows = 0;
		
		if(conn != null) {
			try {
				stmt = conn.createStatement();
				rows = stmt.executeUpdate(qry);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return rows;
	}
	
	
	
	public ArrayList<StudentBean> displayAllRecord() {
		String selectQry = "SELECT * FROM STUDENT";
		Connection conn = DBConnection.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		int rowsAffected = 0;
		ArrayList<StudentBean> list = new ArrayList<StudentBean>();
		
		StudentBean sbean = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectQry);
			
			while(rs.next()) {
				int rno = rs.getInt(1);
				String name = rs.getString(2);
				int std = rs.getInt(3);
				int marks =rs.getInt(3);
				
				sbean = new StudentBean(name,std,marks,rno);
				list.add(sbean);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

}
	public StudentBean getClass(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	public int updateStudent(StudentBean s) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}




	
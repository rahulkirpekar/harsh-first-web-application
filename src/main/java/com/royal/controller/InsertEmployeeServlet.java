package com.royal.controller;

import java.io.IOException;

import com.royal.bean.EmployeeBean;
import com.royal.dao.EmployeeDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertEmployeeServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String name = request.getParameter("name");
		String salary = request.getParameter("salary");
		String dsgn = request.getParameter("dsgn");
		String orgName = request.getParameter("orgName");
		EmployeeBean ebean = new EmployeeBean(0, name, salary, dsgn, orgName);
		EmployeeDao dao = new EmployeeDao();
		int rowsAffected = dao.insert(ebean);
		RequestDispatcher rd=  null;
	
		if(rowsAffected > 0) 
		{
			rd = request.getRequestDispatcher("ListEmployeeServlet");
		}else 
		{
			rd = request.getRequestDispatcher("registration.html");
		}
		rd.forward(request, response);
	}
}

package com.first.work.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.first.work.service.IUserService;
import com.first.work.service.impl.UserServiceImpl;
import com.first.work.utils.MysqlDemo2;

public class UserController extends HttpServlet{
	
	private static final long serialVersionUID = 2841954796650615499L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type = req.getParameter("type");
		if (type != null ) {
			if ("register".equals(type)) {
				doRegister(req, resp);
			} else if ("loggin".equals(type)) {
				doLoggin(req, resp);
			}
		}
		
	}
	

	/**
	 * 鐢ㄦ埛娉ㄥ唽
	 * @param req 璇锋眰
	 * @param resp 鐩稿簲
	 * @return 杩斿洖鍊�
	 */
	public String doRegister(HttpServletRequest req, HttpServletResponse resp) {
		String userName,userPassword,email,sql;
		
		userName = req.getParameter("userName");
		userPassword = req.getParameter("passWord");
		email = req.getParameter("email");
		
		sql="insert into student(user_name,pass_word,email) values('陶伟基','123','123@123.com')";
		Statement stmt;
		try {
			stmt = MysqlDemo2.editData(sql);	
			int result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		IUserService userService = new UserServiceImpl();
		
		return null;
		
	}


	/**
	 * 鐢ㄦ埛鐧诲綍
	 * @param req 璇锋眰
	 * @param resp 鐩稿簲
	 * @return 杩斿洖鍊�
	 */
	private void doLoggin(HttpServletRequest req, HttpServletResponse resp) {
		
	}
}

package com.first.work.utils;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
 
 
public class MysqlDemo2 {
	private static  Connection conn = null; 
	private static  String url = "";
	private static PreparedStatement stmt;
	static {
		 try {
			// 动态加载mysql驱动
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("成功加载MySQL驱动程序");
			
			url = "jdbc:mysql://localhost:3306/mysql_dev?"
	                + "user=root&password=123456&useUnicode=true&characterEncoding=UTF8";
			  // 一个Connection代表一个数据库连接
            conn = DriverManager.getConnection(url);
            // Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
            
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
    public static void main(String[] args) throws Exception {
    	
        String sql;
//        sql = "create table student4(NO char(20),name varchar(20),primary key(NO))";
        sql = "insert into student1(NO,name) values('2012002','陶伟基1')";
        PreparedStatement editData = MysqlDemo2.editData(sql);
//        int executeUpdate = editData.executeUpdate();
        boolean execute = editData.execute();
        System.err.println(execute);
//        int count = editData.executeUpdate();
//        System.err.println(count);
        // MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值
        // 避免中文乱码要指定useUnicode和characterEncoding
        // 执行数据库操作之前要在数据库管理系统上创建一个数据库，名字自己定，
        // 下面语句之前就要先创建javademo数据库
 
        try {
            // 之所以要使用下面这条语句，是因为要使用MySQL的驱动，所以我们要把它驱动起来，
            // 可以通过Class.forName把它加载进去，也可以通过初始化来驱动起来，下面三种形式都可以
           
 
          
        	 sql = "insert into student(NO,name) values('2012001','陶伟基')";
            int result = stmt.executeUpdate(sql);// executeUpdate语句会返回一个受影响的行数，如果返回-1就没有成功
            if (result != -1) {
                System.out.println("创建数据表成功");
              
                result = stmt.executeUpdate(sql);
                sql = "insert into student(NO,name) values('2012002','周小俊')";
                result = stmt.executeUpdate(sql);
                sql = "select * from student";
                ResultSet rs = stmt.executeQuery(sql);// executeQuery会返回结果的集合，否则返回空值
                System.out.println("学号\t姓名");
                while (rs.next()) {
                    System.out
                            .println(rs.getString(1) + "\t" + rs.getString(2));// 入如果返回的是int类型可以用getInt()
                }
            }
        } catch (SQLException e) {
            System.out.println("MySQL操作错误");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
 
    }
 
    public static PreparedStatement editData(String sql) throws SQLException {
    	stmt = conn.prepareStatement(sql);
    	return stmt;
    }
}
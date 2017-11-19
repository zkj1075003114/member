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
			// ��̬����mysql����
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("�ɹ�����MySQL��������");
			
			url = "jdbc:mysql://localhost:3306/mysql_dev?"
	                + "user=root&password=123456&useUnicode=true&characterEncoding=UTF8";
			  // һ��Connection����һ�����ݿ�����
            conn = DriverManager.getConnection(url);
            // Statement������кܶ෽��������executeUpdate����ʵ�ֲ��룬���º�ɾ����
            
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
    public static void main(String[] args) throws Exception {
    	
        String sql;
//        sql = "create table student4(NO char(20),name varchar(20),primary key(NO))";
        sql = "insert into student1(NO,name) values('2012002','��ΰ��1')";
        PreparedStatement editData = MysqlDemo2.editData(sql);
//        int executeUpdate = editData.executeUpdate();
        boolean execute = editData.execute();
        System.err.println(execute);
//        int count = editData.executeUpdate();
//        System.err.println(count);
        // MySQL��JDBC URL��д��ʽ��jdbc:mysql://�������ƣ����Ӷ˿�/���ݿ������?����=ֵ
        // ������������Ҫָ��useUnicode��characterEncoding
        // ִ�����ݿ����֮ǰҪ�����ݿ����ϵͳ�ϴ���һ�����ݿ⣬�����Լ�����
        // �������֮ǰ��Ҫ�ȴ���javademo���ݿ�
 
        try {
            // ֮����Ҫʹ������������䣬����ΪҪʹ��MySQL����������������Ҫ��������������
            // ����ͨ��Class.forName�������ؽ�ȥ��Ҳ����ͨ����ʼ������������������������ʽ������
           
 
          
        	 sql = "insert into student(NO,name) values('2012001','��ΰ��')";
            int result = stmt.executeUpdate(sql);// executeUpdate���᷵��һ����Ӱ����������������-1��û�гɹ�
            if (result != -1) {
                System.out.println("�������ݱ�ɹ�");
              
                result = stmt.executeUpdate(sql);
                sql = "insert into student(NO,name) values('2012002','��С��')";
                result = stmt.executeUpdate(sql);
                sql = "select * from student";
                ResultSet rs = stmt.executeQuery(sql);// executeQuery�᷵�ؽ���ļ��ϣ����򷵻ؿ�ֵ
                System.out.println("ѧ��\t����");
                while (rs.next()) {
                    System.out
                            .println(rs.getString(1) + "\t" + rs.getString(2));// ��������ص���int���Ϳ�����getInt()
                }
            }
        } catch (SQLException e) {
            System.out.println("MySQL��������");
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
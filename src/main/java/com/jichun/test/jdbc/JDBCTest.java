package com.jichun.test.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.jichun.utils.JDBCUtils;

/**
 * Date:20181217 20:45
 * 
 * @author pactera
 *
 */
public class JDBCTest {

	/**
	 * Function:JDBC进行数据库查询 Date:20181217 20:51
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Test
	public void test_select() throws ClassNotFoundException, SQLException {
		long currentTimeMillis = System.currentTimeMillis();
		String sql = "select * from emp";
		Connection conn = JDBCUtils.getConn();
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		ResultSet executeQuery = prepareStatement.executeQuery();
		while (executeQuery.next()) {
			String string = executeQuery.getString("ENAME");
			System.out.println(string);
		}
		long currentTimeMillis2 = System.currentTimeMillis();
		System.out.println(currentTimeMillis2 - currentTimeMillis);
		JDBCUtils.close(executeQuery, prepareStatement, conn);
	}

	/**
	 * Function:JDBC 插入数据
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * 
	 */
	@Test
	public void test_insert() throws ClassNotFoundException, SQLException {
		String sql = "insert into new_emp(empno,ename) values(1111,'曹操')";
		Connection conn = JDBCUtils.getConn();
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		prepareStatement.execute();
	}

	/**
	 * Function：插入数据的另外一种方式
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void test_insert2() throws ClassNotFoundException, SQLException {
		String sql = "insert into new_emp(EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO ) values(?,?,?,?,?,?,?,?)";
		Connection conn = JDBCUtils.getConn();
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		prepareStatement.setInt(1, 1112);
		prepareStatement.setString(2, "小王");
		prepareStatement.setString(3, "销售");
		prepareStatement.setInt(4, 1111);
		prepareStatement.setDate(5, new java.sql.Date(2018,11,11));
		prepareStatement.setDouble(6, 1000.23);
		prepareStatement.setDouble(7, 200);
		prepareStatement.setInt(8, 10);
		prepareStatement.execute();
	}
	
	@Test
	public void test_delete(){
		
	}
}

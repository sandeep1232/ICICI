package com.sb.ad;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class login {

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		String id=null;
		String password=null;
		int count=0;
		try {
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("enter id");
				id = sc.next();
				System.out.println("enter password");
				password=sc.next();
			}
			//convert the values
			id="'"+id+"'";
			password="'"+password+"'";
			//register the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			////established the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","system");
			//create statement
			if(con!=null)
				st=con.createStatement();
			//query
			String query="SELECT COUNT(*) FROM LOGIN WHERE ID="+id+" AND PASSWORD="+password;
			System.out.println(query);
			//execute the query
			if(st!=null)
				rs=st.executeQuery(query);
			//process the resultset
			if(rs!=null) {
				if(rs.next())
				count = rs.getInt(1);
				System.out.println(count);
                 
			}
			if(count==0) {
				System.out.println("invalid");
			
			}else {
				System.out.println("valid");
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)
					rs.close();
					}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(st!=null)
					st.close();
					}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
					}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(sc!=null)
					sc.close();
					}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}

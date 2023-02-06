package com.sb.ad;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Statement;
import java.sql.Connection;

public class assignment {

	public static void main(String[] args) {
		int empno=0;
		String ename=null;
		String job=null;
		int sal=0;
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		try {
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("enter empno");
				empno=sc.nextInt();
				System.out.println("enter ename");
				ename=sc.next();
				System.out.println("enter job");
				job=sc.next();
				System.out.println("enter sal");
				sal=sc.nextInt();
		}//if
			//convert input values required as SQL query
			ename="'"+ename+"'";
			job="'"+job+"'";
			//register jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//estalished the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","system");
			//create statemnet
			if(con!=null)
				st=con.createStatement();
			//prepare the query
			
			String query="insert into emp(empno,ename,job,sal) values("+empno+","+ename+","+job+","+sal+")";
			System.out.println(query);
			//send and execute the query to the database
			 int count = 0;
			if(st!=null)
				count=st.executeUpdate(query);
			//process the resultset
			if(count==0) {
				System.out.println("no record insert");
			}else {
				System.out.println("record inserted");
			}
          }//try
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
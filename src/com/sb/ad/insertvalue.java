//PRODUCTNO,NAME,PRICE ,QANTITY,TOTAL                                             


package com.sb.ad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class insertvalue {
	 public static void main(String[] args) {
	Scanner sc=null;
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	int productno=0;
	String name=null;
	int price=0;
	int qantity=0;
	int total=0;
	int count=0;
	try {
		sc=new Scanner(System.in);
		if(sc!=null) {
			System.out.println("enter productno");
			productno=sc.nextInt();
			System.out.println("enter name");
			name=sc.next();
			System.out.println("enter price");
			price=sc.nextInt();
			System.out.println("enter qantity");
			qantity=sc.nextInt();
			System.out.println("enter total");
			total=sc.nextInt();
       }
		////convert the name
		name="'"+name+"'";
		//register jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//established the connection
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","system");
		//create the statemnet
		if(con!=null)
			st=con.createStatement();
		//query
		String query="insert into jdbc_table values("+productno+","+name+","+price+","+qantity+","+total+")";
		System.out.println(query);
		//send and execute the query to the database
		if(st!=null)
			count=st.executeUpdate(query);
		//count=st.executeUpdate(query);
		//process the resultset
		if(count==0) {
			System.out.println("record inserted falied");
		}else {
			System.out.println("record inserted");
		}//else
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
}//class
}//main
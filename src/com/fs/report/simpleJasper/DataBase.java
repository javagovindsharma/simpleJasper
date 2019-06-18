package com.fs.report.simpleJasper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBase {

	
	  public Connection getConnection() {
		  Connection con=null;
		  try{  
		//	  Class.forName("com.mysql.jdbc.Driver");  
			  Class.forName("com.mysql.cj.jdbc.Driver");
			   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","root");  
		  }catch (Exception e) {
		     e.printStackTrace();
		  }
		  
		  return con;
	  }
	  
	  
	  
	  
	  
	  
	  public List<Empoloye> getEmployee(){
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
				
		  List<Empoloye> empList=new ArrayList<Empoloye>();
		  
		     try {
		    	String SQL="SELECT * FROM employees"; 
		    	con=new DataBase().getConnection();
		    	st=con.createStatement();
		    	rs=st.executeQuery(SQL);
		    	
		    	while(rs.next()) {
		    		Empoloye emp=new Empoloye();
		    		         emp.setEmail(rs.getString("email"));
		    		         emp.setEmployeeNumber(rs.getString("employeeNumber"));
		    		         emp.setExtension(rs.getString("extension"));
		    		         emp.setFirstName(rs.getString("firstName"));
		    		         emp.setJobTitle(rs.getString("jobTitle"));
		    		         emp.setLastName(rs.getString("lastName"));
		    		         emp.setOfficeCode(rs.getString("officeCode"));
		    		         emp.setReportsTo(rs.getString("reportsTo"));
		    		      empList.add(emp);   
		    	}
		    	
		     }catch (Exception e) {
				e.printStackTrace();
				
			}finally {
			   try {	rs.close(); st.close(); con.close();}catch(Exception e) {}
			}
				  
				  
		  return empList;
	  }
	  
}

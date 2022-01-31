package com.curd.curddemo;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.sql.PreparedStatement;


public class studentdata 
{
   Connection con = null;
   
   public studentdata()
   {
	   String jdbcURL = "jdbc:mysql://localhost:3306/demo1db";
       String dbUser = "root";
       String dbPassword = "root";

       try 
       {
    	   Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
       }
        catch(Exception e)
       {
        	System.out.println(e);
       }
    }
   
   //select all student details
   public  List<Student> getstudent()
   {
	   List<Student> student = new ArrayList<>();
	   String sql = "select * from student";
	   try
	   {
		   Statement st = con.createStatement();
		   ResultSet rs = st.executeQuery(sql);
		   
		   while(rs.next())
		   {
			   Student s  = new Student();
			   s.setId(rs.getInt(1));
			   s.setFirst_name(rs.getString(2));
			   s.setLast_name(rs.getString(3));
			   s.setEmail(rs.getString(4));
		      
			   student.add(s);
		   }
	   }
	   catch(Exception e)
	   {
		   System.out.println(e);
	   }
	   return student;
   }
   
	
   // select students by id
   public Student getStudent(int id)
   {
	 String sql= "select * from student where id"+id;
	 Student s = new Student();
	 try
	 {
		  Statement st = con.createStatement();
		  ResultSet rs = st.executeQuery(sql);
		  if(rs.next())
		  {
			   s.setId(rs.getInt(1));
			   s.setFirst_name(rs.getString(2));
			   s.setLast_name(rs.getString(3));
			   s.setEmail(rs.getString(4));
		  }
		}
	 catch(Exception e)
	 {
		 System.out.println(e);
	 }
	 return s;
   }
   
   //insert into student details
   public void create(Student s1)
   {
	   String sql="insert into student values(?,?,?,?)";
	   try
	   {
		   PreparedStatement st = con.prepareStatement(sql);
		   st.setInt(1, s1.getId());
		   st.setString(2, s1.getFirst_name());
		   st.setString(3, s1.getLast_name());
		   st.setString(4, s1.getEmail());
		   st.executeUpdate();
	   }
	   catch(Exception e)
	   {
		   System.out.println(e);
	   }
	   
   }
	   //update data
	   public void update(Student s1)
	   {
		   String sql = "update student set first_name?, last_name=?, email=? where id=?";
		   try
		   {
			   PreparedStatement st = con.prepareStatement(sql);
			   st.setInt(1, s1.getId());
			   st.setString(2, s1.getFirst_name());
			   st.setString(3, s1.getLast_name());
			   st.setString(4, s1.getEmail());
			   st.executeUpdate();
		   }
		   catch(Exception e)
		   {
			   System.out.println(e);
		   }
	   }

	   //delete data
	   public void delete(int id)
	   {
		   String sql="delete  from student where id=?";
		   try
		   {
			   PreparedStatement st = con.prepareStatement(sql);
               st.setInt(1, id);
               st.executeUpdate();
		   }
		   catch(Exception e)
		   {
			   System.out.println(e);
		   }
	   }
}


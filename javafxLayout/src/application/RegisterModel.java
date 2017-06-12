package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegisterModel {
	
	Connection connection;
	PreparedStatement ps = null;
	ResultSet rs=null;
	
	public RegisterModel(){
		connection=SqliteConnection.ConnectionArea();
		if(connection==null)System.exit(1);
	}
	
	public Boolean isDBConnected(){
		try {
			return !connection.isClosed();
		} catch (SQLException e) {
			return false;
		}
		
	}
	
	public Boolean isLogin(String txtemail,String txtpassword){
		
		String query="select * from Register where emailaddress = ? and password = ?";
		
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, txtemail);
			ps.setString(2, txtpassword);
			
			rs=ps.executeQuery();
			if(rs.next()){
				return true;
			}
			else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		finally{
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
	
	public Boolean Register(String name,String emailaddress,String password,String dob,String city){
		
		String query="insert into Register(name,emailaddress,password,dob,city) values(?,?,?,?,?)";
		
		try {
			ps=connection.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, emailaddress);
			ps.setString(3, password);
			ps.setString(4, dob);
			ps.setString(5, city);
			
			int confirmInsert=ps.executeUpdate();
			if(confirmInsert>=1){
				return true;
			}
			else{
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		finally{
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
	
	public List<String> DisplayCity(){
		System.out.println("inside DisplayCity");
		String query ="select * from citylist";
		List<String> citylist = new ArrayList<String>();
		try {
			ps=connection.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()){
				String name=rs.getString("citynames");
				citylist.add(name);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return citylist;
	
		
	}

}

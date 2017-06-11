package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterModel {
	
	Connection connection;	
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
		PreparedStatement ps = null;
		ResultSet rs=null;
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

}

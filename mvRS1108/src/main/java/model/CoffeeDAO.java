package model;
import java.sql.*;

public class CoffeeDAO {
	public Connection getConnection() {
		Connection cn=null;
		 try {
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Taipei","root","1234");
		 }catch(SQLException|ClassNotFoundException ex) {
			 System.out.println("SQL Error "+ex.getMessage());
		 }		
		return cn;
	}
	public int InsertCoffee(Coffee cf)
		    throws SQLException {
		    Connection con=null;
		    PreparedStatement  insert= null;
		   

		    String insertStatement =
		        "insert into classicmodels.COFFEES( COF_NAME , SUP_ID , PRICE , SALES ,TOTAL)" +
		        " values (?,?,?,?,?)";

		    try {
		         
		         con = this.getConnection();
		      
		         con.setAutoCommit(false);    
		         insert = con.prepareStatement(insertStatement);

		        //for (Map.Entry<String, Integer> e : salesForWeek.entrySet()) { }
		           insert.setString(1, cf.getCofName()); 
		           insert.setInt(2, cf.getSupId());           
		           insert.setDouble(3, cf.getPrice());
		           insert.setInt(4, cf.getSales());
		           insert.setInt(5, cf.getTotal());
		           int r=insert.executeUpdate();
		           con.commit();
		           return r;
		        
		    } catch (Exception e ) {
		        System.out.println("SQL Error:"+e.getMessage());
		        if (con != null) {
		            try {
		                System.err.print("Transaction is being rolled back");
		                con.rollback();
		            } catch(SQLException ex) {
		                System.out.println(ex.getMessage());
		            }
		        }
		    } finally {
		    	con.setAutoCommit(true);
		    	if (insert != null) {
		            insert.close();
		        }
		        if (insert != null) {
		            insert.close();
		        }
		        
		    }
		    return 0;
		}   

}

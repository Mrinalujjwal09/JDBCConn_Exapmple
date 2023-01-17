package dBcon;
import java.sql.*;


public class JDBCdemo1 {
    public static void main (String  []args){
    	try {
    		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##batch11","ujjwal");
    		Statement stm = con.createStatement();
    		ResultSet rs = stm.executeQuery("select * from customer50 ");
    		while(rs.next()) {
    			System.out.println(rs.getString(1)+"\t"+rs.getString(2)
    			+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
    		}//end of loop.
    		con.close();
    		}
			
		 catch (Exception e) { e.printStackTrace();
			// TODO: handle exception
		 }
    }
}
package dBcon;
import java.util.*;
import java.sql.*;
public class JDBCBookp {
	public static void main (String []args) {
		try {
		@SuppressWarnings("resource")
		Scanner s= new Scanner(System.in);
		System.out.println("Enter the Alphanumric Code of Book: ");
		String Code= s.nextLine();
		System.out.println("Enter the name of the Book: ");
		String Name=s.nextLine();
		System.out.println("Enter the Author of the Book: ");
		String Author=s.nextLine();
		System.out.println("Enter the Price of the Book: ");
		int price=s.nextInt();	
		System.out.println("Enter the Quantity Of Book: "); 
		int Qty=s.nextInt();
		Connection con=DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:orcl","c##batch11","ujjwal");
		Statement stm=con.createStatement();
		int n = stm.executeUpdate("insert into BookDetails50 values ('"+Code+"','"+Name+"','"+Author+"',"+price+","+Qty+")");
		if(n>0) {
			System.out.println("Bookdetails50 inserted Succesfully .......................");
		}
		} catch (Exception e) {e.printStackTrace();}
	}
}
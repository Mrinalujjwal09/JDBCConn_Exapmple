package dBcon;
import java.util.*;
import java.sql.*;
public class DBCondemo2 {
	public static void main(String[]args) {
		try {
			@SuppressWarnings("resource")
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the Alphanumric Product code :");
			String code =sc.nextLine();
			System.out.println("Enter the Product Name :");
			String name = sc.nextLine();
			System.out.println("Enter Price of the Product :");
			int Price=sc.nextInt();
			System.out.println("Enter the quantity of Product:");
			int Qty=sc.nextInt();
			Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##batch11","ujjwal");
			Statement stm= con.createStatement();
			int n= stm.executeUpdate("insert into product50 values('"+code+"','"+name+"',"+Price+","+Qty+")");
			if(n>0) {
				System.out.println("Product details inserted Successfully........................");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
package dBcon;
import java.sql.*;
import java.util.*;
public class Bookdetails {
	@SuppressWarnings("resource")

	public static void main(String[] args) {
		try {

			Scanner s= new Scanner(System.in);
			Connection con = DriverManager .getConnection
					("jdbc:oracle:thin:@localhost:1521:orcl","c##batch11","ujjwal");
			PreparedStatement ps1= con.prepareStatement("insert into bookdetails50 values(?,?,?,?,?)");
			PreparedStatement ps2= con.prepareStatement("select * from bookdetails50 ");
			PreparedStatement ps3= con.prepareStatement("select * from bookdetails50 where bookcode=?");
			PreparedStatement ps4= con.prepareStatement("update bookdetails50 set BOOKPRICE=?,BOOKQTY=? where bookcode=? ");
			PreparedStatement ps5= con.prepareStatement("delete from bookdetails50 where bookcode=?");
			while(true) {
				System.out.println("*********Choice*********");
				System.out.println("\n\t1.Add Book Details"
						+"\n\t2.View Book Details"
						+"\n\t3.View Book Code"+"\t"
						+"\n\t4.Update Book Details"
						+"\n\t5.Delete Book details"
						+"\n\t6.exit");
				System.out.println("Enter the choice:");
				int choice= Integer.parseInt(s.nextLine());
				switch (choice){
				case 1: 
					System.out.println("Enter the BookCode");
					System.out.println("Enter String value alphanumric ........");
					String Code=s.nextLine();
					System.out.println("Enter the BookName");
					String Name=s.nextLine();
					System.out.println("Enter the BookAuthor");
					String Author=s.nextLine();
					System.out.println("Enter the BookPrice");
					float Price=Float.parseFloat(s.nextLine());
					System.out.println("Enter the BookQty");
					int qty = Integer.parseInt(s.nextLine());
					//Adding data to prepareStatement Object
					ps1.setString(1, Code);
					ps1.setString(2, Name);
					ps1.setString(3, Author);
					ps1.setFloat(4, Price);
					ps1.setInt(5, qty);

					int k = ps1.executeUpdate();//Execution
					if(k>0) {
						System.out.println("Bookdetails Inserted.........");
					}
					break;
				case 2:
					ResultSet rs1 =ps2.executeQuery();//Execution to retrieve
					while(rs1.next()) {
						System.out.println(rs1.getString(1)+
								"\t"+rs1.getString(2)+
								"\t"+rs1.getString(3)+
								"\t"+rs1.getFloat(4)+
								"\t"+rs1.getInt(5));
					}//end of the loop
					break;
				case 3: System.out.println("Enter the Book Code: ");
				String bCode =s.nextLine();
				ps3.setString(1, bCode);
				ResultSet rs2=ps3.executeQuery();
				if(rs2.next()) {
					System.out.println(rs2.getString(1)+
							"\t"+rs2.getString(2)+
							"\t"+rs2.getString(3)+
							"\t"+rs2.getFloat(4)+
							"\t"+rs2.getInt(5));
				}
				else {
					System.out.println("invalid Book Code");
				}
				break;
				case 4: System.out.println("Enter the book Code:");
				String bCode2 =s.nextLine();
				ps3.setString(1, bCode2);
				ResultSet rs3 = ps3.executeQuery();
				if(rs3.next()) {
					System.out.println("Old price:"+rs3.getFloat(4));
					System.out.println("Enter newPrice:");
					float nprice=Float .parseFloat(s.nextLine());
					System.out.println("Existing qty:"+rs3.getInt(5));
					System.out.println("Enter the quantity:");
					int nQty= Integer.parseInt(s.nextLine());
					ps4.setFloat(1,nprice);
					ps4.setInt(2,nQty);
					ps4.setString(3, bCode2);
					int k1=ps4.executeUpdate();
					if(k1>0) {
						System.out.println("Book Details Updated.......");

					}

					else {
						System.out.println("Invalid book details......");
					}
					break;
				}
				case 5:
					System.out.println("Enter the BookCode");
					String bCode3 = s.nextLine();
					ps5.setString(1, bCode3);
					int k3 = ps5.executeUpdate();
					if(k3>0) {
						System.out.println("BookDetails deleted");
					}
					else {
						System.out.println("Invalid Bookcode");

						break;
					}
				case 6:
					System.out.println("Operation stopped......");
					System.exit(0);

				default:
					System.out.println("Invalid Choice...");

				}// end of switch 

			}//end of loop

		} catch (Exception e) {e.printStackTrace();}


	}

}

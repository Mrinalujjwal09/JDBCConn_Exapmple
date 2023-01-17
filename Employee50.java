package dBcon;
import java.util.*;
import java.sql.*;

public class Employee50 {

	public static void main(String[] args) {
		try {
			Scanner s=new Scanner(System.in);
			Connection con= DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:orcl","c##batch11","ujjwal");
			PreparedStatement ps1=con.prepareStatement("insert into Employee50 values(?,?,?,?,?)");
			PreparedStatement ps2=con.prepareStatement("select * from Employee50 ");
			PreparedStatement ps3=con.prepareStatement("select * from Employee50 where EmployeeId=?");
			PreparedStatement ps4=con.prepareStatement("update Employee50 set Empbasal=? where EmployeeId=?");
			PreparedStatement ps5=con.prepareStatement("Delete from Employee50 where EmployeeId=?");
			while(true)
			{
				System.out.println("*********Choice************");
				System.out.println("\n\t1.Add Employee:"+"\n\t2.View Employee:"+"\n\t3.View Employee by EmployeeId"
						+ "\n\t4.Update Employee Basic Sal:"+"\n\t5.Delete Employee by Id:");
				System.out.println("Enter Your Choice:");
				int choice = Integer.parseInt(s.nextLine());
				switch (choice) {
				case 1: 
					System.out.println("Enter the Employee Id : ");
					String EmployeeId=s.nextLine();
					System.out.println("Enter the Employee Name : ");
					String Empname=s.nextLine();
					System.out.println("Enter the Employee Designation : ");
					String Empdesg=s.nextLine();
					System.out.println("Enter the Employee Basic Salary: ");
					int Empbasal=Integer.parseInt(s.nextLine());//1000
					Float hra=(float) (Empbasal*0.93);
					Float dA=(float) (Empbasal*0.61);
					Float empTotSal=Empbasal+hra+dA;
					ps1.setString(1, EmployeeId);
					ps2.setString(2, Empname);
					ps3.setString(3, Empdesg);
					ps4.setInt(4, Empbasal);
					ps5.setFloat(5, empTotSal);
					
					int k= ps1.executeUpdate();
					if (k>0) {
						System.out.println("Employee details inserted Sucsessfully......");
					}
					break;
				case 2:
				ResultSet rs1=ps2.executeQuery();
				while(rs1.next()) {
					System.out.println("\n\t"+rs1.getString(1)+"\n\t"+rs1.getString(2)+"\n\t"+rs1.getString(3)+
							"\n\t"+rs1.getInt(4)+"\n\t"+rs1.getInt(5));
				}//end of while loop
				break;
			   case 3: System.out.println("Enter the Employee Id: ");
			          String employeeId=s.nextLine();
			          ps3.setString(1, employeeId);
			          ResultSet rs2=ps3.executeQuery();
			          if(rs2.next()) {
			        	  System.out.println("\n\t"+rs2.getString(1)+"\n\t"+rs2.getString(2)+"\n\t"+rs2.getString(3)+
			        			  "\n\t"+rs2.getInt(4)+"\n\t"+rs2.getShort(5)); 
			          }//End of loop
			          else {
						System.out.println("Invalid Entry...........");
					}
			          break;
			   case 4: System.out.println("Update Employee basic Salary: ");
			   String employeeId1=s.nextLine();
			   ps3.setString(1, employeeId1);
			   ResultSet rs3=ps3.executeQuery();
			  if (rs3.next()) {
                System.out.println("old Basic salary: "+rs3.getFloat(4));
                System.out.println("Enter Updated salary :");
				float nbasal=Float .parseFloat(s.nextLine());
				
                
			}
			   
			   
			   if (k1>0) {
				   System.out.println("Employee Salary Updated...........");
				
			}
			   
			   
			          
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}

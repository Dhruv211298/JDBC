package dhruv.ajt;
import java.sql.*;
import java.util.Scanner;
public class Demo_Prepared_Statement
{
	public static void main(String args[]) throws Exception
	{
		Scanner s=new Scanner(System.in);
		String DRIVER="com.mysql.jdbc.Driver";
		String URL="jdbc:mysql://localhost:3306/dhruv_db";
		String USERNAME="root";
		String PASSWORD="";
		String QUERY="";
		
		Class.forName(DRIVER);
		Connection con=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		System.out.println("Connection Successfully Done...");
		
		System.out.println("Press 1 for Showing All Data...");
		System.out.println("Press 2 for Inserting Data...");
		System.out.println("Press 3 for Updating Data...");
		System.out.println("Press 4 for Deleting Data...");
		
		System.out.println("Enter Your Choice:");
		int ch=s.nextInt();
		
		switch(ch)
		{
			case 1:
					QUERY="select * from emp_info";
					PreparedStatement pt=con.prepareStatement(QUERY);
					ResultSet rs=pt.executeQuery();
					String Data;
					while(rs.next())
					{
						Data=rs.getInt(1)+"|"+rs.getString(2)+"|"+rs.getString(3)+"|"+rs.getInt(4)+"|"+rs.getInt(5);
						System.out.println(Data);
					}
					break;
			case 2:
					QUERY="insert into emp_info values (?,?,?,?)";
					System.out.println("Enter The Employee Id:");
					int id=s.nextInt();
					System.out.println("Enter The Name Of Employee:");
					String name=s.nextLine();
					System.out.println("Enter The City:");
					String city=s.nextLine();
					System.out.println("Enter The Pincode Of City:");
					int pincode=s.nextInt();
					System.out.println("Enter The Employee Salary:");
					int salary=s.nextInt();
					PreparedStatement pt1=con.prepareStatement(QUERY);
					pt1.setInt(1, id);
					pt1.setString(2, name);
					pt1.setString(3, city);
					pt1.setInt(4, pincode);
					pt1.setInt(5, salary);
					System.out.println(pt1.executeUpdate()+" inserted Successfully...");
					break;
			case 3:
					QUERY="update emp_info set emp_name=? where emp_id=?";
					PreparedStatement pt2=con.prepareStatement(QUERY);
					System.out.println("Enter The Employee Id:");
					int id2=s.nextInt();
					System.out.println("Enter The Employee Name:");
					String name2=s.next();
					pt2.setString(1, name2);
					pt2.setInt(2, id2);
					System.out.println(pt2.executeUpdate()+" updated Successfully...");
					break;
			case 4:
					QUERY="delete from emp_info where emp_id=?";
					PreparedStatement pt3=con.prepareStatement(QUERY);
					System.out.println("Enter The Employee Id:");
					int id3=s.nextInt();
					pt3.setInt(1, id3);
					System.out.println(pt3.executeUpdate() +" deleted Successfully...");
					break;
			default:
					System.out.println("Enter Valid Choice...try Again...");
					break;
		}
		con.close();
	}
}

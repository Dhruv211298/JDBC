package dhruv.ajt;
import java.sql.*;
import java.util.Scanner;

public class Demo_Connection
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
		System.out.println("Driver Successfully Loaded...");
		Connection con=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		System.out.println("Connection Successfully Established...");
		Statement st=con.createStatement();
		System.out.println("Press 1 for inserting data.");
		System.out.println("Press 2 for updating data.");
		System.out.println("Press 3 for deleting data.");
		System.out.println("Press 4 for selecting data.");
		
		System.out.println("Enter Your Choice:");
		int ch=s.nextInt();
		String EmpDetail;
		switch(ch)
		{
			case 1:
					QUERY="insert into emp_info values (3,'Jay','Anand',388001,410000)";
					System.out.println(st.executeUpdate(QUERY) +" inserted successfully..");
					break;
			case 2:
					QUERY="update emp_info set emp_city='Anand' where emp_id='2'";
					System.out.println(st.executeUpdate(QUERY) +" updated successfully..");
					break;
			case 3:
					QUERY="delete from emp_info where emp_pincode='388001'";
					System.out.println(st.executeUpdate(QUERY) +" deleted successfully..");
					break;
			case 4:
					QUERY="select * from emp_info";
					ResultSet rs=st.executeQuery(QUERY);
					while(rs.next())
					{
						EmpDetail=rs.getInt(1)+"|"+rs.getString(2)+"|"+rs.getString(3)+"|"+rs.getInt(4)+"|"+rs.getInt(5);
						System.out.println(EmpDetail);
					}
					break;
		}
		con.close();
		
	}
}

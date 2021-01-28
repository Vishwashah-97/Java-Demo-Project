import java.sql.*;  
import java.util.*;
class MysqlCon{  
public static void main(String args[])
{  
	Scanner sc=new Scanner(System.in);
	int op;
	int id,price;
	String name,desc1;
	System.out.println("Which operation do u want to perform? 1. insert 2.update 3.delete");
	op=sc.nextInt();
		try{  
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/mydatabse","root","");  
				Statement stmt=con.createStatement(); 
				switch(op)
				{
					//***********Insert**********
					case 1:
						System.out.print("Enter Id which you want to insert");
						id=sc.nextInt();
						System.out.print("Enter Name which you want to insert");
						name=sc.next();
						System.out.print("Enter Price which you want to insert");
						price=sc.nextInt();
						System.out.print("Enter Description which you want to insert");
						desc1=sc.next();
						
						//String query1 = "insert into Product values (4,'MAC',500000,'OS')";
						String query1 = "insert into Product (pid,pname,pprice,pdescription)" + " values ('"+id+"','"+name+"','"+price+"','"+desc1+"')";
						System.out.println("Record is inserted in the table successfully.");
						stmt.executeUpdate(query1);
						break;
						
				//******************update*************
					case 2:

						String query2 = "update Product set pprice=90000 where pid=2";
						System.out.println("Record updated successfully.");
						stmt.executeUpdate(query2);
						break;
						
				//************Delete******************
					case 3:
						System.out.println("Enter id which you want to Delete");
						id=sc.nextInt();
						
						String query3 = "delete from Product where pid= "+id+"";
						System.out.println("Record Deleted successfully.");
						stmt.executeUpdate(query3);
						break;
						
				}
				

				//***************Select *************************
				ResultSet rs=stmt.executeQuery("select * from Product");  
				while(rs.next())  
					System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getDouble(3) +" "+rs.getString(4));  
				con.close();  
		}
		catch(Exception e){ System.out.println(e);}  
}  
}  
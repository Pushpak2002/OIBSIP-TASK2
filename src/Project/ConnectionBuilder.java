package Project;

import java.sql.*;

public class ConnectionBuilder {
	
	
	public static Connection getcon()
	{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/train", "root","@Pu201880");
			return con;
			/*Statement st = con.createStatement();
			PreparedStatement pst;
			String l = "insert into login values(3,'atharv','1234')";
			System.out.println(sql);
			st.executeUpdate(sql);
			System.out.println("Updated Successfully");*/
		}
		catch(Exception e)
		{
		//System.out.println(e);
		return null;
		}
	//}
		
}
}

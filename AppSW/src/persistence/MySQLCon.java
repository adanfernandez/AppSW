package persistence;

import java.sql.*;


public class MySQLCon {

	private Connection con;

	public Connection getConnection() {
		if (con == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba_sw?user=vmchaves&password=123456&useSSL=false");
				System.out.println(this.con.toString());
				Statement stm = con.createStatement();
				ResultSet rs = stm.executeQuery("select * from user");
				while (rs.next())
					System.out.println(rs.getString(1));

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	
	public void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

//// here sonoo is database name, root is username and password
//Statement stmt = con.createStatement();
//ResultSet rs = stmt.executeQuery("select * from emp");
//while (rs.next())
//	System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
//con.close();

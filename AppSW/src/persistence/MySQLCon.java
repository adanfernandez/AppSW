package persistence;

import java.sql.*;

import conf.Config;

public class MySQLCon {

	private Connection con;
	private Config config = Config.getInstance();

	public Connection getConnection() {
		if (con == null) {
			try {
				Class.forName(config.get("DRIVER"));
				this.con = DriverManager
						.getConnection(config.get("JDBC") + config.get("HOST") + "/" + config.get("DATABASE") + "?user="
								+ config.get("USERNAME") + "&password=" + config.get("PASSWORD") + "&allowPublicKeyRetrieval=true&useSSL=false");

//				TODO: Delete
//				Statement st = con.createStatement();
//				ResultSet rs = st.executeQuery("SELECT email FROM user");
//				while(rs.next()) {
//					System.out.println(rs.getString(1));
//				}
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

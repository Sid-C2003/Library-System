package pack4;

import pack5.Connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import pack3.Guest;
import pack2.Admin;
import java.sql.*;
import java.io.*;

class DBConnect {
	Statement s;
	Connection c;

	private final Connection con;

	public DBConnect() {
		this.con = Connect.provideConnection();
	}

	void DBinsertAdmin(String uname, String pword) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void DBinsertGuest(String uname, String pword) {
		try {

			String q = "insert into guest(username, password) values (?,?)";
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet res = pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void DBConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost/db1", "root", "1234567890"); // test1 is dbname,
																									// root is
																									// dbusername and
																									// dbpassword
			s = c.createStatement();

		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		DBConnect x = new DBConnect();
	}
}

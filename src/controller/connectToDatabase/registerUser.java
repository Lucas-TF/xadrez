package controller.connectToDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class registerUser {

    private volatile static Connection con;

    public static boolean CED(String sql) {
		boolean value = false;
		if (sql == null) {
			return value;
		}
		try {
			if(con == null || con.isClosed()){
				con = dataBaseConnect.createConnectionToMySQL();
			}
		} catch (Exception e) {
            e.printStackTrace();
        }
		try(PreparedStatement ps = con.prepareStatement(sql)){
			ps.execute();
			value = true;
		} catch (SQLException e) {
			e.printStackTrace();
			value = false;
		}
		return value;
	}
}

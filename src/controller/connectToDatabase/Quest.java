package controller.connectToDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Quest {

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
	public static String Count(String sql){
		String result = "0";
		if(sql == null){
			return result;
		}
		try {
			if(con == null || con.isClosed()) {
				con = dataBaseConnect.createConnectionToMySQL();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try(PreparedStatement ps = con.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			if (rs.next() && rs.getString(1) != null) {
				result = rs.getString(1);
				try {
					Integer.parseInt(result);
				} catch (NumberFormatException e) {
					System.out.println("count so retorna numeros verifique seu string sql");
				}
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
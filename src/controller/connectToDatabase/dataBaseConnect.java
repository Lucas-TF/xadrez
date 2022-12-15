package controller.connectToDatabase;

import java.sql.Connection;
import java.sql.DriverManager;

public class dataBaseConnect{
   
   private static final String USERNAME = "root";

   private static final String PASSWORD = "Msabor@900";
  
   private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/teste";
   /**
   * @param username
   * @param senha
   * @return 
   * @throws Exception
   */
   public static Connection createConnectionToMySQL() throws Exception{
      Class.forName("com.mysql.cj.jdbc.Driver"); 
      Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
      return connection;
   }
   public static void main(String[] args) throws Exception{
    Connection con = createConnectionToMySQL();
    if(con != null){
       System.out.println("Conectado " + con);
       con.close();
    }
    }
} 

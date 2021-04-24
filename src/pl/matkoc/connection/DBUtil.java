package pl.matkoc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    public static Connection getConnection() throws SQLException{
         return DriverManager.getConnection(
                 "jdbc:mysql://localhost:3306/programing_school?serverTimezone=UTC&useSSL=false&characterEncoding=utf8",
                 "root",
                 "coderslab");
    }
}

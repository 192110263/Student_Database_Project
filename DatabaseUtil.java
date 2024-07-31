package Student_Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseUtil {
	private static final String URL="jdbc:mysql://localhost:3306/wipro";
	private static final String USERNAME="root";
	private static final String PASSWORD="madhav.9441507591";
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(URL,USERNAME,PASSWORD);
	}
}

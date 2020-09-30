package ia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class ConnectDB {

	static Connection connection =null;		
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/logginuser","root","241099");
		PreparedStatement ps =(PreparedStatement) connection.prepareStatement("INSERT INTO `logginuser`.`students` (`idstudent`, `name`) VALUES ('111', 'MR');");
				
		if (connection !=null) {
			System.out.println("Conectat");
			
		}
		int status =ps.executeUpdate();
		if (status!=0) {
			System.out.println("S-a facut editarea in baza de date");
			}
	}
	

}

import java.sql.Connection;
import java.sql.DriverManager;

class DBCon{
	public Connection con;
	
	public DBCon() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loaded");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/simplijdbc","root","root");
	}
}
public class JDBCCode8 {
	public static void main(String[] args)throws Exception {
		DBCon dbCon = new DBCon();
		dbCon.con.createStatement();
		System.out.println("Statement created");  
		
	}

}

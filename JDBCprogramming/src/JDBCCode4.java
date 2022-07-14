import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class JDBCCode4 {
	private static Connection con;
	private static PreparedStatement pstmt;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");//loading the driver
		System.out.println("Driver Loaded");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/simplijdbc", "root", "root");//establishing connection
		
		//query to insert data into database table
		String sq1 = "update student set percentage=? where sid=?";
		
		//create statement to be created
		pstmt = con.prepareStatement(sq1);
		
		//complete the query using prepared statement
		//pstmt.setInt(1, 81); //static
		//pstmt.setInt(2,3);
		
		System.out.println("Enter the percentage");
		pstmt.setInt(1, sc.nextInt());//dynamic
		
		System.out.println("Enter the student id");
		pstmt.setInt(2, sc.nextInt());//dynamic
		//execute the query
		int x = pstmt.executeUpdate();
		if (x>0)
			System.out.println("Data modified");
		else
			System.out.println("Failed to modify data");
		
		pstmt.close();
		con.close();
		

}
}

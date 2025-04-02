package jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnectionClass {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		// Step 1: Provide connection details
		
		String db_url="jdbc:mysql://localhost:3306";
		String username="root";
		String password="root";
		
		// Stepn 2: Establish the connection
		
		Connection connection = DriverManager.getConnection(db_url, username, password);
		
		// Step 3: Create the query statements
		
		String createDB="create database JDBCStudent_Demo";
		String useDB="use JDBCStudent_Demo";
		String createTable="create table student_details(rno int unique,name varchar(25) NOT NULL,total decimal(10,4))";
		String insert="insert into student_details (rno, name,total) values (102,'Akash','78.70'),(103,'Aruna','91.10'),(104,'Tina','58.50')";
		String select="select * from student_details";
		
		// Step 4: Execute the statements
		
		Statement smt = connection.createStatement();
		
		smt.execute(createDB);
		smt.execute(useDB);
		smt.execute(createTable);
		smt.executeUpdate(insert);
		
		ResultSet result = smt.executeQuery(select);
		
		while(result.next()) {
			
			System.out.println(result.getInt("rno")+"||"+result.getString("name")+"||"+result.getBigDecimal("total"));
		}
		
		// Step 5: Close the connection
		
		connection.close();
	}

}


package alcalajericho;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;



public class Alcalajericho {
public static Connection connectDB() {
  Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC"); 
            con = DriverManager.getConnection("jdbc:sqlite:test.db"); 
            System.out.println("Connection Successful");
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e);
        }
        return con;
    }
public static void main(String[] args) throws SQLException {
Scanner sc=new Scanner(System.in);
System.out.println("Enter Student ID:");
int id=sc.nextInt();
System.out.println("First name:");
String fn=sc.next();
System.out.println("Last name:");
String ln=sc.next();
System.out.println("Email:");
String em=sc.next();
System.out.println("Status:");
String sts=sc.next();


String sql = "INSERT INTO Students(s_id,s_fname,s_lname,s_email,s_status) VALUES (?,?,?,?,?)";
try{
    
   Connection con= connectDB();
   PreparedStatement pst= con.prepareStatement(sql);
       pst.setInt(1,id);
       pst.setString(2,fn);
       pst.setString(3,ln);
       pst.setString(4,em);
      pst.setString(5,sts);
      pst.executeUpdate();
      System.out.println("Inserted Successfully");
}
catch(SQLException ex){
    System.out.println("Connection Error!"+ex.getMessage());
  
}
}
}

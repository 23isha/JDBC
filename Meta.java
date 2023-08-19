import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
public class Meta{
public static void main(String arg[]){
try{
       Scanner sc=new Scanner(System.in);
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc/mysql://localhost:4306/vvit","root","");
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("select * from student1");
        ResultSetMetaData rsmd=rs.getMetaData();
        System.out.println(rsmd.getColumnName(1)+" "+rsmd.getColumnName(1));
        stmt.close();
        rs.close();
}
           catch(ClassNotFoundException e){
                  e.printStackTrace();
           }
          catch(SQLException e){
                  e.printStackTrace();
           }
}
} 
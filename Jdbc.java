import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Jdbc{
public static void main(String arg[]){
try{
       Scanner sc=new Scanner(System.in);
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc/mysql://localhost:4306/vvit","root","");
        ResultSet rs;
        PreparedStatement ps;
        System.out.println("enter choice");
        int ch=sc.nextInt();
        switch(ch){
             case 1:ps=conn.prepareStatement("insert into student1 values(?,?);");
                    System.out.println("enter roll no");
                    int no=sc.nextInt();
                    ps.setInt(1,no);
                    System.out.println("enter name");
                    String name=sc.next();
                    ps.setString(2,name);
                    ps.executeUpdate();
                    System.out.println("inserted successfully");  
                    break;
             case 2:ps=conn.prepareStatement("update student1 set name=? where no=?;");
                    System.out.println("enter roll no");
                    int rono=sc.nextInt();
                    ps.setInt(1,rono);
                    System.out.println("enter name");
                    String oname=sc.next();
                    ps.setString(2,oname);
                    ps.executeUpdate();
                    System.out.println("updated successfully");  
                    break;
             case 3:ps=conn.prepareStatement("delete from student1 where no=?");
                    System.out.println("enter roll no");
                    int rno=sc.nextInt();
                    ps.setInt(1,rno);
                    ps.executeUpdate();
                    System.out.println("updated successfully");  
                    break;
            case 4:ps=conn.prepareStatement("select * from student1");
                   rs=ps.executeQuery();
                   while(rs.next()){
                         System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
                  }
                  break;
            default:System.out.println("Invalid choice");
                    System.exit(0);
}

}
           catch(ClassNotFoundException e){
                  e.printStackTrace();
           }
          catch(SQLException e){
                  e.printStackTrace();
           }
}
}
             
import java.sql.*;

public class Main {
    public static void main(String[] args) {
       String url = "jdbc:mysql://localhost:3306/mydb";
       String name = "root";
       String password = "Rudasingw@76";
       try{
           Connection conn = DriverManager.getConnection(url,name,password);
           System.out.println("connection success");
           Statement stmt= conn.createStatement();
           String insert = "INSERT INTO users(name,age) VALUES('Rudasingwa Bienvenue','19')";
           int insertResult=stmt.executeUpdate(insert);
           System.out.println("insert successfull");
           String update="UPDATE users SET name='amns' WHERE id=2";
           int updateResult=stmt.executeUpdate(update);
           String Delete="DELETE FROM users WHERE name = 'RUDASINGWA'";
           int deleteResult=stmt.executeUpdate(Delete);
           String sql ="SELECT * FROM users";
           ResultSet rs=stmt.executeQuery(sql);
           while(rs.next()){
               System.out.println("Id: "+rs.getInt("id")+" name: "+rs.getString("name")+" age: "+rs.getInt("age"));
           }
       }
       catch (SQLException e){
           e.printStackTrace();
       }
    }
}
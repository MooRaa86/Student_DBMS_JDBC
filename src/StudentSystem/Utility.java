package StudentSystem;

import java.sql.*;

public class Utility {

    public static boolean addStudent(String name, String city, double mark) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schema1",
                    "root","12345");
            String query = "insert into student (name,city,mark)" +
                    "values (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, city);
            ps.setDouble(3, mark);

            int r = ps.executeUpdate();
            conn.close();
            ps.close();
            return r > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void showStudents() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schema1",
                    "root","12345");
            String query = "select * from student";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("ID : "+rs.getInt("id")+"\n"
                        + "Name : " + rs.getString("name") + "\n"
                        + "City : " + rs.getString("city") + "\n"
                        + "Mark : " + rs.getDouble("mark"));
                System.out.println("-----------");
            }
            conn.close();
            ps.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean deleteStudent(int id) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schema1",
                    "root","12345");
            String query = "delete from student where id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            int r = ps.executeUpdate();
            conn.close();
            ps.close();
            return r > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean updateStudentById(int id, String name, String city, double mark) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schema1",
                    "root","12345");
            String query = "update student set name = ?, city = ?, mark = ? where id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, city);
            ps.setDouble(3, mark);
            ps.setInt(4, id);
            int r = ps.executeUpdate(); // هتبقا 0 لو ال id مش موجود في ال table
            ps.close();
            conn.close();
            return r > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

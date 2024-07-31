package Student_Database;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public void addStudent(Student student) throws SQLException {
        try (Connection conn = DatabaseUtil.getConnection()) {
            String sql = "INSERT INTO student1 (rollno, studentname, standard, date_of_birth, fees) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, student.getRollNo());
            pstmt.setString(2, student.getName());
            pstmt.setString(3, student.getStandard());
            pstmt.setString(4, student.getDateOfBirth());
            pstmt.setDouble(5, student.getFees());
            pstmt.executeUpdate();
        }
    }

    public void deleteStudent(int rollNo) throws SQLException {
        try (Connection conn = DatabaseUtil.getConnection()) {
            String sql = "DELETE FROM student1 WHERE rollno = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, rollNo);
            pstmt.executeUpdate();
        }
    }

    public void updateStudentFees(int rollNo, double newFees) throws SQLException {
        try (Connection conn = DatabaseUtil.getConnection()) {
            String sql = "UPDATE student1 SET fees = ? WHERE rollno = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, newFees);
            pstmt.setInt(2, rollNo);
            pstmt.executeUpdate();
        }
    }

    public Student getStudent(int rollNo) throws SQLException {
        try (Connection conn = DatabaseUtil.getConnection()) {
            String sql = "SELECT * FROM student1 WHERE rollno = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, rollNo);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return mapRowToStudent(rs);
            } else {
                return null;
            }
        }
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConnection()) {
            String sql = "SELECT * FROM student1";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                students.add(mapRowToStudent(rs));
            }
        }
        return students;
    }

    private Student mapRowToStudent(ResultSet rs) throws SQLException {
        Student student = new Student();
        student.setRollNo(rs.getInt("rollno"));
        student.setName(rs.getString("studentname"));
        student.setStandard(rs.getString("standard"));
        student.setDateOfBirth(rs.getString("date_of_birth"));
        student.setFees(rs.getDouble("fees"));
        return student;
    }
}

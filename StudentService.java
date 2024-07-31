package Student_Database;
import java.sql.SQLException;
import java.util.List;

public class StudentService {
    private StudentDAO studentDAO;

    public StudentService() {
        this.studentDAO = new StudentDAO();
    }

    public void registerStudent(Student student) throws SQLException {
        studentDAO.addStudent(student);
    }

    public void removeStudent(int rollNo) throws SQLException {
        studentDAO.deleteStudent(rollNo);
    }

    public void updateStudentFees(int rollNo, double newFees) throws SQLException {
        studentDAO.updateStudentFees(rollNo, newFees);
    }

    public Student findStudent(int rollNo) throws SQLException {
        return studentDAO.getStudent(rollNo);
    }

    public List<Student> findAllStudents() throws SQLException {
        return studentDAO.getAllStudents();
    }
}

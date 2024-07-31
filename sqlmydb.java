package Student_Database;

import java.util.*;
import java.sql.*;

public class sqlmydb {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("1:insert  2:Delete  3:Modify 4:View");
            return;
        }
        int option = Integer.parseInt(args[0]);
        StudentService studentService = new StudentService();
        try {
            switch (option) {
                case 1:
                    // Insert 
                    if (args.length != 6) {
                        System.out.println("Usage: java Sqlmydb 1 <rollno> <name> <standard> <dob> <fees>");
                    } else {
                        Student student = new Student();
                        student.setRollNo(Integer.parseInt(args[1]));
                        student.setName(args[2]);
                        student.setStandard(args[3]);
                        student.setDateOfBirth(args[4]);
                        student.setFees(Double.parseDouble(args[5]));
                        studentService.registerStudent(student);
                        System.out.println("Record inserted successfully.");
                    }
                    break;
                case 2:
                    // Delete 
                    if (args.length != 2) {
                        System.out.println("Usage: java Sqlmydb 2 <rollno>");
                    } else {
                        studentService.removeStudent(Integer.parseInt(args[1]));
                        System.out.println("Record deleted successfully.");
                    }
                    break;
                case 3:
                    // Modify 
                    if (args.length != 3) {
                        System.out.println("Usage: java Sqlmydb 3 <rollno> <new_fee>");
                    } else {
                        studentService.updateStudentFees(Integer.parseInt(args[1]), Double.parseDouble(args[2]));
                        System.out.println("Record updated successfully.");
                    }
                    break;
                case 4:
                    // Display 
                    if (args.length == 1) {
                        List<Student> students = studentService.findAllStudents();
                        for (Student student : students) {
                            displayStudentDetails(student);
                        }
                    } else if (args.length == 2) {
                        Student student = studentService.findStudent(Integer.parseInt(args[1]));
                        if (student != null) {
                            displayStudentDetails(student);
                        } else {
                            System.out.println("Record not found.");
                        }
                    } else {
                        System.out.println("Usage: java Sqlmydb 4 [<rollno>]");
                    }
                    break;
                default:
                    System.out.println("Invalid option. Valid options are 1, 2, 3, 4.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void displayStudentDetails(Student student) {
        System.out.println("Roll No: " + student.getRollNo());
        System.out.println("Name: " + student.getName());
        System.out.println("Standard: " + student.getStandard());
        System.out.println("Date of Birth: " + student.getDateOfBirth());
        System.out.println("Fees: " + student.getFees());
        System.out.println();
    }
}

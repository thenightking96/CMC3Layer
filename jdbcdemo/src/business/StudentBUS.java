package business;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import util.SQLQueryStudent;
import dao.StudentDAO;
import data.Student;

public class StudentBUS {
	static Scanner input = new Scanner(System.in);

	public static boolean exists(Student st) {
		ResultSet rs;
		try {
			rs = new StudentDAO().getByStudent(st);
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static int checkInput() {
		int num = 0;
		boolean isInvalid = false;
		do {
			try {
				isInvalid = false;
				num = input.nextInt();
			} catch (Exception e) {
				input.next();
				isInvalid = true;
				System.out.println("Invalid,Please re-enter! Thank you");
			}
		} while (isInvalid == true);

		return num;
	}

	public void input() throws SQLException, IOException {
		int studentId;
		String fullName;
		String address;
		int age;

		System.out.println("Input studentId:");
		studentId = checkInput();
		System.out.println("Input Full Name:");
		input.nextLine();
		fullName = input.nextLine();
		System.out.print("Input Address");
		address = input.nextLine();
		System.out.println("Input Age");
		age = checkInput();

		Student student = new Student(studentId, fullName, address, age);
		if (exists(student)) {
			update(student);
		} else {
			insert(student);
		}

	}

	public List<Student> getAllStudents() {
		List<Student> list = new ArrayList<Student>();
		StudentDAO studentDAO = new StudentDAO();
		try {
			list = studentDAO.getList(SQLQueryStudent.SELECT);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean insert(Student student) throws SQLException {
		return new StudentDAO().insert(student, SQLQueryStudent.INSERT);
	}

	public boolean update(Student student) throws SQLException {
		return new StudentDAO().update(student, SQLQueryStudent.UPDATE);
	}

	public boolean delete(int id) throws SQLException {
		return new StudentDAO().delete(SQLQueryStudent.DELETE, id);
	}
}

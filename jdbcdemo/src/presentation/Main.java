package presentation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import data.Student;
import business.StudentBUS;

public class Main {
	public static void show(StudentBUS studentBUS) {
		System.out.println("Danh sách sinh viên");
		List<Student> listStudent = new ArrayList<Student>();
		listStudent = studentBUS.getAllStudents();
		// System.out.println(listStudent.size());
		Collections.sort(listStudent);
		for (Student student : listStudent) {
			System.out.print(student.getStudentId() + "/");
			System.out.print(student.getFullName() + "/");
			System.out.print(student.getAddress() + "/");
			System.out.println(student.getAge());
		}
	}

	public static void main(String... args) throws SQLException, IOException {
		StudentBUS studentBUS = new StudentBUS();
		boolean isCondition = true;
		do {

			System.out.println("------------------------------------");
			System.out.println("Choose 1 -->> Input Student ");
			System.out.println("Choose 2 -->> Show list Student");
			System.out.println("choose 3 -->> Close");
			System.out.println("Choose:  ");
			switch (StudentBUS.checkInput()) {
			case 1:
				isCondition = true;

				studentBUS.input();
				break;
			case 2:
				isCondition = true;
				show(studentBUS);
				break;
			case 3:
				isCondition = false;
				System.out.println("Good Bye, See You Again");
				break;

			default:
				System.out.println("Again input");
				break;
			}
		} while (isCondition);

	}
}

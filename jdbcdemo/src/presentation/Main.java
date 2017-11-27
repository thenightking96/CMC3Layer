package presentation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import data.Student;
import business.StudentBUS;

public class Main {
	public static void main(String... args) throws SQLException{
		StudentBUS studentBUS = new StudentBUS();
//		Student studentupdate = new Student(1,"Phan Sỹ Mạnh Tiến","Nghệ An",21);
//		studentBUS.update(studentupdate);
//		Student studentInsert = new Student(7,"Lê Thị Thu Trang","Nghệ An",21);
//		studentBUS.insert(studentInsert);
		studentBUS.delete(4);
		System.out.println("Danh sách sinh viên");
		
		List<Student> listStudent = new ArrayList<Student>();
		listStudent = studentBUS.getAllStudents();
//		System.out.println(listStudent.size());
		Collections.sort(listStudent);
		for (Student student : listStudent) {
			System.out.print(student.getStudentId() + "/");
			System.out.print(student.getFullName() + "/");
			System.out.print(student.getAddress() + "/");
			System.out.println(student.getAge());
		}
		
		
		
	}
}

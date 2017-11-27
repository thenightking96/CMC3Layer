package business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.SQLQueryStudent;
import util.SqlQuery;
import dao.StudentDAO;
import data.Student;

public class StudentBUS {
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

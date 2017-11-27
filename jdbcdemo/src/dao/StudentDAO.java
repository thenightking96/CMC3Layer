package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.SQLQueryStudent;
import data.ConnectDB;
import data.Student;

/**
 * @author User
 * @date: Nov 27, 2017
 */
public class StudentDAO {

	/**
	 * @author User
	 * @date: Nov 27, 2017
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public List<Student> getList(String sql) throws SQLException {
		Connection connect;
		try {
			connect = ConnectDB.connect();
			List<Student> list = new ArrayList<Student>();
			Statement statement = connect.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				Student student = new Student();
				student.setStudentId(resultSet
						.getInt(SQLQueryStudent.FIRST_COLUMN));
				student.setFullName(resultSet
						.getString(SQLQueryStudent.SECOND_COLUMN));
				student.setAddress(resultSet
						.getString(SQLQueryStudent.THIRD_COLUMN));
				student.setAge(resultSet.getInt(SQLQueryStudent.FORTH_COLUMN));
				list.add(student);
			}
			connect.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
	}

	/**
	 * @author User
	 * @date: Nov 27, 2017
	 * @param student
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public boolean insert(Student student, String sql) throws SQLException {
		Connection connect;

		connect = ConnectDB.connect();
		PreparedStatement preparedStatement = connect.prepareStatement(sql);
		connect.setAutoCommit(false);
		preparedStatement.setInt(1, student.getStudentId());
		preparedStatement.setString(2, student.getFullName());
		preparedStatement.setString(3, student.getAddress());
		preparedStatement.setInt(4, student.getAge());
		connect.setAutoCommit(true);
		try {
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			connect.close();
		}
		return true;
	}

	/**
	 * @author User
	 * @date: Nov 27, 2017
	 * @param student
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public boolean update(Student student, String sql) throws SQLException {
		Connection connect;
		connect = ConnectDB.connect();
		PreparedStatement preparedStatement = connect.prepareStatement(sql);
		connect.setAutoCommit(false);

		preparedStatement.setString(1, student.getFullName());
		preparedStatement.setString(2, student.getAddress());
		preparedStatement.setInt(3, student.getAge());
		preparedStatement.setInt(4, student.getStudentId());

		connect.setAutoCommit(true);

		try {
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			connect.close();
		}
		return true;
	}

	/**
	 * @author User
	 * @date: Nov 27, 2017
	 * @param sql
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public boolean delete(String sql, int id) throws SQLException {
		Connection connect;
		connect = ConnectDB.connect();
		PreparedStatement preparedStatement = connect.prepareStatement(sql);

		preparedStatement.setInt(1, id);

		try {
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			connect.close();
		}
		return true;

	}

	/**
	 * @author User
	 * @date: Nov 27, 2017
	 * @param st
	 * @return
	 * @throws SQLException
	 */
	public ResultSet getByStudent(Student st) throws SQLException {
		Connection connect;
		connect = ConnectDB.connect();

		PreparedStatement preparedStatement = connect
				.prepareStatement(SQLQueryStudent.FIND_BY_ACCOUNT);
		preparedStatement.setInt(1, st.getStudentId());
		ResultSet rs = preparedStatement.executeQuery();
		return rs;
	}
}

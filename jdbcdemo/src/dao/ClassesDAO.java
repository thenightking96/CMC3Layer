package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import data.Classes;
import data.ConnectDB;

public class ClassesDAO {
	public List<Classes> getList(String sql) throws SQLException {
		Connection connect;
		try {
			connect = ConnectDB.connect();
			List<Classes> listClasses = new ArrayList<Classes>();

			Statement stamentStatement = connect.createStatement();
			ResultSet rs = stamentStatement.executeQuery(sql);
			while (rs.next()) {
				Classes classes = new Classes();
				classes.setClassId(rs.getString("clasesId"));
				classes.setClassName(rs.getString("classesName"));
				classes.setNote(rs.getString("note"));
				listClasses.add(classes);
			}
			connect.close();
			return listClasses;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean insert(Classes classes, String sql) throws SQLException {
		Connection connect;

		connect = ConnectDB.connect();
		PreparedStatement ps = connect.prepareStatement(sql);
		connect.setAutoCommit(false);
		ps.setString(1, classes.getClassId());
		ps.setString(2, classes.getClassName());
		ps.setString(3, classes.getNote());
		connect.setAutoCommit(true);
		try {
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			connect.close();
		}

		return true;

	}
}

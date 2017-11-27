package dao;

import java.sql.Connection;
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
}

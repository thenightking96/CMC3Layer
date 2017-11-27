/**
 * 
 */
package business;

import java.sql.SQLException;

import util.SQLQueryClasses;
import util.SQLQueryStudent;
import dao.ClassesDAO;
import data.Classes;

/**
 * @author User
 * @date: Nov 27, 2017
 */
public class ClassesBUS {

	public boolean insert(Classes classes) throws SQLException {
		return new ClassesDAO().insert(classes, SQLQueryClasses.INSERT);
	}

}

/**
 * 
 */
package util;

/**
 * @author User
 * @date: Nov 27, 2017
 */
public class SQLQueryClasses {
	public static final String SELECT = "SELECT * FROM Classes";
	public static final String FIRST_COLUMN = "ClassId";
	public static final String SECOND_COLUMN = "ClassName";
	public static final String THIRD_COLUMN = "Note";
	public static final String INSERT = "INSERT INTO Classes(" + FIRST_COLUMN
			+ ", " + SECOND_COLUMN + ", " + THIRD_COLUMN + ") VALUES (?,?,?)";
	public static final String UPDATE = "UPDATE  Classes SET " + SECOND_COLUMN
			+ "=? ," + THIRD_COLUMN + "=? " + " WHERE " + FIRST_COLUMN + " =?";
	public static final String DELETE = "DELETE FROM Classes WHERE "
			+ FIRST_COLUMN + " =?";
	public static final String FIND_BY_ACCOUNT = "SELECT ClassesId FROM Classes WHERE "
			+ FIRST_COLUMN + "=?";
}

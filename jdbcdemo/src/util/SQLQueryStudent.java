package util;

public class SQLQueryStudent {
	public static final String SELECT = "SELECT * FROM student";
	public static final String FIRST_COLUMN = "StudentId";
	public static final String SECOND_COLUMN = "FullName";
	public static final String THIRD_COLUMN = "Address";
	public static final String FORTH_COLUMN = "Age";
	public static final String INSERT = "INSERT INTO student(" + FIRST_COLUMN
			+ ", " + SECOND_COLUMN + ", " + THIRD_COLUMN + ", " + FORTH_COLUMN
			+ ") VALUES (?,?,?,?)";
	public static final String UPDATE = "UPDATE  student SET " + SECOND_COLUMN
			+ "=? ," + THIRD_COLUMN + "=? ," + FORTH_COLUMN + "=? " + " WHERE "
			+ FIRST_COLUMN + " =?";
	public static final String DELETE = "DELETE FROM student WHERE "
			+ FIRST_COLUMN + " =?";
}

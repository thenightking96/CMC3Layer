package util;

public class SqlQuery {
	public static final String SELECT = "SELECT * FROM Student";
	public static final String FIRST_COLUMN = "Account";
	public static final String SECOND_COLUMN = "FirstName";
	public static final String THIRD_COLUMN = "LastName";
	public static final String FORTH_COLUMN = "Email";
	public static final String INSERT = "INSERT INTO Employee(" + FIRST_COLUMN + ", " + SECOND_COLUMN + ", "
			+ THIRD_COLUMN + ", " + FORTH_COLUMN + ") VALUES (?,?,?,?)";
	public static final String UPDATE = "UPDATE Employee SET " + SECOND_COLUMN + "=?, " + THIRD_COLUMN + "=?, "
			+ FORTH_COLUMN + "=?  WHERE " + FIRST_COLUMN + " = ?";
	public static final String PREPARED_STATEMENT = "SELECT * FROM Employee WHERE ACCOUNT = ? ";
	public static final String FIND_BY_ACCOUNT = "SELECT ACCOUNT FROM Employee WHERE ACCOUNT = ?";

}

package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ConnectionFactory class provides methods to establish database connections.
 *
 * @version 1.0
 * @author Technical University of Cluj-Napoca, Romania Distributed Systems Research Laboratory
 * @see <a href="http://theopentutorials.com/tutorials/java/jdbc/jdbc-mysql-create-database-example/">Source</a>
 */

public class ConnectionFactory {

	private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3307/schooldb";
	private static final String USER = "root";
	private static final String PASS = "";

	private static ConnectionFactory singleInstance = new ConnectionFactory();

	/**
	 * Private constructor to prevent instantiation from other classes.
	 * Loads the database driver class.
	 */
	private ConnectionFactory() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates a new database connection.
	 *
	 * @return a new Connection object, or null if the connection failed
	 */
	private Connection createConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DBURL, USER, PASS);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "An error occured while trying to connect to the database");
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * Returns the single instance of the ConnectionFactory and creates a new database connection.
	 *
	 * @return a Connection object
	 */
	public static Connection getConnection() {
		return singleInstance.createConnection();
	}

	/**
	 * Closes the given database connection.
	 *
	 * @param connection the Connection object to be closed
	 */
	public static void close(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "An error occured while trying to close the connection");
			}
		}
	}

	/**
	 * Closes the given SQL statement.
	 *
	 * @param statement the Statement object to be closed
	 */
	public static void close(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "An error occured while trying to close the statement");
			}
		}
	}

	/**
	 * Closes the given ResultSet.
	 *
	 * @param resultSet the ResultSet object to be closed
	 */
	public static void close(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "An error occured while trying to close the ResultSet");
			}
		}
	}
}

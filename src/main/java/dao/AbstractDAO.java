package dao;
import connection.ConnectionFactory;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * AbstractDAO class provides common functionality for Data Access Objects.
 */
public class AbstractDAO <T>{
    /** Logger for logging messages. */
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());
    private final Class<T> type;

    /**
     * Constructs an AbstractDAO and determines the actual class type of the generic parameter T
     * using reflection.
     */

    //uses reflection to determine the actual class type of the generic parameter T.
    //extracts the type parameter <T> from the superclass of the current class (using reflection) and stores it in the type field
    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        Type genericSuperclass = getClass().getGenericSuperclass();//retrieves the generic superclass of the current class. It's using reflection (getClass()) to obtain the class object and then calling getGenericSuperclass() to get its generic superclass.
        this.type = (Class<T>) ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
    }

    //uses reflection to create instances of T and populate them with data from the ResultSet
//    private List<T> createObjects(ResultSet resultSet) throws SQLException {
//        List<T> list = new ArrayList<>();
//        Constructor<?> constructor = type.getDeclaredConstructors()[0];//It gets the constructor of the type T. Since getDeclaredConstructors() returns an array of constructors and here [0] is used, it's assuming that T has at least one constructor.
//        constructor.setAccessible(true);
//
//        try {
//            while (resultSet.next()) {
//                T instance = (T) constructor.newInstance();//creates a new instance of type T using the constructor obtained earlier
//                for (Field field : type.getDeclaredFields()) {
//                    String fieldName = field.getName();
//                    Object value = resultSet.getObject(fieldName);//retrieves the value from the ResultSet corresponding to the current field name
//                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
//                    Method writeMethod = propertyDescriptor.getWriteMethod();
//                    writeMethod.invoke(instance, value);
//                }
//                list.add(instance);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            Logger.getLogger(AbstractDAO.class.getName()).severe("Error creating objects from ResultSet");
//        }
//
//        return list;
//    }

    /**
     * Creates instances of T and populates them with data from the ResultSet.
     *
     * @param resultSet the ResultSet object containing data from the database
     * @return a list of instances of T populated with data from the ResultSet
     */

    //uses reflection to create instances of T and populate them with data from the ResultSet
    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] constructors = type.getConstructors();
        Constructor ctor = null;
        for (Constructor constructor : constructors) {
            ctor = constructor;
            if (ctor.getGenericParameterTypes().length == 0) {
                break;
            }
        }
        try{
            while(resultSet.next()){
                ctor.setAccessible(true);
                T instance = (T) ctor.newInstance();//creates a new instance of type T using the constructor obtained earlier
                for(Field field : type.getDeclaredFields()){
                    String fieldName = field.getName();
                    Object value;//retrieves the value from the ResultSet corresponding to the current field name
                    if (field.getType() == int.class) {
                        value = resultSet.getInt(fieldName);
                    } else if (field.getType() == String.class) {
                        value = resultSet.getString(fieldName);
                    } else if (field.getType() == double.class) {
                        value = resultSet.getDouble(fieldName);
                    } else {
                        value = resultSet.getObject(fieldName);
                    }
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        }
        catch (Exception e) {
            LOGGER.severe(e.toString());
        }
        return list;
    }

    /**
     * Retrieves all records from the database table corresponding to the entity type T.
     *
     * @return a list of all records of type T
     */

    //constructs the SQL query based on the class name of T and retrieves all records from the corresponding table
    public List<T> findAll() {
        List<T> list = new ArrayList<>();
        String tableName = type.getSimpleName().toLowerCase() + "s"; // Assuming table name is the plural of the class name

        String sql = "SELECT * FROM " + tableName;
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            list = createObjects(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
            Logger.getLogger(AbstractDAO.class.getName()).severe("Error finding all records");
        }

        return list;
    }

    /**
     * Retrieves a record from the database table corresponding to the entity type T by its ID.
     *
     * @param id the ID of the record to retrieve
     * @return an instance of T representing the retrieved record, or null if no record is found
     */
    public T findById(int id) {
        T instance = null;//the object representing the record fetched from the database
        String tableName = type.getSimpleName().toLowerCase() + "s";//It determines the table(the name of the class in lowercase letters and plural)

        String sql = "SELECT * FROM " + tableName + " WHERE id = ?";//select all columns (*) from the determined table where the id column matches the provided id
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                List<T> list = createObjects(resultSet);
                if (!list.isEmpty()) {
                    instance = list.get(0);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.getLogger(AbstractDAO.class.getName()).severe("Error finding record by id");
        }

        return instance;
    }

    /**
     * Retrieves a record from the database table corresponding to the entity type T by its name.
     *
     * @param name the name of the record to retrieve
     * @return an instance of T representing the retrieved record, or null if no record is found
     */
    public T findByName(String name) {
        T instance = null;
        String tableName = type.getSimpleName().toLowerCase() + "s";

        String sql = "SELECT * FROM " + tableName + " WHERE name = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);
            try (ResultSet resultSet = statement.executeQuery()) {
                List<T> list = createObjects(resultSet);
                if (!list.isEmpty()) {
                    instance = list.get(0);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.getLogger(AbstractDAO.class.getName()).severe("Error finding record by name");
        }

        return instance;
    }

    /**
     * Inserts a new record into the database table corresponding to the entity type T.
     *
     * @param instance the instance of T to be inserted into the database
     */
    public void insert(T instance) {
        String tableName = type.getSimpleName().toLowerCase() + "s";
        //initializes two StringBuilder objects, sql and values, to build the SQL query dynamically
        StringBuilder sql = new StringBuilder("INSERT INTO " + tableName + " (");
        StringBuilder values = new StringBuilder("VALUES (");

        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            sql.append(field.getName()).append(",");
            values.append("?,");
        }
        sql.setLength(sql.length() - 1); // Remove last comma
        values.setLength(values.length() - 1); // Remove last comma
        sql.append(") ").append(values).append(")");

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql.toString())) {

            int index = 1;//keep track of the position of placeholders
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(instance);
                statement.setObject(index++, value);
            }

            statement.executeUpdate();
        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
            Logger.getLogger(AbstractDAO.class.getName()).severe("Error inserting record");
        }
    }

    /**
     * Deletes a record from the database table corresponding to the entity type T by its ID.
     *
     * @param id the ID of the record to delete
     */
    public void delete(int id) {
        String tableName = type.getSimpleName().toLowerCase() + "s";

        String sql = "DELETE FROM " + tableName + " WHERE id = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.getLogger(AbstractDAO.class.getName()).severe("Error deleting record");
        }
    }

    /**
     * Updates a record in the database table corresponding to the entity type T.
     *
     * @param instance the instance of T with updated values
     * @param id the ID of the record to update
     */
    public void update(T instance, int id) {
        String tableName = type.getSimpleName().toLowerCase() + "s";
        StringBuilder sql = new StringBuilder("UPDATE " + tableName + " SET ");

        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            sql.append(field.getName()).append(" = ?, ");//setting each column in the database to a new value
        }
        sql.setLength(sql.length() - 2); // Remove the last comma and space
        sql.append(" WHERE id = ?");

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql.toString())) {

            int index = 1;
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(instance);
                statement.setObject(index++, value);
            }
            statement.setInt(index, id);

            statement.executeUpdate();
        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
            Logger.getLogger(AbstractDAO.class.getName()).severe("Error updating record");
        }
    }
}

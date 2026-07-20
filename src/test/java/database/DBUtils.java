package database;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class DBUtils {

    private static DBUtils dbUtils;
    // logger to print logs, debug failures, track database operations
    public static final Logger LOGGER = Logger.getLogger(DBUtils.class.getName());
    //jdbcTemplate is a Spring jDBC object handles boilerplate operations like connection, statements , closing resources
    // JdbcTemplate is the Spring JDBC helper class that executes SQL queries for us.
    // JdbcTemplate does: ds.getConnection() ← from DataSource
    //Create statement //Execute query //Convert result → List<Map> //Close connection
    private final JdbcTemplate jdbc;

    // defining a constrcutor to accept and initialize DB configs as Map
    public DBUtils(DBConfig config) throws Exception {
        // Pass DataSource to JdbcTemplate;
        this.jdbc = new JdbcTemplate(createDataSource(config));
        LOGGER.info("Initialized JDBC template with URL: " + config.getUrl());
    }
    // Database configuration
    // DataSource holds credentials
    private DataSource createDataSource(DBConfig config) throws Exception {
        // Instead of creating connections manually, Spring uses DataSource. Manages connection
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
        // reading configurations and Setting DB config. In plain JDBC Connection conn = DriverManager.getConnection(url, username, password);
        dataSource.setDriverClassName(config.getDriver());
        dataSource.setUrl(config.getUrl());
        dataSource.setUsername(config.getUsername());
        dataSource.setPassword(config.getPassword());
        System.out.println("Connecting to database..."+config.getUrl());

        return dataSource;
    }

    // Return one single value from DB.Eg:  SELECT COUNT(*) FROM users. Run ' query' and return Object.class(Return the result as a generic Java Object.)
    public String getSingleValue(String query) {
        // queryForObject expects only 1 row in return
        // return jdbc.queryForObject(query, Object.class); // Object.class means rs.getObject(1);
    String name = query;
    System.out.println("Test name"+name);
    return name;
    }
    // return single row of objects;SELECT COUNT(*) FROM users. Eg: SELECT * FROM users WHERE id=3
    public Map<String,Object> getSingleRow(String query) {

        return jdbc.queryForMap(query);

    }

    // Return multiple rows.SELECT * FROM users
    public List<Map<String, Object>> readRows(String query) throws InterruptedException {
        Thread.sleep(7000);
        return jdbc.queryForList(query);
    }
    public static DBUtils getDB() {
        if (dbUtils == null) {
            try {
                DBConfig config = new DBConfig(); // uses ConfigLoader
                dbUtils = new DBUtils(config);
            } catch (Exception e) {
                throw new RuntimeException("❌ Failed to initialize DBUtils", e);
            }
        }

        return dbUtils;
    }
    }
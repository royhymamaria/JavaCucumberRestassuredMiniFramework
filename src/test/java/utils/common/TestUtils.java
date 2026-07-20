package utils.common;

import java.util.Map;
import java.util.List;
import java.util.Random;

import database.DBUtils;

// import static config.ConfigLoader.getConfig;
// import static java.lang.Math.random;

public class TestUtils {
    // code to generate Random Data
    // -?Math.random() returns a double between 0.0 and 1.0

    public static final Random random = new Random();
    // private static DBUtils dbUtils;

    public static int generateRandomInt() {
        return random.nextInt(1000);
        //-? generate number between 0 to 999
    }

    // Call methods in DBUtils

    // 🔹 Get single value (1 row, 1 column)
    public static Object getDBValue(String query) {
        return DBUtils.getDB().getSingleValue(query);
    }
    // 🔹 Get single row (1 row, multiple columns)
    public static Map<String, Object> getDBRow(String query) {
        return DBUtils.getDB().getSingleRow(query);
    }
    // 🔹 Get multiple rows
    public static List<Map<String, Object>> getDBRows(String query) {
        try {
            return DBUtils.getDB().readRows(query);
        } catch (InterruptedException e) {
            throw new RuntimeException("❌ Error fetching DB rows", e);
        }
    }

//    // Reusable method to get DBUtils instance
//    public static Map<String, Object> RDSDBQuery(String table, String condition) {
//
//        String query = "SELECT * FROM " + table + " WHERE " + condition;
//
//        return DBUtils.getDB().getSingleRow(query);
//    }

    // allure attachment utility
    // @Attachment(value = "API Response", type = "application/json")
    // public static String attachResponse(String response) {
    //     return response;
    // }
}

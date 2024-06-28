package api.utils.database;

import api.utils.logging.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DBConnection {

    private String dbUrl;
    private String dbUsername;
    private String dbPassword;

    public DBConnection() {}

    public DBConnection(Properties properties) {
        this.dbUrl = properties.getProperty("dbHostnameAndPortForQA");
        this.dbUsername = properties.getProperty("dbUsernameForQA");
        this.dbPassword = properties.getProperty("dbPasswordForQA");
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
            Log.error(e, "Failed to create JDBC db connection..!");
        }
        return connection;
    }

    public ResultSet executeQuery(String query) throws Exception {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }
}

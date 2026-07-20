package database;

import config.ConfigLoader;

public class DBConfig {

    private String url;
    private String username;
    private String password;
    private String driver;

    public DBConfig() {
        this.url = ConfigLoader.getConfig("db.url");
        this.username = ConfigLoader.getConfig("db.username");
        this.password = ConfigLoader.getConfig("db.password");
        this.driver = ConfigLoader.getConfig("db.driver");

        System.out.println("DB URL: " + url);
        System.out.println("DB USER: " + username);
        System.out.println("DB DRIVER: " + driver);
    }

    // Getters
    public String getUrl() { return url; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getDriver() { return driver; }
}
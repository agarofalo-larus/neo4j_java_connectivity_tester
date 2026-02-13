package org.neo4j_java_connectivity_tester;

import org.neo4j.driver.AuthToken;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;

import java.io.IOException;

public class AppUtils {
    public static void loadProperties() {
        try{
            var file = AppUtils.class.getResourceAsStream("/application.properties");
            if (file!=null)
                System.getProperties().load(file);
        } catch (IOException e) {
            throw new RuntimeException("Error loading application properties", e);
        }
    }

    public static Driver initNeo4jDriver() {
        AuthToken authToken = AuthTokens.basic(getNeo4jUsername(), getNeo4jPassword());
        Driver driver= GraphDatabase.driver(getNeo4jUri(), authToken);
        driver.verifyConnectivity();

        return driver;
    }

    public static String getNeo4jUri() {
        return System.getProperty("NEO4J_URI");
    }

    public static String getNeo4jUsername() {
        return System.getProperty("NEO4J_USERNAME");
    }

    public static String getNeo4jPassword() {
        return System.getProperty("NEO4J_PASSWORD");
    }

    public static String getNeo4jDB() {
        return System.getProperty("NEO4J_DATABASE");
    }

    static String getJwtSecret() {
        return System.getProperty("JWT_SECRET");
    }
}

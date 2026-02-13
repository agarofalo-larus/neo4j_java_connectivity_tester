package neo4j_java_connectivity_tester;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.neo4j.driver.Driver;
import org.neo4j_java_connectivity_tester.AppUtils;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.neo4j_java_connectivity_tester.CypherQueries.*;

public class ConnectionTestNeo4j {


    static Driver driver;

    @BeforeAll
    static void createDriverNeo4j(){
        AppUtils.loadProperties();
        assertNotNull(AppUtils.getNeo4jUsername(), "neo4j username found");
        assertNotNull(AppUtils.getNeo4jPassword(), "neo4j password found");
        assertNotNull(AppUtils.getNeo4jUri(), "neo4j uri found");

        driver = AppUtils.initNeo4jDriver();
        Assumptions.assumeTrue(driver != null);
    }

    @Test
    void connectToNeo4j() {
        assertNotNull(driver, "driver created");
        assertDoesNotThrow(driver::verifyConnectivity, "unable to connect to neo4j");
    }

    @Test
    void queryMovieNeo4j() {
        var results = driver.executableQuery(COUNT_QUERY).execute();

        var records = results.records();

        System.out.println(records);

        assertNotNull(records,records.toString());
    }


    @Test
    void queryListDBsNeo4j() {
        var results = driver.executableQuery(SHOW_DATABASE_QUERY).execute();

        var records = results.records();

        System.out.println(records);

        assertNotNull(records,records.toString());
    }

    @Test
    void queryRolesNeo4j() {
        var results = driver.executableQuery(SHOW_ROLES_QUERY).execute();

        var records = results.records();

        System.out.println(records);

        assertNotNull(records,records.toString());
    }
}

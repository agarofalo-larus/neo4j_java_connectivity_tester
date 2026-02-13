package org.neo4j_java_connectivity_tester;

import org.neo4j.driver.*;
import static org.neo4j_java_connectivity_tester.CypherQueries.*;


public class Neo4jJavaConnectivityTest {
    public static void main(String[] args) {
        System.out.println("Hello world! It's me, neo4j_java_connectivity_test v0.2.1!");

        AppUtils.loadProperties();

        Driver neo4jDriver = AppUtils.initNeo4jDriver();

        String jwtSecret = AppUtils.getJwtSecret();
        String database = AppUtils.getNeo4jDB();

        var results = neo4jDriver.executableQuery(COUNT_QUERY)
            .withConfig(QueryConfig.builder()
                .withDatabase(database)
                .build())
            .execute();

        var records = results.records();

        System.out.println("Database: " + database);
        System.out.println("Record totali:" + records);

        var resultsNPF = neo4jDriver.executableQuery(COUNT_NPF_QUERY)
                .withConfig(QueryConfig.builder()
                        .withDatabase(database)
                        .build())
                .execute();

        var recordsNPF = resultsNPF.records();

        System.out.println("Record totali:" + recordsNPF);
    }
}
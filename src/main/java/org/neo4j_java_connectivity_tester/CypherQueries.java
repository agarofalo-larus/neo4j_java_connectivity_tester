package org.neo4j_java_connectivity_tester;

public class CypherQueries {

    public final static String SHOW_DATABASE_QUERY = "SHOW DATABASES";

    public final static String SHOW_ROLES_QUERY = "SHOW ROLES";

    public final static String COUNT_QUERY = "MATCH (p) RETURN count(p)";

    public final static String COUNT_NPF_QUERY = "MATCH (p:NPF) RETURN count(p)";
}

package com.ensa.projects.solid.OpenClosed;

public abstract class DatabaseAccessor {
    protected String connectionString;

    public DatabaseAccessor(String connectionString) {
        this.connectionString = connectionString;
    }

    public void connect() {
        // Code pour établir une connexion à la base de données.
    }

    public abstract void executeQuery(String query);
}

class MySqlDatabaseAccessor extends DatabaseAccessor {
    public MySqlDatabaseAccessor(String connectionString) {
        super(connectionString);
    }

    @Override
    public void executeQuery(String query) {
    }

    // now there is no need for this method
    public void executeMySqlQuery(String query) {
        // Code spécifique pour exécuter une requête SQL dans MySQL.
    }
}

class OracleDatabaseAccessor extends DatabaseAccessor {
    public OracleDatabaseAccessor(String connectionString) {
        super(connectionString);
    }

    @Override
    public void executeQuery(String query) {

    }

    // no need for this method
    public void executeOracleQuery(String query) {
        // Code spécifique pour exécuter une requête SQL dans Oracle.
    }
}

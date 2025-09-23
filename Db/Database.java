package Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    public static Connection getConnection() throws SQLException {
        String host = System.getenv("DB_HOST");
        String dbname = System.getenv("DB_NAME"); 
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");
        
        // Verificar se todas as variáveis de ambiente estão definidas
        if (host == null || dbname == null || user == null || password == null) {
            throw new SQLException("Variáveis de ambiente da base de dados em falta. " +
                                 "Defina: DB_HOST, DB_NAME, DB_USER, DB_PASSWORD");
        }
        
        String url = String.format("jdbc:postgresql://%s/%s?sslmode=require", host, dbname);

        try {
            Class.forName("org.postgresql.Driver"); 
            
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver PostgreSQL não encontrado!", e);
        }

        return DriverManager.getConnection(url, user, password);
    }
}

package dao;

import java.io.InputStream;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
    
    private static Properties arquivoDePropriedades;
    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    public static Connection getConnection() throws Exception{

        Connection connection = null;
        try{
            if (arquivoDePropriedades == null) {
                arquivoDePropriedades = new Properties();
                InputStream is = ConnectionFactory.class.getClassLoader().getResourceAsStream("db.properties");
                arquivoDePropriedades. load(is);
                driver = arquivoDePropriedades.getProperty("banco.driver");
                url = arquivoDePropriedades.getProperty("banco.url");
                user = arquivoDePropriedades.getProperty("banco.user");
                password = arquivoDePropriedades.getProperty("banco.password");                
            }
            Class.forName(driver).newInstance();
            connection = DriverManager.getConnection(url, user, password);                 
        }catch(Exception e){
            throw new Exception("Problema ao pegar conexão ¬¬ | Exception: " + e.getMessage());            
        }
        return connection;
    }

    public static Statement getStatement() throws Exception {
        return (Statement) getConnection().createStatement();
    }
}

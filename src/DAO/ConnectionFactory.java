package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private String usuario = "root";
    private String senha = "root";
    private String host = "localhost";
    private String port = "3306";
    private String bd = "db_usuario";

    public Connection conexao(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://"+host+":"+port+"/"+bd,usuario,senha);

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

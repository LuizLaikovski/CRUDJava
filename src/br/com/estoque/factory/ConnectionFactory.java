package br.com.estoque.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    // USUARIO MYSQL
    private static final String USERNAME = "root";

    // SENHA MYSQL
    private static final String PASSWORD = "16012008";

    // CAMINHO PARA O BANCO DE DADOS, porta, nome do bd
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/estoque";

    // CONEXÃO COM BANCO DE DADOS
    public static Connection createConnectionToMySQL() throws Exception {
        // FAZ COM QUE A CLASSE SEJA CARREGADA PELA JVM
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        return connection;
    }

    public static void main(String[] args) throws Exception {
        //RECUPERAR UMA CONEXÃO COM O BANCO DE DADO
        Connection con = createConnectionToMySQL();

        //testar se a conexão a nula

        if (con != null) {
            System.out.println("Conexão Obtida com sucesso");
            con.close();
        }

    }


}

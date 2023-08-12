package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost?verifyCertificate=false&useSSL=true";
        String usuario = "iago";
        String senha = "1234";
        Connection conexao = DriverManager.getConnection(url, usuario, senha);

        Statement stmt = conexao.createStatement();
        stmt.execute("CREATE DATABASE IF NOT EXISTS curso_java");
        conexao.close();
    }
}

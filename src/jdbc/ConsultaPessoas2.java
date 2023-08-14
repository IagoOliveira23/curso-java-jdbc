package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultaPessoas2 {
    public static void main(String[] args) throws SQLException {
        Scanner teclado = new Scanner(System.in);

        Connection conexao = FabricaConexao.getConexao();
        String sql = "SELECT * FROM pessoas WHERE nome LIKE ?";

        System.out.println("Informe o valor pra pesquisar: ");
        String valor = teclado.nextLine();

        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, "%" + valor + "%");
        ResultSet resultado = stmt.executeQuery();

        List<Pessoa> pessoas = new ArrayList<>();

        while(resultado.next()){
            int codigo = resultado.getInt("codigo");
            String nome = resultado.getString("nome");
            pessoas.add(new Pessoa(codigo, nome));
        }

        for(Pessoa p: pessoas){
            System.out.println(p.getCodigo() + "==> " + p.getNome());
        }
        stmt.close();
        conexao.close();
    }

}

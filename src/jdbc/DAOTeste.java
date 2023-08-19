package jdbc;

public class DAOTeste {
    public static void main(String[] args) {
        DAO dao = new DAO();

        String sql = "INSERT INTO pessoas (nome) VALUES (?)";
        String sql2 = "INSERT INTO pessoas (nome, codigo) VALUES (?, ?)";

        dao.incluir(sql, "Testando");
        dao.incluir(sql, "Ednaldo");
        dao.incluir(sql, "Cássio");
        dao.incluir(sql2, "Teste2", 123);
        dao.close();
    }
}

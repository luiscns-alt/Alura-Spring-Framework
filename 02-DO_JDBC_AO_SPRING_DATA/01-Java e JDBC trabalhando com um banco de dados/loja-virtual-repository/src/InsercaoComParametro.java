import java.sql.*;

public class InsercaoComParametro {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.RecuperarConexao();
        connection.setAutoCommit(false);

        PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);

        AdicionarProduto("TV", "45pol", stm);
        AdicionarProduto("Radio", "bateria", stm);
    }

    private static void AdicionarProduto(String nome, String descricao, PreparedStatement stm) throws SQLException {
        stm.setString(1, nome);
        stm.setString(2, descricao);

        if (nome.equals("Radio")){
            throw new RuntimeException("Não foi possível adicionar o produto");
        }

        stm.execute();

        ResultSet rst = stm.getGeneratedKeys();

        while (rst.next()) {
            Integer id = rst.getInt(1);
            System.out.println("ID criado: " + id);
        }
        rst.close();
    }
}

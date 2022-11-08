import java.sql.*;

public class InsercaoComParametro {
    public static void main(String[] args) throws SQLException {
        String nome = "Teclado";
        String descricao = "Multilaser";
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.RecuperarConexao();

        PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);

        stm.setString(1, nome);
        stm.setString(2, descricao);

        stm.execute();

        ResultSet rst = stm.getGeneratedKeys();

        while (rst.next()) {
            Integer id = rst.getInt(1);
            System.out.println("ID criado: " + id);
        }
        connection.close();
    }
}

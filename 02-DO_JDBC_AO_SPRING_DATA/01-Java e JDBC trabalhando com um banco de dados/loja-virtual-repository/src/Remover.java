import java.sql.*;

public class Remover {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.RecuperarConexao();

        PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
        stm.setInt(1, 2);
        stm.execute();

        Integer rst = stm.getUpdateCount();
        System.out.println("Deletado: " + rst);

        connection.close();
    }
}

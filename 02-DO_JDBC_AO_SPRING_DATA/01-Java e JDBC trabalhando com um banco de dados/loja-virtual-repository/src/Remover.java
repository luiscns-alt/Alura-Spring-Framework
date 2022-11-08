import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Remover {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.RecuperarConexao();

        Statement stm = connection.createStatement();
        stm.execute("DELETE FROM PRODUTO WHERE ID > 2");

        Integer rst = stm.getUpdateCount();
        System.out.println("Deletado: " + rst);

        connection.close();
    }
}

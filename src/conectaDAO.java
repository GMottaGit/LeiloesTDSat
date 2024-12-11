
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conectaDAO {

    public Connection connectDB() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/uc11", "root", "12345678");;
            return conn;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO" + erro.getMessage());
            return null;
        }
        
    }

    public void desconectar(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();

            }
        } catch (SQLException ex) {
            System.out.println("Nao foi possivel desconectar do banco dados.");
        }
    }
}

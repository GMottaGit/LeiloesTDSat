
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutosDAO {

    conectaDAO db = new conectaDAO();
    Connection conn = db.connectDB();
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();

    public void cadastrarProduto(ProdutosDTO produto) {
        try {
            String sql = "INSERT INTO produtos(nome, valor, status) VALUES" + "(?, ?, ?)";
            PreparedStatement smts = this.conn.prepareStatement(sql);
            smts.setString(1, produto.getNome());
            smts.setInt(2, produto.getValor());
            smts.setString(3, produto.getStatus());
            smts.execute();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso.");
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar produto: " + e.getMessage());

        }
    }

    public ArrayList<ProdutosDTO> listarProdutos() {

        return listagem;
    }

}

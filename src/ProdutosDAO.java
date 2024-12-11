
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutosDAO {

    conectaDAO db = new conectaDAO();
    Connection conn = db.connectDB();
    
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
            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar o produto.");

        }
    }

    public ArrayList<ProdutosDTO> listarProdutos() {
        try{
        String sql = "SELECT * FROM produtos";
        PreparedStatement smts = this.conn.prepareStatement(sql);
        ResultSet rs = smts.executeQuery(); 
        ArrayList<ProdutosDTO> listagem = new ArrayList<>();
        while(rs.next()){
          ProdutosDTO prod = new ProdutosDTO();
          prod.setId(rs.getInt("id"));
          prod.setNome(rs.getString("nome"));
          prod.setValor(rs.getInt("valor"));
          prod.setStatus(rs.getString("status"));
          listagem.add(prod);
        }
        return listagem;
        }
        catch(Exception ex){
            return null;
        }
    }

}

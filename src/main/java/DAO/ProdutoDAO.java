
package DAO;

import Model.Imagem;
import Model.Produto;
import Utils.GerenciarConexao;
import static Utils.Utils.popularImagem;
import static Utils.Utils.popularProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoDAO {
    
    public static int idProduto;
    
     public static boolean cadastrarProduto(Produto produto) {
        boolean ok = true;
        try {
            Connection con = GerenciarConexao.getConexao();
            String query = "insert into produto(nome, avaliacao, descricao, status, preco, qtd_estoque) values (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, produto.getNome());
            ps.setInt(2, produto.getAvaliacao());
            ps.setString(3, produto.getDescricao());
            ps.setString(4, produto.getStatus());
            ps.setDouble(5, produto.getPreco());
            ps.setInt(6, produto.getQtdEstoque());  
            ps.executeUpdate();
            
            ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                       produto.setIdProduto(generatedKeys.getInt(1));
                       idProduto = produto.getIdProduto();
                       
                }
                
                
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }
     
     public static boolean cadastrarImagem(Imagem imagem) {
        boolean ok = true;
        try {
            Connection con = GerenciarConexao.getConexao();
            String query = "insert into imagem(nome, padrao, FK_id_produto) values (?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, imagem.getNome());
            ps.setString(2, imagem.getPadrao());
            ps.setInt(3, imagem.getFKProduto()); 
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }
     
     public static boolean excluirImagem(int idImagem) {
       boolean ok = true;
       String query = "delete from imagem where id_imagem=?";
       Connection conn;
        try {
            conn = GerenciarConexao.getConexao();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idImagem);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
   }
     
     public static boolean atualizarProduto(Produto produto) {
       boolean ok = true;
       String query = "update produto set nome=?, avaliacao=?, descricao=?, status=?, preco=?, qtd_estoque=? where id_produto=?";
       Connection conn;
        try {
            conn = GerenciarConexao.getConexao();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, produto.getNome());
            ps.setInt(2, produto.getAvaliacao());
            ps.setString(3, produto.getDescricao());
            ps.setString(4, produto.getStatus());
            ps.setDouble(5, produto.getPreco());
            ps.setInt(6, produto.getQtdEstoque());
            ps.setInt(7, produto.getIdProduto());

            ps.executeUpdate();
                
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
   }
     
     public static boolean atualizarStatus(String status, int idProduto) {
       boolean ok = true;
       String query = "update produto set status=? where id_produto=?";
       Connection conn;
        try {
            conn = GerenciarConexao.getConexao();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, status);
            ps.setInt(2, idProduto);

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
   }
     
     public static Produto getProduto(int idProduto) {
       Produto produto = null;
       String query = "select * from produto where id_produto=?";
       Connection conn;
        try {
            conn = GerenciarConexao.getConexao();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idProduto);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                produto = popularProduto(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto;
   }
     
     public static Imagem getImagem(int idImagem) {
       Imagem imagem = null;
       String query = "select * from imagem where id_imagem=?";
       Connection conn;
        try {
            conn = GerenciarConexao.getConexao();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idImagem);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                imagem = popularImagem(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return imagem;
   }
     
     public static List<Produto> listaProdutos() {
        List<Produto> produtos = new ArrayList<>();
        String query = "select * from produto";
        Connection con;
        try {
            con = GerenciarConexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int idProduto = rs.getInt("id_produto");
                String nome = rs.getString("nome");
                int avaliacao = rs.getInt("avaliacao");
                String descricao = rs.getString("descricao");
                String status = rs.getString("status");
                double preco = rs.getDouble("preco");
                int qtdEstoque = rs.getInt("qtd_estoque");
               
                Produto produto = new Produto(idProduto, nome, avaliacao, descricao, status, preco, qtdEstoque);
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;   
    }
     
     public static List<Imagem> listaImagens(int idProduto) {
        List<Imagem> imagens = new ArrayList<>();
        String query = "select id_imagem, imagem.nome, padrao, fk_id_produto from imagem\n" +
"        inner join produto on imagem.FK_id_produto = produto.id_produto\n" + 
"        where id_produto = ?";
        Connection con;
        try {
            con = GerenciarConexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,idProduto);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int idImagem = rs.getInt("id_imagem");
                String nome = rs.getString("nome");
                String padrao = rs.getString("padrao");
                int FkProduto = rs.getInt("fk_id_produto");
               
                Imagem imagem = new Imagem(idImagem, nome, padrao, FkProduto);
                imagens.add(imagem);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return imagens;   
    }
     
     public static List<Produto> listaProdutosNome(String nomeProduto) {
        List<Produto> produtos = new ArrayList<>();
        String query = "select * from produto where nome like ?";
        Connection con;
        try {
            con = GerenciarConexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, "%" + nomeProduto + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int idProduto = rs.getInt("id_produto");
                String nome = rs.getString("nome");
                int avaliacao = rs.getInt("avaliacao");
                String descricao = rs.getString("descricao");
                String status = rs.getString("status");
                double preco = rs.getDouble("preco");
                int qtdEstoque = rs.getInt("qtd_estoque");
               
                Produto produto = new Produto(idProduto, nome, avaliacao, descricao, status, preco, qtdEstoque);
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;   
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Model.Imagem;
import Model.Produto;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ygor.oliveira
 */
public class Utils {
    
    public static Produto popularProduto(ResultSet rs) throws SQLException {
                int idProduto = rs.getInt("id_produto");
                String nome = rs.getString("nome");
                int avaliacao = rs.getInt("avaliacao");
                String descricao = rs.getString("descricao");
                String status = rs.getString("status");
                double preco = rs.getDouble("preco");
                int qtdEstoque = rs.getInt("qtd_estoque");
               
                Produto produto = new Produto(idProduto, nome, avaliacao, descricao, status, preco, qtdEstoque);
                
        return produto;
    }
    
    public static Imagem popularImagem(ResultSet rs) throws SQLException {
                int idImagem = rs.getInt("id_imagem");
                String nome = rs.getString("nome");
                String padrao = rs.getString("padrao");
                int FkProduto = rs.getInt("fk_id_produto");
               
                Imagem imagem = new Imagem(idImagem, nome, padrao, FkProduto);
                
        return imagem;
    }
    
}

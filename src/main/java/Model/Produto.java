/**
 *
 * @author Ygor Oliveira | Yasmim Candelária | Dalila Di Lazzáro | Jeferson Davi
 */
package Model;

public class Produto {

    private int idProduto;
    private String nome;
    private int avaliacao;
    private String descricao;
    private String status;
    private double preco;
    private int qtdEstoque;

    
    public Produto(String nome, int avaliacao, String descricao, String status, double preco, int qtdEstoque) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.avaliacao = avaliacao;
        this.descricao = descricao;
        this.status = status;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
    }
    
    public Produto(int idProduto, String nome, int avaliacao, String descricao, String status, double preco, int qtdEstoque) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.avaliacao = avaliacao;
        this.descricao = descricao;
        this.status = status;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
   

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }
    
    

    
    
}

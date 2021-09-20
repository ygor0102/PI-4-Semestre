/**
 *
 * @author Ygor Oliveira | Yasmim Candelária | Dalila Di Lazzáro | Jeferson Davi
 */
package Model;

public class Imagem {
    
    private int idImagem;
    private String nome;
    private String padrao;
    private int FKProduto;
    
     public Imagem(String nome, String padrao, int FKProduto) {
        this.nome = nome;
        this.padrao = padrao;
        this.FKProduto = FKProduto;
    }
     
    public Imagem(String nome) {
        this.nome = nome;
    } 

    public Imagem(int idImagem, String nome, String padrao, int FKProduto) {
        this.idImagem = idImagem;
        this.nome = nome;
        this.padrao = padrao;
        this.FKProduto = FKProduto;
    }

    public int getIdImagem() {
        return idImagem;
    }

    public void setIdImagem(int idImagem) {
        this.idImagem = idImagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPadrao() {
        return padrao;
    }

    public void setPadrao(String padrao) {
        this.padrao = padrao;
    }

    public int getFKProduto() {
        return FKProduto;
    }

    public void setFKProduto(int FKProduto) {
        this.FKProduto = FKProduto;
    }

    
    
}

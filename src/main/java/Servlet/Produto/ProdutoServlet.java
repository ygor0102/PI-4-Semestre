/**
 *
 * @author Ygor Oliveira | Yasmim Candelária | Dalila Di Lazzáro | Jeferson Davi
 */
package Servlet.Produto;

import DAO.ProdutoDAO;
import Model.Imagem;
import Model.Produto;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@MultipartConfig

public class ProdutoServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //INSERE O PRODUTO NO BANCO;
         String nome = request.getParameter("nome");
         int avaliacao = Integer.parseInt(request.getParameter("avaliacao"));
         String descricao = request.getParameter("descricao");
         String status = "Ativo";
         double preco = Double.parseDouble(request.getParameter("preco"));
         int qtdEstoque = Integer.parseInt(request.getParameter("qtdEstoque"));

         Produto produto = new Produto(nome, avaliacao, descricao, status, preco, qtdEstoque);
         boolean ok= ProdutoDAO.cadastrarProduto(produto);
        
        boolean ok2 = false;
        
        //CRIA A IMAGEM NO DIRETÓRIO;
        String msg = "Arquivo enviado com sucesso";
        String path = "C:\\Users\\ygor.oliveira\\Documents\\NetBeansProjects\\ProjetoInt_4SM\\src\\main\\webapp\\img";
        try {
            
            for(Part part : request.getParts()){
                if(part.getName().equals("file"))
                    part.write(part.getSubmittedFileName());
                
                
                // Arquivo a ser movido
                File arquivo = new File("C:\\Users\\ygor.oliveira\\GlassFish_Server\\glassfish\\domains\\domain1\\generated\\jsp\\ProjetoInt_4SM\\"+part.getSubmittedFileName());
                if (!arquivo.exists()) {
                    System.out.println("Arquivo não encontrado");
                } else {
                    // Diretorio de destino
                     File diretorioDestino = new File(path);
            
                    // Move o arquivo para o novo diretorio
                     boolean sucesso = arquivo.renameTo(new File(diretorioDestino, part.getSubmittedFileName()));
                     if (sucesso) {
                        System.out.println("Arquivo movido para '" + diretorioDestino.getAbsolutePath() + "'");
                        
                    //INSERE A IMAGEM NO BANCO;
                    String nomeImagem = ""+part.getSubmittedFileName();
                    String padrao = "Secundaria";
                    int FkProduto = ProdutoDAO.idProduto;
        
                    Imagem imagem = new Imagem(nomeImagem, padrao, FkProduto);
                    ok2 = ProdutoDAO.cadastrarImagem(imagem);
                    
            } else {
                System.out.println("Erro ao mover arquivo '" + arquivo.getAbsolutePath() + "' para '"
                        + diretorioDestino.getAbsolutePath() + "'");
            }
            }
        }     
            }
            
         catch (Exception e) {
            System.out.println(e.getMessage());
            msg = "Erro ao salvar arquivos";
        }
        
        // Passo 3: Redirecionar para sucesso.jsp
            if (ok && ok2) {
                System.out.println("Sucesso!");
                response.sendRedirect("../Protegido/Sucesso.jsp");
            } else {
                System.out.println("Falha!");
                response.sendRedirect("Erro.jsp");
            }
   
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
         List<Produto> listaProdutos = ProdutoDAO.listaProdutos();
         request.setAttribute("listaProdutos", listaProdutos);
         request.getRequestDispatcher("/Protegido_Admin/ConsultaProduto.jsp").forward(request, response);
    }
    
}

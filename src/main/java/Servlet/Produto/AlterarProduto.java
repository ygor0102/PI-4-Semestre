/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
/**
 *
 * @author ygor.oliveira
 */
public class AlterarProduto extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Alterando produto no banco:
        int idProduto = Integer.parseInt(request.getParameter("idProduto"));
        String nome = request.getParameter("nome");
        int avaliacao = Integer.parseInt(request.getParameter("avaliacao"));
        String descricao = request.getParameter("descricao");
        String status = request.getParameter("status");
        double preco = Double.parseDouble(request.getParameter("preco"));
        int qtdEstoque = Integer.parseInt(request.getParameter("qtdEstoque"));
        
        Produto produto = new Produto(idProduto, nome, avaliacao, descricao, status, preco, qtdEstoque);
        boolean ok = ProdutoDAO.atualizarProduto(produto);
        boolean ok2 = false;
        
        
        //CASO NÃO TENHA ESCOLHIDO NOVAS IMAGENS;
        if(request.getPart("file").getSize()<=0){
            
            if (ok) {
                System.out.println("Sucesso!");
                response.sendRedirect("../Protegido/Sucesso.jsp");
            } else {
                System.out.println("Falha!");
                response.sendRedirect("Erro.jsp");
            }
        
        }else{
        
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
                    String padrao = "Complementar";
                    int FkProduto = idProduto;
        
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
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idProduto = Integer.parseInt(request.getParameter("idproduto"));
        Produto produto = ProdutoDAO.getProduto(idProduto);
        
        request.setAttribute("produto", produto);
        
        List<Imagem> listaImagens = ProdutoDAO.listaImagens(idProduto);
        request.setAttribute("listaImagens", listaImagens);
        
        request.getRequestDispatcher("/Protegido_Admin/AlterarProduto.jsp").forward(request, response);
       
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.Produto;

import DAO.ProdutoDAO;
import Model.Imagem;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExcluirImagem extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
         int idImagem = Integer.parseInt(request.getParameter("idImagem"));
         Imagem imagem = ProdutoDAO.getImagem(idImagem);
         
        // Arquivo a ser deletado
                File arquivo = new File("C:\\Users\\ygor.oliveira\\Documents\\NetBeansProjects\\ProjetoInt_4SM\\src\\main\\webapp\\img\\"+imagem.getNome());
                if (!arquivo.exists()) {
                    System.out.println("Arquivo não encontrado");
                } else {
                     boolean sucesso = arquivo.delete();
                     
                     if (sucesso) {
                        System.out.println("O arquivo foi deletado");
                         boolean ok = ProdutoDAO.excluirImagem(idImagem);
                    
            } else {
                System.out.println(arquivo);
                System.out.println("Erro ao deletar arquivo");
            }
    }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

 
}

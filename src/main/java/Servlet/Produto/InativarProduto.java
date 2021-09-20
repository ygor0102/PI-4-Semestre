/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.Produto;

import DAO.ProdutoDAO;
import Model.Produto;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ygor.oliveira
 */
public class InativarProduto extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idProduto = Integer.parseInt(request.getParameter("idproduto"));
        Produto produto = ProdutoDAO.getProduto(idProduto);
        
        String validaStatus ="";
        if(produto.getStatus().equals("Ativo")){
            validaStatus="Inativo";
        }
        else{
            validaStatus="Ativo";
        }
        
        boolean ok = ProdutoDAO.atualizarStatus(validaStatus, idProduto);
        
        // Passo 3: Redirecionar para sucesso.jsp
            if (ok) {
                System.out.println("Sucesso!");
                response.sendRedirect("ProdutoServlet");
            } else {
                System.out.println("Falha!");
            }
   
    }
    
}

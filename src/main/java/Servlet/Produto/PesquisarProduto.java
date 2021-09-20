/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.Produto;

import DAO.ProdutoDAO;
import Model.Produto;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ygor.oliveira
 */
public class PesquisarProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
   
        
        String nome = request.getParameter("nome_produto");
      
            List<Produto> listaProdutos = ProdutoDAO.listaProdutosNome(nome);
            request.setAttribute("listaProdutos", listaProdutos);
            
         request.getRequestDispatcher("/Protegido_Admin/ConsultaProduto.jsp").forward(request, response);
    }
    
    
    
}

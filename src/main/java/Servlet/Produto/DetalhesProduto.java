/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.Produto;

import DAO.ProdutoDAO;
import Model.Imagem;
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
public class DetalhesProduto extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idProduto = Integer.parseInt(request.getParameter("idproduto"));
        Produto produto = ProdutoDAO.getProduto(idProduto);
        request.setAttribute("produto", produto);
        
        
        List<Imagem> listaImagens = ProdutoDAO.listaImagens(idProduto);
        request.setAttribute("listaImagens", listaImagens);
        
        request.getRequestDispatcher("/Protegido_Admin/DetalhesProduto.jsp").forward(request, response);

       
    }
}   
<%-- 
    Document   : DetalhesProduto
    Created on : 12/09/2021, 09:40:20
    Author     : ygor.oliveira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../css/DetalhesProduto.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <title>Visualizar Produtos</title>
    </head>
    <body>
        
        <style>
            #grad {
                height: auto;
                background-color: rgba(95, 216, 229, 0.89); /* For browsers that do not support gradients */
                background-image: linear-gradient(to bottom right, #c0c0c0, transparent);
                border-radius: 30px;
            }
                
            #grad2 {
                height: auto;
                background-color: rgba(95, 216, 229, 0.89); /* For browsers that do not support gradients */
                border-radius: 30px;
            }
            
            .w-auto legend{
                display: flex;
                align-items: center;
                left: 50%;
                font-style: bold;
                font-family: "Segoe UI", "Arial";
                
            }
                #iconProd{
                    height: 80px;
                    padding-left: 1%;
            }
            
            .container{
                display: flex;
                align-items: center;
                }
                
             #imagem:hover{
                    transform: scale(2.5) rotate(-5deg);
                    background-color: rgba(255,255,255,0.8);
                    box-shadow: 0 0 5px #333;
                    transition: all 1.2s;
                    border-radius:30%;
            }
                
        </style>
    <c:import url="../Protegido/Menu.jsp"/>

    <c:if test="${not empty produto}">
        
        <div class="container mt-5">
            <fieldset class="border p-3 fieldset mb-25 col py-3 px-md-5 border" id="grad">
                
                
                <legend  class="w-auto legend">
                            <div class="container">
                                <h2>${produto.nome}</h2>
                                <img src="../img/adesivo_instrumento_cordas.png" alt="iconProd" name="iconProd" id="iconProd"/>
                                </div>
               </legend>
      
        
        </fieldset>
        
        </div>
       
        
        <div class="container mt-5">
            <fieldset class="border p-3 fieldset mb-25 col py-3 px-md-5 border" id="grad2">
            
           <div class="row">    
           <c:forEach var="imagem" items="${listaImagens}">
           <img src="../img/${imagem.nome}" alt="fotos produto" id="imagem" class="imagens">
            </c:forEach>
           
           <div class="col-sm">
               <center><h3>${produto.preco}R$</h3></center>
                <button type="submit" class="btn btn-dark form-control form-control-lg h4" enabled="false">Comprar</button>

             </div>
           </div>
            
        
        <br>
        <h3>Descrição do Produto</h3>
        <p>${produto.descricao}</p>
        
        
    </fieldset>   
        </div>
    </c:if>
    </body>
</html>

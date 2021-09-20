<%-- 
    Document   : CadastroProduto
    Created on : 12/09/2021, 09:39:50
    Author     : ygor.oliveira
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="../css/CadastroProduto.css">
      
            
        <title>Cadastrar Produtos</title>
        
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
                background-image: linear-gradient(to bottom right, #c0c0c0, transparent);
                border-radius: 30px;
            }
            
            
            
        </style>
    </head>
    <body>
       <c:import url="../Protegido/Menu.jsp"/>
        
        <form  action="ProdutoServlet" method="POST" class="formulario" autocomplete="off" enctype="multipart/form-data">
       <div class="container mt-5">
            <fieldset class="border p-3 fieldset mb-25 col py-3 px-md-5 border" id="grad">
                
                        <legend  class="w-auto legend">
                            <div class="container">
                                <h2> Cadastro de Produtos</h2>
                                <img src="../img/amplificador_icon.png" alt="Amplificador">
                            </div>
                        </legend>
            
        <div class="row">
                <!--tamanho do input-->
                        <div class="col-sm">
                            <label for="colFormLabelLg" class="form-label h4">* Nome do produto: </label>
                            <input class="form-control form-control-lg" id="nome" type="text" name="nome" required><br>
                        </div>
                
                        <div class="col-sm">
                            <label for="colFormLabelLg" class="form-label h4">* Avaliação: </label>
                            <input class="form-control form-control-lg" type="number" id="avaliacao" name="avaliacao" min="1" max="5" step="1" required><br>

                        </div>
        </div>
                        
        <div class="row">
                        <label for="colFormLabelLg" class="form-label h4">* Descrição: </label>
                        <div class="col-sm">
                            <textarea class="form-control form-control-lg" id="descricao" cols="35" rows="5" name="descricao" required></textarea><br>
                        </div>
        </div>
                        
                        
        <div class="row">
                        <div class="col-sm">
                            <label for="colFormLabelLg" class="form-label h4">* Preço unitário: </label>
                            <input class="form-control form-control-lg" type="number" id="preco" min="1" name="preco" placeholder="0.00" required><br>
                        </div>


                        <div class="col-sm">
                            <label ffor="colFormLabelLg" class="form-label h4">* Quantidade para estoque: </label>
                            <input class="form-control form-control-lg" type="number" id="qtdEstoque"  name="qtdEstoque" required><br>
                        </div> 
        </div>
                        
       
                
            </fieldset>
           
            
    </div>
            
        <div class="container mt-5">
                <fieldset class="border p-3 fieldset mb-25 col py-3 px-md-5 border" id="grad2">
                
                <legend  class="w-auto legend">
                            <div class="container">
                                <h2> Seleção de imagens</h2>
                                <img src="../img/amplificador_icon.png" alt="Amplificador">
                            </div>
                        </legend>
                    <div class="row">
                        
                         <input type="file" name="file" multiple="multiple" id="file" accept="image/*" required><br><br>
       
                    </div>
               
		 <div class="row">
                       
                 <div class="col-sm">
                            <button type="submit" class="btn btn-dark form-control form-control-lg h4">Incluir</button>
                 </div>
                
                 <div class="col-sm">
                            <a href="../Protegido/index.jsp"><button type="button" class="btn btn-dark form-control form-control-lg h4">Cancelar</button></a>
                 </div>
                </div>
            </fieldset>
            
        </div>
    </form>
        
    </body>
</html>

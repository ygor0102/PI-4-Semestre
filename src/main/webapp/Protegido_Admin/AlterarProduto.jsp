<%-- 
    Document   : CadastroProduto
    Created on : 12/09/2021, 09:39:50
    Author     : ygor.oliveira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="../css/AlterarProduto.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <title>Alterar Produtos</title>
        
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
        
        <c:if test="${not empty produto}">
            
        <form  action="AlterarProduto" method="POST" class="formulario" enctype="multipart/form-data" autocomplete="off">
        <div class="container mt-5">
            <fieldset class="border p-3 fieldset mb-25 col py-3 px-md-5 border" id="grad">
                
                        <legend class="w-auto legend">
                            <div class="container">
                                <h2>Alteração de Produtos</h2>
                                <img src="../img/amplificador_icon.png" alt="Amplificador">
                            </div>
                        </legend>
            
        <div class="row">
                        <div class="col-sm">
                                 <label for="colFormLabelLg" class="form-label h4">* Nome do produto: </label>
                                 <input class="form-control form-control-lg" id="nome" type="text" value="${produto.nome}" name="nome" required><br>
                        </div>   
        </div>
                        
        <div class="row">
                <!--tamanho do input-->
                
                        <div class="col-sm">
                            <label for="colFormLabelLg" class="form-label h4">* ID do Produto: </label>
                            <input class="form-control form-control-lg" type="number" value="${produto.idProduto}" id="idProduto" name="idProduto" min="1" max="5" step="1" readOnly="true" required><br>

                        </div>
                           
                        <div class="col-sm">
                            <label for="colFormLabelLg" class="form-label h4">* Avaliação: </label>
                            <input class="form-control form-control-lg" type="number" value="${produto.avaliacao}" id="avaliacao" name="avaliacao" min="1" max="5" step="1" required><br>

                        </div>
                        
                        <div class="col-sm">
                        <label for="colFormLabelLg" class="form-label h4">* Status do produto: </label>
                             <select name="status" id="status" class="form-control" required>
                                    <option value="${produto.status}">${produto.status}</option>
                                    <option value="Inativo">Inativo</option>
                            </select>
                        </div>
        </div>
                    
        <div class="row">
                        <label for="colFormLabelLg" class="form-label h4">* Descrição: </label>
                        <div class="col-sm">
                            <textarea class="form-control form-control-lg" id="descricao" cols="35" rows="5" name="descricao" required>${produto.descricao}</textarea><br>
                        </div>
        </div>
                        
                        
        <div class="row">
                        <div class="col-sm">
                            <label for="colFormLabelLg" class="form-label h4">* Preço unitário: </label>
                            <input class="form-control form-control-lg" type="number" value="${produto.preco}" id="preco" min="1" name="preco" placeholder="0.00" required><br>
                        </div>


                        <div class="col-sm">
                            <label ffor="colFormLabelLg" class="form-label h4">* Quantidade para estoque: </label>
                            <input class="form-control form-control-lg" type="number" value="${produto.qtdEstoque}" id="qtdEstoque"  name="qtdEstoque" required><br>
                        </div> 
        </div>
                
                    
            </fieldset>
    </div>
                        
        <div class="container mt-5">
        <fieldset class="border p-3 fieldset mb-25 col py-3 px-md-5 border" id="grad2">
                
                <legend  class="w-auto legend">
                            <div class="container">
                                <h2> Apagar imagens</h2>
                                <img src="../img/amplificador_icon.png" alt="Amplificador">
                            </div>
                        </legend>
            
            <div class="containerIMG">
                
                    <div class="row">
                    <c:forEach var="imagem" items="${listaImagens}">
                    
                    <div class="col-sm">
                       <img src="../img/${imagem.nome}" alt="fotos produto" id="imagem" class="imagens">
                       <p>ID da imagem: ${imagem.idImagem}</p>
                       <p name="nomeImagem" id="nomeImagem">Nome da imagem: ${imagem.nome}</p>
                        <img src="../img/lixeira_icon.png" alt="fotos produto" id="lixeira" onclick="confirmarExclusao(${imagem.idImagem})" class="bin">
                    </div>
                    </c:forEach>
                   </div>
                  </div>
            
            <script>
                
                function confirmarExclusao(IdImagem) {
                console.log("Sucesso!" , IdImagem);
                $("#idImagem").html(IdImagem);
                $("#modal1").show();
            }
            
            function fecharModal(){
                $(".modal").hide();
            }
            
            function deletarImagem() {
                var idImagem = $("#idImagem").html();
                $("#modal1").hide();
                //Chamada AJAX para o servlet
                $.ajax({
                    method: "GET",
                    url: "ExcluirImagem?idImagem="+idImagem
                })
                .done(function( msg ) {
                   location.reload();
                });
            }
                
                
             </script>
             
            <div class="modal" tabindex="-1" id="modal1">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <h5 class="modal-title">Confirmar Exclusão</h5>
                  <button type="button" class="btn-close"
                          data-bs-dismiss="modal" aria-label="Close" onclick="fecharModal()"></button>
                </div>
                <div class="modal-body">
                    <p>Confirmar a exclusão da imagem <label id="idImagem"></label>?</p>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" onclick="fecharModal()">Cancelar</button>
                  <button type="button" class="btn btn-danger" onclick="deletarImagem()">Confirmar</button>
                </div>
              </div>
            </div>
          </div>
             <br>
             
             <legend  class="w-auto legend">
                            <div class="container">
                                <h2> Cadastrar novas imagens para o produto</h2>
                                <img src="../img/violao_acustico_folk.png" alt="Amplificador">
                            </div>
                        </legend>
             
                <div class="row">
                        
                         <input type="file" name="file" multiple="multiple" id="file" accept="image/*"><br><br>
       
                </div>
                
                <div class="row">
                        <div class="col-sm">
                            <button type="submit" class="btn btn-dark form-control form-control-lg h4">Alterar</button>
                        </div>
            
                        <div class="col-sm">
                            <a href="ProdutoServlet"><button type="button" class="btn btn-dark form-control form-control-lg h4">Cancelar</button></a>
                        </div>
                </div>
            </fieldset>
        </div>
 </form> 

        </c:if>
    </body>
</html>

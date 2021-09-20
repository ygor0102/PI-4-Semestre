<%-- 
    Document   : Menu
    Created on : 15/09/2021, 20:32:33
    Author     : ygor.oliveira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" />
            <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js"></script>
        <title>Menu de navegação</title>
    </head>
    <body>
       <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
            </button>
                <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="../Protegido/index.jsp">Página principal <span class="sr-only">(atual)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="../Protegido_Admin/CadastroProduto.jsp">Cadastrar Produtos</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="../Protegido_Admin/ProdutoServlet">Gerenciar Produtos</a>
      </li>
    </ul>
  </div>
</nav>
    </body>
</html>

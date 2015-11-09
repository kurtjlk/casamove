<div class="brand">
    <a href="index.jsp">
        <span style="color: white">Casa do Novo e Usado</span>    
    </a>
</div>
<div class="address-bar">O seu produto na casa do cliente</div>
<!-- Navigation -->
<nav class="navbar navbar-default" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <!-- navbar-brand is hidden on larger screens, but visible when the menu is collapsed -->
            <a class="navbar-brand" href="index.jsp">Business Casual</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a href="index.jsp">Inicio</a>
                </li>
                <li>
                    <a href="novos">Novos</a>
                </li>
                <li>
                    <a href="usados">Usados</a>
                </li>

                <c:choose>
                    <c:when test="${sessionScope.usuarioLogado}">
                        <li>
                            <a href="geral?do=MinhaConta"><span style="font-weight: bold;">${sessionScope.usuarioNome}</span></a>
                        </li>
                        <li>
                            <a href="autenticacao?act=sair"><span style="color:tomato ">Sair</span></a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li>
                            <a href="cadastroUsuario.jsp">Cadastro</a>
                        </li>
                        <li>
                            <a href="login.jsp">Login</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

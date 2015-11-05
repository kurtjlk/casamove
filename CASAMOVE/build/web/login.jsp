<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty sessionScope.usuarioLogado}">
    <c:redirect url="geral"/>
</c:if>
<%@include file="includes/verificaJavaScript.jsp" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <%@include file="includes/head.jsp" %>
    </head>
    <body onLoad="document.forms.login.usuario.focus()">

        <!-- end #header -->
        <div id="wrapper">
            <%@include file="includes/menu.jsp" %>
            <!-- end #menu -->

            <div class="container">

                <div class="row">
                    <div class="box">
                        <div class="col-lg-12">
                            <hr>
                                <h2 class="intro-text text-center">
                                    <strong>Login</strong>
                                    <p class="meta">Preencha os campos com seus dados corretamente.</p>
                                </h2>
                                <hr>
                                    <c:if test="${param.success == 0}">
                                        <div id="alerta" style="display:block;">Usuário ou senha inválidos. Verifique.</div>
                                    </c:if>
                                    <div style="clear: both;"></div>

                                    <form name="login" action="autenticacao?act=login" method="post" role="form">
                                        <div class="row">

                                            <div class="form-group col-lg-4">
                                                <label>Usuário</label>
                                                <input type="text" name="usuario" class="form-control">
                                            </div>
                                            <div class="form-group col-lg-4">
                                                <label>Senha</label>
                                                <input type="password" name="senha" class="form-control">
                                            </div>

                                            <div class="form-group col-lg-12">
                                                <!--<input type="hidden" name="save" value="contact">-->
                                                <input type="submit" class="btn btn-default" value="Enviar"/>
                                            </div>
                                        </div>
                                    </form>
                                    </div>
                                    </div>
                                    </div>

                                    </div>
                                    <!-- /.container -->

                                    <div style="clear: both;">&nbsp;</div>

                                    <!-- begins #sidebar -->
                                    <!-- end #sidebar -->

                                    <div style="clear: both;">&nbsp;</div>
                                    <div style="clear: both;">&nbsp;</div>
                                    </div>  
                                    <!-- end #page -->

                                    <!-- begins #footer -->
                                    <%@include file="includes/footer.jsp" %>
                                    <!-- end #footer -->
                                    </body>
                                    </html>

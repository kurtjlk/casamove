<%@page import="java.util.List"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../includes/verificaLogin.jsp" %>
<%@include file="../includes/verificaJavaScript.jsp" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <%@include file="../includes/head.jsp" %>
        <script type="text/javascript">

            function verificaDadosAlteraSenha(form) {

                if (form.senhaAtual.value.length < 4) {
                    alerta("Sua senha atual contém no mínimo 4 caracteres.");
                    form.senhaAtual.focus();
                    return false;
                }
                if (form.novaSenha.value.length < 4) {
                    alerta("Sua nova senha deve conter no mínimo 4 caracteres.");
                    form.novaSenha.focus();
                    return false;
                }
                if (form.confirmaNovaSenha.value === "") {
                    alerta("Confime sua nova senha.");
                    form.confirmaNovaSenha.focus();
                    return false;
                }

                if (form.confirmaNovaSenha.value !== form.novaSenha.value) {
                    alerta("Senhas diferentes, confirme sua senha.");
                    form.confirmaNovaSenha.value = "";
                    form.confirmaNovaSenha.focus();
                    return false;
                }

                return true;
            }

            function alerta(mensagem) {
                aviso = document.getElementById("alerta");
                aviso.innerHTML = mensagem;
                aviso.style.display = 'block';
            }

        </script>
    </head>
    <body>

        <div id="wrapper">
            <%@include file="../includes/menu.jsp" %>

            <div style="clear: both;"></div>


            <div class="container">
                <div class="row">
                    <div class="box">
                        <div class="col-lg-12">
                            <div id="page">

                                <!-- begins #content -->
                                <div id="content">

                                    <h2 class="title"><a href="#">Alterar Senha</a></h2>
                                    <p class="meta">Altere sua senha.</p>
                                    <div style="clear: both;"></div>
                                    <c:choose>
                                        <c:when test="${param.sucesso == 'sim'}">
                                            <p>Senha alterada com sucesso!</p>
                                            <span class="ok" alt="Ok!"></span>
                                            <a href="index.jsp">Ir para a Página Inicial</a>
                                        </c:when>
                                        <c:otherwise>
                                            <c:if test="${param.sucesso == 'nao'}">
                                                <div id="alerta" style="display: block;">Senha atual inválida! Verifique.</div>
                                            </c:if>
                                            <div id="form">
                                                <form action="geral?do=AlterarSenha&act=post" method="post" onsubmit="return verificaDadosAlteraSenha(this);" >
                                                    <div id="alerta"></div>
                                                    <span>Senha Atual</span>
                                                    <input name="senhaAtual" type="password"/>
                                                    <div style="clear: both;">&nbsp;</div>

                                                    <span>Nova Senha:</span>
                                                    <input name="novaSenha" type="password"/>
                                                    <div style="clear: both;">&nbsp;</div>

                                                    <span>Confirme nova senha:</span>
                                                    <input name="confirmaNovaSenha" type="password"/>
                                                    <div style="clear: both;">&nbsp;</div>

                                                    <input type="reset" value="Limpar campos" class="button"/>
                                                    <input type="submit" value="Salvar" class="button"/>
                                                </form>
                                            </div>
                                        </c:otherwise>
                                    </c:choose>

                                </div>
                            </div>
                            <div style="clear: both;">&nbsp;</div>
                        </div>

                        <!-- end #content -->

                        <div style="clear: both;">&nbsp;</div>
                    </div>  
                    <!-- end #page -->

                    <!-- begins #footer -->
                    <%@include file="../includes/footer.jsp" %>
                    <!-- end #footer -->
                    </body>
                    </html>
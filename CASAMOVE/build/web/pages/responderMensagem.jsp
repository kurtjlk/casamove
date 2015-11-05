<%@page import="java.util.List"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../includes/verificaLogin.jsp" %>
<%@include file="../includes/verificaJavaScript.jsp" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <%@include file="../includes/head.jsp" %>
        <script type="text/javascript" src="http://cidades-estados-js.googlecode.com/files/cidades-estados-v0.2.js"></script>
        <script type="text/javascript" src="js/verificaDados.js"></script>
    </head>
    <body>

        <div id="wrapper">
            <%@include file="../includes/menu.jsp" %>
            <!-- end #menu -->
        </div>
        <div style="clear: both;"></div>
        <div class="container">
            <div class="row">
                <div class="box">
                    <div class="col-lg-12">
                        <div id="page">

                            <!-- begins #content -->
                            <div id="content">

                                <h2 class="title"><a href="#">Respondendo cliente</a></h2>
                                <!--  <p class="meta">Responder Mensagem</p>-->
                                <div style="clear: both;"></div>
                                <c:choose>
                                    <c:when test="${param.success == '1'}">
                                        <p>Salvo com sucesso!</p>
                                        <span class="ok" alt="Ok!"></span>
                                        <a href="index.jsp">Ir para a Página Inicial</a>
                                    </c:when>
                                    <c:otherwise>
                                        <div id="form">
                                            <div id="alerta"></div>
                                            <span>Cliente: </span>${mensagem.nomeRemetente}<br/>
                                            <span>Email: </span>${mensagem.emailRemetente}<br/>
                                            <label for="msgcliente">Pergunta: </label> ${mensagem.texto}
                                            <div style="clear: both;">&nbsp;</div>
                                            <form action="EnviarEmail?act=enviar" method="post">
                                                <label for="resposta">Resposta:
                                                    <br/>
                                                    <input type="hidden" name="codigo" value="${mensagem.codigo}"/>
                                                    <textarea name="resposta" id="resposta" required maxlength="1999" rows="7" cols="120">${usuario.sobre}</textarea>
                                                </label>
                                                <div style="clear: both;"></div>

                                                <input type="reset" value="Desfazer" class="button"/>
                                                <input type="submit" value="Enviar" class="button"/>
                                            </form>

                                        </c:otherwise>
                                    </c:choose>
                                    <div style="clear: both;">&nbsp;</div>

                                </div>
                                <!-- end #content -->

                            </div>
                        </div>
                    </div>
                    <div style="clear: both;">&nbsp;</div>
                    <div style="clear: both;">&nbsp;</div>
                </div>  
                <!-- end #page -->
            </div>
        </div>
        <!-- begins #footer -->
        <%@include file="../includes/footer.jsp" %>
        <!-- end #footer -->
    </body>
</html>



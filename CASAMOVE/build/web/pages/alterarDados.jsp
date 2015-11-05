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
        <script type="text/javascript">
            window.onload = function () {
                new dgCidadesEstados(document.getElementById('estado'), document.getElementById('cidade'), true);
            };
        </script>
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

                                <h2 class="title"><a href="#">Alterar Dados</a></h2>
                                <p class="meta">Edite seus dados cadastrais.</p>
                                <div style="clear: both;"></div>
                                <c:choose>
                                    <c:when test="${param.success == '1'}">
                                        <p>Salvo com sucesso!</p>
                                        <span class="ok" alt="Ok!"></span>
                                        <a href="index.jsp">Ir para a Página Inicial</a>
                                    </c:when>
                                    <c:otherwise>
                                        <div id="form">
                                            <form action="geral?do=AlterarDados&act=post" method="post" onsubmit="return verificaDadosAlteraCadastro(this);" >
                                                <div id="alerta"></div>
                                                <span>Razão Social:</span>
                                                <input name="nome" value="${usuario.nome}" required/>
                                                <div style="clear: both;">&nbsp;</div>

                                                <span>Nome fantasia:</span>
                                                <input type="text" name="fantasia" value="${usuario.fantasia}"required/>
                                                <div style="clear: both;">&nbsp;</div>

                                                <span>CNPJ:</span>
                                                <input type="text" id="icnpj" value="${usuario.cnpj}" name="cnpj" onkeypress="mascara(this, vcnpj)" maxlength="18" required pattern=".{18,18}" required title="Preencha todos os números corretamente"/>
                                                <div style="clear: both;">&nbsp;</div>

                                                <span>Email:</span>
                                                <input name="email" value="${usuario.email}"required/>
                                                <div style="clear: both;">&nbsp;</div>

                                                <span>Endereço:</span>
                                                <input name="endereco" value="${usuario.endereco}"required/>
                                                <div style="clear: both;">&nbsp;</div>

                                                <label for="estado">Estado:
                                                    <br/>
                                                    <select name="estado" id="estado"required>
                                                        <option value="${usuario.endereco}">${usuario.estado}</option>
                                                    </select>
                                                </label>
                                                <div style="clear: both;"></div>

                                                <label for="cidade">Cidade:</label>
                                                <br/>
                                                <select name="cidade" id="cidade"required>
                                                    <option value="${usuario.cidade}">${usuario.cidade}</option>
                                                </select>
                                                <div style="clear: both;">&nbsp;</div>

                                                <label for="isobre">Sobre a Empresa:*
                                                    <br/>
                                                    <textarea name="sobre" id="isobre" required maxlength="1999" rows="10" cols="70">${usuario.sobre}</textarea>
                                                </label>
                                                <div style="clear: both;"></div>

                                                <input type="reset" value="Desfazer" class="button"/>
                                                <input type="submit" value="Salvar" class="button"/>
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

                <!-- begins #footer -->
                <%@include file="../includes/footer.jsp" %>
                <!-- end #footer -->
                </body>
                </html>



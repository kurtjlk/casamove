<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%  /*
     <c:if test="${not empty sessionScope.usuarioLogado}">
     <c:redirect url="index.jsp"/>
     </c:if>
     <%@include file="includes/verificaJavaScript.jsp" 
     */
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <%@include file="includes/head.jsp" %>
        <script type="text/javascript" src="js/verificaDados.js"></script>
        <script type="text/javascript" charset="utf-8">
            window.onload = function () {
                new dgCidadesEstados(document.getElementById('estado'), document.getElementById('cidade'), true);
                document.forms.cadastro.nome.focus();
            };
             
        </script>

        <script type="text/javascript" src="http://cidades-estados-js.googlecode.com/files/cidades-estados-v0.2.js"></script>

    </head>
    <body>
        <!-- end #header -->
        <div id="wrapper">
            <%@include file="includes/menu.jsp" %>
            <!-- end #menu -->
            <div style="clear: both;"></div>

            <div class="container">
                <div class="row">
                    <div class="box">
                        <div class="col-lg-12">
                            <hr>
                                <h2 class="intro-text text-center">
                                    <strong>Formulario de cadastro</strong>
                                    <br>     Somente Pessoas juridica podem se cadastrar
                                </h2>
                                <hr>
                                    <c:choose>
                                        <c:when test="${param.success == '1'}">
                                            <p>Enviado com sucesso. Obrigado, Seu cadastro foi realizado!</p>
                                            <p>Você já está cadastrado, <a href="autenticacao">clique aqui para entrar.</a></p>
                                        </c:when>
                                        <c:when test="${param.success == '0'}">
                                            <p>Ops! Ouve uma falha no cadastro!</p>
                                            <p>Por Favor tente novamente mais tarde. Obrigado.</p>
                                            <a href="index.jsp">Ir para a Página Inicial</a>
                                        </c:when>
                                        <c:otherwise>
                                            <p class="meta">Preencha <strong>todos</strong> os campos com seus dados corretamente.</p>
                                            <div style="clear: both;"></div>


                                            <div id="form">
                                                <form role="form" name="cadastro" action="cadastro?act=cadastrar" method="post" onsubmit="return verificaDadosCadastro(this);">
                                                    <div id="alerta"></div>

                                                    <label for="inome">Razão Social:*
                                                        <br/>
                                                        <input type="text" name="nome" id="inome" required/>
                                                    </label>
                                                    <div style="clear: both;"></div>

                                                    <label for="ifantasia">Nome Fantasia:
                                                        <br/>
                                                        <input type="text" name="fantasia" id="ifantasia"/>
                                                    </label>
                                                    <div style="clear: both;"></div>

                                                    <label for="icnpj">CNPJ(somente números):*
                                                        <br/>
                                                        <input type="text" id="icnpj" name="cnpj" onkeypress="mascara(this, vcnpj)" maxlength="18" required pattern=".{18,18}" required title="Preencha todos os números corretamente"/>
                                                    </label>
                                                    <div style="clear: both;"></div>

                                                    <label for="iendereco">Endereço:*
                                                        <br/>
                                                        <input name="endereco" type="text" id="iendereco" required/>
                                                    </label>
                                                    <div style="clear: both;"></div>

                                                    <label for="estado">Estado:*
                                                        <br/>
                                                        <select name="estado" id="estado" required></select>
                                                    </label>
                                                    <div style="clear: both;"></div>

                                                    <label for="cidade">Cidade:*</label>
                                                    <br/>
                                                    <select name="cidade" id="cidade" required>
                                                        <option value="">-- Escolha um estado --</option>
                                                    </select>
                                                    <div style="clear: both;">&nbsp;</div>

                                                    <label for="iusuario">Usuário (Para Login):*
                                                        <br/>
                                                        <input type="text" name="usuario" id="iusuario" required/>
                                                    </label>
                                                    <div style="clear: both;"></div>

                                                    <label for="iemail">Email:*
                                                        <br/>
                                                        <input type="email" name="email" id="iemail" required/>
                                                    </label>
                                                    <div style="clear: both;"></div>
                                                    
                                                    
                                                    <label for="isobre">Sobre a Empresa:*
                                                        <br/>
                                                        <textarea name="sobre" id="isobre" required maxlength="1999" placeholder="Descreva sua empresa aqui..." rows="10" cols="70"></textarea>
                                                    </label>
                                                    <div style="clear: both;"></div>
                                                    

                                                    <label for="isenha">Senha:*
                                                        <br/>
                                                        <input name="senha" type="password" id="isenha" required/>
                                                    </label>
                                                    <div style="clear: both;"></div>

                                                    <label for="iconfirmarsenha">Confirmar Senha:*
                                                        <br/>
                                                        <input name="confirmarsenha" type="password" id="iconfirmarsenha" oninput="validaSenha(this)" required/>
                                                    </label>
                                                    <div style="clear: both;">&nbsp;</div>

                                                    <input type="reset" value="Limpar" class="button"/>
                                                    <input type="submit" value="Enviar" class="button"/>
                                                </form>
                                            </div>
                                        </c:otherwise>
                                    </c:choose>
                                    <div style="clear: both;">&nbsp;</div>

                                    <div style="clear: both;">&nbsp;</div>
                                </div>
                            </div>
                        </div>
                    </div> 
                                    <!-- end #page -->

                                    <!-- begins #footer -->
                                    <%@include file="includes/footer.jsp" %>
                                    <!-- end #footer -->
                                    </body>
                                    </html>

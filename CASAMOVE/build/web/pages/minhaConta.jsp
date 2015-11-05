<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../includes/verificaLogin.jsp" %>
<%@include file="../includes/verificaJavaScript.jsp" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <%@include file="../includes/head.jsp" %>
        <meta charset="UTF-8">
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
                            <div class="col-lg-12">
                                <hr>
                                    <h2 class="intro-text text-center">
                                        <strong>Minha Conta</strong>
                                    </h2>
                                    <hr></div>
                                        <div id="content">

                                            <br/>
                                            <div style="clear: both;"></div>

                                            <span>Razao Social:</span>
                                            <strong>${usuario.nome}</strong>
                                            <div style="clear: both;">&nbsp;</div>

                                            <span>Nome Fantasia:</span>
                                            <strong>${usuario.fantasia}</strong>
                                            <div style="clear: both;">&nbsp;</div>

                                            <span>Usuário:</span>
                                            <strong>${usuario.nickname}</strong>
                                            <div style="clear: both;">&nbsp;</div>

                                            <span>Email:</span>
                                            <strong>${usuario.email}</strong>
                                            <div style="clear: both;">&nbsp;</div>

                                            <span>CNPJ:</span>
                                            <strong>${usuario.cnpj}</strong>
                                            <div style="clear: both;">&nbsp;</div>

                                            <span>Endereço:</span>
                                            <strong>${usuario.endereco}</strong>
                                            <div style="clear: both;">&nbsp;</div>

                                            <span>Cidade:</span>
                                            <strong>${usuario.cidade}</strong>
                                            <div style="clear: both;">&nbsp;</div>

                                            <span>Estado:</span>
                                            <strong>${usuario.estado}</strong>
                                            <div style="clear: both;">&nbsp;</div>

                                            <a href="geral?do=AlterarDados"><input style="width: 10% "type="button" value="Alterar dados" class="button"/></a>
                                            <a href="geral?do=AlterarSenha"><input style="width: 10% "type="button" value="Alterar Senha" class="button"/></a>
                                            <br/>
                                            <hr>
                                                <a href="#msgcliente">

                                                    <button style="width: 20%">
                                                        Ir para mensagens
                                                        <img src="img/mail.png"/>
                                                    </button>
                                                </a> 

                                                <div class="col-lg-12">
                                                    <hr>
                                                        <h2 class="intro-text text-center">
                                                            <strong>Meus anúncios</strong>
                                                        </h2>
                                                        <hr>
                                                            </div>
                                                            <div class="box">

                                                                <form action="upload" enctype="multipart/form-data" method="POST">
                                                                    <input type="Submit" value="NOVO PRODUTO"><br/>
                                                                </form>
                                                                <c:choose>
                                                                    <c:when test="${empty listaDeItensByUsuario}">
                                                                        <p>Nenhum produto anunciado.</p>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <c:forEach items="${listaDeItensByUsuario}" var="item">

                                                                            <div id="item" class="col-sm-4 text-center">
                                                                                <a href="detalhesProduto?cod=${item.codigo}">
                                                                                    <img src="data/upload/${item.imagem}" style="height:25%; width: 50%;"/>
                                                                                </a>
                                                                                <br/>${item.titulo} 
                                                                                <br/> <span class="preco">R$ ${item.valor}</span>
                                                                                <a href="geral?do=excluir"><input style="width: 10% "type="button" value="X" class="button" alt="Excluir" /></a>

                                                                            </div>


                                                                        </c:forEach>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </div>
                                                            <br/>
                                                            <div class="col-lg-12">
                                                                <hr>
                                                                    <h2 class="intro-text text-center" id="msgcliente">
                                                                        <strong>Mensagens</strong>
                                                                    </h2>
                                                                    <hr>
                                                                        </div>
                                                                        <div class="box">
                                                                            <c:choose>
                                                                                <c:when test="${empty listaDeMensagensByUsuario}">
                                                                                    <p>Nenhuma mensagem.</p>
                                                                                </c:when>
                                                                                <c:otherwise>
                                                                                    <table style="width:100%">

                                                                                        <tr>
                                                                                            <th>Cliente</th>
                                                                                            <th>Mensagem</th>
                                                                                            <th>Respondida?</th>
                                                                                            <th></th>
                                                                                        </tr>


                                                                                        <c:forEach items="${listaDeMensagensByUsuario}" var="msg">
                                                                                            <tr>
                                                                                                <td>${msg.nomeRemetente}<br/>
                                                                                                    <a href="mailto:${msg.emailRemetente}?subject=Resposta&body=${msg.texto}">${msg.emailRemetente}</a>
                                                                                                </td>
                                                                                                <td>
                                                                                                    ${msg.texto}
                                                                                                </td>
                                                                                                <td>
                                                                                                    <c:if test="${msg.mensagemRespondida == 1}">
                                                                                                        <img src="img/sim.png" alt="SIM" title="SIM">
                                                                                                        </c:if>
                                                                                                        <c:if test="${msg.mensagemRespondida == 0}">
                                                                                                            <img src="img/nao.png" alt="NÃO" title="NÃO">
                                                                                                            </c:if>
                                                                                                            </td>
                                                                                                            <td>
                                                                                                                <a href="ResponderMensagem?id=${msg.codigo}">
                                                                                                                    <button class="show_hide">
                                                                                                                        Responder
                                                                                                                        <img src="img/mail.png"/>
                                                                                                                    </button>
                                                                                                                </a>
                                                                                                            </td>
                                                                                                            </tr>

                                                                                                        </c:forEach>
                                                                                                        </table>

                                                                                                    </c:otherwise>
                                                                                                </c:choose>
                                                                                                </div>
                                                                                                <br/>
                                                                                                <br/>
                                                                                                <a href="#top" class="col-sm-4 text-left" title="Voltar para o topo">

                                                                                                    <button style="width: 20%">
                                                                                                        Voltar ao topo

                                                                                                    </button>
                                                                                                </a>
                                                                                                <div style="clear: both;">&nbsp;</div>

                                                                                                </div>


                                                                                                <!-- end #content -->

                                                                                                </div>
                                                                                                </div>


                                                                                                </div>
                                                                                                <div style="clear: both;">&nbsp;</div>
                                                                                                </div>  
                                                                                                </div>
                                                                                                <!-- end #page -->

                                                                                                <!-- begins #footer -->
                                                                                                <%@include file="../includes/footer.jsp" %>
                                                                                                <!-- end #footer -->
                                                                                                </body>
                                                                                                </html>

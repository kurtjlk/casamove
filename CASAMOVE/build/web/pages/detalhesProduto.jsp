<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../includes/verificaJavaScript.jsp" %>

<!DOCTYPE html>
${warningMessage}
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="UTF-8">
        <%@include file="../includes/head.jsp" %>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js" type="text/javascript"></script>
        <script type="text/javascript">

            $(document).ready(function () {

                $(".slidingDiv").hide();
                $(".show_hide").show();

                $('.show_hide').click(function () {
                    $(".slidingDiv").slideToggle();
                });

            });

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
                            <div class="col-lg-12">
                            <hr>
                                <h2 class="intro-text text-center">
                                    <strong>Detalhes do Produto</strong>
                                </h2>
                                <hr></div>
                            <div id="content">
                                <br/>
                                <div style="clear: both;"></div>
                                <div id="item" class="col-sm-4 text-center">
                                    <img src="data/upload/${item.imagem}" style="height:50%; width: 100%;"/>
                                </div>
                                <div id="item" class="col-sm-4 text-left">
                                    <span>Nome:</span>
                                    <strong>${item.titulo}</strong>
                                    <div style="clear: both;">&nbsp;</div>
                                    <span>Valor:</span>
                                    <strong class="preco">R$ ${item.valor}</strong>
                                    <div style="clear: both;">&nbsp;</div>
                                    <span>Descrição:</span>
                                    <strong>${item.descricao}</strong>
                                    <div style="clear: both;">&nbsp;</div>
                                    <span>
                                        
                                            <c:if test="${item.status == true}">
                                                <strong>Produto Novo</strong>
                                            </c:if>
                                            <c:if test="${item.status == false}">
                                                <strong>Produto Usado</strong>
                                            </c:if>
                                    </span>
                                    <div style="clear: both;">&nbsp;</div>
                                    <span>Anunciado por:</span>
                                    <a href="detalhesEmpresa?cod=${usuario.codigo}"><strong>${usuario.nome}</strong></a>
                                    <div style="clear: both;">&nbsp;</div>
                                    <button class="show_hide">
                                        Entrar em contato
                                        <img src="img/mail.png"/>
                                    </button>
                                    <br/>
                                    <div id="mensagemParaLoja" class="slidingDiv">
                                        <form action="Mensagem" method="post" >
                                            <input type="hidden" name="codigoproduto" value="${item.codigo}"/>
                                            <input type="hidden" name="codigodono" value="${item.codigoDono}"/>
                                            <strong>Nome:</strong> <br/>
                                            <input type="text" name="nomeRemetente" required/><br/>
                                            <strong>Email:</strong> <br/>
                                            <input type="email" name="emailRemetente" required><br/>
                                                <strong>Mensagem:</strong> <br/>
                                                <textarea name="mensagemRemetente" rows="5" cols="50" maxlength="500" wrap="hard" placeholder="Escreva sua mensagem aqui..."></textarea> <br/><br/>
                                                <input type="submit" value="Enviar"/>
                                        </form>
                                    </div>
                                            
                                    <div style="clear: both;">&nbsp;</div>
                                </div>
                            </div>
                            <!-- end #content -->
                        </div>
                    </div>
                </div>
                <div style="clear: both;">&nbsp;</div>
            </div>  
            <!-- end #page -->

            <!-- begins #footer -->
            <%@include file="../includes/footer.jsp" %>
            <!-- end #footer -->
    </body>
</html>

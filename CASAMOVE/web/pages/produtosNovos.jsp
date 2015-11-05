<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../includes/verificaJavaScript.jsp" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <%@include file="../includes/head.jsp" %>
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
                                    <strong>Produtos Novos</strong>
                                    <form method="post" action="busca">
                                        <input type="text" name="termo" placeholder="Procure seu móvel"/>
                                    <input type="submit" value="Buscar" class="button"/>
                                    </form>
                                </h2>
                                <hr></div>
                            <div id="box">
                                
                                <br/>
                                <div style="clear: both;"></div>
                                <c:choose>
                                    <c:when test="${not empty param.listaDeItensNovos}">
                                        <p>Não há nenhum produto cadastrado no site ainda.</p>
                                    </c:when>
                                    <c:otherwise>
                                        <c:forEach items="${listaDeItensNovos}" var="item">
                                            <a href="detalhesProduto?cod=${item.codigo}">
                                                <div id="item" class="col-sm-4 text-center" style="height: 30%;">
                                                    <img src="data/upload/${item.imagem}" style="height: 50%;"/>
                                                    <span style="color:#000"><br/>${item.titulo} <br/></span>
                                                    <span class="preco">Por:R$ ${item.valor}</span>
                                                  
                                                </div>
                                            </a>
                                        </c:forEach>
                                    </c:otherwise>
                                </c:choose>
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

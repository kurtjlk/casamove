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
                            <div id="content">
                                <h2 class="title"><a href="#">Detalhes do Anunciante</a></h2>
                                <br/>
                                <div style="clear: both;"></div>
                                <div id="item" class="col-sm-4 text-left">
                                    <span>Nome:</span>
                                    <strong>${usuario.nome}</strong>
                                    <br/><br/>
                                    <span>Endereço:</span>
                                    <strong>${usuario.endereco} - ${usuario.cidade} - ${usuario.estado}</strong>
                                    <br/><br/>
                                    <span>Sobre:</span>
                                    <strong>${usuario.sobre}</strong>
                                </div>
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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../includes/verificaLogin.jsp" %>
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
                                <h2 class="title"><a href="#">Novo Produto</a></h2>
                                <br/>
                                <div style="clear: both;"></div>


                                <div id="form">
                                    <form action="upload?act=addItem" enctype="multipart/form-data" method="POST" role="form" name="cadastro">
                                        <div id="alerta"></div>

                                        <label for="iimagem">Imagem do Produto
                                            <br/>
                                            <input type="file" name="imagem" id="iimagem" accept="image/*" required/>
                                        </label>
                                        <div style="clear: both;"></div>
                                        <label for="inomeitem">Título do item:
                                            <br/>
                                            <input type="text" id="inomeitem" name="tituloitem" required/>
                                        </label>
                                        <div style="clear: both;"></div>
                                        <label for="idescricao">Descrição:
                                            <br/>
                                            <textarea name="descricaoitem" type="text" id="idescricao" rows="7" cols="60" required/></textarea>
                                        </label>
                                      <br/>  <label for="ivalor">Valor:
                                            <br/>
                                            <input type="text" name="valoritem" id="ivalor"  required/>
                                        </label>
                                        <label for="istatus">
                                            <br/>
                                                <input type="checkbox" name="status" value="status" id="istatus" required>Produto usado.
                                        </label>
                                        <div style="clear: both;"></div>
                                        <div style="clear: both;"></div>
                                        <input type="reset" value="Limpar" class="button" style="background-color:tomato ; color:white;font-weight: bold; "/>
                                        <input type="submit" value="Enviar" class="button" style="background-color:darkblue; color:white;font-weight: bold; "/>
                                    </form>

                                    <div style="clear: both;">&nbsp;</div>
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

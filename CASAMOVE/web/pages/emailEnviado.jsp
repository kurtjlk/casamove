<%@page import="java.util.List"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../includes/verificaLogin.jsp" %>
<%@include file="../includes/verificaJavaScript.jsp" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <%@include file="../includes/head.jsp" %>
        <script type="text/javascript">
            alert("Resposta enviada com sucesso!");
            window.location="geral?do=MinhaConta"; 
        </script>
    </head>
    <body>

    </body>
</html>



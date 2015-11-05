<html>
    <head>
        <title>Saída de Exceção</title>
    </head>
    <body>
        <p>Exceção</p>
        <%
            out.write("<br/>" + session.getAttribute("excecao"));
        %>
    </body>
</html>
<c:if test="${empty sessionScope.usuarioLogado}">
    <c:redirect url="autenticacao"/>
</c:if>
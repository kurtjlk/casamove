package control.command;

//import dao.DenunciaDAO;
import dao.UsuarioDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;

public class AlterarSenha implements control.command.Comando {

    public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        if (request.getParameter("act") == null) {
            request.getRequestDispatcher("pages/alterarSenha.jsp").forward(request, response);

        } else {
            if (request.getParameter("act").equals("post")) {

                HttpSession session = request.getSession();
                int codigo = Integer.parseInt(session.getAttribute("usuarioCodigo").toString());

                UsuarioDAO usuarioDAO = new UsuarioDAO();
                Usuario novoUsuario = usuarioDAO.getUsuarioById(codigo);

                String novaSenha = request.getParameter("novaSenha");
                String confirmaNovaSenha = request.getParameter("confirmaNovaSenha");
                String senhaAtual = request.getParameter("senhaAtual");

                if (senhaAtual.equals(novoUsuario.getSenha())) {
                    if (novaSenha.equals(confirmaNovaSenha)) {
                        novoUsuario.setSenha(novaSenha);
                        usuarioDAO.alterarSenhaDoUsuario(novoUsuario, codigo);
                        request.getRequestDispatcher("pages/alterarSenha.jsp?sucesso=sim").forward(request, response);
                    } else {
                        request.getRequestDispatcher("pages/alterarSenha.jsp?sucesso=nao").forward(request, response);
                    }
                } else {
                    request.getRequestDispatcher("pages/alterarSenha.jsp?sucesso=nao").forward(request, response);
                }

            } else {
                request.getRequestDispatcher("error/404error.jsp").forward(request, response);
            }
        }
    }
}

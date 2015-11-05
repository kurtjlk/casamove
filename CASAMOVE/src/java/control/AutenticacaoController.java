package control;

import dao.UsuarioDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;

public class AutenticacaoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();

        if (request.getParameter("act") == null) {
            if (session.getAttribute("usuarioLogado") != null && (Boolean) session.getAttribute("usuarioLogado") != true) {
                response.sendRedirect("geral");
            } else {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else {
            if (request.getParameter("act").equals("login")) {
                logarUsuario(request, response);
            } else {
                if (request.getParameter("act").equals("sair")) {
                    desconectarUsuario(request, response);
                } else {
                    request.getRequestDispatcher("error/404error.jsp").forward(request, response);
                }

            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void logarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");

        try {
            HttpSession session = request.getSession();
            //Connection conexao = (Connection) request.getAttribute("conexaoBanco");

            UsuarioDAO novoUsuarioDAO = new UsuarioDAO();
            List listaDeUsuarios = novoUsuarioDAO.getListaDeUsuarios();

            int logado = 0;
           for (Object listaDeUsuario : listaDeUsuarios) {
               Usuario umUsuario = (Usuario) listaDeUsuario;
               String usuarioBanco = umUsuario.getNickname();
               String senhaBanco = umUsuario.getSenha();
               if (usuario.equals(usuarioBanco) && senha.equals(senhaBanco)) {
                   
                   session.setAttribute("usuarioLogado", true);
                   session.setAttribute("usuarioNome", umUsuario.getNome());
                   session.setAttribute("usuarioNickname", umUsuario.getNickname());
                   session.setAttribute("usuarioCodigo", umUsuario.getCodigo());
                   
                   logado = 1;
                   request.setAttribute("comando", "fez Login");
                   response.sendRedirect("index.jsp");
                   
                   break;
                   
               }
           }

            if (logado == 0) {
                request.getRequestDispatcher("login.jsp?success=0").forward(request, response);
            }

        } catch (Exception ex) {
            request.getRequestDispatcher("login.jsp?success=0").forward(request, response);
        }

    }

    private void desconectarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("autenticacao");
    }
}

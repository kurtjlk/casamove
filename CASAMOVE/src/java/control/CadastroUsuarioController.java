package control;

import dao.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

public class CadastroUsuarioController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        if (request.getParameter("act") == null) {
            request.getRequestDispatcher("cadastroUsuario.jsp").forward(request, response);
        } else {
            if (request.getParameter("act").equals("cadastrar")) {
                cadastraUsuario(request, response);
            } else {
                request.getRequestDispatcher("error/404error.jsp").forward(request, response);
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

    private void cadastraUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String fantasia = request.getParameter("fantasia");
        String usuario = request.getParameter("usuario");
        String email = request.getParameter("email");
        String cnpj = request.getParameter("cnpj");
        String endereco = request.getParameter("endereco");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String senha = request.getParameter("senha");
        String sobre = request.getParameter("sobre");

        try {
            Usuario novoUsuario = new Usuario(nome, fantasia, usuario, email, cnpj, endereco, cidade, estado, senha, sobre);
            UsuarioDAO novoUsuarioDAO = new UsuarioDAO();
            novoUsuarioDAO.novoUsuario(novoUsuario);
            
        } catch (Exception ex) {
            request.getRequestDispatcher("cadastroUsuario.jsp?success=0").forward(request, response);
        }
        request.getRequestDispatcher("cadastroUsuario.jsp?success=1").forward(request, response);

    }
}

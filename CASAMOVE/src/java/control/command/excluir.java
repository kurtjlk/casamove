package control.command;


import dao.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;

public class excluir implements control.command.Comando {

    public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        if (request.getParameter("act") == null) {

            HttpSession session = request.getSession();
            int codigo = Integer.parseInt(session.getAttribute("usuarioCodigo").toString());

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario novoUsuario = usuarioDAO.getUsuarioById(codigo);

            request.setAttribute("usuario", novoUsuario);
            request.getRequestDispatcher("pages/alterarDados.jsp").forward(request, response);
            
        } else {
            if (request.getParameter("act").equals("post")) {
                atualizaUsuario(request, response);
            } else {
                request.getRequestDispatcher("error/404error.jsp").forward(request, response);
            }
        }
    }

    // Processa 
    private void atualizaUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();

        int codigo = Integer.parseInt(session.getAttribute("usuarioCodigo").toString());
        String nome = request.getParameter("nome");
        String fantasia = request.getParameter("fantasia");
        String cnpj = request.getParameter("cnpj");
        String email = request.getParameter("email");
        String endereco = request.getParameter("endereco");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String sobre = request.getParameter("sobre");
        

        try {
            Usuario novoUsuario = new Usuario();
            
            novoUsuario.setNome(nome);
            novoUsuario.setFantasia(fantasia);
            novoUsuario.setCnpj(cnpj);
            novoUsuario.setEmail(email);
            novoUsuario.setEndereco(endereco);
            novoUsuario.setCidade(cidade);
            novoUsuario.setEstado(estado);
            novoUsuario.setSobre(sobre);
            
            UsuarioDAO novoUsuarioDAO = new UsuarioDAO();
            
            novoUsuarioDAO.alterarUsuario(novoUsuario, codigo);
            
        } catch (Exception ex) {
            request.getRequestDispatcher("error/500error.jsp").forward(request, response);
        }
        request.getRequestDispatcher("pages/alterarDados.jsp?success=1").forward(request, response);
        
        
    }
}


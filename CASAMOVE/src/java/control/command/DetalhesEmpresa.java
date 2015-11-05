package control.command;

import dao.ItemDAO;
import dao.UsuarioDAO;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Item;
import model.Usuario;

public class DetalhesEmpresa extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {

            if (request.getParameter("cod") == null) {
                request.getRequestDispatcher("geral").forward(request, response);

            } else {
                int codigo = Integer.parseInt(request.getParameter("cod"));

                //ESSE BLOCO CAPTURA OS ITEMS QUE O USUARIO TEM CADASTRADOS
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                Usuario usuario = usuarioDAO.getUsuarioById(codigo);

                request.setAttribute("usuario", usuario);

                request.getRequestDispatcher("pages/detalhesEmpresa.jsp").forward(request, response);

            }

        } catch (Exception e) {
            DebugException.capturaErro(e, request, response);
        }
    }

}

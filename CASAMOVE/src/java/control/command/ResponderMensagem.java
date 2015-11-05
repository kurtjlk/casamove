package control.command;

import dao.MensagemDAO;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import model.Mensagem;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponderMensagem extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            if (request.getParameter("id") == null) {
                request.getRequestDispatcher("error/404error.jsp").forward(request, response);
            } else {
                int codigoMensagem = Integer.parseInt(request.getParameter("id"));
                MensagemDAO mensagemDAO = new MensagemDAO();
                Mensagem umaMensagem = mensagemDAO.getMensagemByCodigo(codigoMensagem);
                request.setAttribute("mensagem", umaMensagem);
                request.getRequestDispatcher("pages/responderMensagem.jsp").forward(request, response);
            }
    
        } catch (Exception ex) {
            DebugException.capturaErro(ex, request, response);
        }
    }

}

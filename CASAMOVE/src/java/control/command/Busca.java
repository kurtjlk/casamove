package control.command;

import dao.ItemDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Busca extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            buscaPorTermo(request, response);
        } catch (Exception ex) {
            DebugException.capturaErro(ex, request, response);
        }
    }

    public void buscaPorTermo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {

        response.setContentType("text/html;charset=UTF-8");
        
        String termo = request.getParameter("termo");
        request.setAttribute("termo", termo);
        ItemDAO itemDAO = new ItemDAO();
        List items = null;
        try {
            try {
                items = (List) itemDAO.getListBusca(termo);
            } catch (Exception ex) {
                
                DebugException.capturaErro(ex, request, response);
            }
            request.setAttribute("listaDeBusca", items);

        } catch (IOException ex) {
            request.getRequestDispatcher("error/500error.jsp").forward(request, response);
        }

        //E AQUI DESPACHA PRA JSP
        request.getRequestDispatcher("pages/mostraResultados.jsp").forward(request, response);

    }
}

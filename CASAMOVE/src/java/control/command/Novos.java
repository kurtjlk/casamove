package control.command;

import dao.ItemDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Novos extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            buscaNovosProdutos(request, response);
        } catch (Exception ex) {
            DebugException.capturaErro(ex, request, response);
        }
    }
    

    public void buscaNovosProdutos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {

        response.setContentType("text/html;charset=UTF-8");

        //ESSE BLOCO CAPTURA OS ITEMS QUE O USUARIO TEM CADASTRADOS
        ItemDAO itemDAO = new ItemDAO();
        List items = null;
        try {
            try {
                items = (List) itemDAO.getListaDeItensNovos();
            } catch (Exception ex) {
                //Logger.getLogger(MinhaConta.class.getName()).log(Level.SEVERE, null, ex);
                DebugException.capturaErro(ex, request, response);
            }
            request.setAttribute("listaDeItensNovos", items);

        } catch (IOException ex) {
            request.getRequestDispatcher("error/500error.jsp").forward(request, response);
        }

        //E AQUI DESPACHA PRA JSP
        request.getRequestDispatcher("pages/produtosNovos.jsp").forward(request, response);

    }
}

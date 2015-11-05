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

public class DetalhesProduto extends HttpServlet {
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            detalhaProduto(request, response);
        } catch (Exception ex) {
            DebugException.capturaErro(ex, request, response);
        }
    }
    
    public void detalhaProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        
        response.setContentType("text/html;charset=UTF-8");
        try {
            
            if (request.getParameter("cod") == null) {
                request.getRequestDispatcher("geral").forward(request, response);
                
            } else {
                int codigo = Integer.parseInt(request.getParameter("cod"));

                //ESSE BLOCO CAPTURA OS ITEMS QUE O USUARIO TEM CADASTRADOS
                ItemDAO itemDAO = new ItemDAO();
                Item item = itemDAO.getItemByCodigo(codigo);
                
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                Usuario usuario = usuarioDAO.getUsuarioById(item.getCodigoDono());
                
                request.setAttribute("item", item);
                request.setAttribute("usuario", usuario);

            //request.getRequestDispatcher("error/500error.jsp").forward(request, response);
                //E AQUI DESPACHA PRA JSP
                request.getRequestDispatcher("pages/detalhesProduto.jsp").forward(request, response);
                
            }
            
        } catch (Exception e) {
            DebugException.capturaErro(e, request, response);
        }
    }
}

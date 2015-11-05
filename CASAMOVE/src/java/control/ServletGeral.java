package control;

import control.command.Comando;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletGeral extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String comandoPorGet = request.getParameter("do");

        if (comandoPorGet == null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

        String nomeDaClasse = "control.command." + comandoPorGet;

        try {
            Comando comando = (Comando) Class.forName(nomeDaClasse).newInstance();
            comando.executa(request, response);

        } catch (Exception ex) {
            //ex.printStackTrace(out);
            request.getRequestDispatcher("pages/404error.jsp").forward(request, response);
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
    }
}

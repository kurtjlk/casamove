package control.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Inicio implements control.command.Comando {

    public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}

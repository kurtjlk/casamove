package control.command;

import dao.ItemDAO;
import dao.MensagemDAO;
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
import model.Mensagem;
import model.Usuario;

public class MensagemContato extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            if (request.getParameter("codigoproduto") == null) {
                request.getRequestDispatcher("geral").forward(request, response);

            } else {
                int codigoDoProduto = Integer.parseInt(request.getParameter("codigoproduto"));
                int codigoDono = Integer.parseInt(request.getParameter("codigodono"));
                String nome = request.getParameter("nomeRemetente");
                String email = request.getParameter("emailRemetente");
                String texto = request.getParameter("mensagemRemetente");

                Mensagem msg = new Mensagem();
                msg.setCodigoItem(codigoDoProduto);
                msg.setNomeRemetente(nome);
                msg.setEmailRemetente(email);
                msg.setCodigoDono(codigoDono);
                msg.setTexto(texto);

                MensagemDAO msgDAO = new MensagemDAO();
                msgDAO.novaMensagem(msg);

                //Aqui dá a mensagem de sucesso com javascript e redireciona
                request.setAttribute("warningMessage", "<script type=\"text/javascript\"> \n"
                        + "\n"
                        + "alert(\"Enviada com sucesso! Aguarde a resposta da Loja.\"); \n"
                        + "window.location.href = \"detalhesProduto?cod="
                        + codigoDoProduto
                        + "\"; \n"
                        + "\n"
                        + "</script>");

                //E AQUI DESPACHA PRA JSP
                request.getRequestDispatcher("pages/detalhesProduto.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            DebugException.capturaErro(ex, request, response);
        }
    }

}

package control.command;

import dao.ItemDAO;
import dao.MensagemDAO;
import dao.UsuarioDAO;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;

public class MinhaConta implements control.command.Comando {

    public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //ESSE BLOCO CAPTURA O USUARIO
        HttpSession session = request.getSession();
        int codigo = Integer.parseInt(session.getAttribute("usuarioCodigo").toString());
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario novoUsuario = usuarioDAO.getUsuarioById(codigo);
        request.setAttribute("usuario", novoUsuario);

        //ESSE BLOCO CAPTURA OS ITEMS QUE O USUARIO TEM CADASTRADOS
        ItemDAO itemDAO = new ItemDAO();
        MensagemDAO msgDAO = new MensagemDAO();
        List items = null;
        List msgs = null;
        try {
            try {
                items = (List) itemDAO.getListaDeItensByUsuario(codigo);
                request.setAttribute("listaDeItensByUsuario", items);
            } catch (Exception ex) {
                //Logger.getLogger(MinhaConta.class.getName()).log(Level.SEVERE, null, ex);
                DebugException.capturaErro(ex, request, response);
            }

            try {
                msgs = (List) msgDAO.getListaDeMensagensByUsuario(codigo);
                request.setAttribute("listaDeMensagensByUsuario", msgs);
            } catch (Exception ex) {
                //Logger.getLogger(MinhaConta.class.getName()).log(Level.SEVERE, null, ex);
                DebugException.capturaErro(ex, request, response);
            }

        } catch (IOException ex) {
            request.getRequestDispatcher("error/500error.jsp").forward(request, response);
        }

        //E AQUI DESPACHA PRA JSP
        request.getRequestDispatcher("pages/minhaConta.jsp").forward(request, response);

    }
}

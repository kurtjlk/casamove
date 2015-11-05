package control.command;

import dao.MensagemDAO;
import dao.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import model.Mensagem;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
public class EnviarEmail extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            if (request.getParameter("act") == null) {
                request.getRequestDispatcher("error/404error.jsp").forward(request, response);
            }             else {
                int codigoMensagem = Integer.parseInt(request.getParameter("codigo"));
                String respostaMensagem = request.getParameter("resposta");

                MensagemDAO mensagemDAO = new MensagemDAO();
                Mensagem umaMensagem = mensagemDAO.getMensagemByCodigo(codigoMensagem);
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                Usuario usuarioDono = usuarioDAO.getUsuarioById(umaMensagem.getCodigoDono());
                

                sendEmail(codigoMensagem, umaMensagem, respostaMensagem, usuarioDono);
                
                mensagemDAO.marcarComoRespondida(codigoMensagem);
                request.getRequestDispatcher("pages/emailEnviado.jsp").forward(request, response);
            }

        } catch (Exception ex) {
            DebugException.capturaErro(ex, request, response);
        }
    }

    public void sendEmail(int codigoMensagem, Mensagem umaMensagem, String respostaMensagem, Usuario usuarioDono) throws EmailException {
        SimpleEmail email = new SimpleEmail();
        //Utilize o hostname do seu provedor de email
        //System.out.println("alterando hostname...");
        email.setHostName("mail.mzgweb.com.br");
        //Quando a porta utilizada não é a padrão (gmail = 465)
        email.setSmtpPort(587);
        //Adicione os destinatários
        email.addTo(umaMensagem.getEmailRemetente(), umaMensagem.getNomeRemetente());
        //Configure o seu email do qual enviará
        email.setFrom(usuarioDono.getEmail(), usuarioDono.getNome());
        //Adicione um assunto
        email.setSubject("Resposta para sua mensagem no CASA DO NOVO E USADO");
        //Adicione a mensagem do email
        email.setMsg(respostaMensagem);
        //Para autenticar no servidor é necessário chamar os dois métodos abaixo
        //System.out.println("autenticando...");
        email.setSSL(false);
        email.setAuthentication("jonas@mzgweb.com.br", "j0n4sjlk");
        //System.out.println("enviando...");
        email.send();
        //System.out.println("Email enviado!");
    }

}

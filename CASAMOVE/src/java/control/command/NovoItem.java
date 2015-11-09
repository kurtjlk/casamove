package control.command;

import dao.ItemDAO;
import dao.UsuarioDAO;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
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
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class NovoItem extends HttpServlet {

    private static final String TEMP_PATH = "/temp";
    private File tmpDir;
    private static final String DESTINATION_DIR_PATH = "/data/upload";
    private File destinationDir;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext sc = getServletContext();
        tmpDir = new File(sc.getRealPath(TEMP_PATH));
        if (!tmpDir.isDirectory()) {
            throw new ServletException(TEMP_PATH + " is not a directory");
        }
        String realPath = getServletContext().getRealPath(DESTINATION_DIR_PATH);
        destinationDir = new File(realPath);
        if (!destinationDir.isDirectory()) {
            throw new ServletException(DESTINATION_DIR_PATH + " is not a directory");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        if (request.getParameter("act") == null) {
            HttpSession session = request.getSession();
            int codigo = Integer.parseInt(session.getAttribute("usuarioCodigo").toString());
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario novoUsuario;
            try {
                novoUsuario = usuarioDAO.getUsuarioById(codigo);
                request.setAttribute("usuario", novoUsuario);
                request.getRequestDispatcher("pages/novoProduto.jsp").forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(NovoItem.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (request.getParameter("act").equals("addItem")) {
                cadastraNovoItem(request, response);
            } else {
                request.getRequestDispatcher("error/404error.jsp").forward(request, response);
            }
        }
    }

    //FUNÇÃO QUE CADASTRA UM NOVO ITEM/PRODUTO
    private void cadastraNovoItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        int codigo = Integer.parseInt(session.getAttribute("usuarioCodigo").toString());
        String titulo = "";
        String descricao = "";
        float valor = 0;
        boolean status = true;
        String caminhoImagem = "";

       
        
        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
        //fileItemFactory.setSizeThreshold(1 * 1024 * 1024); //1 MB // Para limitar Tamanho máximo
        fileItemFactory.setRepository(tmpDir);

        ServletFileUpload uploadHandler = new ServletFileUpload(fileItemFactory);
        try {
            List items = uploadHandler.parseRequest(request);
            Iterator itr = items.iterator();
            while (itr.hasNext()) {
                FileItem item = (FileItem) itr.next();
                if (item.isFormField()) {
                    if ("tituloitem".equals(item.getFieldName())) {
                        titulo = item.getString();
                    } else if ("descricaoitem".equals(item.getFieldName())) {
                        descricao = item.getString();
                    } else if ("valoritem".equals(item.getFieldName())) {
                        valor = Float.parseFloat(item.getString());
                    }
                     else if ("statusitem".equals(item.getFieldName())){
                        status = Boolean.parseBoolean(item.getString());
                    }
                } else {
                    File file = new File(destinationDir, item.getName());
                    item.write(file);
                    caminhoImagem = file.getName();
                }
            }
        } catch (Exception ex) {
            DebugException.capturaErro(ex, request, response);
        }
        try {
            Item novoItem = new Item();
                
            novoItem.setCodigoDono(codigo);
            novoItem.setDescricao(descricao);
            novoItem.setTitulo(titulo);
            novoItem.setValor(valor);
            novoItem.setStatus(status);
            novoItem.setImagem(caminhoImagem);

            ItemDAO novoItemDAO = new ItemDAO();

            novoItemDAO.novoItem(novoItem);

        } catch (Exception ex) {
            DebugException.capturaErro(ex, request, response);
        }
        request.getRequestDispatcher("geral?do=MinhaConta").forward(request, response);

    }
}

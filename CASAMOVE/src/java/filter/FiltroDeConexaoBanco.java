package filter;

import dao.ConnectionFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FiltroDeConexaoBanco implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        PrintWriter out = response.getWriter();
        
        try {
            Connection conexao = ConnectionFactory.getConnection();
            request.setAttribute("conexaoBanco", conexao);
            chain.doFilter(request, response);

        } catch (Exception ex) {
            ex.printStackTrace(out);
        }
}

    public void destroy() {
    }
}

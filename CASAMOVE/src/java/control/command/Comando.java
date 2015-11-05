package control.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Comando {

    public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception;
    
}

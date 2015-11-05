package dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Item;
import model.Mensagem;

public class MensagemDAO {

    PreparedStatement ps;
    Connection con;

    public MensagemDAO() {
    }

    public void novaMensagem(Mensagem mensagem) throws Exception {
        //NOVA MENSAGEM PARA O BANCO
        String sql = "INSERT INTO mensagem (codigoDono, codigoItem, nomeRemetente, emailRemetente, texto, mensagemRespondida) VALUES(?,?,?,?,?,?)";
        con = ConnectionFactory.getConnection();
        ps = con.prepareStatement(sql);

        ps.setInt(1, mensagem.getCodigoDono());
        ps.setInt(2, mensagem.getCodigoItem());
        ps.setString(3, mensagem.getNomeRemetente());
        ps.setString(4, mensagem.getEmailRemetente());
        ps.setString(5, mensagem.getTexto());
        ps.setInt(6, 0);
        ps.executeUpdate();

    }

    public List getListaDeMensagensByUsuario(int codigoDono) throws Exception {
        List lista = new ArrayList();

        String sql = "SELECT * FROM mensagem WHERE codigoDono=" + codigoDono + ";";

        con = ConnectionFactory.getConnection();
        ps = con.prepareStatement(sql);

        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Mensagem novaMensagem = new Mensagem();

            novaMensagem.setCodigo(result.getInt("codigo"));
            novaMensagem.setCodigoDono(result.getInt("codigoDono"));
            novaMensagem.setCodigoItem(result.getInt("codigoItem"));
            novaMensagem.setNomeRemetente(result.getString("nomeRemetente"));
            novaMensagem.setEmailRemetente(result.getString("emailRemetente"));
            novaMensagem.setTexto(result.getString("texto"));
            novaMensagem.setMensagemRespondida(result.getInt("mensagemRespondida"));

            lista.add(novaMensagem);
        }
        return lista;
    }

    public Mensagem getMensagemByCodigo(int codigo) throws Exception {

        String sql = "SELECT * FROM mensagem WHERE codigo=" + codigo + ";";

        con = ConnectionFactory.getConnection();
        ps = con.prepareStatement(sql);

        ResultSet result = ps.executeQuery();
        Mensagem novaMsg = new Mensagem();

        while (result.next()) {

            novaMsg.setCodigo(result.getInt("codigo"));
            novaMsg.setCodigoDono(result.getInt("codigoDono"));
            novaMsg.setCodigoItem(result.getInt("codigoItem"));
            novaMsg.setNomeRemetente(result.getString("nomeRemetente"));
            novaMsg.setEmailRemetente(result.getString("emailRemetente"));
            novaMsg.setTexto(result.getString("texto"));
            novaMsg.setMensagemRespondida(result.getInt("mensagemRespondida"));
        }
        return novaMsg;

    }
    
    
    public void marcarComoRespondida(int codigo) throws Exception {

        String sql = "UPDATE mensagem SET mensagemRespondida = 1 WHERE codigo = ?";

        con = ConnectionFactory.getConnection();
        ps = con.prepareStatement(sql);

        ps.setInt(1, codigo);

        ps.executeUpdate();

    }
    

    public void ExcluirItem(int codigo) throws Exception {

        String sql = "DELETE FROM `casanovousado`.`item` WHERE `item`.`coditem` = ?;";

        con = ConnectionFactory.getConnection();
        ps = con.prepareStatement(sql);

        ps.setInt(1, codigo);

        ps.executeUpdate();

    }

}

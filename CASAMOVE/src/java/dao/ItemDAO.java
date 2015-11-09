package dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Item;

public class ItemDAO {

    PreparedStatement ps;
    Connection con;

    public ItemDAO() {
    }

    public void novoItem(Item item) throws Exception {
        //AQUI VAI O SQL PARA CADASTRAR UM NOVO PRODUTO NO BANCO
        String sql = "INSERT INTO item (titulo, valor, status, descricao, imagem, codusuario) VALUES(?,?,?,?,?,?)";
        con = ConnectionFactory.getConnection();
        ps = con.prepareStatement(sql);

        ps.setString(1, item.getTitulo());
        ps.setFloat(2, item.getValor());
        ps.setBoolean(3,item.getStatus());
        ps.setString(4, item.getDescricao());
        ps.setString(5, item.getImagem());
        ps.setInt(6, item.getCodigoDono());
        ps.executeUpdate();

    }

    public List getListaDeItensByUsuario(int codigoDono) throws Exception {
        List lista = new ArrayList();

        String sql = "SELECT * FROM item WHERE codusuario=" + codigoDono + ";";

        con = ConnectionFactory.getConnection();
        ps = con.prepareStatement(sql);

        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Item novoItem = new Item();

            novoItem.setCodigo(result.getInt("coditem"));
            novoItem.setTitulo(result.getString("titulo"));
            novoItem.setValor(Float.parseFloat(result.getString("valor")));
            novoItem.setStatus(Boolean.parseBoolean(result.getString("status")));
            novoItem.setDescricao(result.getString("descricao"));
            novoItem.setImagem(result.getString("imagem"));
            novoItem.setCodigoDono(Integer.parseInt(result.getString("codusuario")));

            lista.add(novoItem);
        }
        return lista;
    }

    public List getListaDeItensNovos() throws Exception {
        List lista = new ArrayList();

        String sql = "SELECT * FROM item where status = true;";

        con = ConnectionFactory.getConnection();
        ps = con.prepareStatement(sql);

        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Item novoItem = new Item();

            novoItem.setCodigo(result.getInt("coditem"));
            novoItem.setTitulo(result.getString("titulo"));
            novoItem.setValor(Float.parseFloat(result.getString("valor")));
            novoItem.setStatus(Boolean.parseBoolean(result.getString("status")));
            novoItem.setDescricao(result.getString("descricao"));
            novoItem.setImagem(result.getString("imagem"));
            novoItem.setCodigoDono(Integer.parseInt(result.getString("codusuario")));

            lista.add(novoItem);
        }
        return lista;
    }
    public List getListaDeItensUsados() throws Exception {
        List lista = new ArrayList();

        String sql = "SELECT * FROM item where status = false;";

        con = ConnectionFactory.getConnection();
        ps = con.prepareStatement(sql);

        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Item novoItem = new Item();

            novoItem.setCodigo(result.getInt("coditem"));
            novoItem.setTitulo(result.getString("titulo"));
            novoItem.setValor(Float.parseFloat(result.getString("valor")));
            novoItem.setStatus(Boolean.parseBoolean(result.getString("status")));
            novoItem.setDescricao(result.getString("descricao"));
            novoItem.setImagem(result.getString("imagem"));
            novoItem.setCodigoDono(Integer.parseInt(result.getString("codusuario")));

            lista.add(novoItem);
        }
        return lista;
    }

    public Item getItemByCodigo(int codigo) throws Exception {

        String sql = "SELECT * FROM item WHERE coditem=" + codigo + ";";

        con = ConnectionFactory.getConnection();
        ps = con.prepareStatement(sql);

        ResultSet result = ps.executeQuery();
        Item novoItem = new Item();

        while (result.next()) {

            novoItem.setCodigo(result.getInt("coditem"));
            novoItem.setTitulo(result.getString("titulo"));
            novoItem.setValor(Float.parseFloat(result.getString("valor")));
            novoItem.setStatus(Boolean.parseBoolean(result.getString("status")));
            novoItem.setDescricao(result.getString("descricao"));
            novoItem.setImagem(result.getString("imagem"));
            novoItem.setCodigoDono(Integer.parseInt(result.getString("codusuario")));

        }
        return novoItem;

    }

    public void ExcluirItem(int codigo) throws Exception {

        String sql = "DELETE FROM `casanovousado`.`item` WHERE `item`.`coditem` = ?;";

        con = ConnectionFactory.getConnection();
        ps = con.prepareStatement(sql);

        ps.setInt(1, codigo);

        ps.executeUpdate();

    }

    public List getListBusca(String termo) throws Exception {
        List lista = new ArrayList();

        String sql = "SELECT * FROM item where UPPER(titulo) like '%" + termo.toUpperCase() + "%' OR UPPER(descricao) like '%" + termo.toUpperCase() + "%';";
        //ente WHERE UPPER(nome) LIKE ‘%’ || UPPER(’Marcelo’) || ‘%’;
        
        con = ConnectionFactory.getConnection();
        ps = con.prepareStatement(sql);

        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Item novoItem = new Item();

            novoItem.setCodigo(result.getInt("coditem"));
            novoItem.setTitulo(result.getString("titulo"));
            novoItem.setValor(Float.parseFloat(result.getString("valor")));
            novoItem.setStatus(Boolean.parseBoolean(result.getString("status")));
            novoItem.setDescricao(result.getString("descricao"));
            novoItem.setImagem(result.getString("imagem"));
            novoItem.setCodigoDono(Integer.parseInt(result.getString("codusuario")));

            lista.add(novoItem);
        }
        return lista;

    }
}

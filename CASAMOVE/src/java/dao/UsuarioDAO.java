package dao;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

public class UsuarioDAO {

    PreparedStatement ps;
    Connection con;

    public UsuarioDAO() {
    }

    public List getListaDeUsuarios() throws Exception {
        List lista = new ArrayList();

        String sql = "SELECT * FROM usuario";

        con = ConnectionFactory.getConnection();
        ps = con.prepareStatement(sql);

        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Usuario novoUsuario = new Usuario();

            novoUsuario.setCodigo(result.getInt("usuario_codigo"));
            novoUsuario.setNome(result.getString("usuario_nome"));
            novoUsuario.setFantasia(result.getString("usuario_fantasia"));
            novoUsuario.setNickname(result.getString("usuario_nickname"));
            //novoUsuario.setImagem(result.getString("usuario_imagem"));
            novoUsuario.setEmail(result.getString("usuario_email"));
            novoUsuario.setCnpj(result.getString("usuario_cnpj"));
            novoUsuario.setEndereco(result.getString("usuario_endereco"));
            novoUsuario.setCidade(result.getString("usuario_cidade"));
            novoUsuario.setEstado(result.getString("usuario_estado"));
            novoUsuario.setSenha(result.getString("usuario_senha"));
            novoUsuario.setSobre(result.getString("usuario_sobre"));

            lista.add(novoUsuario);
        }
        //ps.close();
        //con.close();
        return lista;
    }

    public void novoUsuario(Usuario novoUsuario) throws Exception {

        String sql = "INSERT INTO usuario (`usuario_nome`,`usuario_fantasia`,`usuario_nickname`,`usuario_email`,`usuario_cnpj`,`usuario_endereco`,`usuario_cidade`,`usuario_estado`,`usuario_sobre`,`usuario_senha`) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        con = ConnectionFactory.getConnection();
        ps = con.prepareStatement(sql);

        ps.setString(1, novoUsuario.getNome());
        ps.setString(2, novoUsuario.getFantasia());
        ps.setString(3, novoUsuario.getNickname());
        //ps.setString(4, novoUsuario.getImagem());
        ps.setString(4, novoUsuario.getEmail());
        ps.setString(5, novoUsuario.getCnpj());
        ps.setString(6, novoUsuario.getEndereco());
        ps.setString(7, novoUsuario.getCidade());
        ps.setString(8, novoUsuario.getEstado());
        ps.setString(9, novoUsuario.getSobre());
        ps.setString(10, novoUsuario.getSenha());
        

        ps.executeUpdate();
    }

    public Usuario getUsuarioById(int idUsuario) throws Exception {

        String sql = "SELECT * FROM usuario Where usuario_codigo = '" + idUsuario + "'";

        con = ConnectionFactory.getConnection();
        ps = con.prepareStatement(sql);

        ResultSet result = ps.executeQuery();

        Usuario novoUsuario = new Usuario();

        while (result.next()) {

            novoUsuario.setCodigo(result.getInt("usuario_codigo"));
            novoUsuario.setNome(result.getString("usuario_nome"));
            novoUsuario.setFantasia(result.getString("usuario_fantasia"));
            novoUsuario.setNickname(result.getString("usuario_nickname"));
            //novoUsuario.setImagem(result.getString("usuario_imagem"));
            novoUsuario.setEmail(result.getString("usuario_email"));
            novoUsuario.setCnpj(result.getString("usuario_cnpj"));
            novoUsuario.setEndereco(result.getString("usuario_endereco"));
            novoUsuario.setCidade(result.getString("usuario_cidade"));
            novoUsuario.setEstado(result.getString("usuario_estado"));
            novoUsuario.setSenha(result.getString("usuario_senha"));
            novoUsuario.setSobre(result.getString("usuario_sobre"));
        }

        return novoUsuario;
    }

    public void alterarUsuario(Usuario usuario, int codigo) throws Exception {

        String sql = "UPDATE usuario SET usuario_nome = ?, usuario_fantasia = ?, usuario_email = ?, usuario_endereco = ?, usuario_cidade = ?, usuario_estado = ?, usuario_cnpj = ?, usuario_sobre = ? WHERE usuario_codigo = ?";

        con = ConnectionFactory.getConnection();
        ps = con.prepareStatement(sql);

        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getFantasia());
        ps.setString(3, usuario.getEmail());
        ps.setString(4, usuario.getEndereco());
        ps.setString(5, usuario.getCidade());
        ps.setString(6, usuario.getEstado());
        ps.setString(7, usuario.getCnpj());
        ps.setString(8, usuario.getSobre());
        ps.setInt(9, codigo);

        ps.executeUpdate();

    }

    public void alterarSenhaDoUsuario(Usuario usuario, int codigo) throws Exception {

        String sql = "UPDATE usuario SET usuario_senha = ? WHERE usuario_codigo = ?";

        con = ConnectionFactory.getConnection();
        ps = con.prepareStatement(sql);

        ps.setString(1, usuario.getSenha());
        ps.setInt(2, codigo);

        ps.executeUpdate();

    }

    public void alterarImagemDoUsuario(Usuario usuario, int codigo) throws Exception {

        String sql = "UPDATE usuario SET usuario_imagem = ? WHERE usuario_codigo = ?";

        con = ConnectionFactory.getConnection();
        ps = con.prepareStatement(sql);

        ps.setString(1, usuario.getImagem());

        ps.executeUpdate();

    }

}

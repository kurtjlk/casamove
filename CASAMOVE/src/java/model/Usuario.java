package model;

public class Usuario {

    private int codigo;
    private String nome;
    private String fantasia;
    private String nickname;
    private String imagem;
    private String email;
    private String cnpj;
    private String endereco;
    private String cidade;
    private String estado;
    private String senha;
    private String sobre;

    public Usuario() {
    }

    public Usuario(String nome, String fantasia, String nickname, String email, String cnpj, String endereco, String cidade, String estado, String senha, String sobre) {
        this.nome = nome;
        this.fantasia = fantasia;
        this.nickname = nickname;
        this.email = email;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.senha = senha;
        this.sobre = sobre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSobre() {
        return sobre;
    }

    public void setSobre(String sobre) {
        this.sobre = sobre;
    }
}

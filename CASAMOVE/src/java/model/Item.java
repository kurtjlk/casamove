package model;

public class Item {

    private int codigo;
    private int codigoDono;
    private String titulo;
    private float valor;
    private boolean status;
    private String descricao;
    private String imagem;

    public Item() {
    }

    public Item(int codigo, int codigoDono, String titulo, float valor, boolean status, String descricao, String imagem) {
        this.codigo = codigo;
        this.codigoDono = codigoDono;
        this.titulo = titulo;
        this.valor = valor;
        this.status = status;
        this.descricao = descricao;
        this.imagem = imagem;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getCodigoDono() {
        return codigoDono;
    }

    public void setCodigoDono(int codigo) {
        this.codigoDono = codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public boolean getStatus(){
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}

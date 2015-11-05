package model;

public class Mensagem {

    private int codigo;
    private int codigoDono;
    private int codigoItem;
    private String nomeRemetente;
    private String emailRemetente;
    private String texto;
    private int mensagemRespondida;

    public Mensagem() {
    }

    public Mensagem(int codigo, int codigoDono, int codigoItem, String nomeRemetente, String emailRemetente, String texto, int mensagemRespondida) {
        this.codigo = codigo;
        this.codigoDono = codigoDono;
        this.codigoItem = codigoItem;
        this.nomeRemetente = nomeRemetente;
        this.emailRemetente = emailRemetente;
        this.texto = texto;
        this.mensagemRespondida = mensagemRespondida;
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigoDono() {
        return codigoDono;
    }

    public void setCodigoDono(int codigoDono) {
        this.codigoDono = codigoDono;
    }

    public String getNomeRemetente() {
        return nomeRemetente;
    }

    public void setNomeRemetente(String nomeRemetente) {
        this.nomeRemetente = nomeRemetente;
    }

    public String getEmailRemetente() {
        return emailRemetente;
    }

    public void setEmailRemetente(String emailRemetente) {
        this.emailRemetente = emailRemetente;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(int codigoItem) {
        this.codigoItem = codigoItem;
    }

    public void setMensagemRespondida(int mensagemRespondida) {
        this.mensagemRespondida = mensagemRespondida;
    }

    public int getMensagemRespondida() {
        return mensagemRespondida;
    }

}
